package groupix05.dtcroptopia.init;

import groupix05.dtcroptopia.DynamicTreesCROPTOPIA;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DTCROPTOPIAItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, DynamicTreesCROPTOPIA.MOD_ID);


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static void acceptToDynamicTreesTab (BuildCreativeModeTabContentsEvent event){
    }

}
