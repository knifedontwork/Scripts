
import java.util.ArrayList;
import java.util.List;
import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;
import org.powerbot.script.wrappers.Tile;

@Manifest(name = "KRC", authors = "mhm", description = "worth")
public class KRC extends PollingScript{
        public boolean flag;
	public Tile Alter = new Tile(2400,4844,0);
       
      
	private List<Task> taskList = new ArrayList<>();
			
	

	@Override
    public void start() {
        ctx.players.local().getLocation();
        taskList.add(new Withdraw(ctx));
        taskList.add(new pathing(ctx));
        taskList.add(new Crafting(ctx));
        taskList.add(new Teleport(ctx));
        taskList.add(new Deposit(ctx));
        flag=false;
        
        
       
    }


	

	@Override
	public int poll() {
	        for (Task task : taskList) {
	            if (task.activate()) {
	                task.excecute();
	                return 1000;
	            }
	        }
	        return 500;
	    }
	}


