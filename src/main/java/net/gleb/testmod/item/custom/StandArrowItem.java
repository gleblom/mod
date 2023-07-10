package net.gleb.testmod.item.custom;



import net.gleb.testmod.item.ModItems;
import net.gleb.testmod.world.entity.projectile.StandArrow;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;



public class StandArrowItem extends ArrowItem {
    public final float damage;
    public StandArrowItem(Properties properties, float damage) {
        super(properties);
        this.damage = damage;
    }
    @Override
    public AbstractArrow createArrow(Level level, ItemStack stack, LivingEntity livingEntity) {
        StandArrow arrow = new StandArrow(livingEntity, level, ModItems.STAND_ARROW.get());
        arrow.setBaseDamage(this.damage);
        return arrow;
    }

    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, Player player) {
        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant > 0 && this.getClass() == StandArrowItem.class;
    }
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand){
        if(getRandomNumber() == 1){
            player.addEffect(new MobEffectInstance(MobEffects.HEAL, 200));

        }
        else{
            player.kill();

        }
        return super.use(level, player, interactionHand);
    }
    private int getRandomNumber(){
        return RandomSource.createNewThreadLocalInstance().nextInt(2);
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity livingEntity, LivingEntity livingEntity1) {
        if(getRandomNumber() == 1){
            livingEntity.addEffect(new MobEffectInstance(MobEffects.HEAL, 200));

        }
        else
        {
            livingEntity.kill();
        }
        return super.hurtEnemy(itemStack, livingEntity, livingEntity1);
    }

}
