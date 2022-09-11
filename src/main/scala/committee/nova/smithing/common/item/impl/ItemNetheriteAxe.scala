package committee.nova.smithing.common.item.impl

import committee.nova.smithing.common.item.init.ItemInit.names
import committee.nova.smithing.common.item.material.MaterialInit
import committee.nova.smithing.common.util.Utilities.{prefixName, prefixResourceLocation}
import net.minecraft.creativetab.CreativeTabs.tabTools
import net.minecraft.item.ItemAxe

class ItemNetheriteAxe(id: Int) extends ItemAxe(id, MaterialInit.NETHERITE_TOOL) {
  setUnlocalizedName(prefixName(names(2)))
  setFull3D()
  setTextureName(prefixResourceLocation(names(2)))
  setCreativeTab(tabTools)
}
