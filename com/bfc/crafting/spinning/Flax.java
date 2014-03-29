
package com.bfc.crafting.spinning;

import com.bfc.Task;
import com.bfc.crafting.spinning.jobs.*;

import java.awt.Graphics;
import java.util.ArrayList;

import org.powerbot.event.MessageEvent;
import org.powerbot.event.MessageListener;
import org.powerbot.event.PaintListener;
import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;

/**
 * @package com.bfc.crafting.spinning
 * @class Flax
 * @version 1.0
 * @author bluefirecorp
 * @date Mar 27, 2014
 */
@Manifest(description = "Spins flax into bowstring in Lumbridge", name="BlueFlaxSpinner")
public class Flax extends PollingScript implements PaintListener,
        MessageListener {
    
    //TODO: Create enum that contains objects and reference them from there.
    
    private ArrayList<Task> jobs = new ArrayList<Task>();
    
    @Override
    public void start() {
        jobs.add(new Bank(ctx));
        jobs.add(new Spin(ctx));
        jobs.add(new Walking(ctx));
    }
    
    @Override
    public int poll() {
        for(Task job : jobs) {
            if(job.activate()) {
                job.execute();
            }
        }
        return 500;
    }

    @Override
    public void repaint(Graphics g) {
        g.drawString("Graphics not fully implemented.", 10, 10);
    }

    @Override
    public void messaged(MessageEvent m) {
        
    }
}
