package com.thegreatunclean.emcsorter.blocks;

import com.thegreatunclean.emcsorter.EMCSorter;
import moze_intel.projecte.api.ProjectEAPI;
import moze_intel.projecte.gameObjs.ObjHandler;
import moze_intel.projecte.gameObjs.blocks.AlchemicalChest;
import moze_intel.projecte.gameObjs.tiles.AlchChestTile;
import moze_intel.projecte.rendering.ChestItemRenderer;
import moze_intel.projecte.rendering.ChestRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by thegreatunclean on 3/26/2016.
 * License: MIT
 */
public class EMCChest {
    public static class block extends AlchemicalChest {
        public block() {
            this.setCreativeTab(ObjHandler.cTab);
            this.setBlockName("emcchest");
        }

        @Override
        public Item getItemDropped(int par1, Random random, int par2) {
            return Item.getItemFromBlock(EMCSorter.bEMCChest);
        }
        @Override
        public TileEntity createTileEntity(World world, int metadata) {
            return new EMCChest().new tile();
        }
    }
    public class tile extends AlchChestTile {
        public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
            return (ProjectEAPI.getEMCProxy().getValue(itemStack) > 0);
        }
    }

    public static class renderer {
        //subclass renderers and inject different texture.
        public static class block extends ChestRenderer {
            public block() {
                try {
                    Field hack = ChestRenderer.class.getDeclaredField("texture");
                    hack.setAccessible(true);
                    hack.set(this, new ResourceLocation("emcsorter", "textures/blocks/emcsort_chest.png"));
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        public static class item extends ChestItemRenderer {
            public item() {
                try {
                    Field hack = ChestItemRenderer.class.getDeclaredField("texture");
                    hack.setAccessible(true);
                    hack.set(this, new ResourceLocation("emcsorter", "textures/blocks/emcsort_chest.png"));
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        public static class tile extends ChestRenderer {
            public tile() {
                try {
                    Field hack = ChestRenderer.class.getDeclaredField("texture");
                    hack.setAccessible(true);
                    hack.set(this, new ResourceLocation("emcsorter", "textures/blocks/emcsort_chest.png"));
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
