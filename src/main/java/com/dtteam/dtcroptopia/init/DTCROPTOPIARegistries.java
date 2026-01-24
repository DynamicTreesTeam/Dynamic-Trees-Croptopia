package com.dtteam.dtcroptopia.init;

import com.dtteam.dtcroptopia.DynamicTreesCROPTOPIA;
import com.dtteam.dynamictrees.block.CommonVoxelShapes;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DTCROPTOPIARegistries {

    public static final VoxelShape DRAGON_FRUIT_CACTUS_SAPLING_SHAPE = Shapes.box(
                    0.375f, 0.0f, 0.375f,
                    0.625f, 0.5f, 0.625f);

    public static final VoxelShape BANANA_SAPLING_SHAPE = Shapes.box(
                    0.375f, 0.0f, 0.375f,
                    0.625f, 0.9375f, 0.625f);

    public static void setup() {
        CommonVoxelShapes.SHAPES.put(DynamicTreesCROPTOPIA.location("dragon_fruit_cactus").toString(), DRAGON_FRUIT_CACTUS_SAPLING_SHAPE);
        CommonVoxelShapes.SHAPES.put(DynamicTreesCROPTOPIA.location("banana_sapling").toString(), BANANA_SAPLING_SHAPE);
    }

}
