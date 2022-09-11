package committee.nova.smithing.common.advancement.init

import committee.nova.smithing.common.block.init.BlockInit
import committee.nova.smithing.common.config.CommonConfig._
import committee.nova.smithing.common.item.init.ItemInit
import net.minecraft.stats.{Achievement, AchievementList}

object AdvancementInit {
  val hiddenInTheDepths = new Achievement(idHiddenInTheDepths, prefix("hiddenInTheDepths"), 1, 7, BlockInit.blockList(BlockInit.names(0)), AchievementList.portal)
  val coverMeInDebris = new Achievement(idCoverMeInDebris, prefix("coverMeInDebris"), 5, 9, ItemInit.itemList(ItemInit.names(5)), hiddenInTheDepths)
  val seriousDedication = new Achievement(idSeriousDedication, prefix("seriousDedication"), 1, -2, ItemInit.itemList(ItemInit.names(3)), AchievementList.buildHoe)

  def init(): Unit = {
    hiddenInTheDepths.setSpecial().registerAchievement()
    coverMeInDebris.setSpecial().registerAchievement()
    seriousDedication.setSpecial().registerAchievement()
  }

  def prefix(id: String): String = "smithing." + id
}
