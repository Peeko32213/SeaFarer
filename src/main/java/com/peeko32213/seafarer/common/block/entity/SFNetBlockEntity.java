package com.peeko32213.seafarer.common.block.entity;

import com.mojang.logging.LogUtils;
import com.peeko32213.seafarer.core.registry.SFBlockEntities;
import com.peeko32213.seafarer.core.registry.SFLootTables;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import javax.annotation.Nullable;
import java.util.Objects;

public class SFNetBlockEntity extends BlockEntity {
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final int MAX_SALT = 1;
    private static final int MAX_BRUSH_TIME = 40;

    private static final int SALT_GATHER_TIME = 24000; //1 day = 24000 ticks
    private int saltCount;
    private int gatherTicks;
    private long brushCountResetsAtTick;
    private long coolDownEndsAtTick;
    @Nullable
    private Direction hitDirection;
    private int brushCount;
    private ItemStack item = ItemStack.EMPTY;
    @Nullable
    private static final ResourceLocation LOOT_TABLE = SFLootTables.FISHING_NET;
    private final long lootTableSeed;

    public SFNetBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(SFBlockEntities.NET_BLOCK_ENTITY.get(), pPos, pBlockState);
        this.lootTableSeed = pPos.asLong();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("count", this.saltCount);
        tag.putInt("gatherTicks", this.gatherTicks);

    }



    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        this.saltCount = nbt.getInt("count");
        this.gatherTicks= nbt.getInt("gatherTicks");
    }

    public int getGatherTicks() {
        return gatherTicks;
    }

    public int getSaltCount() {
        return saltCount;
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, SFNetBlockEntity pBlockEntity) {
        if(!pLevel.getBiome(pPos).is(BiomeTags.IS_OCEAN) || !pLevel.getBiome(pPos).is(BiomeTags.IS_BEACH) || pPos.getY() < 62) {
            return;
        }

        if(pBlockEntity.saltCount < MAX_SALT && pBlockEntity.gatherTicks < SALT_GATHER_TIME) {
            pBlockEntity.gatherTicks++;
        } else if(pBlockEntity.saltCount < MAX_SALT) {
            pBlockEntity.saltCount++;
        }
    }

    public boolean brush(long gameTime, Player player, Direction direction) {
        if (this.hitDirection == null) {
            this.hitDirection = direction;
        }

        this.brushCountResetsAtTick = gameTime + MAX_BRUSH_TIME;
        if (gameTime >= this.coolDownEndsAtTick && this.level instanceof ServerLevel && this.saltCount >= MAX_SALT) {
            this.coolDownEndsAtTick = gameTime + 10L;
            this.unpackLootTable(player);
            int i = this.getCompletionState();
            if (++this.brushCount >= 5) {
                this.brushingCompleted(player);
                return true;
            }
            //todo add this if you want to change states.
            //else {
              //  this.level.scheduleTick(this.getBlockPos(), this.getBlockState().getBlock(), 40);
              //  int j = this.getCompletionState();
              //  if (i != j) {
              //      BlockState blockstate = this.getBlockState();
              //      BlockState blockstate1 = blockstate.setValue(BlockStateProperties.DUSTED, Integer.valueOf(j));
              //      this.level.setBlock(this.getBlockPos(), blockstate1, 3);
              //  }
//
              //  return false;
            //}
            return false;
        } else {
            return false;
        }
    }

    public void unpackLootTable(Player player) {
        if (LOOT_TABLE != null && this.level != null && !this.level.isClientSide() && this.level.getServer() != null) {
            LootTable lootTable = this.level.getServer().getLootData().getLootTable(LOOT_TABLE);
            if (player instanceof ServerPlayer) {
                ServerPlayer serverplayer = (ServerPlayer) player;
                CriteriaTriggers.GENERATE_LOOT.trigger(serverplayer, LOOT_TABLE);
            }

            LootParams lootparams = (new LootParams.Builder((ServerLevel) this.level)).withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(this.worldPosition)).withLuck(player.getLuck()).withParameter(LootContextParams.THIS_ENTITY, player).create(LootContextParamSets.CHEST);
            ObjectArrayList<ItemStack> objectarraylist = lootTable.getRandomItems(lootparams, this.lootTableSeed);
            ItemStack itemstack;
            switch (objectarraylist.size()) {
                case 0:
                    itemstack = ItemStack.EMPTY;
                    break;
                case 1:
                    itemstack = objectarraylist.get(0);
                    break;
                default:
                    LOGGER.warn("Expected max 1 loot from loot table " + LOOT_TABLE + " got " + objectarraylist.size());
                    itemstack = objectarraylist.get(0);
            }

            this.item = itemstack;
            this.setChanged();
        }
    }


    private void brushingCompleted(Player player) {
        if (this.level != null && this.level.getServer() != null) {
            this.dropContent(player);
            BlockState blockstate = this.getBlockState();
            this.level.levelEvent(3008, this.getBlockPos(), Block.getId(blockstate));
            this.saltCount--;
            this.brushCount = 0;
            this.gatherTicks = 0;
            this.level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), Block.UPDATE_IMMEDIATE);
            this.setChanged();
        }
    }

    private void dropContent(Player player) {
        if (this.level != null && this.level.getServer() != null) {
            this.unpackLootTable(player);
            if (!this.item.isEmpty()) {
                double d0 = (double) EntityType.ITEM.getWidth();
                double d1 = 1.0D - d0;
                double d2 = d0 / 2.0D;
                Direction direction = Objects.requireNonNullElse(this.hitDirection, Direction.UP);
                BlockPos blockpos = this.worldPosition.relative(direction, 1);
                double d3 = (double) blockpos.getX() + 0.5D * d1 + d2;
                double d4 = (double) blockpos.getY() - 0.8D + (double) (EntityType.ITEM.getHeight() / 2.0F);
                double d5 = (double) blockpos.getZ() + 0.5D * d1 + d2;
                ItemEntity itementity = new ItemEntity(this.level, d3, d4, d5, this.item.split(this.level.random.nextInt(21) + 10));
                itementity.setDeltaMovement(Vec3.ZERO);
                this.level.addFreshEntity(itementity);
                this.item = ItemStack.EMPTY;
            }
        }
    }




    private int getCompletionState() {
        if (this.brushCount == 0) {
            return 0;
        } else if (this.brushCount < 3) {
            return 1;
        } else {
            return this.brushCount < 6 ? 2 : 3;
        }
    }


    @org.jetbrains.annotations.Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }


    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putInt("count", saltCount);
        return compoundTag;
    }


    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        super.onDataPacket(net, pkt);
        CompoundTag tag = pkt.getTag();
        if(tag != null && tag.contains("count", 10)) {
            this.saltCount = tag.getInt("count");
        }
        this.level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), Block.UPDATE_IMMEDIATE);
    }
}
