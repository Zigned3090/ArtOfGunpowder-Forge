package mc.art.gunpowder;

import com.mojang.logging.LogUtils;
import mc.art.gunpowder.entity.ModEntityType;
import mc.art.gunpowder.entity.creeper.SuperCreeperEntity;
import mc.art.gunpowder.register.RegisterListener;
import mc.art.gunpowder.util.ModItemProperties;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ModMain.MODID)
public class ModMain {

    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MODID = "art_gunpowder";

    public ModMain() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        RegisterListener.registerListener(eventBus);
        ModEntityType.modEntityType(eventBus);
        MinecraftForge.EVENT_BUS.register(this);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::addAttributes);

    }

    private void addAttributes(final EntityAttributeCreationEvent event) {
        event.put(ModEntityType.SUPER_CREEPER_ENTITY.get(), SuperCreeperEntity.createAttributes().build());
    }


    private void clientSetup(final FMLClientSetupEvent event) {
        ModItemProperties.addCustomItemProperties();
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("ART OF GUNPOWDER");
    }

}
