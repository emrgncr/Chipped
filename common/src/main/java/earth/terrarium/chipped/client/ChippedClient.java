package earth.terrarium.chipped.client;

import com.teamresourceful.resourcefullib.common.exceptions.NotImplementedException;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import dev.architectury.injectables.annotations.ExpectPlatform;
import earth.terrarium.chipped.common.registry.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class ChippedClient {

    public static void init() {
        registerRenderTypes();
    }

    private static void registerRenderTypes() {
        createSetRenderType(ModBlocks.BENCHES, ChunkSectionLayer.CUTOUT);

        createSetRenderType(ModBlocks.ICE, ChunkSectionLayer.TRANSLUCENT);

        createSetRenderType(ModBlocks.GLASS, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.GLASS_PANE, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.BLACK_STAINED_GLASS, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.BLACK_STAINED_GLASS_PANE, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.BLUE_STAINED_GLASS, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.BLUE_STAINED_GLASS_PANE, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.BROWN_STAINED_GLASS, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.BROWN_STAINED_GLASS_PANE, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.CYAN_STAINED_GLASS, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.CYAN_STAINED_GLASS_PANE, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.GRAY_STAINED_GLASS, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.GRAY_STAINED_GLASS_PANE, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.GREEN_STAINED_GLASS, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.GREEN_STAINED_GLASS_PANE, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.LIGHT_BLUE_STAINED_GLASS, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.LIGHT_BLUE_STAINED_GLASS_PANE, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.LIGHT_GRAY_STAINED_GLASS, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.LIGHT_GRAY_STAINED_GLASS_PANE, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.LIME_STAINED_GLASS, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.LIME_STAINED_GLASS_PANE, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.MAGENTA_STAINED_GLASS, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.MAGENTA_STAINED_GLASS_PANE, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.ORANGE_STAINED_GLASS, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.ORANGE_STAINED_GLASS_PANE, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.PINK_STAINED_GLASS, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.PINK_STAINED_GLASS_PANE, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.PURPLE_STAINED_GLASS, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.PURPLE_STAINED_GLASS_PANE, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.RED_STAINED_GLASS, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.RED_STAINED_GLASS_PANE, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.WHITE_STAINED_GLASS, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.WHITE_STAINED_GLASS_PANE, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.YELLOW_STAINED_GLASS, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.YELLOW_STAINED_GLASS_PANE, ChunkSectionLayer.TRANSLUCENT);

        createSetRenderType(ModBlocks.IRON_BARS, ChunkSectionLayer.CUTOUT);

        createSetRenderType(ModBlocks.ACACIA_LEAVES, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.BIRCH_LEAVES, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.DARK_OAK_LEAVES, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.JUNGLE_LEAVES, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.MANGROVE_ROOTS, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.OAK_LEAVES, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.SPRUCE_LEAVES, ChunkSectionLayer.CUTOUT);

        createSetRenderType(ModBlocks.BROWN_MUSHROOM, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.RED_MUSHROOM, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.COBWEB, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.LADDER, ChunkSectionLayer.CUTOUT);

        createSetRenderType(ModBlocks.ACACIA_DOOR, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.BIRCH_DOOR, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.DARK_OAK_DOOR, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.JUNGLE_DOOR, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.MANGROVE_DOOR, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.OAK_DOOR, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.SPRUCE_DOOR, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.CRIMSON_DOOR, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.WARPED_DOOR, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.CHERRY_DOOR, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.BAMBOO_DOOR, ChunkSectionLayer.CUTOUT);

        createSetRenderType(ModBlocks.ACACIA_TRAPDOOR, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.BIRCH_TRAPDOOR, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.DARK_OAK_TRAPDOOR, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.JUNGLE_TRAPDOOR, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.MANGROVE_TRAPDOOR, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.OAK_TRAPDOOR, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.SPRUCE_TRAPDOOR, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.CRIMSON_TRAPDOOR, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.WARPED_TRAPDOOR, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.CHERRY_TRAPDOOR, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.BAMBOO_TRAPDOOR, ChunkSectionLayer.CUTOUT);

        createSetRenderType(ModBlocks.CRIMSON_ROOTS, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.WARPED_ROOTS, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.LANTERN, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.SOUL_LANTERN, ChunkSectionLayer.TRANSLUCENT);
        createSetRenderType(ModBlocks.SPECIAL_LANTERN, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.SPECIAL_SOUL_LANTERN, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.LILY_PAD, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.NETHER_SPROUTS, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.NETHER_WART_BLOCK, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.VINE, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.WARPED_WART_BLOCK, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.CRIMSON_FUNGUS, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.WARPED_FUNGUS, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.POINTED_DRIPSTONE, ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.TORCH.getFirst(), ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.TORCH.getSecond(), ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.REDSTONE_TORCH.getFirst(), ChunkSectionLayer.CUTOUT);
        createSetRenderType(ModBlocks.REDSTONE_TORCH.getSecond(), ChunkSectionLayer.CUTOUT);
    }

    private static void createSetRenderType(ResourcefulRegistry<Block> registry, ChunkSectionLayer layer) {
        registry.getEntries().forEach(b -> registerBlockRenderType(layer, b));
    }

    @ExpectPlatform
    public static void registerBlockRenderType(ChunkSectionLayer layer, Supplier<Block> block){ 
        throw new NotImplementedException();
    }
}
