
import java.util.logging.Level;
import java.util.logging.Logger;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.methods.Widgets;
import org.powerbot.script.wrappers.Component;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Item;
import org.powerbot.script.wrappers.Widget;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Austin
 */
public class Deposit extends Task{
    public boolean flag;
    Item Essence = ctx.backpack.select().id(7936).poll();
    public Deposit(MethodContext ctx) {
		super(ctx);
	}

    @Override
    public boolean activate() {
        return  ctx.players.local().getLocation().y == (4843) && !ctx.backpack.contains(Essence);
    }

    @Override
    public void excecute() {
       teleport();
    }
    public void depoistItems(){
        
    }
    public void teleport(){
       
        Component Tp =  ctx.widgets.get(1092,26);
        Component Map = ctx.widgets.get(1465,10);
         if(flag == false){
            Map.click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            Tp.click();
           flag = true;
            
        }
    }
    }

