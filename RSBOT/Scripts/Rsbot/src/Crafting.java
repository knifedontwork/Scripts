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
	
		return ctx.players.local().getLocation() == Alter;
	} 

	@Override
	public void excecute() {
		Craft();	
		
	}
	public void Craft(){
		boolean flag = false;
		Item SmallPouch = ctx.backpack.id(5509).poll();
		Item MediumPouch = ctx.backpack.id(5510).poll();
		Item LargePouch = ctx.backpack.id(5513).poll();
		Item GiantPouch = ctx.backpack.id(5514).poll();
		GameObject Alter = ctx.objects.nearest().id(2486).poll();
		Alter.click();
		if(ctx.backpack.contains(GiantPouch)&& flag == false && ctx.players.local().getAnimation() ==-1){
			GiantPouch.interact("Empty");
			Alter.click();
			flag = true;
		}else{
			if(ctx.players.local().getAnimation() ==-1 && Alter !=null){
			SmallPouch.interact("Empty");
			System.out.println("Empty the pouch");
			MediumPouch.interact("Empty");
			System.out.println("Empty the pouch");
			LargePouch.interact("Empty");
			System.out.println("Empty the pouch");
			Alter.click();
			}
		}
	}

}
