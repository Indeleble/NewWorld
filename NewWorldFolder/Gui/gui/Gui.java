package gui;

import gui.command.GuiCommand;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Gui extends JavaPlugin{
	
	public GuiCommand ejecutor;
	
	@Override
	public void onEnable(){
		Logger log = this.getLogger();
		ejecutor = new GuiCommand(this);
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
