package committee.nova.smithing.client.gui

import committee.nova.smithing.client.gui.GuiContainerSmithingTable.texturePath
import committee.nova.smithing.common.inventory.ContainerSmithingTable
import committee.nova.smithing.common.util.Utilities._
import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraft.client.resources.I18n
import net.minecraft.util.ResourceLocation
import org.lwjgl.opengl.GL11

object GuiContainerSmithingTable {
  val texturePath: ResourceLocation = new ResourceLocation(prefixResourceLocation("textures/gui/container/smithing.png"))
}

@SideOnly(Side.CLIENT)
class GuiContainerSmithingTable(container: ContainerSmithingTable) extends GuiContainer(container) {
  inventorySlots = container
  xSize = 176
  ySize = 166

  override def drawGuiContainerBackgroundLayer(partialTicks: Float, mouseX: Int, mouseY: Int): Unit = {
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F)
    mc.getTextureManager.bindTexture(texturePath)
    val offsetX = (this.width - this.xSize) / 2
    val offsetY = (this.height - this.ySize) / 2
    drawTexturedModalRect(offsetX, offsetY, 0, 0, xSize, ySize)
    if (container.unable()) drawTexturedModalRect(offsetX + 99, offsetY + 45, xSize, 0, 28, 21)
  }

  override def drawGuiContainerForegroundLayer(mouseX: Int, mouseY: Int): Unit = {
    fontRendererObj.drawString(I18n.format("gui.smithing.upgrade"), 60, 18, 0x000000)
  }

}
