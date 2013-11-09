package bugcraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class butterfly extends Item {

	public butterfly(int id) {
		super(id);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("butterfly");
		this.setTextureName("bugcraft:butterfly");
	}

}
