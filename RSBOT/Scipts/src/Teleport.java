
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Component;
import org.powerbot.script.wrappers.Item;

public class Teleport extends Task{
    public int i=0;
    Item Essence = ctx.backpack.select().id(7936).poll();
    public boolean flag = false;
    public Teleport(MethodContext ctx) {
		super(ctx);
        
	}


    @Override
    public boolean activate() {
         return !ctx.backpack.contains(Essence) && ctx.players.local().getLocation().y == (4843)&& ctx.players.local().getAnimation()==-1 ; 
    }

    @Override
    public void excecute() {
        teleport();
        i=0;
    }
    
public void teleport(){
       
        Component Tp =  ctx.widgets.get(1092,26);
        Component Map = ctx.widgets.get(1465,10);
         if(i<1&& ctx.players.local().getLocation().y == (4843)&&!ctx.backpack.contains(Essence)){
            Map.click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            Tp.click();
            
         try {
                Thread.sleep(7000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            
        }
         
    }

}