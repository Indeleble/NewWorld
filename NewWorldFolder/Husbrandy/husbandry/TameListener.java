package husbandry;

import org.bukkit.Material;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.Plugin;

import core.husbrandy.AnimalDb;
import de.ntcomputer.minecraft.controllablemobs.api.ControllableMob;
import de.ntcomputer.minecraft.controllablemobs.api.ControllableMobs;

public class TameListener implements Listener {

	Plugin	pl;

	public TameListener(Plugin pl) {

		this.pl = pl;
	}

	@EventHandler
	public void PlayerInteractEvent(PlayerInteractEntityEvent ev) {

		Player p = ev.getPlayer();
		Entity e = ev.getRightClicked();
		Cow cow = (Cow) e;
		ControllableMob<Cow> conCow;
		
		if (p.getItemInHand().getType() == Material.BONE && e.getType() == EntityType.COW) {

//			AnimalDb animal = new AnimalDb();
//			animal.setAge(e.getTicksLived() / 20);
//			animal.setOwner(p.getName());
//			animal.setUuid(e.getUniqueId());
			

			conCow = ControllableMobs.getOrAssign(cow, true);
			//conCow.getActions().follow(p);
			conCow.getActions().clearActions();
			conCow.getActions().follow(p, false, 3);
			p.sendMessage(conCow.getActions().toString());
			
		}
		
	}

}
