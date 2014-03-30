
package com.bfc.methods;

import java.util.concurrent.Callable;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.methods.MethodProvider;
import org.powerbot.script.util.Condition;
/**
 * @package com.bfc.methods
 * @class Widgets
 * @version 1.00
 * @author bluefirecorp
 * @date Mar 27, 2014
 */
public class WidgetClick extends MethodProvider {
    
    public WidgetClick(MethodContext ctx) {
        super(ctx);
    }
    
    private int intID;
    private int compID;
    private boolean left;
    private String interact;  

    public boolean click(int interfaceID, int componentID, boolean clickLeft,
            int tries, int freq) {
        intID = interfaceID;
        compID = componentID;
        left = clickLeft;
        
        if(!ctx.widgets.get(intID).isValid()) return false;
        
        return Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.widgets.get(intID, compID).click(left);
            }
        }, freq, tries);
    }
    
    public boolean click(int interfaceID, int componentID) {
        return click(interfaceID, componentID, true, 600, 1);
    }
    public boolean click(int interfaceID, int componentID, 
            boolean clickLeft) {
        return click(interfaceID, componentID, true);
    }
    public boolean click(int interfaceID, int componentID, 
            boolean clickLeft, int tries) {
        return click(interfaceID, componentID, clickLeft, tries, 600);
    }
    
    
    public boolean clickInteract(int interfaceID, int componentID,
            String interactText, int tries, int freq) {
        
        intID = interfaceID;
        compID = componentID;
        interact = interactText;
        
        if(!ctx.widgets.get(intID).isValid()) return false;
        
        return Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.widgets.get(intID, compID).interact(interact);
            }
        }, freq, tries);
    }
    
    public boolean clickInteract(int interfaceID, int componentID,
            String interactText) {
        return clickInteract(interfaceID, componentID, interactText, 600, 1);
    }
    public boolean clickInteract(int interfaceID, int componentID,
            String interactText, int tries) {
        return clickInteract(interfaceID, componentID, interactText, 600, tries);
    }
}
