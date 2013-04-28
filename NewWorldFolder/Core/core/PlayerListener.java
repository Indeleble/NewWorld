package core;

import java.util.List;
import java.util.logging.Logger;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import com.avaje.ebean.Query;

public class PlayerListener implements Listener {

	Plugin pl;
	Logger log;

	public PlayerListener(Plugin p) {
		
		this.pl = p;
		log = p.getLogger();

	}

	@EventHandler
	public void PlayerJoin(PlayerJoinEvent ev) {

		Query<SkillPlayer> query = pl.getDatabase().find(SkillPlayer.class);
		log.info("Ha encontrado la clase");
		
		List<SkillPlayer> beans = query.findList();
		log.info("Ha encontrado la lista");
		
		for (SkillPlayer ip : beans) {
			log.info("entra en bucle");
			if (ip.getAccountName().compareToIgnoreCase(
					ev.getPlayer().getName()) == 0) {

				ev.getPlayer().sendMessage("Bienvenido de nuevo");
				break;
			}

			else {

				SkillPlayer ip2 = new SkillPlayer();
				ip2.setAccountName(ev.getPlayer().getName());
				
				pl.getDatabase().save(ip2);
				break;

			}
		}
		
		if (beans.size() == 0 || beans == null){
			
			log.info("Ha entrado if secundario");
			SkillPlayer ip2 = new SkillPlayer();
			ip2.setAccountName(ev.getPlayer().getName());
			
			pl.getDatabase().save(ip2);
			
		}
	}

}