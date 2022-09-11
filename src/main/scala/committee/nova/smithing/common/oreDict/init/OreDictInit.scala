package committee.nova.smithing.common.oreDict.init

import committee.nova.smithing.common.block.init.BlockInit
import committee.nova.smithing.common.item.init.ItemInit
import cpw.mods.fml.common.event.FMLInitializationEvent
import net.minecraftforge.oredict.OreDictionary

object OreDictInit {
  def init(event: FMLInitializationEvent): Unit = {
    OreDictionary.registerOre("scrapNetherite", ItemInit.itemList(ItemInit.names(10)))
    OreDictionary.registerOre("ingotNetherite", ItemInit.itemList(ItemInit.names(9)))
    OreDictionary.registerOre("oreNetherite", BlockInit.blockList(BlockInit.names(0)))
    OreDictionary.registerOre("debrisAncient", BlockInit.blockList(BlockInit.names(0)))
    OreDictionary.registerOre("blockNetherite", BlockInit.blockList(BlockInit.names(1)))
  }
}
