package gui.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.getspout.spoutapi.player.SpoutPlayer;

import gui.Gui;

public class GuiCommand {
	@SuppressWarnings("unused")
	private Gui plugin;

	public GuiCommand(Gui plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("gui")){
			
			SpoutPlayer player = (Player) sender;
			final CustomGui gi = new CustomGui(Gui.getPlayer(player));
			gi.makeGui();
			
		}
		return false;
	}
	
	
	
}
