package core;


import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.PersistenceException;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.avaje.ebean.EbeanServer;

import core.skills.PlayerListener;
import core.skills.SkillPlayer;
import core.skills.SkillPlayerManager;

public class Core extends JavaPlugin {

	Logger log;
	EbeanServer db;
	PluginManager pm;
	SkillPlayerManager spm;
	HusAnimalManager ham;
	

	@Override
	public void onEnable() {

		log = this.getLogger();
		
		log.info("Setting up database");
		setupDatabase();
		db = this.getDatabase();
		
		spm = new SkillPlayerManager(db, log);
		pm = this.getServer().getPluginManager();
		
		pm.registerEvents(new PlayerListener(spm), this);
		

		
				
	}

	@Override
	public void onDisable() {

		spm.saveDb();
		
	}
	
	public HusAnimalManager getHusAnimalManager(){
		
		return this.ham;
	}
	

	private void setupDatabase() {
		try {
			getDatabase().find(SkillPlayer.class).findRowCount();
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

		return classes;
	}
}
