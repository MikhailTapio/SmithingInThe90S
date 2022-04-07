package committee.nova.smithing.common.util

import committee.nova.smithing.Smithing
import net.minecraft.creativetab.CreativeTabs._
import net.minecraft.entity.player.InventoryPlayer
import net.minecraft.item.Item

object Utilities {
  val NETHERITE = "netherite"

  def prefixId(id: String): String = NETHERITE + "_" + id

  def itemWithProperties(item: Item, id: String, isTool: Boolean): Item = {
    item.setUnlocalizedName(prefixName(id))
    item.setFull3D()
    item.setTextureName(prefixResourceLocation(id))
    item.setCreativeTab(if (isTool) tabTools else tabCombat)
  }

  def prefixName(id: String): String = Smithing.MODID + "." + id

  def prefixResourceLocation(id: String): String = Smithing.MODID + ":" + id

  def hasTheseItem(items: Array[Item], inv: InventoryPlayer): Boolean = {
    for (item <- items) {
      if (!inv.hasItem(item)) return false
    }
    true
  }
}
