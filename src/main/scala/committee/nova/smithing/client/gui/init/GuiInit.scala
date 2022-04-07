package committee.nova.smithing.client.gui.init

import committee.nova.smithing.Smithing
import committee.nova.smithing.client.gui.GuiContainerSmithingTable
import committee.nova.smithing.common.inventory.ContainerSmithingTable
import cpw.mods.fml.common.network.{IGuiHandler, NetworkRegistry}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World

object GuiInit {
  final val smithingTable = 1

  def init(): Unit = new GuiInit
}

class GuiInit extends IGuiHandler {
  NetworkRegistry.INSTANCE.registerGuiHandler(Smithing.instance, this)

  override def getServerGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): AnyRef = {

    ID match {
      case GuiInit.smithingTable => new ContainerSmithingTable(player.inventory, world)
      case _ => null
    }
  }

  override def getClientGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): AnyRef = {
    ID match {
      case GuiInit.smithingTable => new GuiContainerSmithingTable(new ContainerSmithingTable(player.inventory, world))
      case _ => null
    }
  }
}
