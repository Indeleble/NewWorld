package skills.mineria;

import java.util.Random;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ProspectarEventHandler implements Listener{

	static boolean prospectando = false;
	
	public boolean getProspectando(Player player) {
		return prospectando;
	}
	public void setProspectando(Player player) {
		prospectando = true;
	}
    public static Boolean isProspecting(Player player) {
		return prospectando;
    }
    
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
		PermissionUser user  = PermissionsEx.getUser(event.getPlayer());

        switch (action) {
        case RIGHT_CLICK_BLOCK:
        	if (user.inGroup("mineria")){   // Colocar a nivel en el que empieza a ser prospectable la piedra

        	}
        	break;
        case RIGHT_CLICK_AIR:	
        	if (user.inGroup("mineria")){   // Colocar a nivel en el que empieza a ser prospectable la piedra
        		
        	}
        	break;
        default:
			break;
        }
	}
	
	
	
	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent evnt) {

        Block block = evnt.getBlock();
        Player player = evnt.getPlayer();

		PermissionUser user  = PermissionsEx.getUser(evnt.getPlayer());
		

		
		Random r = new Random();
		int r2 = 0;
		
		if (user.inGroup("mineria")){   // Colocar a nivel en el que empieza a ser prospectable la piedra
			if(player.getGameMode()==GameMode.SURVIVAL){
				if (block.getType() == Material.STONE){ 
    	    	
				}
			}
    	}
		
	}
	
}
