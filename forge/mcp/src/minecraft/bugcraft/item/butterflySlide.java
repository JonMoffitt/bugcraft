package bugcraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class butterflySlide extends Item {

	public butterflySlide(int id) {
		super(id);
		this.setMaxStackSize(64);
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setUnlocalizedName("butterflySlide");
		this.setTextureName("bugcraft:butterflySlide");
	}

}
