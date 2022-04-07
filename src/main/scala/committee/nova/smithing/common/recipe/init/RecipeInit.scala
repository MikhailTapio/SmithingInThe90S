package committee.nova.smithing.common.recipe.init

import committee.nova.smithing.common.block.init.BlockInit
import committee.nova.smithing.common.item.init.ItemInit
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.init.Items
import net.minecraft.item.{Item, ItemStack}
import net.minecraftforge.oredict.ShapedOreRecipe

object RecipeInit {
  val n_ingot: Item = ItemInit.itemList(ItemInit.names(9))

  def init(): Unit = {
    registerCrafting()
    registerSmelting()
  }

  private def registerCrafting(): Unit = {
    GameRegistry.addShapelessRecipe(new ItemStack((n_ingot), 9), new ItemStack(BlockInit.blockList(BlockInit.names(1))))
    GameRegistry.addShapelessRecipe(new ItemStack(BlockInit.blockList(BlockInit.names(1))), n_ingot, n_ingot, n_ingot, n_ingot, n_ingot, n_ingot, n_ingot, n_ingot, n_ingot)
    GameRegistry.addShapedRecipe(new ItemStack(ItemInit.itemList(ItemInit.names(0))),
      " # ", " S ", " S ", jC('#'), n_ingot, jC('S'), Items.stick)
    GameRegistry.addShapedRecipe(new ItemStack(ItemInit.itemList(ItemInit.names(1))),
      "###", " S ", " S ", jC('#'), n_ingot, jC('S'), Items.stick)
    GameRegistry.addShapedRecipe(new ItemStack(ItemInit.itemList(ItemInit.names(2))),
      "## ", "#S ", " S ", jC('#'), n_ingot, jC('S'), Items.stick)
    GameRegistry.addShapedRecipe(new ItemStack(ItemInit.itemList(ItemInit.names(2))),
      " ##", " S#", " S ", jC('#'), n_ingot, jC('S'), Items.stick)
    GameRegistry.addShapedRecipe(new ItemStack(ItemInit.itemList(ItemInit.names(3))),
      "## ", " S ", " S ", jC('#'), n_ingot, jC('S'), Items.stick)
    GameRegistry.addShapedRecipe(new ItemStack(ItemInit.itemList(ItemInit.names(3))),
      " ##", " S ", " S ", jC('#'), n_ingot, jC('S'), Items.stick)
    GameRegistry.addShapedRecipe(new ItemStack(ItemInit.itemList(ItemInit.names(4))),
      "###", "# #", jC('#'), n_ingot)
    GameRegistry.addShapedRecipe(new ItemStack(ItemInit.itemList(ItemInit.names(5))),
      "# #", "###", "###", jC('#'), n_ingot)
    GameRegistry.addShapedRecipe(new ItemStack(ItemInit.itemList(ItemInit.names(6))),
      "###", "# #", "# #", jC('#'), n_ingot)
    GameRegistry.addShapedRecipe(new ItemStack(ItemInit.itemList(ItemInit.names(7))),
      "# #", "# #", jC('#'), n_ingot)
    GameRegistry.addShapedRecipe(new ItemStack(ItemInit.itemList(ItemInit.names(8))),
      " # ", " # ", " S ", jC('#'), n_ingot, jC('S'), Items.stick)
    GameRegistry.addShapedRecipe(new ItemStack(ItemInit.itemList(ItemInit.names(9))),
      "###", "#GG", "GG ", jC('#'), n_ingot, jC('G'), Items.gold_ingot)
    GameRegistry.addRecipe(new ShapedOreRecipe(BlockInit.blockList(BlockInit.names(2)),
      "II ", "WW ", "WW ", jC('I'), Items.iron_ingot, jC('W'), "plankWood"))
  }

  private def jC(char: Char): Character = char.asInstanceOf[Character]

  private def registerSmelting(): Unit = {
    GameRegistry.addSmelting(BlockInit.blockList(BlockInit.names(0)), new ItemStack(ItemInit.itemList(ItemInit.names(10))), 2F)
  }
}
