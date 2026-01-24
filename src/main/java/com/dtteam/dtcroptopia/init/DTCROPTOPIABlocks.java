package com.dtteam.dtcroptopia.init;

import com.dtteam.dtcroptopia.DynamicTreesCROPTOPIA;
import com.dtteam.dtcroptopia.blocks.BananaSuckerBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class DTCROPTOPIABlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, DynamicTreesCROPTOPIA.MOD_ID);

    public static final Supplier<Block> BANANA_SUCKER_BLOCK = registerBlock("banana_sucker",
            ()->new BananaSuckerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS)));

    private static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
