package core.skills;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class PlayerListener implements Listener {

	SkillPlayerManager spm;


	public PlayerListener(SkillPlayerManager spm) {
		
		this.spm = spm;
	}

	@EventHandler
	public void PlayerJoin(PlayerJoinEvent ev) {

		Player player = ev.getPlayer();
		
		
	}
}