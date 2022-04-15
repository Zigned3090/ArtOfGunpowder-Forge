package mc.art.gunpowder.listener;

import mc.art.gunpowder.ModMain;
import mc.art.gunpowder.entity.ModEntityType;
import mc.art.gunpowder.item.*;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemListener {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModMain.MODID);

    public static final CreativeModeTab ART_OF_GUNPOWDER = new CreativeModeTab("art_of_gunpowder") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemListener.SPECIAL_GUNPOWDER.get());
        }
    };

    public static final RegistryObject<Item> SPECIAL_GUNPOWDER = ITEMS.register("special_gunpowder", () -> new Item(new Item.Properties().tab(ItemListener.ART_OF_GUNPOWDER)));
    public static final RegistryObject<Item> DETONATOR_ITEM = ITEMS.register("detonator", () -> new DetonatorItem(new Item.Properties().tab(ItemListener.ART_OF_GUNPOWDER)));
    public static final RegistryObject<Item> LVL_2_DETONATOR_ITEM = ITEMS.register("detonator_2", () -> new Lvl2DetonatorItem(new Item.Properties().tab(ItemListener.ART_OF_GUNPOWDER)));
    public static final RegistryObject<Item> EXPLODE_ARROW_ITEM = ITEMS.register("explode_arrow", () -> new ExplodeArrowItem(new Item.Properties().tab(ItemListener.ART_OF_GUNPOWDER).stacksTo(16)));
    public static final RegistryObject<Item> SPECIAL_BOW_ITEM = ITEMS.register("special_bow", () -> new SpecialBowItem(new Item.Properties().tab(ItemListener.ART_OF_GUNPOWDER).durability(64)));
    public static final RegistryObject<Item> SULPHUR = ITEMS.register("sulphur", () -> new Item(new Item.Properties().tab(ItemListener.ART_OF_GUNPOWDER)));
    public static final RegistryObject<ForgeSpawnEggItem> SUPER_CREEPER_SPAWN_EGG_ITEM = ITEMS.register("super_creeper_spawn_egg", () -> new ForgeSpawnEggItem(ModEntityType.SUPER_CREEPER_ENTITY, 8913436, 13829169, new Item.Properties().tab(ItemListener.ART_OF_GUNPOWDER)));
    public static final RegistryObject<Item> GUNPOWDER_STICK_ITEM = ITEMS.register("gunpowder_stick", () -> new GunpowderStickItem(new Item.Properties().stacksTo(1)));

}
