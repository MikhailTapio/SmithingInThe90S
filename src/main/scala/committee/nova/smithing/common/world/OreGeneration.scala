package committee.nova.smithing.common.world

import java.util.Random

import committee.nova.smithing.common.block.init.BlockInit._
import cpw.mods.fml.common.IWorldGenerator
import net.minecraft.block.Block
import net.minecraft.world.World
import net.minecraft.world.chunk.IChunkProvider
import net.minecraft.world.gen.feature.WorldGenMinable

class OreGeneration extends IWorldGenerator {
  override def generate(random: Random, chunkX: Int, chunkZ: Int, world: World, chunkGenerator: IChunkProvider, chunkProvider: IChunkProvider): Unit = {
    if (world.provider.dimensionId == -1) generateOre(blockList(names(0)), world, random, chunkX, chunkZ, 3, 1, 8, 119, Block.netherrack)
  }

  def generateOre(block: Block, world: World, random: Random, chunkX: Int, chunkZ: Int,
                  vein: Int, chance: Int, minY: Int, maxY: Int, generateIn: Block): Unit = {
    val gen = new WorldGenMinable(block.blockID, vein, generateIn.blockID)
    for (_ <- 0 until chance) {
      val xRand = chunkX * 16 + random.nextInt(16)
      val yRand = random.nextInt(maxY - minY) + minY
      val zRand = chunkZ * 16 + random.nextInt(16)
      gen.generate(world, random, xRand, yRand, zRand)
    }
  }
}
