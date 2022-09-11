package committee.nova.smithing.common.item.material

import committee.nova.smithing.common.item.init.ItemInit
import committee.nova.smithing.common.util.Utilities.NETHERITE
import net.minecraft.item.{EnumArmorMaterial, EnumToolMaterial}
import net.minecraftforge.common.EnumHelper

object MaterialInit {
  val NETHERITE_ARMOR: EnumArmorMaterial = EnumHelper.addArmorMaterial(NETHERITE, 37, Array(4, 7, 9, 4), 15)
  val NETHERITE_TOOL: EnumToolMaterial = EnumHelper.addToolMaterial(NETHERITE, 3, 2031, 9F, 4F, 15)

  def init(): Unit = {
    NETHERITE_ARMOR.customCraftingMaterial = ItemInit.itemList(ItemInit.names(9))
    NETHERITE_TOOL.customCraftingMaterial = ItemInit.itemList(ItemInit.names(9))
  }
}
