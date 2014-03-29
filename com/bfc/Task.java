
package com.bfc;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.methods.MethodProvider;

/**
 * @package com.bfc
 * @class Task
 * @version 1.0
 * @author bluefirecorp
 * @date Mar 27, 2014
 */
public abstract class Task extends MethodProvider {
    public Task(MethodContext ctx) {
        super(ctx);
    }
    
    public abstract boolean activate();
    
    public abstract void execute();
}
