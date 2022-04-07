package committee.nova.smithing.common.util

import committee.nova.smithing.common.block.init.BlockInit
import committee.nova.smithing.common.item.init.ItemInit
import committee.nova.smithing.common.item.material.MaterialInit
import committee.nova.smithing.common.world.OreGeneration
import cpw.mods.fml.common.registry.GameRegistry

object RegistryHandler {
  def register(): Unit = {
    BlockInit.init()
    ItemInit.init()
    MaterialInit.init()
    GameRegistry.registerWorldGenerator(new OreGeneration, 1)
  }
}
