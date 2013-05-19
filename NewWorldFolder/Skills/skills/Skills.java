package skills;

import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.player.SpoutPlayer;

import skills.agricultura.AgriculturaListener;
import skills.commands.SkillCommandsBaseListener;
import skills.mineria.MiningListener;
import skills.tala.TalaListener;
import core.Core;
import core.skills.SkillPlayerManager;

public class Skills extends JavaPlugin {

	Logger log;
	SkillPlayerManager spm;

	@Override
	public void onEnable() {

		log = this.getLogger();

		PluginManager pm = this.getServer().getPluginManager();

		Core core = (Core) pm.getPlugin("NWCore");
		spm = core.getSkillPlayerManager();
		
		
		
		//Register listeners
		pm.registerEvents(new MiningListener(spm, log, this), this);
		pm.registerEvents(new TalaListener(spm, log, this), this);
		pm.registerEvents(new AgriculturaListener(spm, log, this), this);
		
		//Register commands
		getCommand("skills").setExecutor(new SkillCommandsBaseListener(spm));
		
	}

	@Override
	public void onDisable() {
		// TODO Insert logic to be performed when the plugin is disabled
	}
	
	public SpoutPlayer getPlayer(String name){
		return (SpoutPlayer) getServer().getPlayer(name);
	}
}
