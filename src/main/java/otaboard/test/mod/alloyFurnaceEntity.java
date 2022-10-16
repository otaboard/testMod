package otaboard.test.mod;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class alloyFurnaceEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
   private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(9, ItemStack.EMPTY);

   public alloyFurnaceEntity(BlockPos pos, BlockState state) {
	super(testMod.ALLOY_FURNACE_ENTITY, pos, state);
   }

   @Override
   public DefaultedList<ItemStack> getItems() {
	return inventory;
   }

   @Override
   public ScreenHandler createMenu(int syncID, PlayerInventory playerInventory, PlayerEntity player) {
	return new alloyFurnaceScreenHandler(syncID, playerInventory, this);
   }

   @Override
   public Text getDisplayName() {
	return Text.translatable(getCachedState().getBlock().getTranslationKey());
   }

   @Override
   public void readNbt(NbtCompound nbt) {
	super.readNbt(nbt);
	Inventories.readNbt(nbt, this.inventory);
   }

   @Override
   public void writeNbt(NbtCompound nbt) {
	Inventories.writeNbt(nbt, this.inventory);
	super.writeNbt(nbt);
   }
} 
