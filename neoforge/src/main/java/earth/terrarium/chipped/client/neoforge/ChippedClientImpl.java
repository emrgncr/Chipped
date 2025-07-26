package earth.terrarium.chipped.client.neoforge;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class ChippedClientImpl {
    public static void registerBlockRenderType(ChunkSectionLayer layer, Supplier<Block> block) {
        ItemBlockRenderTypes.setRenderLayer(block.get(), layer);
    }
}
