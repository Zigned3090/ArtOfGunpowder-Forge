package mc.art.gunpowder;

import mc.art.gunpowder.entity.ModEntityType;
import mc.art.gunpowder.entity.render.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModMain.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModClient {

    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityType.DETONATOR_ENTITY.get(), RenderDetonatorEntity::new);
        event.registerEntityRenderer(ModEntityType.LVL_2_DETONATOR_ENTITY.get(), RenderLvl2DetonatorEntity::new);
        event.registerEntityRenderer(ModEntityType.EXPLODE_ARROW_ENTITY.get(), RenderExplodeArrowEntity::new);
        event.registerEntityRenderer(ModEntityType.SUPER_CREEPER_ENTITY.get(), RenderSuperCreeperEntity::new);
        event.registerEntityRenderer(ModEntityType.LVL_2_TNT_ENTITY.get(), RenderLvl2TntEntity::new);
        event.registerEntityRenderer(ModEntityType.THROWN_TNT_ENTITY.get(), RenderThrownTntEntity::new);
    }

}
