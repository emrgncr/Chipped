package earth.terrarium.chipped.client.screens;

import java.util.List;

import com.mojang.blaze3d.pipeline.RenderPipeline;

import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.menus.WorkbenchMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipPositioner;
import net.minecraft.client.gui.screens.inventory.tooltip.DefaultTooltipPositioner;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;


public class SlotWidget extends AbstractWidget {

    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "textures/gui/sprites/slot.png");
    private static final ResourceLocation SLOT_HIGHLIGHT_BACK_SPRITE = ResourceLocation.withDefaultNamespace("container/slot_highlight_back");
    private static final ResourceLocation SLOT_HIGHLIGHT_FRONT_SPRITE = ResourceLocation.withDefaultNamespace("container/slot_highlight_front");

    private final ItemStack stack;
    private final WorkbenchMenu menu;
    private final int minY;
    private final int maxY;

    public SlotWidget(ItemStack stack, WorkbenchMenu menu, int minY, int maxY) {
        super(0, 0, 18, 18, CommonComponents.EMPTY);
        this.stack = stack;
        this.menu = menu;
        this.minY = minY;
        this.maxY = maxY;
    }

    @Override
    protected void renderWidget(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, getX(), getY(), 0, 0, 18, 18, 18, 18);

        boolean isHighlighted = isMouseOver(mouseX, mouseY);
        if (isHighlighted) {
            graphics.blitSprite(RenderPipelines.GUI_TEXTURED, SLOT_HIGHLIGHT_BACK_SPRITE, getX() + 1, getY() + 1, 24, 24);
        }
        graphics.renderItem(stack, getX() + 1, getY() + 1);
        if (isMouseOver(mouseX, mouseY)) {
            graphics.blitSprite(RenderPipelines.GUI_TEXTURED, SLOT_HIGHLIGHT_FRONT_SPRITE, getX() + 1, getY() + 1, 24, 24);
        }
    }

    public void renderTooltip(GuiGraphics graphics, Font font, int mouseX, int mouseY) {
        if (isMouseOver(mouseX, mouseY)) {
            if (!stack.isEmpty() && !stack.getTooltipImage().isEmpty()) {
                graphics.renderTooltip(font, null, mouseX, mouseY, null, SLOT_HIGHLIGHT_BACK_SPRITE);
                graphics.renderTooltip(font,
                        List.of(ClientTooltipComponent.create(
                                stack.getTooltipImage().get())),
                        mouseX, mouseY, DefaultTooltipPositioner.INSTANCE, SLOT_HIGHLIGHT_BACK_SPRITE);
            }
        }
    }

    @Override
    public boolean isMouseOver(double mouseX, double mouseY) {
        return super.isMouseOver(mouseX, mouseY) && mouseY >= minY && mouseY <= maxY;
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {}

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (this.isMouseOver(mouseX, mouseY)) {
            if (stack.isEmpty() || mouseY < minY || mouseY > maxY) return false;
            menu.setChosenStack(stack);
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
}
