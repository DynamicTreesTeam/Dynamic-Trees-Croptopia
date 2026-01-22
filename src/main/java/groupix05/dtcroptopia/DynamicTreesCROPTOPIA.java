package groupix05.dtcroptopia;

import com.dtteam.dynamictrees.block.fruit.Fruit;
import com.dtteam.dynamictrees.block.leaves.LeavesProperties;
import com.dtteam.dynamictrees.block.pod.Pod;
import com.dtteam.dynamictrees.data.GatherDataHelper;
import com.dtteam.dynamictrees.registry.NeoForgeRegistryHandler;
import com.dtteam.dynamictrees.tree.family.Family;
import com.dtteam.dynamictrees.tree.species.Species;
import groupix05.dtcroptopia.init.DTCROPTOPIABlocks;
import groupix05.dtcroptopia.init.DTCROPTOPIAClient;
import groupix05.dtcroptopia.init.DTCROPTOPIARegistries;
import groupix05.dtcroptopia.init.DTCROPTOPIAItems;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod(DynamicTreesCROPTOPIA.MOD_ID)

public class DynamicTreesCROPTOPIA {
    public static final String MOD_ID = "dtcroptopia";

    public DynamicTreesCROPTOPIA(IEventBus bus, ModContainer modContainer) {
        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);
        bus.addListener(this::gatherData);

        NeoForgeRegistryHandler.setup(MOD_ID, bus);

        DTCROPTOPIABlocks.register(bus);
        DTCROPTOPIAItems.register(bus);
        DTCROPTOPIARegistries.setup();
        DTCROPTOPIARegistries.SOUNDS.register(bus);
    }

    private void commonSetup(final FMLConstructModEvent event) {
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        DTCROPTOPIAClient.setup();
    }

    private void gatherData(final GatherDataEvent event) {
        GatherDataHelper.gatherAllData(MOD_ID, event,
                //SoilProperties.REGISTRY,
                Family.REGISTRY,
                Species.REGISTRY,
                LeavesProperties.REGISTRY,
                Fruit.REGISTRY,
                Pod.REGISTRY
        );
    }

    public static ResourceLocation location(final String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

}
