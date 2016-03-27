package com.thegreatunclean.emcsorter;

import com.thegreatunclean.emcsorter.blocks.EMCChest;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.registry.GameRegistry;
import moze_intel.projecte.PECore;
import moze_intel.projecte.gameObjs.ObjHandler;
import moze_intel.projecte.proxies.IProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by thegreatunclean on 3/26/2016.
 * License: MIT
 */
@Mod(modid = EMCSorter.MODID, version = EMCSorter.VERSION, dependencies = "required-after:ProjectE")
public class EMCSorter {
    public static final String MODID = "emcsorter";
    public static final String VERSION = "1.0";

    public final static Block bEMCChest = new EMCChest.block();

    @SidedProxy(clientSide = "com.thegreatunclean.emcsorter.proxies.ClientProxy", serverSide = "com.thegreatunclean.emcsorter.proxies.ServerProxy")
    public static IProxy proxy;

    @Mod.Instance("EMCSorter")
    public static EMCSorter instance;

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @EventHandler
    public void preInit(FMLInitializationEvent event) {

    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
        GameRegistry.registerBlock(bEMCChest, ItemBlock.class, bEMCChest.getUnlocalizedName());
        GameRegistry.registerTileEntity(EMCChest.tile.class, "tile_" + bEMCChest.getUnlocalizedName());
        proxy.registerRenderers();

        GameRegistry.addShapelessRecipe(new ItemStack(EMCSorter.bEMCChest),
                new ItemStack(ObjHandler.alchChest),
                new ItemStack(Items.sugar));
    }
}
