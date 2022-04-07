package committee.nova.smithing

import committee.nova.smithing.Smithing.proxy
import committee.nova.smithing.common.proxy.CommonProxy
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.{Mod, SidedProxy}

object Smithing {
  final val MODID = "smithing"
  @SidedProxy(serverSide = "committee.nova.smithing.common.proxy.CommonProxy")
  val proxy: CommonProxy = new CommonProxy
  @Mod.Instance(Smithing.MODID)
  var instance: Smithing = _
}

@Mod(modid = Smithing.MODID, useMetadata = true)
class Smithing {
  Smithing.instance = this
  @EventHandler
  def preInit(event: FMLPreInitializationEvent): Unit = proxy.preInit(event)
  @EventHandler
  def init(event: FMLInitializationEvent): Unit = proxy.init(event)
}