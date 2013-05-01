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
					spm.getSkillPlayer(player.getName()).addTalaExp(10);
					player.sendMessage("Experiencia en tala subio en 10 puntos");
					player.sendMessage("Experiencia en tala: " + spm.getSkillPlayer(player.getName()).getTalaExp());
					player.sendMessage("Nivel de tala: " + spm.getSkillPlayer(player.getName()).getTalaLvl());
					player.sendMessage("Nivel total: " + spm.getSkillPlayer(player.getName()).getTotalLevel());
		
				} else
					spm.getSkillPlayer(player.getName()).addTalaExp(5);
				player.sendMessage("Experiencia en tala subio en 5 puntos");
				player.sendMessage("Nivel de tala: " + sp.getTalaLvl());
				player.sendMessage("Nivel total: " + sp.getTotalLevel());

			} 
		}
	}
}
