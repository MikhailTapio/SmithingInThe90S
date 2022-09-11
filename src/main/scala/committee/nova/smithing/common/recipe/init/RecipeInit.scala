package committee.nova.smithing.common.recipe.init

import committee.nova.smithing.common.block.init.BlockInit
import committee.nova.smithing.common.item.init.ItemInit
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.item.{Item, ItemStack}
import net.minecraftforge.oredict.{ShapedOreRecipe, ShapelessOreRecipe}

object RecipeInit {
  val n_ingot: Item = ItemInit.itemList(ItemInit.names(9))

  def init(): Unit = {
    registerCrafting()
    registerSmelting()
  }

  private def registerCrafting(): Unit = {
    val stick = "stickWood"
    val ni = "ingotNetherite"
    GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(n_ingot, 9), "blockNetherite"))
    GameRegistry.addRecipe(new ShapelessOreRecipe(BlockInit.blockList(BlockInit.names(1)), ni, ni, ni, ni, ni, ni, ni, ni, ni))
    GameRegistry.addRecipe(new ShapedOreRecipe(ItemInit.itemList(ItemInit.names(0)),
      " # ", " S ", " S ", jC('#'), ni, jC('S'), stick))
    GameRegistry.addRecipe(new ShapedOreRecipe(ItemInit.itemList(ItemInit.names(1)),
      "###", " S ", " S ", jC('#'), ni, jC('S'), stick))
    GameRegistry.addRecipe(new ShapedOreRecipe(ItemInit.itemList(ItemInit.names(2)),
      "## ", "#S ", " S ", jC('#'), ni, jC('S'), stick))
    GameRegistry.addRecipe(new ShapedOreRecipe(ItemInit.itemList(ItemInit.names(2)),
      " ##", " S#", " S ", jC('#'), ni, jC('S'), stick))
    GameRegistry.addRecipe(new ShapedOreRecipe(ItemInit.itemList(ItemInit.names(3)),
      "## ", " S ", " S ", jC('#'), ni, jC('S'), stick))
    GameRegistry.addRecipe(new ShapedOreRecipe(ItemInit.itemList(ItemInit.names(3)),
      " ##", " S ", " S ", jC('#'), ni, jC('S'), stick))
    GameRegistry.addRecipe(new ShapedOreRecipe(ItemInit.itemList(ItemInit.names(4)),
      "###", "# #", jC('#'), ni))
    GameRegistry.addRecipe(new ShapedOreRecipe(ItemInit.itemList(ItemInit.names(5)),
      "# #", "###", "###", jC('#'), ni))
    GameRegistry.addRecipe(new ShapedOreRecipe(ItemInit.itemList(ItemInit.names(6)),
      "###", "# #", "# #", jC('#'), ni))
    GameRegistry.addRecipe(new ShapedOreRecipe(ItemInit.itemList(ItemInit.names(7)),
      "# #", "# #", jC('#'), ni))
    GameRegistry.addRecipe(new ShapedOreRecipe(ItemInit.itemList(ItemInit.names(8)),
      " # ", " # ", " S ", jC('#'), ni, jC('S'), stick))
    GameRegistry.addRecipe(new ShapedOreRecipe(n_ingot,
      "###", "#GG", "GG ", jC('#'), "scrapNetherite", jC('G'), "ingotGold"))
    GameRegistry.addRecipe(new ShapedOreRecipe(BlockInit.blockList(BlockInit.names(2)),
      "II ", "WW ", "WW ", jC('I'), "ingotIron", jC('W'), "plankWood"))
  }

  private def jC(char: Char): Character = char.asInstanceOf[Character]

  private def registerSmelting(): Unit = GameRegistry.addSmelting(BlockInit.blockList(BlockInit.names(0)).blockID, new ItemStack(ItemInit.itemList(ItemInit.names(10))), 2F)
}
