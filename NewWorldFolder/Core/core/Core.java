package core;


import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.PersistenceException;

import org.bukkit.plugin.java.JavaPlugin;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import com.avaje.ebean.EbeanServer;

public class Core extends JavaPlugin {

	Logger log;
	EbeanServer db;
	
	HusAnimalManager ham;
	

	@Override
	public void onEnable() {

		log = this.getLogger();
		
		log.info("Setting up database");
		setupDatabase();
		db = this.getDatabase();
		
		//Create managers
		ham = new HusAnimalManager(db);
		
		

	}

	@Override
	public void onDisable() {
		log.info("Saving animals");
		
	}
	
	public HusAnimalManager getHusAnimalManager(){
		
		return this.ham;
	}
	

	private void setupDatabase() {
		try {
			getDatabase().find(SkillPlayer.class).findRowCount();
			getDatabase().find(HusAnimal.class).findRowCount();
		} catch (PersistenceException ex) {
			System.out.println("Installing database for "
					+ getDescription().getName() + " due to first time usage");
			installDDL();
		}
	}

	@Override
	public List<Class<?>> getDatabaseClasses() {

		List<Class<?>> classes = new LinkedList<Class<?>>();
		classes.add(SkillPlayer.class);
		classes.add(HusAnimal.class);

		return classes;
	}
}
