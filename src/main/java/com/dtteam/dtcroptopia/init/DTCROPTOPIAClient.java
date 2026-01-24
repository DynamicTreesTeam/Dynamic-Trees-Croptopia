package com.dtteam.dtcroptopia.init;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;

public class DTCROPTOPIAClient {

    public static void setup (){
        registerRenderLayers();
    }

    private static void registerRenderLayers() {
        ItemBlockRenderTypes.setRenderLayer(DTCROPTOPIABlocks.BANANA_SUCKER_BLOCK.get(), RenderType.cutout());
    }

}
