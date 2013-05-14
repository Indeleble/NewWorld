package skills.agricultura;

import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import skills.drops.CustomDrop;
import skills.drops.ItemPurityBuilder;
import core.skills.SkillPlayer;
import core.skills.SkillPlayerManager;
import core.skills.SkillType;

public class AgriculturaListener implements Listener {

	SkillPlayerManager	spm;
	Logger				log;
	Plugin				pl;

	public AgriculturaListener(SkillPlayerManager spm, Logger log, Plugin pl) {

		this.spm = spm;
		this.log = log;
		this.pl = pl;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void AgriculturaDamageEvent(BlockBreakEvent event) {

		Block block = event.getBlock();
		Player player;
		SkillPlayer sp;
		PermissionUser user;
		ItemPurityBuilder ipb;
		player = event.getPlayer();
		user = PermissionsEx.getUser(player);
		
		if (user.inGroup("agricultura")) {
			log.info("Detecta grupo agricultura");

			sp = spm.getSkillPlayer(player.getName());
			ipb = new ItemPurityBuilder();
			int level = sp.getLevel(SkillType.Agricultura);
			int dropLevel = Double.valueOf(level / 2).intValue();

			if (block.getType() == Material.POTATO) {
				log.info("Patata");
				ipb.addDrop(new CustomDrop(new ItemStack(392), level, 1, 90));

			}
			if (block.getType() == Material.CARROT) {
				log.info("Zanahoria");
				ipb.addDrop(new CustomDrop(new ItemStack(391), level, 1, 90));

			}
			if (block.getType() == Material.WHEAT) {
				log.info("trigos");
				ipb.addDrop(new CustomDrop(new ItemStack(296), level, 1, 90));

			}

			if (ipb.getDrops().size() > 0) {

				for (ItemStack is : ipb.getDrops()) {
					pl.getServer().getWorld("world").dropItem(block.getLocation(), is);
				}
			}

			sp.addExperience(SkillType.Agricultura, 500);
			player.sendMessage("Exp. agricultura subio 500 puntos. Total: " + sp.getExperience(SkillType.Agricultura) + "Level: " + sp.getLevel(SkillType.Agricultura));

			event.setCancelled(true);
			event.getBlock().setTypeId(0);
		}
	}
}
