
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
 * @version 1.03
 * @author bluefirecorp
 * @date Mar 27, 2014
 */
@Manifest(description = "Spins flax into bowstring in Lumbridge", name="BlueFlaxSpinner")
public class Flax extends PollingScript implements PaintListener,
        MessageListener {
    
    //TODO: Create enum that contains objects and reference them from there.
    
    private ArrayList<Task> jobs = new ArrayList<>();
    private long startTime;
    
    @Override
    public void start() {
        startTime = System.currentTimeMillis();
        jobs.add(new Bank(ctx));
        jobs.add(new Spin(ctx));
        jobs.add(new Walking(ctx));
        jobs.add(new Downstairs(ctx));
    }
    
    @Override
    public int poll() {
        for(Task job : jobs) {
            if(job.activate()) {
                job.execute();
            }
        }
        return 1000;
    }

    @Override
    public void repaint(Graphics g) {
        g.drawString("Runtime: "+ formatTime(System.currentTimeMillis() - startTime), 10, 10);
        
    }
    public String formatTime(long time) {
        long sec =  (time / 1000);
        long d = sec / 86400;
        long h = sec / 3600 % 3600;
        long m = sec / 60 % 60;
        long s = sec % 60;
        return d + ":" 
                + (h < 10 ? "0" + h : h) + ":"
                + (m < 10 ? "0" + m : m) + ":"
                + (s < 10 ? "0" + s : s);
    }
    @Override
    public void messaged(MessageEvent m) {
        //
    }
}
