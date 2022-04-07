package committee.nova.smithing.common.event

import committee.nova.smithing.common.advancement.init.AdvancementInit
import committee.nova.smithing.common.block.init.BlockInit
import committee.nova.smithing.common.item.init.ItemInit
import committee.nova.smithing.common.util.Utilities
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import net.minecraft.entity.item.EntityItem
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.Item
import net.minecraftforge.event.entity.EntityJoinWorldEvent
import net.minecraftforge.event.entity.player.EntityItemPickupEvent

import scala.collection.mutable.ArrayBuffer


class SmithingEventHandler {
  @SubscribeEvent
  def onItemDrop(event: EntityJoinWorldEvent): Unit = {
    val e = event.entity
    if (!e.isInstanceOf[EntityItem]) return
    val itemEntity = e.asInstanceOf[EntityItem]
    val unlocalized = itemEntity.getEntityItem.getItem.getUnlocalizedName.substring(5)
    if (!unlocalized.startsWith("smithing.netherite") && !unlocalized.startsWith("smithing.ancient")) return
    val big = Integer.MAX_VALUE / 2
    itemEntity.fireResistance = big
    itemEntity.isImmuneToFire = true
    itemEntity.health = big
  }

  @SubscribeEvent
  def onPlayerGainItem(event: EntityItemPickupEvent): Unit = {
    if (event.isCanceled) return
    if (!event.entity.isInstanceOf[EntityPlayer]) return
    val player = event.entity.asInstanceOf[EntityPlayer]
    val item = event.item.getEntityItem.getItem
    if (item == Item.getItemFromBlock(BlockInit.blockList(BlockInit.names(0)))) {
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
