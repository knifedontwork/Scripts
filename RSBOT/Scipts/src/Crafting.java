import java.util.logging.Level;
import java.util.logging.Logger;
import org.powerbot.script.methods.Hud;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Item;
import org.powerbot.script.wrappers.Tile;


public class Crafting extends Task{
	public Tile Alter = new Tile(2400,4844,0);
	
	public Crafting(MethodContext ctx) {
		super(ctx);
		
	}

	@Override
	public boolean activate() {
	
		return ctx.players.local().getLocation().x == (2400) && ctx.players.local().getLocation().y == (4844);
	} 

	@Override
	public void excecute() {
		Craft();	
		
	}
	public void Craft(){
		boolean flag = false;
		Item SmallPouch = ctx.backpack.select().id(5509).poll();
		Item MediumPouch = ctx.backpack.select().id(5510).poll();
		Item LargePouch = ctx.backpack.select().id(5513,5512).poll();
		Item GiantPouch = ctx.backpack.select().id(5514).poll();
		GameObject Alter = ctx.objects.select().id(2486).poll();
                ctx.hud.view(Hud.Window.BACKPACK);
                ctx.camera.turnTo(Alter);
                Alter.interact("Crafft-rune");
		if(ctx.backpack.contains(GiantPouch)&& flag == false && ctx.players.local().getAnimation() ==-1){
			GiantPouch.interact("Empty");
			Alter.interact("Craft-rune");
			flag = true;
		}else{
                        Alter.interact("Craft-rune");
			if(ctx.players.local().getAnimation() ==-1){
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex) {
                                Thread.interrupted();
                            }
                        SmallPouch.interact("Empty");
			MediumPouch.interact("Empty");
			LargePouch.interact("Empty");
			Alter.interact("Craft");
			}
                        }
		}
	}


