
package com.bfc.crafting.spinning.jobs;

import com.bfc.Task;
import com.bfc.constants.Items;
import org.powerbot.script.methods.MethodContext;

/**
 * @package com.bfc.crafting.spinning.jobs
 * @class Spin
 * @version 1.0
 * @author bluefirecorp
 * @date Mar 29, 2014
 */
public class Spin extends Task {
    public Spin(MethodContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return (!ctx.backpack.contains(ctx.backpack.select().id(Items.BOWSTRING.getItemID()).poll())
                && ctx.objects.id(36970).nearest().poll().getLocation().distanceTo(ctx.players.local().getLocation()) > 30);
    }

    @Override
    public void execute() {
    }
}
