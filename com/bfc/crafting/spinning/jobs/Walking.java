
package com.bfc.crafting.spinning.jobs;

import com.bfc.Task;
import com.bfc.constants.Items;
import java.util.concurrent.Callable;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Condition;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Tile;

/**
 * @package com.bfc.crafting.spinning.jobs
 * @class Walking
 * @version 1.02
 * @author bluefirecorp
 * @date Mar 29, 2014
 */
public class Walking extends Task {
    
    public Walking(MethodContext ctx) {
        super(ctx);
    }
    
    @Override
    public boolean activate() {
        return (ctx.backpack.select().id(Items.FLAX.getItemID()).count() == 0
                && ctx.players.local().getLocation().plane == 1
                && !ctx.players.local().isInMotion()
                && !ctx.bank.isOpen())
                || 
                (ctx.backpack.select().id(Items.BOWSTRING.getItemID()).count() == 0
                && ctx.players.local().getLocation().plane == 2
                && !ctx.players.local().isInMotion())
                && !ctx.bank.isOpen();
    }

    @Override
    public void execute() {
        if(ctx.backpack.select().id(Items.FLAX.getItemID()).count() == 0) {
            walkToBank();
        } else {
            walkToSpinner();
        }
    }
    public void walkToBank() {
        GameObject stairs = ctx.objects.select().id(36774).nearest().poll();
        if(!stairs.isInViewport()) {
            ctx.movement.findPath(new Tile(3205, 3210)).traverse();
        }
        stairs.interact("Climb-up", "Staircase");
        Condition.wait(new Callable<Boolean>() {

                        @Override
                        public Boolean call() throws Exception {
                            return true;
                        }
                    }, 1000);
    }
    public void walkToSpinner() {
        GameObject stairs = ctx.objects.select().id(36775).nearest().poll();
        if(!stairs.isInViewport()) {
            ctx.movement.findPath(new Tile(3205, 3210)).traverse();
        }
        stairs.interact("Climb-down", "Staircase");
        Condition.wait(new Callable<Boolean>() {

                        @Override
                        public Boolean call() throws Exception {
                            return true;
                        }
                    }, 1000);
    }
}
