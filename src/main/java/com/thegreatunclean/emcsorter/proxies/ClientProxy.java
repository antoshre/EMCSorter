package com.thegreatunclean.emcsorter.proxies;

import com.thegreatunclean.emcsorter.EMCSorter;
import com.thegreatunclean.emcsorter.blocks.EMCChest;
import cpw.mods.fml.client.registry.ClientRegistry;
import moze_intel.projecte.playerData.AlchBagProps;
import moze_intel.projecte.playerData.TransmutationProps;
import moze_intel.projecte.proxies.IProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

/**
 * Created by thegreatunclean on 3/26/2016.
 * License: MIT
 */
public class ClientProxy implements IProxy {

    @Override
    public void registerKeyBinds() {

    }

    @Override
    public void registerRenderers() {
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(EMCSorter.bEMCChest), new EMCChest.renderer.item());
        ClientRegistry.bindTileEntitySpecialRenderer(EMCChest.tile.class, new EMCChest.renderer.tile());
    }

    @Override
    public void registerClientOnlyEvents() {

    }

    @Override
    public void initializeManual() {

    }

    @Override
    public void clearClientKnowledge() {

    }

    @Override
    public TransmutationProps getClientTransmutationProps() {
        return null;
    }

    @Override
    public AlchBagProps getClientBagProps() {
        return null;
    }

    @Override
    public EntityPlayer getClientPlayer() {
        return null;
    }

    @Override
    public boolean isJumpPressed() {
        return false;
    }
}
