package core;


import java.util.List;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.Query;

public class HusAnimalManager {
	
	EbeanServer db;
	List<HusAnimal> husAnimalsList;
	
	public HusAnimalManager(EbeanServer db){
		
		this.db = db;
		husAnimalsList = this.getHusAnimalsDb();
	}
	
	public void saveHusAnimal(Object et) {
		db.save(et);
		husAnimalsList.add((HusAnimal) et);
	}

	public List<HusAnimal> getHusAnimalsDb() {

		Query<HusAnimal> query = db.find(HusAnimal.class);
		husAnimalsList = query.findList();

		return husAnimalsList;

	}
}
