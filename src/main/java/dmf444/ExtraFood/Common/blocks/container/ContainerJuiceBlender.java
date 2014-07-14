package dmf444.ExtraFood.Common.blocks.container;


import dmf444.ExtraFood.ExtraFood;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.Core.PacketJBTank;

public class ContainerJuiceBlender extends Container{


	TileEntityJuiceBlender tileEntity;
	public static int INPUT_1 = 0, INPUT_2 = 1, OUTPUT_1 = 2;


	public ContainerJuiceBlender(InventoryPlayer inventoryPlayer, TileEntityJuiceBlender te){
		this.addSlotToContainer(new Slot(te, INPUT_1, 80, 20));
		this.addSlotToContainer(new Slot(te, INPUT_2, 126, 12));
		this.addSlotToContainer(new Slot(te, OUTPUT_1, 126, 34));


		this.bindPlayerInventory(inventoryPlayer);

	}
	 protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
         for (int i = 0; i < 3; i++) {
                 for (int j = 0; j < 9; j++) {
                         addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
                                         8 + j * 18, 84 + i * 18));
                 }
         }

         for (int i = 0; i < 9; i++) {
                 addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
         }
 }


	@Override
	public boolean canInteractWith(EntityPlayer theplayer) {
		return true;
	}
	
	@Override
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		for (int i = 0; i < this.crafters.size(); ++i){
		ExtraFood.JBTanknet.sendToAll(new PacketJBTank(tileEntity.tank.getFluidAmount(), tileEntity.tank.getFluid().tag, tileEntity.tank.getFluid().getFluid().getID()));
		}
	}

}
