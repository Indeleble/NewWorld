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

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import core.husbrandy.AnimalDb;
import core.husbrandy.HusAnimalManager;
import de.ntcomputer.minecraft.controllablemobs.api.ControllableMob;
import de.ntcomputer.minecraft.controllablemobs.api.ControllableMobs;
import de.ntcomputer.minecraft.controllablemobs.api.actions.ActionType;
import de.ntcomputer.minecraft.controllablemobs.api.ai.behaviors.AIBehavior;

public class TameListener implements Listener {

	Plugin				pl;
	HusAnimalManager	ham;

	public TameListener(Plugin pl, HusAnimalManager ham) {

		this.pl = pl;
		this.ham = ham;
	}

	@EventHandler
	public void PlayerInteractEvent(PlayerInteractEntityEvent ev) {

		Player p = ev.getPlayer();
		Entity e = ev.getRightClicked();
		Cow cow = (Cow) e;
		ControllableMob<Cow> conCow;
		PermissionUser user = PermissionsEx.getUser(ev.getPlayer());

		if (user.inGroup("ganaderia")) {

			if (p.getItemInHand().getType() == Material.BONE && (e.getType() == EntityType.COW || e.getType() == EntityType.WOLF) ) {

				// Si tiene dueño

				if (ham.animalHasOwner(e.getUniqueId()) != null) {

					// Si el que le llama es el dueño
					if (ham.animalHasOwner(e.getUniqueId()).equalsIgnoreCase(p.getName())) {

						conCow = ControllableMobs.getOrAssign(cow, true);

						if (conCow.getActions().isActionRunning(ActionType.FOLLOW)) {

							conCow.getActions().clearActions();
							
							conCow.getAI().restoreAIBehaviors();
							p.sendMessage("Ese animal te deja de seguir");

						} else {

							conCow.getActions().clearActions();
							conCow.getActions().follow(p, false, 3);
							p.sendMessage("Te sigue");
						}
						// Si tiene dueño y no es el que activa el evento
					} else {
						p.sendMessage("Ese animal tiene dueño");
					}

				} else {

					AnimalDb animal = new AnimalDb();
					animal.setAge(e.getTicksLived() / 20);
					animal.setOwner(p.getName());
					animal.setUuid(e.getUniqueId());
					animal.setType(e.getType().getTypeId());
					animal.setQuality(10);

					ham.addNewAnimalToDb(p.getName(), animal);

				}

			}

		}
	}

}
