package miscelaneo;

import java.util.logging.Logger;

import miscelaneo.commands.MiscelaneoCommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Miscelaneo extends JavaPlugin{
	
	public MiscelaneoCommand ejecutor;
	
	@Override
	public void onEnable() {
		Logger log = this.getLogger();
		log.info("Miscelaneo activado");
	}

	@Override
	public void onDisable() {
		// TODO Insert logic to be performed when the plugin is disabled
	}
	
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args){
		return ejecutor.onCommand(sender, command, commandLabel, args);
	}
}
