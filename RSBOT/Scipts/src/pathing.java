
import org.powerbot.event.MessageEvent;
import org.powerbot.event.MessageListener;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.methods.Npcs;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Item;
import org.powerbot.script.wrappers.Npc;
import org.powerbot.script.wrappers.Path;
import org.powerbot.script.wrappers.Tile;


public class pathing extends Task{;
        public int i = 0;
        public Tile Alter = new Tile(2400,4844,0);
        public boolean Allow = false;
	Item Essence = ctx.backpack.select().id(7936).poll();
        Item Runes = ctx.backpack.select().id(651).poll();
	public pathing(MethodContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		
		return !ctx.backpack.contains(Runes) && !ctx.bank.isOpen() && ctx.players.local().getLocation().x != (2400) && ctx.backpack.select().count() == 28 && ctx.players.local().getLocation().y !=(3505) ;
	}

	@Override
	public void excecute() {
            
		if(ctx.players.local().getLocation().y<(3522)){
		pathToWall();
                }else if(ctx.players.local().getLocation().y<(4000) && ctx.players.local().getLocation().y >= (3522)){
                    pathToWizard();
		}else if(ctx.players.local().getLocation().y>(4001)&&!ctx.backpack.isEmpty()){
			pathToEntrance();
		}
		
		
	}

	public void pathToWall(){
		GameObject Wall = ctx.objects.select().nearest().name("Wilderness wall").poll();
		final Tile wall = new Tile(3093, 3520, 0);
		final Path Wallpath = ctx.movement.findPath(wall);
		if(ctx.players.local().isIdle()){
		Wallpath.traverse();
                }
		if(ctx.players.local().getAnimation() == -1 && ctx.players.local().getLocation().y <(3522)){
			ctx.camera.setPitch(50);
                        ctx.camera.setAngle(345);
			Wall.interact("Cross");
			}
		}
                
	
	public void pathToWizard(){
		
		Npc Wizard = ctx.npcs.select().nearest().id(2257).poll();
		final Tile wizardTile = new Tile(3104, 3554, 0);
		final Path Wizardpath = ctx.movement.findPath(wizardTile);
                if(!ctx.players.local().isInMotion()&& ctx.players.local().getLocation().y>=(3522)){
                Wizardpath.traverse();
                ctx.camera.turnTo(wizardTile);
                }
		ctx.camera.setPitch(25);
                 ctx.camera.turnTo(Wizard);
                if(Wizard!=null){
			Wizard.interact("Teleport");
			}	
		}
			
	
	
	public void pathToEntrance(){
		final GameObject Rift = ctx.objects.select().id(7133).poll();
                final Npc Mage = ctx.npcs.select().id(2262).poll();
                final GameObject Entrances = ctx.objects.select().nearest(ctx.players.local().getLocation()).id(7144,7145,7146,7147,7146,7148,7149,7150,7151).poll();
		final Tile abyssTile = new Tile(3037, 4856, 0);
		final Tile RiftTile = new Tile(3035, 4842, 0);
                final Tile MageTile = new Tile(3039, 4835, 0);
		final Path Abysspath = ctx.movement.findPath(abyssTile);
		final Path Riftpath = ctx.movement.findPath(RiftTile);
                final Path Magepath = ctx.movement.findPath(MageTile);
                if(ctx.players.local().getAnimation() ==-1){
                    if(Entrances!=null && ctx.players.local().getLocation().y>(4845)){
                ctx.camera.turnTo(Entrances);
		Entrances.interact("Mine");
                Entrances.interact("Go-through");
                Entrances.interact("Chop");
                Entrances.interact("Burn-down");
                Entrances.interact("Squeeze-through");
                Entrances.interact("Distract");
                }
                    if(ctx.players.local().getLocation().y>(4845) &&ctx.players.local().getAnimation()==-1){
		ctx.movement.getClosestOnMap(Entrances);
                ctx.movement.stepTowards(Entrances);
                    }
		
                }
                if(i >= 40){
                    Magepath.traverse();
                    Mage.interact("Repair");
                    i = 0;
                    
                }else if(i < 40 && ctx.players.local().getLocation().y <= (4845) && ctx.players.local().isIdle() && ctx.players.local().getAnimation() == -1){
		Riftpath.traverse();
                System.out.println("Walking to rift");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                   Thread.currentThread().interrupt();
                }
                if(ctx.players.local().isIdle()){
                System.out.println("Clicking on rift");
                ctx.camera.setAngle(175);
		ctx.camera.setPitch(71);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                   Thread.currentThread().interrupt();
                }
                Rift.hover();
                ctx.mouse.move(ctx.mouse.getLocation().x+-2 , ctx.mouse.getLocation().y-55);
                ctx.mouse.click(true);
                i++;
		}
		}
        }
}

    
		
	
	

