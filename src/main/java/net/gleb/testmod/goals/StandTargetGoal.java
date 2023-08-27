package net.gleb.testmod.goals;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;

public class StandTargetGoal extends TargetGoal {
    private LivingEntity LastHurtMobByPlayer;
    private int timestamp;
    public StandTargetGoal(Mob mob, boolean b) {
        super(mob, b);
    }

    @Override
    public boolean canUse() {
        LivingEntity lasthurtmobyplayer1 = this.LastHurtMobByPlayer;
        return lasthurtmobyplayer1 != null;
    }

    @Override
    public void start() {
        this.mob.setTarget(this.LastHurtMobByPlayer);
        super.start();
    }
}
