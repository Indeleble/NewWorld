package miscelaneo;


import java.util.logging.Logger;

import keys.commands.KeysCommand;

import miscelaneo.instrumentos.InstrumentoHandler;
import miscelaneo.listeners.MiscelaneoListener;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import soil.listeners.SoilListener;

public class Miscelaneo extends JavaPlugin{
	
	public KeysCommand ejecutor;
	public SoilListener listener;
	
	private static InstrumentoHandler iHandler;

	
	@Override
	public void onLoad() {
		iHandler = new InstrumentoHandler();
	}
	
	@Override
	public void onEnable() {
		Logger log = this.getLogger();
		PluginManager pm = this.getServer().getPluginManager();
		MiscelaneoListener listener = new MiscelaneoListener(this);
		pm.registerEvents(listener,this);
		log.info("Miscelaneo activado");
	}

	@Override
	public void onDisable() {
		// TODO Insert logic to be performed when the plugin is disabled
	}
	
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args){
		return ejecutor.onCommand(sender, command, commandLabel, args);
	}
	
	public static InstrumentoHandler getInstrumentoHandler() {
		return iHandler;
	}
}
