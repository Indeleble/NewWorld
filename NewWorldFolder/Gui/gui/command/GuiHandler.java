package gui.command;

import gui.Gui;

import org.bukkit.event.EventHandler;
import org.getspout.spoutapi.event.input.KeyBindingEvent;
import org.getspout.spoutapi.event.input.KeyPressedEvent;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.keyboard.BindingExecutionDelegate;
import org.getspout.spoutapi.player.SpoutPlayer;


public class GuiHandler implements BindingExecutionDelegate{

	@Override
	public void keyPressed(KeyBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@EventHandler
	public void onKeyPress(KeyPressedEvent event) { 
		if (event.getKey().equals(event.getPlayer().getInventoryKey())) {
			SpoutPlayer player = event.getPlayer();
			if (player.getActiveScreen() == ScreenType.GAME_SCREEN || player.getActiveScreen() == ScreenType.PLAYER_INVENTORY) {
				final CustomGui gi = new CustomGui(Gui.getPlayer(player));
					gi.makeGui();
				}
			}
	}
	
	
	
}
