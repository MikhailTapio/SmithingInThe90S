package committee.nova.smithing.client.proxy

import committee.nova.smithing.client.sound.SoundInit
import committee.nova.smithing.common.proxy.CommonProxy
import cpw.mods.fml.common.event.FMLPreInitializationEvent

class ClientProxy extends CommonProxy {
  override def preInit(event: FMLPreInitializationEvent): Unit = {
    super.preInit(event)
    SoundInit.init()
  }
}