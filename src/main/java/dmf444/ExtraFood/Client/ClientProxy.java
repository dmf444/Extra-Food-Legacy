package dmf444.ExtraFood.Client;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInterModComms;
import dmf444.ExtraFood.Client.renderer.AutoCutterRenderer;
import dmf444.ExtraFood.Client.renderer.BerryRender;
import dmf444.ExtraFood.Client.renderer.CheesePressRenderer;
import dmf444.ExtraFood.Client.renderer.RenderOven;
import dmf444.ExtraFood.Client.renderer.RendererJuiceBlender;
import dmf444.ExtraFood.Common.CommonProxy;
import dmf444.ExtraFood.Common.RecipeHandler.JuiceRegistry;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.blocks.tileentity.AutoCutterTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.CheesePressTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityOven;
import dmf444.ExtraFood.Core.Crossmod.WailaConfig;

public class ClientProxy extends CommonProxy{

	public static BerryRender bushrender;
	
	public void registerRenderers(){ 
		ClientRegistry.bindTileEntitySpecialRenderer(CheesePressTileEntity.class, new CheesePressRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(AutoCutterTileEntity.class, new AutoCutterRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJuiceBlender.class, new RendererJuiceBlender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOven.class, new RenderOven());
		//JuiceRegistry.instance = new JuiceRegistry();
		bushrender = new BerryRender();
		RenderingRegistry.registerBlockHandler(bushrender);
		
		FMLInterModComms.sendMessage("Waila", "register", WailaConfig.class.getName() + ".callbackRegister");
		
	}
}

