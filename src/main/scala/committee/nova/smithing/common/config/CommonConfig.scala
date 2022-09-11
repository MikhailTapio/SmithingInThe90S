package committee.nova.smithing.common.config

import committee.nova.smithing.common.config.CommonConfig._
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.common.Configuration

object CommonConfig {
  def init(e: FMLPreInitializationEvent): Unit = new CommonConfig(e)

  private var config: Configuration = _
  var idAncientDebris: Int = _
  var idNetheriteBlock: Int = _
  var idSmithingTable: Int = _

  var idNetheriteShovel: Int = _
  var idNetheritePickaxe: Int = _
  var idNetheriteAxe: Int = _
  var idNetheriteHoe: Int = _
  var idNetheriteHelmet: Int = _
  var idNetheriteChestplate: Int = _
  var idNetheriteLeggings: Int = _
  var idNetheriteBoots: Int = _
  var idNetheriteSword: Int = _
  var idNetheriteIngot: Int = _
  var idNetheriteScrap: Int = _

  var idHiddenInTheDepths: Int = _
  var idCoverMeInDebris: Int = _
  var idSeriousDedication: Int = _

  private def idOf(target: String): String = s"The ID of $target"

  private def of(target: String, defaultValue: Int): Int = config.get(Configuration.CATEGORY_GENERAL, target, defaultValue, idOf(target)).getInt(defaultValue)
}

class CommonConfig(event: FMLPreInitializationEvent) {
  config = new Configuration(event.getSuggestedConfigurationFile)
  config.load()
  idAncientDebris = of("AncientDebris", 3468)
  idNetheriteBlock = of("NetheriteBlock", 3469)
  idSmithingTable = of("SmithingTable", 3470)
  idNetheriteShovel = of("NetheriteShovel", 13468)
  idNetheritePickaxe = of("NetheritePickaxe", 13469)
  idNetheriteAxe = of("NetheriteAxe", 13470)
  idNetheriteHoe = of("NetheriteHoe", 13471)
  idNetheriteHelmet = of("NetheriteHelmet", 13472)
  idNetheriteChestplate = of("NetheriteChestplate", 13473)
  idNetheriteLeggings = of("NetheriteLeggings", 13474)
  idNetheriteBoots = of("NetheriteBoots", 13475)
  idNetheriteSword = of("NetheriteSword", 13476)
  idNetheriteIngot = of("NetheriteIngot", 13477)
  idNetheriteScrap = of("NetheriteScrap", 13478)
  idHiddenInTheDepths = of("HiddenInTheDepths", 134)
  idCoverMeInDebris = of("CoverMeInDebris", 135)
  idSeriousDedication = of("SeriousDedication", 136)
  config.save()
}
