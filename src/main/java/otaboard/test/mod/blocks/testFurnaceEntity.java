package otaboard.test.mod.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import otaboard.test.mod.testMod;
import otaboard.test.mod.screens.testFurnaceScreenHandler;

public class testFurnaceEntity extends AbstractFurnaceBlockEntity {
    public testFurnaceEntity(BlockPos pos, BlockState state) {
        super(testMod.TEST_FURNACE_ENTITY, pos, state, testMod.TEST_RECIPE_TYPE);
    }
    
    @Override
    public Text getContainerName() {
        return Text.of("test furnace");
    }

    @Override
    public ScreenHandler createScreenHandler(int syncID, PlayerInventory playerInventory) {
        return new testFurnaceScreenHandler(syncID, playerInventory, this, this.propertyDelegate);
    }
}
