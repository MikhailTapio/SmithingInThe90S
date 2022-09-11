package committee.nova.smithing.common.block.init

import committee.nova.smithing.common.block.base.BlockMaterial
import committee.nova.smithing.common.block.impl.{BlockAncientDebris, BlockSmithingTable}
import committee.nova.smithing.common.block.sound.BlockSoundTypes._
import committee.nova.smithing.common.config.CommonConfig._
import committee.nova.smithing.common.util.Utilities._
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.block.Block
import net.minecraft.block.material.{MapColor, Material}
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.world.World

object BlockInit {
  val names: Array[String] = Array("ancient_debris", prefixId("block"), "smithing_table")
  val netherite: Material = new Material(MapColor.stoneColor) {
    setRequiresTool()
  }
  val blockList = Map(
    names(0) -> new BlockAncientDebris(idAncientDebris),
    names(1) -> new BlockMaterial(idNetheriteBlock, netherite) {

      override def isBeaconBase(worldObj: World, x: Int, y: Int, z: Int, beaconX: Int, beaconY: Int, beaconZ: Int): Boolean = true
    }.setHardness(30F).setResistance(1200F).setStepSound(netheriteBlock).setUnlocalizedName(prefixName(names(1))).
      setTextureName(prefixResourceLocation(names(1))).setCreativeTab(CreativeTabs.tabBlock),
    names(2) -> new BlockSmithingTable(idSmithingTable)
  )

  def init(): Unit = blockList.foreach(list => register(list._1, list._2))

  private def register(id: String, block: Block): Unit = GameRegistry.registerBlock(block, id)
}
