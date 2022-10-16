package otaboard.test.mod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import otaboard.test.mod.blocks.testFurnace;
import otaboard.test.mod.blocks.testFurnaceEntity;
import otaboard.test.mod.recipeTypes.testRecipe;
import otaboard.test.mod.screens.testFurnaceScreenHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class testMod implements ModInitializer {
	public static final String MOD_ID = "testmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// Alloy Furnace Instances
	public static final Identifier ALLOY_FURNACE_IDENTIFIER = new Identifier(MOD_ID, "alloy_furnace");
	public static final Block ALLOY_FURNACE = new alloyFurnace(FabricBlockSettings.of(Material.STONE).strength(4.5F, 4.5F).requiresTool());
	public static final BlockItem ALLOY_FURNACE_ITEM = new BlockItem(ALLOY_FURNACE, new Item.Settings().group(ItemGroup.DECORATIONS));
	public static final BlockEntityType<alloyFurnaceEntity> ALLOY_FURNACE_ENTITY = FabricBlockEntityTypeBuilder.create(alloyFurnaceEntity::new, ALLOY_FURNACE).build();
	public static final ScreenHandlerType<alloyFurnaceScreenHandler> ALLOY_FURNACE_SCREEN_HANDLER = new ScreenHandlerType<>(alloyFurnaceScreenHandler::new);

	// Test Furnace Instances
	public static final Identifier TEST_FURNACE_IDENTIFIER = new Identifier(MOD_ID, "test_furnace");
	public static final Block TEST_FURNACE = new testFurnace(FabricBlockSettings.of(Material.STONE));
	public static final BlockItem TEST_FURNACE_ITEM = new BlockItem(TEST_FURNACE, new Item.Settings().group(ItemGroup.DECORATIONS));
	public static final BlockEntityType<testFurnaceEntity> TEST_FURNACE_ENTITY = FabricBlockEntityTypeBuilder.create(testFurnaceEntity::new, TEST_FURNACE).build();
	public static final RecipeType<testRecipe> TEST_RECIPE_TYPE = new RecipeType<testRecipe>() {
		@Override
		public String toString() {return "test_furnace";}
	};
	public static final RecipeSerializer<testRecipe> TEST_RECIPE_SERIALIZER = new CookingRecipeSerializer<>(testRecipe::new, 200);
	public static final ScreenHandlerType<testFurnaceScreenHandler> TEST_FURNACE_SCREEN_HANDLER = new ScreenHandlerType<>(testFurnaceScreenHandler::new);

	// Metals
	public static final Item STEEL_INGOT = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));

	@Override
	public void onInitialize() {
		LOGGER.info("testmod started");

		// Register Alloy Furnace into Game Registers
		Registry.register(Registry.BLOCK, ALLOY_FURNACE_IDENTIFIER, ALLOY_FURNACE);
		Registry.register(Registry.ITEM, ALLOY_FURNACE_IDENTIFIER, ALLOY_FURNACE_ITEM);
		Registry.register(Registry.BLOCK_ENTITY_TYPE, ALLOY_FURNACE_IDENTIFIER, ALLOY_FURNACE_ENTITY);
		Registry.register(Registry.SCREEN_HANDLER, ALLOY_FURNACE_IDENTIFIER, ALLOY_FURNACE_SCREEN_HANDLER);

		// Register Test Furnace into Game Registers
		Registry.register(Registry.BLOCK, TEST_FURNACE_IDENTIFIER, TEST_FURNACE);
		Registry.register(Registry.ITEM, TEST_FURNACE_IDENTIFIER, TEST_FURNACE_ITEM);
		Registry.register(Registry.BLOCK_ENTITY_TYPE, TEST_FURNACE_IDENTIFIER, TEST_FURNACE_ENTITY);
		Registry.register(Registry.RECIPE_TYPE, TEST_FURNACE_IDENTIFIER, TEST_RECIPE_TYPE);
		Registry.register(Registry.RECIPE_SERIALIZER, TEST_FURNACE_IDENTIFIER, TEST_RECIPE_SERIALIZER);
		Registry.register(Registry.SCREEN_HANDLER, TEST_FURNACE_IDENTIFIER, TEST_FURNACE_SCREEN_HANDLER);

		// Register Metals into Game Registers
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "steel_ingot"), STEEL_INGOT);
	}
}
