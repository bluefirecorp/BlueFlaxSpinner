
package com.bfc.crafting.spinning.jobs;

import com.bfc.Task;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.GameObject;

/**
 * @package com.bfc.crafting.spinning.jobs
 * @class Downstairs
 * @version 1.0
 * @author bluefirecorp
 * @date Mar 29, 2014
 */
public class Downstairs extends Task {
    public Downstairs(MethodContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.players.local().getLocation().getPlane() == 0 && 
                 !ctx.players.local().isInMotion();
    }

    @Override
    public void execute() {
        GameObject stairs = ctx.objects.select().id(36773).nearest().poll();
        stairs.interact("Climb-up", "Staircase");
    }
}
