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

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class MiningListener implements Listener{

	public MiningListener(){


	}

	@EventHandler
    public static void PlayerInteractEvent(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        Action action = event.getAction();
		PermissionUser user  = PermissionsEx.getUser(event.getPlayer());
        Block block = event.getClickedBlock();
        @SuppressWarnings("unused")
		Material material;

        int inHand = player.getItemInHand().getTypeId();

        if (block == null) {
            material = Material.AIR;
        }
        else {
            material = block.getType();
        }
        
        switch (action) {
        case RIGHT_CLICK_BLOCK:
//        	if (user.inGroup("mineria")){   // Colocar a nivel en el que empieza a ser prospectable la piedra
    		if((inHand==257) || (inHand==274) || (inHand==278) || (inHand==285) ){
				player.sendMessage("test block");
//				if(prospectando==false){             //Mal fijo, a revisar.
    				player.sendMessage("Te preparas para prospectar la piedra");
//    			}else{
    				player.sendMessage("Dejas de prospectar la piedra");
 //   			}
    		}
//        	}
    		break;
        case RIGHT_CLICK_AIR:	
//        	if (user.inGroup("mineria")){   // Colocar a nivel en el que empieza a ser prospectable la piedra
        		if((inHand==257) || (inHand==274) || (inHand==278) || (inHand==285) ){
    				player.sendMessage("test aire");

        		}
//        	}
        	break;
        default:
			break;
        }
	}
	
	@EventHandler
	public void BlockBreakEvent(BlockBreakEvent ev) {
		
		PermissionUser user  = PermissionsEx.getUser(ev.getPlayer());
        Block block = ev.getBlock();
        Player player = ev.getPlayer();
		Random r = new Random();
        int inHand = player.getItemInHand().getTypeId();
		int r2 = 0;
		
		
		if (user.inGroup("mining")){
		
		ev.getPlayer().sendMessage("Has ganado 1 punto de experiencia");
		} else ev.getPlayer().sendMessage("No ganas exp");

		


		
//		if (user.inGroup("mineria")){   // Colocar a nivel en el que empieza a ser prospectable la piedra
			if(player.getGameMode()==GameMode.SURVIVAL){
				if (block.getType() == Material.STONE){ 
		       		if((inHand==257) || (inHand==274) || (inHand==278) || (inHand==285) ){
		       			player.sendMessage("test romper stone");
		       		}
				}
			}
//    	}
	}
}
