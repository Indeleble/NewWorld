package basehabilidades;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class BaseHabilidades extends JavaPlugin{

	@Override
	public void onEnable() {
		Logger log = this.getLogger();
		log.info("Base de las habilidades activado");
	}

	@Override
	public void onDisable() {
		// TODO Insert logic to be performed when the plugin is disabled
	}

}
