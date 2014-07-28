package dmf444.ExtraFood.Common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.lib.ModInfo;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

/*--Future Reference. Copied of the BlockCarrot DIRECTLY w/ minimal change--*/
public class CropTomato extends BlockCrops{
	
	    @SideOnly(Side.CLIENT)
	    private IIcon[] PlantIcons;

	    /**
	     * Gets the block's texture. Args: side, meta
	     */
	    @SideOnly(Side.CLIENT)
	    public IIcon getIcon(int p_149691_1_, int meta)
	    {
	        if (meta < 7)
	        {
	            if (meta == 6)
	            {
	                meta = 5;
	            }

	            return this.PlantIcons[meta >> 2];
	        }
	        else
	        {
	            return this.PlantIcons[3];
	        }
	    }

	    protected Item func_149866_i()
	    {
	        return ItemLoader.tomato;
	    }

	    protected Item func_149865_P()
	    {
	        return ItemLoader.tomato;
	    }

	    @SideOnly(Side.CLIENT)
	    public void registerBlockIcons(IIconRegister icon)
	    {
	        this.PlantIcons = new IIcon[4];

	        for (int i = 0; i < this.PlantIcons.length; ++i)
	        {
	            this.PlantIcons[i] = icon.registerIcon( ModInfo.MId.toLowerCase() + ":Plants/tomato" + "_stage_" + i);
	        }
	    }
	}