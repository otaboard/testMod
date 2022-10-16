package otaboard.test.mod.screens;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;
import otaboard.test.mod.testMod;

public class testFurnaceScreenHandler extends AbstractFurnaceScreenHandler {
    public testFurnaceScreenHandler(int i, PlayerInventory playerInventory) {
        super(testMod.TEST_FURNACE_SCREEN_HANDLER, testMod.TEST_RECIPE_TYPE, RecipeBookCategory.FURNACE, i, playerInventory);
    }

    public testFurnaceScreenHandler(int i, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(testMod.TEST_FURNACE_SCREEN_HANDLER, testMod.TEST_RECIPE_TYPE, RecipeBookCategory.FURNACE, i, playerInventory, inventory, propertyDelegate);
    }
}
