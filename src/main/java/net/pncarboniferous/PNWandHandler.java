package net.pncarboniferous;

import net.lepidodendron.LepidodendronConfig;
import net.lepidodendron.enchantments.Enchantments;
import net.lepidodendron.item.ItemBoneWand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.pncarboniferous.world.dimension.carboniferous.WorldCarboniferous;

public class PNWandHandler {

    @SubscribeEvent
    public void useWand(PlayerInteractEvent.RightClickBlock event) {

        EntityPlayer entity = event.getEntityPlayer();
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        EnumHand hand = event.getHand();
        EnumFacing facing = event.getFace();

        if (world.isRemote) {
            return;
        }

        BlockPos pos1 = pos.offset(facing);
        ItemStack itemstack = entity.getHeldItem(hand);

        if (itemstack.getItem() != ItemBoneWand.block) {
            return;
        }

        if (!(itemstack.getItem().getDamage(itemstack) < (itemstack.getItem().getMaxDamage() - 1))) {
            event.setCancellationResult(EnumActionResult.FAIL);
            event.setCanceled(true);
            return;
        }

        int levelEnchantment = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(Enchantments.TIME_REVERSAL, itemstack);
        if (levelEnchantment > 0) {
            if (!entity.canPlayerEdit(pos1, facing, itemstack)) {
                event.setCancellationResult(EnumActionResult.FAIL);
                event.setCanceled(true);
                return;
            }
            if (world.isAirBlock(pos1)) {
                if (world.provider.getDimension() == LepidodendronConfig.dimCarboniferous) {
                    return;
                }
                boolean portalSpawnCarboniferous = WorldCarboniferous.portal.portalSpawn(world, pos1);

                if (portalSpawnCarboniferous) {
                    if (!entity.capabilities.isCreativeMode && itemstack.getItemDamage() < (itemstack.getItem().getMaxDamage() - 1)) {
                        itemstack.damageItem(1, entity);
                    }
                    event.setCancellationResult(EnumActionResult.SUCCESS);
                    event.setCanceled(true);
                    return;
                }
            }
        }
    }

    @SubscribeEvent //Manage Nether portals: when travelling to the Nether
    // use the overworld (or other) portal, not a new Nether Portal in the Nether itself.
    //This subscriber is also copied into the dimension mods to deal with those.
    public void goToNether(EntityTravelToDimensionEvent event) {
        if (LepidodendronConfig.oneWayPortalsNether && LepidodendronConfig.oneWayPortals) {
            if (event.getDimension() == -1) {
                //We are travelling to the Nether from here:
                Entity entityIn = event.getEntity();
                World worldIn = entityIn.getEntityWorld();

                if (event.getEntity().getEntityWorld().provider.getDimensionType().getId() == LepidodendronConfig.dimCarboniferous) {
                    if (!worldIn.isRemote && !entityIn.isRiding() && !entityIn.isBeingRidden() && entityIn instanceof EntityPlayerMP) {
                        EntityPlayerMP thePlayer = (EntityPlayerMP) entityIn;
                        if (thePlayer.dimension != event.getDimension()) {
                            thePlayer.timeUntilPortal = 10;
                            ReflectionHelper.setPrivateValue(EntityPlayerMP.class, thePlayer, true, "invulnerableDimensionChange", "field_184851_cj");
                            WorldCarboniferous.BlockCustomPortal.transferPlayerToDimensionPN(thePlayer.server.getPlayerList(), thePlayer, event.getDimension(), WorldCarboniferous.BlockCustomPortal.getTeleporterForDimension(thePlayer, entityIn.getPosition(), event.getDimension()));
                        }
                    }
                    event.setCanceled(true);
                }
            }
        }
    }
}