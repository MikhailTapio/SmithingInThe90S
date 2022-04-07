package committee.nova.smithing.common.recipe

import committee.nova.smithing.common.item.init.ItemInit._
import net.minecraft.init.Items
import net.minecraft.item.Item

object SmithingPreference {
  private val smithingMap: Map[Item, Item] = Map(
    Items.diamond_shovel -> itemList(names(0)),
    Items.diamond_pickaxe -> itemList(names(1)),
    Items.diamond_axe -> itemList(names(2)),
    Items.diamond_hoe -> itemList(names(3)),
    Items.diamond_helmet -> itemList(names(4)),
    Items.diamond_chestplate -> itemList(names(5)),
    Items.diamond_leggings -> itemList(names(6)),
    Items.diamond_boots -> itemList(names(7)),
    Items.diamond_sword -> itemList(names(8))
  )

  def getSmithingMap: Map[Item, Item] = smithingMap

}
