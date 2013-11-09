package bugcraft.item;

import bugcraft.mod;
import bugcraft.entity.butterfly;

import com.google.common.collect.Multimap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class net extends Item {

	public net(int id) {
		super(id);
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("net");
		this.setTextureName("bugcraft:net");
	}
	
	public boolean hitEntity(ItemStack weapon, EntityLivingBase hitEntity, EntityLivingBase player)
    {
		weapon.damageItem(1, player);
        if (hitEntity instanceof butterfly && hitEntity.prevHealth > 0) {
        	butterfly hitButterfly = (butterfly)hitEntity;
        	if (!hitButterfly.caught) {
        		hitEntity.dropItem(mod.butterfly.itemID, 1);
        		hitButterfly.caught = true;
        	}
        }
        
        return true;
    }

}