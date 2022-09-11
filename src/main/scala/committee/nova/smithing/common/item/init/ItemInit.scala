package committee.nova.smithing.common.item.init

import committee.nova.smithing.common.config.CommonConfig._
import committee.nova.smithing.common.item.impl.{ItemNetheriteArmor, ItemNetheriteAxe, ItemNetheritePickaxe}
import committee.nova.smithing.common.item.material.MaterialInit._
import committee.nova.smithing.common.util.Utilities._
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.creativetab.CreativeTabs._
import net.minecraft.item._

object ItemInit {
  val names: Array[String] = Array(prefixId("shovel"), prefixId("pickaxe"), prefixId("axe"), prefixId("hoe"),
    prefixId("helmet"), prefixId("chestplate"), prefixId("leggings"), prefixId("boots"), prefixId("sword"), prefixId("ingot"), prefixId("scrap"))
  val itemList: Map[String, Item] = Map(
    names(0) -> itemWithProperties(new ItemSpade(idNetheriteShovel, NETHERITE_TOOL), names(0), isTool = true),
    names(1) -> new ItemNetheritePickaxe(idNetheritePickaxe),
    names(2) -> new ItemNetheriteAxe(idNetheriteAxe),
    names(3) -> itemWithProperties(new ItemHoe(idNetheriteHoe, NETHERITE_TOOL), names(3), isTool = true),
    names(4) -> itemWithProperties(new ItemNetheriteArmor(idNetheriteHelmet, 0), names(4), isTool = false),
    names(5) -> itemWithProperties(new ItemNetheriteArmor(idNetheriteChestplate, 1), names(5), isTool = false),
    names(6) -> itemWithProperties(new ItemNetheriteArmor(idNetheriteLeggings, 2), names(6), isTool = false),
    names(7) -> itemWithProperties(new ItemNetheriteArmor(idNetheriteBoots, 3), names(7), isTool = false),
    names(8) -> itemWithProperties(new ItemSword(idNetheriteSword, NETHERITE_TOOL), names(8), isTool = false),
    names(9) -> new Item(idNetheriteIngot) {
      setUnlocalizedName(prefixName(names(9)))
      setTextureName(prefixResourceLocation(names(9)))
      setCreativeTab(tabMaterials)
      //override def isBeaconPayment(stack: ItemStack): Boolean = true
    },
    names(10) -> new Item(idNetheriteScrap) {
      setUnlocalizedName(prefixName(names(10)))
      setTextureName(prefixResourceLocation(names(10)))
      setCreativeTab(tabMaterials)
    }
  )

  def init(): Unit = itemList.foreach(list => register(list._1, list._2))

  private def register(id: String, item: Item): Unit = GameRegistry.registerItem(item, id)
}
