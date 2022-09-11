package committee.nova.smithing.common.util

import committee.nova.smithing.common.block.init.BlockInit
import committee.nova.smithing.common.item.init.ItemInit
import committee.nova.smithing.common.item.material.MaterialInit
import committee.nova.smithing.common.oreDict.init.OreDictInit
import committee.nova.smithing.common.world.OreGeneration
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent}
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraftforge.common.MinecraftForge

object RegistryHandler {
  def register(event: FMLInitializationEvent): Unit = {
    BlockInit.init()
    ItemInit.init()
    MaterialInit.init()
    OreDictInit.init(event)
    GameRegistry.registerWorldGenerator(new OreGeneration)
  }

  def registerHarvestLevel(event: FMLPostInitializationEvent): Unit = {
    MinecraftForge.setBlockHarvestLevel(BlockInit.blockList(BlockInit.names(0)), "pickaxe", 3)
    MinecraftForge.setBlockHarvestLevel(BlockInit.blockList(BlockInit.names(1)), "pickaxe", 3)
  }
}
