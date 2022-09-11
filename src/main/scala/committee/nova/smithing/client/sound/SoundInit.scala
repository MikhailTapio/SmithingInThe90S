package committee.nova.smithing.client.sound

import committee.nova.smithing.client.sound.SoundInit._
import committee.nova.smithing.common.util.Utilities.prefixResourceLocation
import net.minecraft.client.audio.SoundManager
import net.minecraftforge.client.event.sound.SoundLoadEvent
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.ForgeSubscribe

object SoundInit {
  def init(): Unit = MinecraftForge.EVENT_BUS.register(new SoundInit)

  def breakAncientDebris(index: String): String = digFile("ancientDebris", index)

  def breakNetheriteBlock(index: String): String = digFile("netherite", index)

  def stepAncientDebris(index: String): String = stepFile("ancientDebris", index)

  def stepNetheriteBlock(index: String): String = stepFile("netherite", index)

  def digFile(name: String, index: String): String = dig(name, index) + ".ogg"

  def stepFile(name: String, index: String): String = step(name, index) + ".ogg"

  def useFile(name: String, index: String): String = use(name, index) + ".ogg"

  def use(name: String, index: String): String = s"use/$name/use$index"

  def dig(name: String, index: String): String = s"dig/$name/dig$index"

  def step(name: String, index: String): String = s"step/$name/step$index"

  def addSound(manager: SoundManager, name: String): Unit = try {
    manager.addSound(prefixResourceLocation(name))
  } catch {
    case e: Exception => e.printStackTrace()
  }
}

class SoundInit {
  @ForgeSubscribe
  def onSoundLoad(event: SoundLoadEvent): Unit = {
    val manager = event.manager
    for (i <- 1 to 6) {
      addSound(manager, stepAncientDebris(i.toString))
      addSound(manager, stepNetheriteBlock(i.toString))
      if (i != 6) addSound(manager, breakAncientDebris(i.toString))
      if (i < 5) addSound(manager, breakNetheriteBlock(i.toString))
    }
    for (i <- 1 to 3) addSound(manager, useFile("smithingTable", i.toString))
  }
}
