package skills.agricultura;

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

public class AgriculturaListener implements Listener {

	SkillPlayerManager spm;
	Logger log;

	public AgriculturaListener(SkillPlayerManager spm, Logger log) {

		this.spm = spm;
		this.log = log;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void AgriculturaDamageEvent(BlockBreakEvent event) {

		Player player = event.getPlayer();
		SkillPlayer sp;
		PermissionUser user = PermissionsEx.getUser(player);

		if (event.getBlock().getTypeId() == 59
				|| event.getBlock().getTypeId() == 83) {

			if (user.inGroup("agricultura")) {
				sp = spm.getSkillPlayer(player.getName());
				if (event.getBlock().getTypeId() ==59) {
					sp.addAgriculturaExp(200);
					player.sendMessage("Experiencia en agricultura subio en 200 puntos");
					player.sendMessage("Experiencia en agricultura: " + sp.getAgriculturaExp());
					player.sendMessage("Nivel de agricultura: " + sp.getAgriculturaLvl());
					player.sendMessage("Nivel total: " + sp.getTotalLevel());
		
				} else
					sp.addAgriculturaExp(150);
				player.sendMessage("Experiencia en agricultura subio en 150 puntos");
				player.sendMessage("Nivel de agricultura: " + sp.getAgriculturaLvl());
				player.sendMessage("Nivel total: " + sp.getTotalLevel());

			} 
		}
	}
}
