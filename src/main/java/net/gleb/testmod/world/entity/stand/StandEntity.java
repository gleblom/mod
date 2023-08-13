package net.gleb.testmod.world.entity.stand;

import net.gleb.testmod.item.ModItems;
import net.gleb.testmod.world.entity.ModEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
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

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob parent) {
        return new StandEntity(level, this.blockPosition());
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new BreedGoal(this,1.0D));
        this.goalSelector.addGoal(3,new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(7, new TemptGoal(this, 1.0D, Ingredient.of(ModItems.ZIRCON.get()),false));
    }
    public static AttributeSupplier.Builder createAttributer(){
        return Pig.createAttributes();
    }
    public static boolean canSpawn(EntityType<StandEntity> entityType, LevelAccessor levelAccessor,
                                   MobSpawnType mobSpawnType, BlockPos blockPos, RandomSource randomSource){
        return Animal.checkAnimalSpawnRules(entityType, levelAccessor, mobSpawnType, blockPos, randomSource);

    }
}
