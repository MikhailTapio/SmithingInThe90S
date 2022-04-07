package committee.nova.smithing.common.inventory

import committee.nova.smithing.common.inventory.slot.{SlotLimited, SlotResult}
import committee.nova.smithing.common.item.init.ItemInit
import committee.nova.smithing.common.item.init.ItemInit._
import committee.nova.smithing.common.recipe.SmithingPreference
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.entity.player.{EntityPlayer, InventoryPlayer}
import net.minecraft.inventory._
import net.minecraft.item.ItemStack
import net.minecraft.world.World

class ContainerSmithingTable(inv: InventoryPlayer, world: World) extends Container {
  val inputSlots: InventoryBasic = new InventoryBasic("Smithing", true, 2) {
    override def markDirty(): Unit = {
      super.markDirty()
      onCraftMatrixChanged(this)
    }
  }
  val resultSlot = new InventoryCraftResult
  val applicant = new Slot(inputSlots, 0, 27, 47)
  val ingot = new SlotLimited(inputSlots, 1, 76, 47, itemList(names(9)))
  val result = new SlotResult(this, resultSlot, 2, 134, 47)
  addSlotToContainer(applicant)
  addSlotToContainer(ingot)
  addSlotToContainer(result)
  for (y <- 0 until 3) for (x <- 0 until 9) addSlotToContainer(new Slot(inv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18))
  for (y <- 0 until 9) addSlotToContainer(new Slot(inv, y, 8 + y * 18, 142))

  override def canInteractWith(entityPlayer: EntityPlayer): Boolean = true

  override def onContainerClosed(player: EntityPlayer): Unit = {
    super.onContainerClosed(player)
    if (!world.isRemote) {
      for (i <- 0 until inputSlots.getSizeInventory) {
        val stack = inputSlots.getStackInSlotOnClosing(i)
        if (stack != null) player.dropPlayerItemWithRandomChoice(stack, false)
      }
    }
  }

  override def transferStackInSlot(player: EntityPlayer, index: Int): ItemStack = {
    val s = inventorySlots.get(index)
    if (!s.isInstanceOf[Slot]) return null
    val slot = s.asInstanceOf[Slot]
    if (slot == null || !slot.getHasStack) return null
    val newStack = slot.getStack
    val oldStack = newStack.copy()
    val merged: Boolean = index match {
      case x if x >= 0 && x <= 2 => mergeItemStack(newStack, 3, 39, true)
      case x if x >= 3 && x < 30 =>
        tryUpper(newStack) || mergeItemStack(newStack, 30, 39, false)
      case _ =>
        tryUpper(newStack) || mergeItemStack(newStack, 3, 30, false)
    }
    if (!merged) return null
    if (newStack.stackSize == 0) slot.putStack(null) else slot.onSlotChanged()
    slot.onPickupFromSlot(player, newStack)
    oldStack
  }

  def tryUpper(newStack: ItemStack): Boolean = !ingot.getHasStack && newStack.getItem == itemList(names(9)) && mergeItemStack(newStack, 1, 2, false) || !applicant.getHasStack && mergeItemStack(newStack, 0, 1, false)

  override def onCraftMatrixChanged(inv: IInventory): Unit = {
    super.onCraftMatrixChanged(inv)
    if (inv == this.inputSlots) {
      updateSmithingOutput()
      detectAndSendChanges()
    }
  }

  def updateSmithingOutput(): Unit = {
    val a = inputSlots.getStackInSlot(0)
    val b = inputSlots.getStackInSlot(1)
    if (a == null) {
      resultSlot.setInventorySlotContents(0, null)
      return
    }
    if (!SmithingPreference.getSmithingMap.contains(a.getItem)) {
      resultSlot.setInventorySlotContents(0, null)
      return
    }
    if (b == null) {
      resultSlot.setInventorySlotContents(0, null)
      return
    }
    if (b.getItem != ItemInit.itemList(ItemInit.names(9))) {
      resultSlot.setInventorySlotContents(0, null)
      return
    }
    val result = new ItemStack(SmithingPreference.getSmithingMap(a.copy().getItem))
    val enchantmentMap = EnchantmentHelper.getEnchantments(a.copy())
    EnchantmentHelper.setEnchantments(enchantmentMap, result)
    result.setItemDamage(a.getItemDamage)
    resultSlot.setInventorySlotContents(0, result)
  }

  def unable(): Boolean = (applicant.getHasStack || ingot.getHasStack) && !result.getHasStack
}
