package com.ariks.torcherino.Register;

import com.ariks.torcherino.Items.*;
import com.ariks.torcherino.Torcherino;
import net.minecraft.item.Item;
import java.util.ArrayList;
import java.util.List;

public final class RegistryItems {
    public static final String modid = Torcherino.MOD_ID + "_";
    public static final List<Item> ITEMS = new ArrayList<>();
    public static final Item time_Wand_lvl1 = new TimeWand(modid+"time_wand_lvl1",EnumWands.lvl_1,256);
    public static final Item time_Wand_lvl2 = new TimeWand(modid+"time_wand_lvl2",EnumWands.lvl_2,512);
    public static final Item time_Wand_lvl3 = new TimeWand(modid+"time_wand_lvl3",EnumWands.lvl_3,1024);
    public static final Item time_Wand_lvl4 = new TimeWand(modid+"time_wand_lvl4",EnumWands.lvl_4,2048);
    public static final Item time_Wand_lvl5 = new TimeWand(modid+"time_wand_lvl5",EnumWands.lvl_5,4096);
    public static final Item time_Wand_infinite = new TimeWand(modid+"time_wand_infinite",EnumWands.infinite,1);
    public static final Item time_storage_lvl1 = new TimeStorage(modid+"time_storage_lvl1",EnumStorage.lvl_1);
    public static final Item time_storage_lvl2 = new TimeStorage(modid+"time_storage_lvl2",EnumStorage.lvl_2);
    public static final Item time_storage_lvl3 = new TimeStorage(modid+"time_storage_lvl3",EnumStorage.lvl_3);
    public static final Item time_storage_lvl4 = new TimeStorage(modid+"time_storage_lvl4",EnumStorage.lvl_4);
    public static final Item time_storage_lvl5 = new TimeStorage(modid+"time_storage_lvl5",EnumStorage.lvl_5);
    public static final Item time_storage_infinite = new TimeStorage(modid+"time_storage_infinite",EnumStorage.infinite);
    public static final Item time_element = new ItemBase(modid+"time_element");
    public static final Item time_nugget = new ItemBase(modid+"time_nugget");
    public static final Item time_ingot = new ItemBase(modid+"time_ingot");
    public static final Item diamond_Clock = new ItemBase(modid+"diamondclock");
    public static final Item emerald_Clock = new ItemBase(modid+"emeraldclock");
    public static final Item lapis_Clock = new ItemBase(modid+"lapisclock");
    public static final Item dragon_Clock = new ItemBase(modid+"dragonclock");
    public static final Item redstone_Clock = new ItemBase(modid+"redstoneclock");
    public static final Item gold_Clock = new ItemBase(modid+"goldclock");
    public static final Item comp_Torch = new ItemBase(modid+"compressedtorch");
    public static final Item binding_Element = new ItemBase(modid+"bindingelement");
    public static final Item binding_Element2 = new ItemBase(modid+"bindingelement2");
    public static final Item binding_Element3 = new ItemBase(modid+"bindingelement3");
    public static final Item time_stick = new ItemBase(modid+"time_stick");
    public static final Item time_casing = new ItemBase(modid+"time_casing");
    public static final Item time_core = new ItemBase(modid+"time_core");
    public static final Item time_particle = new ItemBase(modid+"time_particle");
    public static final Item time_particle_gold = new ItemBase(modid+"time_particle_gold");
    public static final Item time_particle_redstone = new ItemBase(modid+"time_particle_redstone");
    public static final Item time_particle_diamond = new ItemBase(modid+"time_particle_diamond");
    public static final Item time_particle_emerald = new ItemBase(modid+"time_particle_emerald");
    public static final Item time_plate = new ItemBase(modid+"time_plate");
    public static final Item time_star = new ItemBase(modid+"time_star");
    public static final Item upgrade_count = new ItemUpgradeCount(modid+"upgrade_count");
    public static final Item upgrade_speed = new ItemUpgradeSpeed(modid+"upgrade_speed");
}