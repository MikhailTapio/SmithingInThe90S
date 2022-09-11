package committee.nova.smithing.common.event

import committee.nova.smithing.common.advancement.init.AdvancementInit
import committee.nova.smithing.common.block.init.BlockInit
import committee.nova.smithing.common.item.init.ItemInit
import committee.nova.smithing.common.util.Utilities
import net.minecraft.entity.player.EntityPlayer
import net.minecraftforge.event.ForgeSubscribe
import net.minecraftforge.event.entity.player.EntityItemPickupEvent

import scala.collection.mutable.ArrayBuffer

class SmithingEventHandler {
  @ForgeSubscribe
  def onPlayerGainItem(event: EntityItemPickupEvent): Unit = {
    if (event.isCanceled) return
    if (!event.entity.isInstanceOf[EntityPlayer]) return
    val player = event.entity.asInstanceOf[EntityPlayer]
    val item = event.item.getEntityItem.getItem
    if (item.itemID == BlockInit.blockList(BlockInit.names(0)).blockID) {
      player.triggerAchievement(AdvancementInit.hiddenInTheDepths)
      return
    }
    if (!item.getUnlocalizedName.substring(5).startsWith("smithing.netherite")) return
    if (item == ItemInit.itemList(ItemInit.names(3))) {
      player.triggerAchievement(AdvancementInit.seriousDedication)
      return
    }
    val required = ArrayBuffer(ItemInit.itemList(ItemInit.names(4)), ItemInit.itemList(ItemInit.names(5)), ItemInit.itemList(ItemInit.names(6)), ItemInit.itemList(ItemInit.names(7)))
    if (!required.contains(item)) return
    val inventory = player.inventory
    val r = required.-(item)
    if (Utilities.hasTheseItem(r.toArray, inventory)) player.triggerAchievement(AdvancementInit.coverMeInDebris)
  }
}
