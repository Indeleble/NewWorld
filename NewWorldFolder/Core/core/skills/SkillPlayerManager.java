package core.skills;

import java.util.List;
import java.util.logging.Logger;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.Query;

public class SkillPlayerManager {

	EbeanServer db;
	List<SkillPlayer> skillPlayerList;
	Logger log;

	public SkillPlayerManager(EbeanServer db, Logger log) {

		this.db = db;
		this.log = log;
		Query<SkillPlayer> query = db.find(SkillPlayer.class);
		skillPlayerList = query.findList();
	}

	public void saveDb() {
		log.info("Saving players database");
		
		for(SkillPlayer sp : this.skillPlayerList){
			
			db.update(sp);
		}
	}
	
	public void addSkillPlayer(SkillPlayer player){
		
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
