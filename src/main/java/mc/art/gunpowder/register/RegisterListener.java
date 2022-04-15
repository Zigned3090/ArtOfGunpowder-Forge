package mc.art.gunpowder.register;

import mc.art.gunpowder.listener.BlockListener;
import mc.art.gunpowder.listener.ItemListener;
import net.minecraftforge.eventbus.api.IEventBus;

public class RegisterListener {

    public static void registerListener(IEventBus eventBus) {
        ItemListener.ITEMS.register(eventBus);
        BlockListener.BLOCKS.register(eventBus);
    }

}
