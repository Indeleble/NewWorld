package skills.mineria;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class MiningListener implements Listener{
	

	
	public MiningListener(){


	}
	
	@EventHandler
	public void BlockBreakEvent(BlockBreakEvent ev) {
		
		PermissionUser user  = PermissionsEx.getUser(ev.getPlayer());
		
		if (user.inGroup("mining")){
		
		ev.getPlayer().sendMessage("Has ganado 1 punto de experiencia");
		} else ev.getPlayer().sendMessage("No ganas exp");

	}

}
