package mc.art.gunpowder.entity;

import mc.art.gunpowder.ModMain;
import mc.art.gunpowder.entity.arrow.ExplodeArrowEntity;
import mc.art.gunpowder.entity.creeper.SuperCreeperEntity;
import mc.art.gunpowder.entity.detonator.DetonatorEntity;
import mc.art.gunpowder.entity.detonator.Lvl2DetonatorEntity;
import mc.art.gunpowder.entity.tnt.Lvl2TntEntity;
import mc.art.gunpowder.entity.tnt.ThrownTntEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityType {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ModMain.MODID);

    public static final RegistryObject<EntityType<DetonatorEntity>> DETONATOR_ENTITY = ENTITY_TYPES.register("detonator",
            () -> EntityType.Builder.<DetonatorEntity>of(DetonatorEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).build("detonator"));

    public static final RegistryObject<EntityType<Lvl2DetonatorEntity>> LVL_2_DETONATOR_ENTITY = ENTITY_TYPES.register("lvl_2_detonator",
            () -> EntityType.Builder.<Lvl2DetonatorEntity>of(Lvl2DetonatorEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).build("lvl_2_detonator"));

    public static final RegistryObject<EntityType<ExplodeArrowEntity>> EXPLODE_ARROW_ENTITY = ENTITY_TYPES.register("explode_arrow",
            () -> EntityType.Builder.<ExplodeArrowEntity>of(ExplodeArrowEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).build("explode_arrow"));

    public static final RegistryObject<EntityType<SuperCreeperEntity>> SUPER_CREEPER_ENTITY = ENTITY_TYPES.register("super_creeper",
            () -> EntityType.Builder.of(SuperCreeperEntity::new, MobCategory.MONSTER).sized(0.6F, 1.7F).build("super_creeper"));

    public static final RegistryObject<EntityType<Lvl2TntEntity>> LVL_2_TNT_ENTITY = ENTITY_TYPES.register("tnt_2",
            () -> EntityType.Builder.<Lvl2TntEntity>of(Lvl2TntEntity::new, MobCategory.MISC).sized(0.98F, 0.7F).build("tnt_2"));

    public static final RegistryObject<EntityType<ThrownTntEntity>> THROWN_TNT_ENTITY = ENTITY_TYPES.register("thrown_tnt",
            () -> EntityType.Builder.<ThrownTntEntity>of(ThrownTntEntity::new, MobCategory.MISC).sized(0.98F, 0.7F).build("thrown_tnt"));

    public static void modEntityType(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
