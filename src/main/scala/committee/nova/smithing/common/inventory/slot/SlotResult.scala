package committee.nova.smithing.common.inventory.slot

import committee.nova.smithing.common.inventory.ContainerSmithingTable
import committee.nova.smithing.common.util.Utilities.prefixResourceLocation
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.{IInventory, Slot}
import net.minecraft.item.ItemStack

class SlotResult(container: ContainerSmithingTable, inv: IInventory, index: Int, x: Int, y: Int) extends Slot(inv, index, x, y) {
  override def isItemValid(stack: ItemStack): Boolean = false

  override def canTakeStack(player: EntityPlayer): Boolean = this.getHasStack

  override def onPickupFromSlot(player: EntityPlayer, stack: ItemStack): Unit = {
    val applicant = container.inputSlots.getStackInSlot(0)
    applicant.stackSize -= 1
    container.inputSlots.setInventorySlotContents(0, if (applicant.stackSize > 0) applicant else null)
    val ingot = container.inputSlots.getStackInSlot(1)
    ingot.stackSize -= 1
    container.inputSlots.setInventorySlotContents(1, if (ingot.stackSize > 0) ingot else null)
    player.playSound(prefixResourceLocation("use.smithingTable"), 1F, 1F)
  }
}
