
import java.util.logging.Level;
import java.util.logging.Logger;
import org.powerbot.script.methods.Bank;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.methods.Widgets;
import org.powerbot.script.wrappers.Component;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Item;
import org.powerbot.script.wrappers.Path;
import org.powerbot.script.wrappers.Tile;
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
    Item Rune = ctx.backpack.select().id(561).poll();
    final Tile Tp = new Tile(3067, 3505, 0);
    public Deposit(MethodContext ctx) {
		super(ctx);
	}

    @Override
    public boolean activate() {
        return  ctx.players.local().getLocation().y == (4843) || ctx.backpack.contains(Rune) ;
    }

    @Override
    public void excecute() {
       teleport();
       depositItems();
    }
    public void depositItems(){
        
        final Tile bank = new Tile(3093, 3495, 0);
        final Path Bankpath = ctx.movement.findPath(bank);
        if(ctx.players.local().isIdle()){
		Bankpath.traverse();
                ctx.camera.turnTo(bank);
                ctx.bank.open();
                ctx.bank.deposit(561, Bank.Amount.ALL);
        }
        
    }
    public void teleport(){
       
        Component Tp =  ctx.widgets.get(1092,26);
        Component Map = ctx.widgets.get(1465,10);
         if(flag == false && ctx.players.local().getLocation().y == (4843)){
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

