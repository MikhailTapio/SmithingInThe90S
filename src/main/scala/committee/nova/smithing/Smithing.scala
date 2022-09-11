package committee.nova.smithing

import committee.nova.smithing.common.proxy.CommonProxy
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.network.NetworkMod
import cpw.mods.fml.common.{Mod, SidedProxy}

@Mod(modid = Smithing.MODID, useMetadata = true, modLanguage = "scala")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
object Smithing {
  final val MODID = "smithing"
  @SidedProxy(serverSide = "committee.nova.smithing.common.proxy.CommonProxy", clientSide = "committee.nova.smithing.client.proxy.ClientProxy")
  var proxy: CommonProxy = _

  @EventHandler
  def preInit(e: FMLPreInitializationEvent): Unit = proxy.preInit(e)

  @EventHandler
  def init(e: FMLInitializationEvent): Unit = proxy.init(e)

  @EventHandler
  def postInit(e: FMLPostInitializationEvent): Unit = proxy.postInit(e)
}