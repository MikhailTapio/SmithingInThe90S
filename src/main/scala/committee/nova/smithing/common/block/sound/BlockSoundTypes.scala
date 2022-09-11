package committee.nova.smithing.common.block.sound

import committee.nova.smithing.client.sound.SoundInit._
import committee.nova.smithing.common.util.Utilities.prefixResourceLocation
import net.minecraft.block.StepSound

object BlockSoundTypes {
  val ancientDebris = new ModStepSound("ancientDebris")
  val netheriteBlock = new ModStepSound("netherite")

  class ModStepSound(name: String) extends StepSound(name, 1F, 1F) {
    override def getBreakSound: String = prefixResourceLocation(dig(name, "")).replace('/', '.')

    override def getStepSound: String = prefixResourceLocation(step(name, "")).replace('/', '.')
  }

}
