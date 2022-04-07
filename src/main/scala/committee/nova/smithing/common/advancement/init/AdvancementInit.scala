package committee.nova.smithing.common.advancement.init

import committee.nova.smithing.common.block.init.BlockInit
import committee.nova.smithing.common.item.init.ItemInit
import net.minecraft.stats.{Achievement, AchievementList}

object AdvancementInit {
  val hiddenInTheDepths = new Achievement(prefix("hiddenInTheDepths", p = true), prefix("hiddenInTheDepths", p = false), 1, 7, BlockInit.blockList(BlockInit.names(0)), AchievementList.portal)
  val coverMeInDebris = new Achievement(prefix("coverMeInDebris", p = true), prefix("coverMeInDebris", p = false), 5, 9, ItemInit.itemList(ItemInit.names(5)), hiddenInTheDepths)
  val seriousDedication = new Achievement(prefix("seriousDedication", p = true), prefix("seriousDedication", p = false), 1, -2, ItemInit.itemList(ItemInit.names(3)), AchievementList.buildHoe)

  def init(): Unit = {
    hiddenInTheDepths.registerStat()
    coverMeInDebris.setSpecial().registerStat()
    seriousDedication.setSpecial().registerStat()
  }

  def prefix(id: String, p: Boolean): String = {
    (if (p) "achievement." else "") + "smithing." + id
  }
}
