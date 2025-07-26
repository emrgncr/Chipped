package earth.terrarium.chipped.client.screens.neoforge;

import java.util.ArrayList;
import java.util.List;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import earth.terrarium.athena.api.client.neoforge.AthenaBakedModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.model.BlockModelPart;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.model.data.ModelData;

public class FakeLevelImpl {

    public static void renderBatched(BlockRenderDispatcher dispatcher, BlockState state, BlockPos pos, BlockAndTintGetter level, PoseStack poseStack, VertexConsumer consumer, boolean checkSides, RandomSource random, RenderType type) {
        List<BlockModelPart> parts = new ArrayList<BlockModelPart>();
        if (dispatcher.getBlockModel(state) instanceof AthenaBakedModel model) {
            model.collectParts(random, parts);
        }
        dispatcher.renderBatched(state, pos, level, poseStack, consumer, checkSides, parts);
    }
}
