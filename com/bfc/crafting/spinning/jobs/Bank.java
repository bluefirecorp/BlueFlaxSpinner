
package com.bfc.crafting.spinning.jobs;

import com.bfc.Task;
import com.bfc.constants.Items;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.GameObject;

/**
 * @package com.bfc.crafting.spinning.jobs
 * @class Bank
 * @version 1.0
 * @author bluefirecorp
 * @date Mar 29, 2014
 */
public class Bank extends Task {
    public Bank(MethodContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return (!ctx.backpack.contains(ctx.backpack.select().id(Items.FLAX.getItemID()).poll())
                && ctx.objects.id(36786).nearest().poll().getLocation().distanceTo(ctx.players.local().getLocation()) > 30);
    }

    @Override
    public void execute() {
        if(ctx.bank.isOpen()) {
            GameObject booth = ctx.objects.id(36786).nearest().poll();
            if(!booth.isInViewport()) {
                ctx.movement.stepTowards(booth);
            }
            booth.interact("Bank", "Bank Booth");
        } else {
            ctx.bank.depositInventory();
            //xxx Bank.Amount.ALL doesn't seem to work 
            ctx.bank.withdraw(Items.FLAX.getItemID(), 28); 
        }
    }
}
