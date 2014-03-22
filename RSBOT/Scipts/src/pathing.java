
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Item;
import org.powerbot.script.wrappers.Npc;
import org.powerbot.script.wrappers.Path;
import org.powerbot.script.wrappers.Tile;


public class pathing extends Task{;
        public Tile Alter = new Tile(2400,4844,0);
	Item Essence = ctx.backpack.select().id(7936).poll();
	public pathing(MethodContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		
		return !ctx.bank.isOpen() && ctx.players.local().getLocation().x != (2400) && ctx.players.local().getLocation().y != (4844) ;
	}

	@Override
	public void excecute() {
		if(ctx.players.local().getLocation().y<(3522)&& !ctx.backpack.isEmpty()){
		pathToWall();
                }else if(ctx.players.local().getLocation().y<4000){
                    pathToWizard();
		}else if(ctx.players.local().getLocation().y>(4001)&&!ctx.backpack.isEmpty()){
			pathToEntrance();
		}
		
		
	}

	public void pathToWall(){
		GameObject Wall = ctx.objects.nearest().name("Wilderness wall").poll();
		final Tile wall = new Tile(3093, 3519, 0);
		final Path Wallpath = ctx.movement.findPath(wall);
		if(ctx.players.local().isIdle()){
		Wallpath.traverse();
		if(ctx.players.local().getAnimation() == -1 && ctx.players.local().getLocation().y <3522){
			ctx.camera.setPitch(50);
			Wall.interact("Cross");
                        System.out.println("Walking to wizard now");
			}
		}
                
	}
	public void pathToWizard(){
		
		Npc Wizard = ctx.npcs.select().id(2257).poll();
		final Tile wizardTile = new Tile(3104, 3554, 0);
		final Path Wizardpath = ctx.movement.findPath(wizardTile);
		if(ctx.players.local().isIdle()){
		Wizardpath.traverse();
		ctx.camera.setPitch(25);
		ctx.camera.turnTo(Wizard);
                if(Wizard!=null){
			Wizard.interact("Teleport");
			}	
		}
			
	}
	
	public void pathToEntrance(){
		final GameObject Entrances = ctx.objects.nearest().id(7148).poll();
		final Tile abyssTile = new Tile(3037, 4856, 0);
		final Tile RiftTile = new Tile(3035, 4842, 0);
		final Path Abysspath = ctx.movement.findPath(abyssTile);
		final Path Riftpath = ctx.movement.findPath(RiftTile);
		Abysspath.traverse();
		if(Entrances!=null&& ctx.players.local().getLocation().y >= 4856){
			Entrances.click();
		}
		if(ctx.players.local().getLocation() != RiftTile && !ctx.players.local().isInMotion() && Entrances.click() == false){
		Riftpath.traverse();
		ctx.movement.stepTowards(RiftTile);
		ctx.camera.setPitch(40);
		ctx.camera.setAngle(175);
		ctx.mouse.click(395,240, false);
		ctx.mouse.click(true);	
		}
		}
		
	}
	

