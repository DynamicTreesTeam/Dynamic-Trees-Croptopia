package groupix05.dtcroptopia.init;

import com.dtteam.dynamictrees.block.CommonVoxelShapes;
import com.dtteam.dynamictrees.block.fruit.Fruit;
import com.dtteam.dynamictrees.block.leaves.LeavesProperties;
import com.dtteam.dynamictrees.block.pod.Pod;
import com.dtteam.dynamictrees.event.RegistryEvent;
import com.dtteam.dynamictrees.event.TypeRegistryEvent;
import com.dtteam.dynamictrees.registry.DTRegistries;
import com.dtteam.dynamictrees.systems.genfeature.GenFeature;
import com.dtteam.dynamictrees.tree.species.Species;
import groupix05.dtcroptopia.DynamicTreesCROPTOPIA;
import groupix05.dtcroptopia.blocks.DragonFruitLeavesProperties;
import groupix05.dtcroptopia.fruits.*;
import groupix05.dtcroptopia.genfeatures.DTCROPTOPIAGenFeatures;
import groupix05.dtcroptopia.trees.FruitLogSpecies;
import groupix05.dtcroptopia.trees.GenOnExtraSoilSpecies;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@EventBusSubscriber(bus=EventBusSubscriber.Bus.MOD)
public class DTCROPTOPIARegistries {

    public static final TagKey<Block> CAN_BE_SPILED = BlockTags.create(DynamicTreesCROPTOPIA.location("can_be_spiled"));

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, DynamicTreesCROPTOPIA.MOD_ID);

    public static final Supplier<SoundEvent> FRUIT_BONK = registerSound("falling_fruit.bonk");

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

    public static Supplier<SoundEvent> registerSound (String name){
        return SOUNDS.register(name, ()-> SoundEvent.createVariableRangeEvent(DynamicTreesCROPTOPIA.location(name)));
    }

    @SubscribeEvent
    public static void registerFruitType(final TypeRegistryEvent<Fruit> event) {
        if (event.isEntryOfType(Fruit.class)) {
            event.registerType(DynamicTreesCROPTOPIA.location("offset_down"), OffsetFruit.TYPE);
            event.registerType(DynamicTreesCROPTOPIA.location("falling_fruit"), FallingFruit.TYPE);
        }
    }

    @SubscribeEvent
    public static void registerPodType(final TypeRegistryEvent<Pod> event) {
        if (event.isEntryOfType(Pod.class)) {
            event.registerType(DynamicTreesCROPTOPIA.location("palm"), PalmPod.TYPE);
            event.registerType(DynamicTreesCROPTOPIA.location("falling_palm"), FallingPalmPod.TYPE);
        }
    }

    @SubscribeEvent
    public static void registerLeavesPropertiesType(final TypeRegistryEvent<LeavesProperties> event) {
        if (event.isEntryOfType(LeavesProperties.class)){
            event.registerType(DynamicTreesCROPTOPIA.location("dragon_fruit"), DragonFruitLeavesProperties.TYPE);
        }
    }

    @SubscribeEvent
    public static void registerSpeciesType(final TypeRegistryEvent<Species> event) {
        if (event.isEntryOfType(Species.class)) {
            event.registerType(DynamicTreesCROPTOPIA.location("fruit_log"), FruitLogSpecies.TYPE);
            event.registerType(DynamicTreesCROPTOPIA.location("generates_on_extra_soil"), GenOnExtraSoilSpecies.TYPE);
        }
    }

    @SubscribeEvent
    public static void onGenFeatureRegistry (final RegistryEvent<GenFeature> event) {
        if (event.isEntryOfType(GenFeature.class)) {
            DTCROPTOPIAGenFeatures.register(event.getRegistry());
        }
    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        // Add to ingredients tab
        if (event.getTab() == DTRegistries.DT_CREATIVE_TAB.get()) {
            DTCROPTOPIAItems.acceptToDynamicTreesTab(event);
        }
    }

}
