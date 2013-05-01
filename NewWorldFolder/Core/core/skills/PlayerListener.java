package core.skills;

import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PlayerListener implements Listener {

	SkillPlayerManager spm;
	Logger log;

	public PlayerListener(SkillPlayerManager spm, Logger log) {

		this.spm = spm;
		this.log = log;
	}

	@EventHandler
	public void PlayerJoin(PlayerJoinEvent ev) {

		Player player = ev.getPlayer();

		if (spm.existPlayerInDb(player.getName())) {
			player.sendMessage("Bienvenido de nuevo a Sacra RP");
		} else {
			
			player.sendMessage("Bienvenido a Sacra RP, esperamos que lo pases bien");
			SkillPlayer sp = new SkillPlayer();
			sp.setAccountName(player.getName());	
			
			spm.addSkillPlayer(sp);
			PermissionUser user = PermissionsEx.getUser(player);
			user.addGroup("user");
		}

	}
	
	@EventHandler
	public void PlayerQuit(PlayerQuitEvent ev) {
		
		spm.saveDb();

	}
}