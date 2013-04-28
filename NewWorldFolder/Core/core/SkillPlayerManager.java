package core;

import java.util.List;

import org.bukkit.entity.Player;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.Query;

public class SkillPlayerManager {

	EbeanServer db;
	List<SkillPlayer> skillPlayerList;

	public SkillPlayerManager(EbeanServer db) {

		this.db = db;
		skillPlayerList = this.getSkillPlayerListDb();
	}

	public void saveSkillPlayerDb(Object et) {
		db.save(et);
		skillPlayerList.add((SkillPlayer) et);
	}

	public List<SkillPlayer> getSkillPlayerListDb() {

		Query<SkillPlayer> query = db.find(SkillPlayer.class);
		skillPlayerList = query.findList();

		return skillPlayerList;

	}

	public void refreshDb() {

		this.skillPlayerList = this.getSkillPlayerListDb();
	}

	public SkillPlayer getSkillPlayer(String ac) {
		this.refreshDb();
		SkillPlayer player;

		if (skillPlayerList != null) {

			if (skillPlayerList.size() > 0) {

				for (int i = 0; i < skillPlayerList.size(); i++) {

					if (skillPlayerList.get(i).getAccountName()
							.compareToIgnoreCase(ac) == 0) {
						player = skillPlayerList.get(i);
						return player;
					}
				}return null;

			} else
				return null;

		} else
			return null;

	}

}
