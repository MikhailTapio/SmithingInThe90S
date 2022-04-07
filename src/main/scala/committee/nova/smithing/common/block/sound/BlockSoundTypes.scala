package committee.nova.smithing.common.block.sound

import committee.nova.smithing.Smithing
import net.minecraft.block.Block.SoundType

object BlockSoundTypes {
  val ancientDebris = new ModSoundType("ancientDebris", 1F, 1F)
  val netheriteBlock = new ModSoundType("netheriteBlock", 1F, 1F)

  class ModSoundType(name: String, f1: Float, f2: Float) extends SoundType(name, f1, f2) {
    override def getBreakSound: String = Smithing.MODID + ":" + super.getBreakSound

    override def getStepResourcePath: String = Smithing.MODID + ":" + super.getStepResourcePath
  }
}

