package core.skills;

import java.util.List;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.Query;

public class SkillPlayerManager {

	EbeanServer db;
	List<SkillPlayer> skillPlayerList;

	public SkillPlayerManager(EbeanServer db) {

		this.db = db;
		Query<SkillPlayer> query = db.find(SkillPlayer.class);
		skillPlayerList = query.findList();
	}

	public void saveSkillPlayerDb() {
		db.save(skillPlayerList);
	}

	public List<SkillPlayer> getSkillPlayerList() {

		return skillPlayerList;

	}

	public boolean existPlayerInDb(String name) {
		
		Query<SkillPlayer> query = db.find(SkillPlayer.class);
		//skillPlayerList = db.up

		return false;

	}

	public SkillPlayer getSkillPlayer(String accountName) {

		SkillPlayer player;

		if (skillPlayerList != null) {

			if (skillPlayerList.size() > 0) {

				for (int i = 0; i < skillPlayerList.size(); i++) {

					if (skillPlayerList.get(i).getAccountName()
							.compareToIgnoreCase(accountName) == 0) {
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

}
