package committee.nova.smithing.common.inventory.slot

import net.minecraft.inventory.{IInventory, Slot}
import net.minecraft.item.{Item, ItemStack}

class SlotLimited(inv: IInventory, index: Int, x: Int, y: Int, limited: Item => Boolean) extends Slot(inv, index, x, y) {
  override def isItemValid(stack: ItemStack): Boolean = limited.apply(stack.getItem)
}
