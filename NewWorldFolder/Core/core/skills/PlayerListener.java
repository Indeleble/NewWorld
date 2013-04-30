package core.skills;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

	SkillPlayerManager spm;

	public PlayerListener(SkillPlayerManager spm) {

		this.spm = spm;
	}

	@EventHandler
	public void PlayerJoin(PlayerJoinEvent ev) {

		Player player = ev.getPlayer();

		if (spm.existPlayerInDb(player.getName())) {
			player.sendMessage("Bienvenido de nuevo a Sacra RP");
		} else {
			
			player.sendMessage("Bienvenido a Sacra RP, esperamos lo pases bien");
			SkillPlayer sp = new SkillPlayer();
			sp.setAccountName(player.getName());
			
			spm.addSkillPlayer(sp);
		}

	}
	
	@EventHandler
	public void PlayerQuit(PlayerQuitEvent ev) {
		
		spm.saveDb();

	}
}