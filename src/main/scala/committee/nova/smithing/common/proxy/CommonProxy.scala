package committee.nova.smithing.common.proxy

import committee.nova.smithing.client.gui.init.GuiInit
import committee.nova.smithing.common.advancement.init.AdvancementInit
import committee.nova.smithing.common.event.SmithingEventHandler
import committee.nova.smithing.common.recipe.init.RecipeInit
import committee.nova.smithing.common.util.RegistryHandler
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPreInitializationEvent}
import net.minecraftforge.common.MinecraftForge

class CommonProxy {
  def preInit(event: FMLPreInitializationEvent): Unit = {
    RegistryHandler.register()
  }

  def init(event: FMLInitializationEvent): Unit = {
    RecipeInit.init()
    GuiInit.init()
    AdvancementInit.init()
    MinecraftForge.EVENT_BUS.register(new SmithingEventHandler)
  }
}
