package committee.nova.smithing.common.block.impl

import committee.nova.smithing.common.block.base.BlockMultiFaces
import committee.nova.smithing.common.block.init.BlockInit._
import committee.nova.smithing.common.block.sound.BlockSoundTypes.ancientDebris
import net.minecraft.util.Icon

class BlockAncientDebris(id: Int) extends BlockMultiFaces(id, netherite, names(0), 2) {
  setHardness(30F)
  setResistance(1200F)
  setStepSound(ancientDebris)

  override def getIcon(side: Int, meta: Int): Icon = icons(if (side <= 1) 0 else 1)
}
