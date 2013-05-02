package skills.tala;

import java.util.logging.Logger;

import org.bukkit.Location;
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

public class TalaListener implements Listener {

	SkillPlayerManager spm;
	Logger log;
	Plugin pl;

	public TalaListener(SkillPlayerManager spm, Logger log, Plugin pl) {

		this.spm = spm;
		this.log = log;
		this.pl = pl;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void TalaDamageEvent(BlockBreakEvent event) {

		Player player = event.getPlayer();
		Location blockLocation = event.getBlock().getLocation();
		int itemId = player.getItemInHand().getTypeId();
		SkillPlayer sp;
		PermissionUser user = PermissionsEx.getUser(player);
		ItemPurityBuilder ipb;

		if (event.getBlock().getTypeId() == 17
				|| event.getBlock().getTypeId() == 18) {

			if (user.inGroup("tala")) {
				
				log.info(String.valueOf(itemId));

				if (itemId == 275 || itemId == 258 || itemId == 279) {
					
					sp = spm.getSkillPlayer(player.getName());
					ipb = new ItemPurityBuilder();

					if (event.getBlock().getTypeId() == 17) {
						
						ipb.addDrop(new CustomDrop(new ItemStack(event.getBlock().getType()), sp.getTalaLvl(), 1));
						
						if (itemId == 275) ipb.addDrop(new CustomDrop(new ItemStack(280), sp.getTalaLvl(), 2));
						if (itemId == 258) ipb.addDrop(new CustomDrop(new ItemStack(280), sp.getTalaLvl(), 3));
						if (itemId == 279) ipb.addDrop(new CustomDrop(new ItemStack(280), sp.getTalaLvl(), 4));
						log.info(String.valueOf(ipb.getDrops().size()));
						log.info("Hace cooosaaaas");
						
						if (ipb.getDrops().size()>0){
						for (int i=0; i< ipb.getDrops().size();i++){
							pl.getServer().getWorld("world").dropItem(blockLocation, ipb.getDrops().get(i));
							log.info("Hace cooosaaaas muchaaaaaas");
							}
						}
						
						sp.addTalaExp(200);
						player.sendMessage("Experiencia en tala subio en 200 puntos");
						player.sendMessage("Experiencia en tala: "
								+ sp.getTalaExp());
						player.sendMessage("Nivel de tala: " + sp.getTalaLvl());
						player.sendMessage("Nivel total: " + sp.getTotalLevel());
						
						event.setCancelled(true);
						event.getBlock().setTypeId(0);

					} else
						sp.addTalaExp(150);
					player.sendMessage("Experiencia en tala subio en 150 puntos");
					player.sendMessage("Nivel de tala: " + sp.getTalaLvl());
					player.sendMessage("Nivel total: " + sp.getTotalLevel());
					
					event.setCancelled(true);
					event.getBlock().setTypeId(0);

				}
			}
		}
	}
}
