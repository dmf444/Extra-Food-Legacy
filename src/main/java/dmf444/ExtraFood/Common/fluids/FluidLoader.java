package dmf444.ExtraFood.Common.fluids;

import cpw.mods.fml.common.registry.GameRegistry;
import dmf444.ExtraFood.Core.lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidLoader {
	/*
	 * This class only loads the fluids
	 * The block & tile are registered in the Block loader
	 * 
	 * This will act quite like the "BlockLoader" though
	 */
	
	public static Fluid Fbananajuice;
	public static Fluid Fstrawberryjuice;

	
	public static boolean Register=false;
	
	public static void initiateFluids() {
		Fbananajuice = new Fluid("bananajuice").setViscosity(3000);
		Fstrawberryjuice = new Fluid("strawberryjuice");
		
		
		
		registerFluid();
	}
	private static void registerFluid(){
		if(!Register){
		FluidRegistry.registerFluid(Fbananajuice);
		FluidRegistry.registerFluid(Fstrawberryjuice);

		}
		Register = true;
	}
	
}
