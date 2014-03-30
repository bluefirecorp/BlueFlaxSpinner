
package com.bfc.crafting.spinning.jobs;

import com.bfc.Task;
import com.bfc.constants.Items;
import com.bfc.methods.WidgetClick;
import java.util.concurrent.Callable;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Condition;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Tile;

/**
 * @package com.bfc.crafting.spinning.jobs
 * @class Spin
 * @version 1.03
 * @author bluefirecorp
 * @date Mar 29, 2014
 */
public class Spin extends Task {
    public Spin(MethodContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.backpack.select().id(Items.FLAX.getItemID()).count() != 0
                && ctx.players.local().getLocation().plane == 1 &&
                ctx.players.local().getAnimation() == -1 &&
                !ctx.players.local().isInMotion();
    }

    @Override
    public void execute() {
        GameObject spinner = ctx.objects.select().id(36970).nearest().poll();
        if(!spinner.isInViewport()) {
            ctx.movement.findPath(new Tile(3209, 3213)).traverse();
        }
        spinner.interact("Spin", "Spinning wheel");
        if(new WidgetClick(ctx).click(1370, 38)) {
            long inventoryMonitor = System.currentTimeMillis();
            while(System.currentTimeMillis() - inventoryMonitor < 3500) {
                if(!ctx.players.local().isIdle()) {
                    inventoryMonitor = System.currentTimeMillis();
                    Condition.wait(new Callable<Boolean>() {

                        @Override
                        public Boolean call() throws Exception {
                            return true;
                        }
                    }, 500);
                }
            }
        }
    }
}
