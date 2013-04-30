package armasfuego;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import armasfuego.cannon.CannonEventHandler;

public class ArmasFuego extends JavaPlugin{
	
	public CannonEventHandler ejecutor;
	
	@Override
	public void onEnable(){
		Logger log = this.getLogger();
		ejecutor = new CannonEventHandler(this);
		log.info("Armas de fuego activado");
	}

	@Override
	public void onDisable(){
		Logger log = this.getLogger();
		log.info("Armas de fuego desactivado");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		return ejecutor.onCommand(sender, cmd, commandLabel, args);
	}
}
