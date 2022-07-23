package committee.nova.smithing

import committee.nova.smithing.common.proxy.CommonProxy
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.{Mod, SidedProxy}
@Mod(modid = Smithing.MODID, useMetadata = true, modLanguage = "scala")
object Smithing {
  final val MODID = "smithing"
  @SidedProxy(serverSide = "committee.nova.smithing.common.proxy.CommonProxy", clientSide = "committee.nova.smithing.client.proxy.ClientProxy")
  var proxy: CommonProxy = _

  @EventHandler
  def preInit(event: FMLPreInitializationEvent): Unit = proxy.preInit(event)

  @EventHandler
  def init(event: FMLInitializationEvent): Unit = proxy.init(event)
}