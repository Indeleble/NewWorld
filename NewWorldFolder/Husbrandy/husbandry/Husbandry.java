package husbandry;

import java.util.logging.Logger;

import listeners.CraftListener;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import core.Core;
import core.HusAnimalManager;



public class Husbandry extends JavaPlugin {

	Logger log;
	HusAnimalManager ham;
	
	@Override
	public void onEnable() {

		log = this.getLogger();

		PluginManager pm = this.getServer().getPluginManager();
		
		Core core = (Core) pm.getPlugin("NWCore");
		ham = core.getHusAnimalManager();

		pm.registerEvents(new CraftListener(this), this);
		

	}

	@Override
	public void onDisable() {
		// TODO Insert logic to be performed when the plugin is disabled
	}

}
