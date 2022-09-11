package committee.nova.smithing.common.recipe

import committee.nova.smithing.common.item.init.ItemInit._
import net.minecraft.item.Item

object SmithingPreference {
  private val smithingMap: Map[Item, Item] = Map(
    Item.shovelDiamond -> itemList(names(0)),
    Item.pickaxeDiamond -> itemList(names(1)),
    Item.axeDiamond -> itemList(names(2)),
    Item.hoeDiamond -> itemList(names(3)),
    Item.helmetDiamond -> itemList(names(4)),
    Item.plateDiamond -> itemList(names(5)),
    Item.legsDiamond -> itemList(names(6)),
    Item.bootsDiamond -> itemList(names(7)),
    Item.swordDiamond -> itemList(names(8))
  )

  def getSmithingMap: Map[Item, Item] = smithingMap
}
