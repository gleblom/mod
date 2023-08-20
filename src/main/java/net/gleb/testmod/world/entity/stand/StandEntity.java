package net.gleb.testmod.world.entity.stand;

import net.gleb.testmod.world.entity.ModEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;


public class StandEntity extends Animal {
    public StandEntity(EntityType<StandEntity> type, Level level) {
        super(type, level);
    }

    public StandEntity(Level level, double x, double y, double z){
        this(ModEntityType.STAND_ENTITY.get(), level);
        setPos(x, y, z);
    }

    public StandEntity(Level level, BlockPos position){
        this(level, position.getX(), position.getY(), position.getZ());
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new TemptGoal(this, 1.0D, Ingredient.EMPTY, false));
    }
    public static AttributeSupplier.Builder createAttributer(){
        return Wolf.createAttributes();
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }
    public void StandAttack(Player player){
    }
}
