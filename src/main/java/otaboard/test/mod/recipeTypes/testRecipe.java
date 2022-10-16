package otaboard.test.mod.recipeTypes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import otaboard.test.mod.testMod;

public class testRecipe extends AbstractCookingRecipe {
    public testRecipe(Identifier id, String group, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(testMod.TEST_RECIPE_TYPE, id, group, input, output, experience, cookTime);
    }

    public ItemStack getRecipeKindIcon() {
        return new ItemStack(Items.BLACKSTONE);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return testMod.TEST_RECIPE_SERIALIZER;
    }
}
