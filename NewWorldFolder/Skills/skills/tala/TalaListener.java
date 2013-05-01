package skills.tala;

import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import core.skills.SkillPlayer;
import core.skills.SkillPlayerManager;

public class TalaListener implements Listener {

	SkillPlayerManager spm;
	Logger log;

	public TalaListener(SkillPlayerManager spm, Logger log) {

		this.spm = spm;
		this.log = log;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void TalaDamageEvent(BlockBreakEvent event) {

		Player player = event.getPlayer();
		SkillPlayer sp;
		PermissionUser user = PermissionsEx.getUser(player);

		if (event.getBlock().getTypeId() == 17
				|| event.getBlock().getTypeId() == 18) {

			if (user.inGroup("tala")) {
				sp = spm.getSkillPlayer(player.getName());
				if (event.getBlock().getTypeId() == 17) {
					sp.addTalaExp(200);
					player.sendMessage("Experiencia en tala subio en 200 puntos");
					player.sendMessage("Experiencia en tala: " + sp.getTalaExp());
					player.sendMessage("Nivel de tala: " + sp.getTalaLvl());
					player.sendMessage("Nivel total: " + sp.getTotalLevel());
		
				} else
					sp.addTalaExp(150);
				player.sendMessage("Experiencia en tala subio en 150 puntos");
				player.sendMessage("Nivel de tala: " + sp.getTalaLvl());
				player.sendMessage("Nivel total: " + sp.getTotalLevel());

			} 
		}
	}
}
