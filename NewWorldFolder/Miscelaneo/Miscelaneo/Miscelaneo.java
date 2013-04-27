package Miscelaneo;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import Commands.MiscelaneoCommand;

public class Miscelaneo  extends JavaPlugin{

	public MiscelaneoCommand comd;
	

	@Override
	public void onEnable() {
		Logger log = this.getLogger();
		comd = new MiscelaneoCommand(this);
		log.info("Cosas miscelaneas activado");
	}

	@Override
	public void onDisable() {
		// TODO Insert logic to be performed when the plugin is disabled
	}

	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args){
		return comd.onCommand(sender, command, commandLabel, args);
	}
}
