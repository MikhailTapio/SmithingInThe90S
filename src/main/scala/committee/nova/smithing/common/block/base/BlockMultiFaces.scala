package committee.nova.smithing.common.block.base

import committee.nova.smithing.common.util.Utilities._
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.creativetab.CreativeTabs.tabBlock
import net.minecraft.util.IIcon

class BlockMultiFaces(material: Material, name: String, sides: Int) extends BlockMaterial(material) {
  setBlockName(prefixName(name))
  setCreativeTab(tabBlock)
  val icons: Array[IIcon] = Array(null, null, null, null, null, null)

  override def registerBlockIcons(reg: IIconRegister): Unit = for (i <- 0 until sides) icons(i) = reg.registerIcon(prefixResourceLocation(name + "_" + String.valueOf(i)))
}
