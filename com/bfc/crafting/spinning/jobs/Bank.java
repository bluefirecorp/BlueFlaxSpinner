
package com.bfc.crafting.spinning.jobs;

import com.bfc.Task;
import com.bfc.constants.Items;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Tile;

/**
 * @package com.bfc.crafting.spinning.jobs
 * @class Bank
 * @version 1.02
 * @author bluefirecorp
 * @date Mar 29, 2014
 */
public class Bank extends Task {
    public Bank(MethodContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return (ctx.backpack.select().id(Items.FLAX.getItemID()).count() == 0 &&
                ctx.players.local().getLocation().plane == 2 && !ctx.players.local().isInMotion())                
                || (ctx.bank.isOpen());
    }

    @Override
    public void execute() {
        if(!ctx.bank.isOpen()) {
            GameObject booth = ctx.objects.select().id(36786).nearest().poll();
            if(!booth.isInViewport()) {
                ctx.movement.findPath(new Tile(3209, 3220)).traverse();
            }
        } else if(ctx.bank.isOpen()
                && ctx.backpack.select().id(Items.FLAX.getItemID()).count() != 0) {
            ctx.bank.close();
            return;
        }
        if(ctx.bank.open()) {
                ctx.bank.depositInventory();
                ctx.bank.withdraw(Items.FLAX.getItemID(), 28);
                ctx.bank.close();
        }
    }
}
