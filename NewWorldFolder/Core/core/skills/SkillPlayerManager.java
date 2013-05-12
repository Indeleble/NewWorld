package core.skills;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.avaje.ebean.EbeanServer;

public class SkillPlayerManager extends BukkitRunnable {

	EbeanServer			db;
	List<SkillPlayer>	skillPlayerList;
	Logger				log;
	Plugin				core;

	public SkillPlayerManager(EbeanServer db, Logger log, Plugin core) {

		this.db = db;
		this.log = log;
		this.core = core;
		//Query<SkillPlayer> query = db.find(SkillPlayer.class);
		skillPlayerList = new ArrayList<SkillPlayer>(); //query.findList();
		this.runTaskTimerAsynchronously(this.core, 500, 500);
	}

	public void saveDb() {
		log.info("Saving data base. Number of players to save: " + skillPlayerList.size());
		for (SkillPlayer sp : this.skillPlayerList) {
			
			db.update(sp);
			log.info("-------------");
			//log.info(String.valueOf(sp.getTalaExp()));
			//log.info(String.valueOf(sp.getTalaLvl()));
		}
	}

	public void addSkillPlayer(SkillPlayer player) {

		this.skillPlayerList.add(player);
		db.save(player);
	}

	public List<SkillPlayer> getSkillPlayerList() {

		return skillPlayerList;

	}

	public boolean existPlayerInDb(String name) {

		if (this.getSkillPlayer(name) != null) {
			return true;
		}

		return false;
	}

	public SkillPlayer getSkillPlayer(String accountName) {

		SkillPlayer player;

		if (skillPlayerList != null) {

			if (skillPlayerList.size() > 0) {

				for (int i = 0; i < skillPlayerList.size(); i++) {

					if (skillPlayerList.get(i).getAccountName().compareToIgnoreCase(accountName) == 0) {
						player = skillPlayerList.get(i);
						return player;
					}
				}
				return null;

			} else
				return null;

		} else
			return null;
	}

	public void removeSkillPlayer(String accountName) {

		if (skillPlayerList != null) {

			if (skillPlayerList.size() > 0) {

				for (int i = 0; i < skillPlayerList.size(); i++) {

					if (skillPlayerList.get(i).getAccountName().compareToIgnoreCase(accountName) == 0) {
						skillPlayerList.remove(i);
						break;
					}
				}
			}
		}
	}

	@Override
	public void run() {

		this.saveDb();

	}

}
