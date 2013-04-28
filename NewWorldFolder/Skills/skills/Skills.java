package skills;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import skills.mineria.MiningListener;

import core.Core;
import core.HusAnimalManager;



public class Skills extends JavaPlugin {

	Logger log;
	HusAnimalManager ham;
	
	@Override
	public void onEnable() {

		log = this.getLogger();

		PluginManager pm = this.getServer().getPluginManager();
		
		Core core = (Core) pm.getPlugin("NWCore");

		pm.registerEvents(new MiningListener(), this);

	}

	@Override
	public void onDisable() {
		// TODO Insert logic to be performed when the plugin is disabled
	}

}
