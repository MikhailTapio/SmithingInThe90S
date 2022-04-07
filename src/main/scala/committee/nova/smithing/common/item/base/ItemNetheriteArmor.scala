package committee.nova.smithing.common.item.base

import committee.nova.smithing.Smithing
import committee.nova.smithing.common.item.material.MaterialInit._
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.{Entity, EntityLivingBase}
import net.minecraft.item.{ItemArmor, ItemStack}
import net.minecraft.util.DamageSource
import net.minecraftforge.common.ISpecialArmor
import net.minecraftforge.common.ISpecialArmor.ArmorProperties

class ItemNetheriteArmor(id: Int) extends ItemArmor(NETHERITE_ARMOR, 0, id) with ISpecialArmor {
  override def getArmorTexture(stack: ItemStack, entity: Entity, slot: Int, armorType: String): String = {
    Smithing.MODID + ":textures/models/armor/netherite_layer_" + (if (slot != 2) "1" else "2") + ".png"
  }

  override def getProperties(player: EntityLivingBase, armor: ItemStack, source: DamageSource, damage: Double, slot: Int): ISpecialArmor.ArmorProperties = {
    new ArmorProperties(1, this.damageReduceAmount / 25D, armor.getItem.getMaxDamage + (if (source.isFireDamage) 0 else 1) - armor.getItemDamage)
  }

  override def getArmorDisplay(player: EntityPlayer, armor: ItemStack, slot: Int): Int = armor.getItem match {
    case armor1: ItemArmor => armor1.damageReduceAmount
    case _ => 0
  }

  override def damageArmor(entity: EntityLivingBase, stack: ItemStack, source: DamageSource, damage: Int, slot: Int): Unit = {
    stack.damageItem(if (source.isFireDamage) 0 else damage, entity)
  }
}
