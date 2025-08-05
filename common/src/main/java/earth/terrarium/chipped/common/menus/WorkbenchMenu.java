package earth.terrarium.chipped.common.menus;

import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.recipes.ChippedRecipe;
import earth.terrarium.chipped.common.registry.ModMenuTypes;
import earth.terrarium.chipped.common.registry.ModRecipeTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.StringUtil;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeMap;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class WorkbenchMenu extends AbstractContainerMenu {
    protected final Inventory inventory;
    protected final Level level;
    protected final ServerLevel serverLevel;

    private int selectedStackId;
    private ItemStack selectedStack = ItemStack.EMPTY;
    private ItemStack chosenStack = ItemStack.EMPTY;
    @Nullable
    private String filter;
    private final List<ItemStack> results = new ArrayList<>();

    public WorkbenchMenu(int containerId, Inventory inventory) {
        super(ModMenuTypes.WORKBENCH.get(), containerId);
        this.inventory = inventory;
        var logger = LoggerFactory.getLogger(Chipped.MOD_ID);
        if (inventory.player.getServer() != null) {
            // Multiplayer or dedicated server
            this.serverLevel = inventory.player.getServer().getLevel(inventory.player.level().dimension());
        } else {
            // Singleplayer - use Minecraft instance
            logger.warn("ABC");
            MinecraftServer server = Minecraft.getInstance().getSingleplayerServer();
            logger.warn("DEF");
            this.serverLevel = server.getLevel(inventory.player.level().dimension());
            logger.warn("GEH");
        }
        logger.warn(
            String.format("Server level is null: %b", serverLevel == null
            ));
        this.level = inventory.player.level();
        addPlayerInvSlots();
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    protected void addPlayerInvSlots() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlot(new InventorySlot(inventory, j + i * 9 + 9, getPlayerInvXOffset() + j * 18, getPlayerInvYOffset() + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            addSlot(new InventorySlot(inventory, i, getPlayerInvXOffset() + i * 18, getPlayerInvYOffset() + 58));
        }
    }

    public int getPlayerInvXOffset() {
        return 86;
    }

    public int getPlayerInvYOffset() {
        return 167;
    }


    @Override
    public void clicked(int slotId, int button, ClickType clickType, Player player) {
        selectStack(slotId);
        super.clicked(slotId, button, clickType, player);
    }

    public void selectStack(int slotId) {
        if (slotId < 0 || slotId >= slots.size()) return;
        selectedStackId = slots.get(slotId).getContainerSlot();
        selectedStack = slots.get(slotId).getItem();
        chosenStack = selectedStack;
        updateResults(filter);
    }

    public void updateResults(@Nullable String filter) {
        if (selectedStack.isEmpty()) return;
        this.filter = filter;
        CraftingInput craftingInput = CraftingInput.of(1, 1, List.of(selectedStack));

        var recipeManager = serverLevel.recipeAccess();
        try {
        
        Field recipesField = RecipeManager.class.getDeclaredField("recipes");
        recipesField.setAccessible(true); // Bypass private modifier

        // Get the value
        RecipeMap recipeMap = (RecipeMap) recipesField.get(recipeManager);

        var allMatchingRecipes = recipeMap.getRecipesFor(ModRecipeTypes.WORKBENCH.get(), craftingInput, level);
        
        results.clear();
        allMatchingRecipes.map(
            holder -> holder.value().assemble(craftingInput, level.registryAccess())
        ).forEach(
            result -> {if (filter == null
                       || StringUtil.isBlank(filter)
                       || result.getDisplayName().getString().toLowerCase(Locale.ROOT).contains(filter.toLowerCase(Locale.ROOT))) {
                       results.add(result);
                   }}
        );
        if (results.isEmpty()) {
            this.reset();
        }
        } catch(Exception e) {
            throw new NullPointerException(e.toString());
        }
    }

    public void craft(ItemStack stack, boolean replaceAll) {
        if (stack.isEmpty()) return;

        boolean canCraft = false;
        for (var result : results) {
            if (ItemStack.isSameItemSameComponents(result, stack)) {
                canCraft = true;
                break;
            }
        }
        if (!canCraft) return;

        inventory.setItem(selectedStackId, stack.copyWithCount(inventory.getItem(selectedStackId).getCount()));
        if (replaceAll) {
            for (int i = 0; i < inventory.getContainerSize(); i++) {
                if (ItemStack.isSameItem(inventory.getItem(i), selectedStack)) {
                    inventory.setItem(i, stack.copyWithCount(inventory.getItem(i).getCount()));
                }
            }
        }

        reset();
    }

    public void reset() {
        selectedStackId = 0;
        selectedStack = ItemStack.EMPTY;
        chosenStack = ItemStack.EMPTY;
        results.clear();
    }

    public ItemStack selectedStack() {
        return selectedStack;
    }

    public ItemStack chosenStack() {
        return chosenStack;
    }

    public void setChosenStack(ItemStack stack) {
        chosenStack = stack;
    }

    public List<ItemStack> results() {
        return results;
    }

    public Level level() {
        return level;
    }

    public void setFilter(@Nullable String filter) {
        this.filter = filter;
    }

    private static class InventorySlot extends Slot {
        public InventorySlot(Container container, int slot, int x, int y) {
            super(container, slot, x, y);
        }

        @Override
        public boolean mayPickup(Player player) {
            return false;
        }
    }
}