import org.powerbot.script.methods.Bank;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Area;
import org.powerbot.script.wrappers.Item;
import org.powerbot.script.wrappers.Tile;


public class Withdraw extends Task{
	public boolean flag;
	public int largePouch = 5512;
	public int largePouch2 = 5513;
	public int mediumPouch = 5510;
	public int smallPouch = 5509;
	public int pureEssence = 7936;
	Item Runes = ctx.backpack.id(561).poll();
        final Tile bank = new Tile(3093, 3495, 0);
        final Tile Corner1 = new Tile(3100, 3500, 0);
        final Tile Corner2 = new Tile(3091, 3488, 0);
	final Area Area = new Area(Corner1,Corner2);
	public Withdraw(MethodContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
	
		
		return ctx.backpack.select().count()<28 &&  Area.contains(ctx.players.local().getLocation());
						
	}

	@Override
	public void excecute() {
            ctx.camera.turnTo(bank);
                                ctx.bank.open();
                                ctx.bank.deposit(561, Bank.Amount.ALL);
				withdraw();
				fill();
				withdraw();
				ctx.bank.close();
	}
	public void withdraw(){
		
		ctx.bank.withdraw(smallPouch, 1);
		
		ctx.bank.withdraw(mediumPouch, 1);
		
		ctx.bank.withdraw(largePouch, 1);
		
		ctx.bank.withdraw(largePouch2, 1);
		
		ctx.bank.withdraw(pureEssence, Bank.Amount.ALL);
		
		}
	public void fill(){
		
		
		Item SmallPouch = ctx.backpack.select().id(5509).poll();  
		Item MediumPouch = ctx.backpack.select().id(5510).poll();
		Item LargPouch = ctx.backpack.select().id(5511,5512).poll();
			if(ctx.bank.isOpen()){
			SmallPouch.interact("Fill");
			MediumPouch.interact("Fill");
			LargPouch.interact("Fill");
                        }
		
	
	}
	}


