package bugcraft.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class microscope extends BlockContainer {

	public microscope(int id, Material material) {
		super(id, material);
		this.setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("microscope");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new bugcraft.tileentity.microscope();
	}
	
	@Override
	public int getRenderType() {
		return -1;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public void registerIcons(IconRegister icon) {
		this.blockIcon = icon.registerIcon("bugcraft:microscope");
	}
	
	/**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
        {
            return true;
        }
        else
        {
            par5EntityPlayer.displayGUIWorkbench(par2, par3, par4);
            return true;
        }
    }

}
