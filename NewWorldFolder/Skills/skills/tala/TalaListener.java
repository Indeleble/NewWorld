package skills.tala;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import core.skills.SkillPlayer;
import core.skills.SkillPlayerManager;

public class TalaListener implements Listener {

	SkillPlayerManager spm;

	public TalaListener(SkillPlayerManager spm) {

		this.spm = spm;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void TalaDamageEvent(BlockDamageEvent event) {

		Player player = event.getPlayer();
		SkillPlayer sp;
		PermissionUser user = PermissionsEx.getUser(player);

		if (event.getBlock().getTypeId() == 17
				|| event.getBlock().getTypeId() == 18) {

			if (user.inGroup("tala")) {
				sp = spm.getSkillPlayer(player.getName());
				if (event.getBlock().getTypeId() == 17) {
					sp.addTalaExp(10);
					player.sendMessage("Experiencia en tala subio en 10 puntos");
					player.sendMessage("Nivel de tala: " + sp.getTalaLvl());
					player.sendMessage("Nivel total: " + sp.getTotalLevel());
				} else
					sp.addTalaExp(5);
				player.sendMessage("Experiencia en tala subio en 5 puntos");
				player.sendMessage("Nivel de tala: " + sp.getTalaLvl());
				player.sendMessage("Nivel total: " + sp.getTotalLevel());

			} else
				event.setCancelled(true);

		} else
			event.setCancelled(true);
	}
}
