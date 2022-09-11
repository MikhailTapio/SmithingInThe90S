package committee.nova.smithing.common.block.impl

import committee.nova.smithing.Smithing
import committee.nova.smithing.client.gui.init.GuiInit
import committee.nova.smithing.common.block.init.BlockInit.names
import committee.nova.smithing.common.util.Utilities
import committee.nova.smithing.common.util.Utilities.{prefixName, prefixResourceLocation}
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.texture.IconRegister
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.Icon
import net.minecraft.world.World

class BlockSmithingTable(id: Int) extends Block(id, Material.wood) {
  setCreativeTab(CreativeTabs.tabDecorations)
  setUnlocalizedName(prefixName(names(2)))
  setTextureName(Utilities.prefixResourceLocation(names(2)))
  setHardness(2.5F)
  setResistance(2.5F)
  setStepSound(Block.soundWoodFootstep)

  val icons: Array[Icon] = Array(null, null, null, null, null, null)
  val iconMap = Map(0 -> 0, 1 -> 1, 2 -> 2, 3 -> 2, 4 -> 3, 5 -> 3)

  override def getIcon(side: Int, meta: Int): Icon = icons(iconMap(side))

  override def onBlockActivated(world: World, x: Int, y: Int, z: Int, player: EntityPlayer, side: Int, subX: Float, subY: Float, subZ: Float): Boolean = {
    if (!world.isRemote) player.openGui(Smithing, GuiInit.smithingTable, world, x, y, z)
    true
  }

  override def registerIcons(reg: IconRegister): Unit = for (i <- 0 until 4) icons(i) = reg.registerIcon(prefixResourceLocation(names(2) + "_" + String.valueOf(i)))
}
