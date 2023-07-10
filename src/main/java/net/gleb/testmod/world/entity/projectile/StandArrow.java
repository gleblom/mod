package net.gleb.testmod.world.entity.projectile;


import net.gleb.testmod.item.ModItems;
import net.gleb.testmod.world.entity.ModEntityType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;



public class StandArrow extends AbstractArrow {
    private final Item referenceItem;
    public StandArrow(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
        this.referenceItem = ModItems.STAND_ARROW.get();

    }
    public StandArrow(LivingEntity shooter, Level level, Item referenceItem){
        super(ModEntityType.STAND_ARROW.get(), shooter, level);
        this.referenceItem = referenceItem;
    }
    @Override
    public ItemStack getPickupItem() {
        return new ItemStack(this.referenceItem);
    }
    private int getRandomNumber(){
        return RandomSource.createNewThreadLocalInstance().nextInt(2);
    }
    protected void doPostHurtEffects(LivingEntity livingEntity) {
        if(getRandomNumber() == 1){
            livingEntity.addEffect(new MobEffectInstance(MobEffects.HEAL, 200));
        }
        else{
            livingEntity.kill();
        }
    }
}
