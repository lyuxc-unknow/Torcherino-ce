package com.ariks.torcherino.Items;

import com.ariks.torcherino.Register.RegistryArray;
import com.ariks.torcherino.Tiles.TileCollector;
import com.ariks.torcherino.util.LocalizedStringKey;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public abstract class TimeStorage extends itemBase {
    protected int MaxConfigStorageTime() {
        return 0;
    }
    public TimeStorage(String name) {
        super(name);
        this.setMaxStackSize(1);
        this.setNoRepair();
    }
    @Override
    public void onUpdate(ItemStack stack, @NotNull World worldIn, @NotNull Entity entityIn, int itemSlot, boolean isSelected) {
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
            assert stack.getTagCompound() != null;
            stack.getTagCompound().setInteger("Time", 0);
        }
    }
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, @NotNull List<String> tooltip, @NotNull ITooltipFlag flagIn) {
        LocalizedStringKey LS = new LocalizedStringKey();
        if (stack.hasTagCompound()) {
            assert stack.getTagCompound() != null;
            int time = stack.getTagCompound().getInteger("Time");
            tooltip.add(TextFormatting.GRAY + LS.Str_Time_Storage_Tooltip);
            if (stack.getItem() == RegistryArray.time_storage_infinite) {
                tooltip.add(TextFormatting.GRAY + LS.TimeCollector + ": " + time);
            }
            if (stack.getItem() != RegistryArray.time_storage_infinite) {
                tooltip.add(TextFormatting.GRAY + LS.TimeCollector + ": " + time + "/" + MaxConfigStorageTime());
            }
        }
    }
    @Override
    public @NotNull EnumActionResult onItemUse(@NotNull EntityPlayer player, World worldIn, @NotNull BlockPos pos, @NotNull EnumHand hand, @NotNull EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity instanceof TileCollector) {
                TileCollector tileCollector = (TileCollector) tileEntity;
                ItemStack heldItem = player.getHeldItem(hand);
                if (heldItem.hasTagCompound()) {
                    NBTTagCompound tagCompound = heldItem.getTagCompound();
                    assert tagCompound != null;
                    int storedTime = Math.min(tagCompound.getInteger("Time"), MaxConfigStorageTime());
                    int freeSpace = Integer.MAX_VALUE - tileCollector.TimeCollect;
                    if (!player.isSneaking()) {
                        if (freeSpace > 0) {
                            int transferTime = Math.min(storedTime, freeSpace);
                            tagCompound.setInteger("Time", storedTime - transferTime);
                            tileCollector.TimeCollect += (transferTime);
                        }
                    } else {
                        int transferTime = Math.min(tileCollector.TimeCollect, MaxConfigStorageTime() - storedTime);
                        tagCompound.setInteger("Time", storedTime + transferTime);
                        tileCollector.TimeCollect -= (transferTime);
                    }
                }
            }
        }
        return EnumActionResult.SUCCESS;
    }
}