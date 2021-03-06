import org.powerbot.script.methods.Bank;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Area;
import org.powerbot.script.wrappers.Item;
import org.powerbot.script.wrappers.Tile;


public class Withdraw extends Task{
	
	public boolean large,medium,small;
	public boolean flag;
	public int largePouch = 5512;
	public int largePouch2 = 5513;
	public int mediumPouch = 5510;
	public int smallPouch = 5509;
	public int pureEssence = 7936;
	Item Runes = ctx.backpack.select().id(561).poll();
	public Tile Alter = new Tile(2400,4844,0);
	Area arg;
	public Withdraw(MethodContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
	
		
		return ctx.backpack.select().count()<28;
						
	}

	@Override
	public void excecute() {
				withdraw();
				fill();
				withdraw();
				ctx.bank.close();
				
	}
	public void withdraw(){
		ctx.bank.open();
		ctx.bank.withdraw(smallPouch, 1);
		
		ctx.bank.withdraw(mediumPouch, 1);
		
		ctx.bank.withdraw(largePouch, 1);
		
		ctx.bank.withdraw(largePouch2, 1);
		
		
		ctx.bank.withdraw(pureEssence, Bank.Amount.ALL);
		
		}
	public void fill(){
		
		
		Item SmallPouch = ctx.backpack.select().id(5509).poll();  
		Item MediumPouch = ctx.backpack.select().id(5510).poll();
		Item LargPouch = ctx.backpack.select().id(5512,5513).poll();
			
			SmallPouch.interact("Fill");
			MediumPouch.interact("Fill");
			LargPouch.interact("Fill");
	
		
	
	}
	}


