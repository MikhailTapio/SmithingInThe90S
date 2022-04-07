package committee.nova.smithing.common.block.impl

import committee.nova.smithing.common.block.base.BlockMultiFaces
import committee.nova.smithing.common.block.init.BlockInit._
import committee.nova.smithing.common.block.sound.BlockSoundTypes.ancientDebris
import net.minecraft.util.IIcon

class BlockAncientDebris extends BlockMultiFaces(netherite, names(0), 2) {
  setHardness(30F)
  setResistance(1200F)
  setStepSound(ancientDebris)
  setHarvestLevel("pickaxe", 3)

  override def getIcon(side: Int, meta: Int): IIcon = icons(if (side <= 1) 0 else 1)
}
