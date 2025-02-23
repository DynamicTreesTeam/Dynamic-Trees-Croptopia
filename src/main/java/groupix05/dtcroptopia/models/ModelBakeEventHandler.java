package groupix05.dtcroptopia.models;

import groupix05.dtcroptopia.DynamicTreesCROPTOPIA;
import groupix05.dtcroptopia.models.baked_models.MediumPalmLeavesBakedModel;
import groupix05.dtcroptopia.models.baked_models.LargePalmLeavesBakedModel;
import groupix05.dtcroptopia.models.baked_models.SmallPalmLeavesBakedModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent.RegisterGeometryLoaders;
import net.minecraftforge.client.event.ModelEvent.BakingCompleted;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DynamicTreesCROPTOPIA.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModelBakeEventHandler {

    @SubscribeEvent
    public static void onModelRegistryEvent(RegisterGeometryLoaders event) {
        event.register("large_palm_fronds", new PalmLeavesModelLoader(0));
        event.register("medium_palm_fronds", new PalmLeavesModelLoader(1));
        event.register("small_palm_fronds", new PalmLeavesModelLoader(2));
    }

    @SubscribeEvent
    public static void onModelBake(BakingCompleted event) {
        // Setup fronds models
        MediumPalmLeavesBakedModel.INSTANCES.forEach(MediumPalmLeavesBakedModel::setupModels);
        LargePalmLeavesBakedModel.INSTANCES.forEach(LargePalmLeavesBakedModel::setupModels);
        SmallPalmLeavesBakedModel.INSTANCES.forEach(SmallPalmLeavesBakedModel::setupModels);
    }

}
