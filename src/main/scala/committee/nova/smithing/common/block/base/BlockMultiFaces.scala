package committee.nova.smithing.common.block.base

import committee.nova.smithing.common.util.Utilities._
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.texture.IconRegister
import net.minecraft.creativetab.CreativeTabs.tabBlock
import net.minecraft.util.Icon

class BlockMultiFaces(id: Int, material: Material, name: String, sides: Int) extends BlockMaterial(id, material) {
  setUnlocalizedName(prefixName(name))
  setCreativeTab(tabBlock)
  val icons: Array[Icon] = Array(null, null, null, null, null, null)

  override def registerIcons(reg: IconRegister): Unit = for (i <- 0 until sides) icons(i) = reg.registerIcon(prefixResourceLocation(name + "_" + String.valueOf(i)))
}
