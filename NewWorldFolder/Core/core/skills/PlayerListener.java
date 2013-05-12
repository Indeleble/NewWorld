package core.skills;

import java.util.List;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.avaje.ebean.Query;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PlayerListener implements Listener {

	SkillPlayerManager	spm;
	Logger				log;

	public PlayerListener(SkillPlayerManager spm, Logger log) {

		this.spm = spm;
		this.log = log;
	}

	@EventHandler
	public void PlayerJoin(PlayerJoinEvent ev) {

		Player player = ev.getPlayer();

		Query<SkillPlayer> query = spm.db.find(SkillPlayer.class);

		query.where().eq("accountName", player.getName());

		query.setMaxRows(1);

		List<SkillPlayer> beans = query.findList();

		if (beans == null || beans.size() == 0) {

			player.sendMessage("Bienvenido a Sacra RP, esperamos que lo pases bien");
			SkillPlayer sp = new SkillPlayer();
			sp.setAccountName(player.getName());

			spm.addSkillPlayer(sp);
			PermissionUser user = PermissionsEx.getUser(player);
			user.addGroup("user");

		} else {
			player.sendMessage("Bienvenido de nuevo a Sacra RP");
			spm.addSkillPlayer(beans.get(0));
		}
	}

	@EventHandler
	public void PlayerQuit(PlayerQuitEvent ev) {
		
		spm.db.update(spm.getSkillPlayer(ev.getPlayer().getName()));
		spm.removeSkillPlayer(ev.getPlayer().getName());
	}
}