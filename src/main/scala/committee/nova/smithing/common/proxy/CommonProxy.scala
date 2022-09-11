package committee.nova.smithing.common.proxy

import committee.nova.smithing.client.gui.init.GuiInit
import committee.nova.smithing.common.advancement.init.AdvancementInit
import committee.nova.smithing.common.config.CommonConfig
import committee.nova.smithing.common.event.SmithingEventHandler
import committee.nova.smithing.common.recipe.init.RecipeInit
import committee.nova.smithing.common.util.RegistryHandler
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import net.minecraftforge.common.MinecraftForge

class CommonProxy {
  def preInit(event: FMLPreInitializationEvent): Unit = CommonConfig.init(event)

  def init(event: FMLInitializationEvent): Unit = {
    RegistryHandler.register(event)
    RecipeInit.init()
    GuiInit.init()
    AdvancementInit.init()
    MinecraftForge.EVENT_BUS.register(new SmithingEventHandler)
  }

  def postInit(event: FMLPostInitializationEvent): Unit = RegistryHandler.registerHarvestLevel(event)
}
