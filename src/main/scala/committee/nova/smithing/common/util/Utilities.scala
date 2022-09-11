package committee.nova.smithing.common.util

import committee.nova.smithing.Smithing
import net.minecraft.creativetab.CreativeTabs._
import net.minecraft.entity.player.InventoryPlayer
import net.minecraft.item.Item
import net.minecraftforge.oredict.OreDictionary

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
      if (!inv.hasItem(item.itemID)) return false
    }
    true
  }

  def isNetheriteIngot(item: Item): Boolean = {
    val ores = OreDictionary.getOres("ingotNetherite")
    val size = ores.size()
    for (i <- 0 until size) if (ores.get(i).getItem == item) return true
    false
  }
}
