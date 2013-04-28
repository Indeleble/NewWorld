package husbandry;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import core.HusAnimal;
import core.HusAnimalManager;

public class TameListener implements Listener{
	
	HusAnimalManager ham;
	HusAnimal ha;
	
	public TameListener(HusAnimalManager ham){
		
		this.ham = ham;
	}
	
	@EventHandler
	public void PlayerInteractEvent(PlayerInteractEntityEvent ev) {
		ha = new HusAnimal();
		Player p = ev.getPlayer();
		Entity e = ev.getRightClicked();
		
		ha.setOwner(p.getName());
		ha.setCalidad(1);
		ha.setUid(e.getUniqueId());		
		ham.saveHusAnimal(ha);
	}

}
