
package com.bfc.crafting.spinning.jobs;

import com.bfc.Task;
import com.bfc.constants.Items;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.GameObject;

/**
 * @package com.bfc.crafting.spinning.jobs
 * @class Walking
 * @version 1.0
 * @author bluefirecorp
 * @date Mar 29, 2014
 */
public class Walking extends Task {
    
    public Walking(MethodContext ctx) {
        super(ctx);
    }
    
    @Override
    public boolean activate() {
        return (!ctx.backpack.contains(ctx.backpack.select().id(Items.FLAX.getItemID()).poll())
                && ctx.objects.id(36774).nearest().poll().getLocation().distanceTo(ctx.players.local().getLocation()) < 30)
                || 
                (!ctx.backpack.contains(ctx.backpack.select().id(Items.BOWSTRING.getItemID()).poll())
                && ctx.objects.id(36775).nearest().poll().getLocation().distanceTo(ctx.players.local().getLocation()) < 30);
    }

    @Override
    public void execute() {
        if(!ctx.backpack.contains(ctx.backpack.select().id(Items.FLAX.getItemID()).poll())) {
            walkToBank();
        } else {
            walkToSpinner();
        }
    }
    public void walkToBank() {
        GameObject stairs = ctx.objects.id(36774).nearest().poll();
        if(stairs.isInViewport()) {
            stairs.interact("Climb-up", "Staircase");
        } else {
            ctx.movement.stepTowards(stairs.getLocation());
        }
    }
    public void walkToSpinner() {
        GameObject stairs = ctx.objects.id(36775).nearest().poll();
        if(stairs.isInViewport()) {
            stairs.interact("Climb-down", "Staircase");
        } else {
            ctx.movement.stepTowards(stairs.getLocation());
        }
    }
}
