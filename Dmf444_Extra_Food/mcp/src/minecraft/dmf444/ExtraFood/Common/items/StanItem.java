package dmf444.ExtraFood.Common.items;

import net.minecraft.item.Item;
import dmf444.ExtraFood.Core.EFTabs;

public class StanItem extends Item {

	public StanItem(int id) {
		super(id);
		this.setCreativeTab(EFTabs.INSTANCE);
	}
}
