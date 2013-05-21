package skills.mineria;

import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import skills.drops.CustomDrop;
import skills.drops.ItemPurityBuilder;
import core.skills.SkillPlayer;
import core.skills.SkillPlayerManager;
import core.skills.SkillType;


public class MiningListener implements Listener {

	static SkillPlayerManager	spm;
	static ProsManager pm;
	Logger						log;
	Plugin						pl;

	public MiningListener(SkillPlayerManager spm, Logger log, Plugin pl) {
		this.spm = spm;
		this.log = log;
		this.pl = pl;
	}
	
	@EventHandler
	public static void PlayerInteractEvent(PlayerInteractEvent event){
		Player player = event.getPlayer();
	    Action action = event.getAction();
	    PermissionUser user = PermissionsEx.getUser(event.getPlayer());
	    Block block = event.getClickedBlock();
	    SkillPlayer sp = spm.getSkillPlayer(player.getName());
	    
	    int inHand = player.getItemInHand().getTypeId();
	    Material material;
	    if (block == null) {
	      material = Material.AIR;
	    }
	    else {
	      material = block.getType();
	    }

	    switch (action){
	    case LEFT_CLICK_BLOCK:
	    	if ((inHand == 257) || (inHand == 274) || (inHand == 278) || (inHand == 285)) {
	    		player.sendMessage("test block");

/*	        	if (!sp.isProspectando()) {
	          		sp.setProspectando(true);
	          		player.sendMessage(ChatColor.GREEN + "Te preparas para prospectar la piedra");
	        	} else {
	          		sp.setProspectando(false);
	          		player.sendMessage(ChatColor.RED + "Dejas de prospectar la piedra");
	        	}*/
	    	}
	    	break;
	    case RIGHT_CLICK_AIR:
	    	if ((inHand == 257) || (inHand == 274) || (inHand == 278) || (inHand == 285)) {
	    		player.sendMessage("test block");
/*	        	if (!sp.isProspectando()) {
	          		sp.setProspectando(true);
	          		player.sendMessage(ChatColor.GREEN + "Te preparas para prospectar la piedra");
	        	} else {
	          		sp.setProspectando(false);
	          		player.sendMessage(ChatColor.RED + "Dejas de prospectar la piedra");
	        	}*/
	    	}
	    	break;
	    case PHYSICAL:
	    }
	}

	@EventHandler
	public void BlockBreakEvent(BlockBreakEvent ev){
		Player player = ev.getPlayer();
		Location blockLocation = ev.getBlock().getLocation();
		SkillPlayer sp = spm.getSkillPlayer(player.getName());
		PermissionUser user = PermissionsEx.getUser(ev.getPlayer());
		ItemPurityBuilder ipb = new ItemPurityBuilder();
		Block block = ev.getBlock();
		String name = player.getName();

		Random r = new Random();
		int inHand = player.getItemInHand().getTypeId();
		int r2 = 0;
		r2 = r.nextInt(100);

		if (block.getType() == Material.STONE){
			if ((player.getGameMode() == GameMode.SURVIVAL)){
				if(pm.isProspecting(name)){
					if(inHand == 274){ //pico de cobre
						player.sendMessage("test de prospectar");
					
						/* Hacer los checkeos de porcentajes de cada herramienta */
						
						if(sp.getLevel(SkillType.Mineria)>=20){
							
						}else if(sp.getLevel(SkillType.Mineria)>=30){
							
						}else if(sp.getLevel(SkillType.Mineria)>=40){
							
						}else if(sp.getLevel(SkillType.Mineria)>=50){
							
						}
					}else if(inHand == 257){	// pico de hierro
						if(sp.getLevel(SkillType.Mineria)>=20){
							
						}else if(sp.getLevel(SkillType.Mineria)>=30){
							
						}else if(sp.getLevel(SkillType.Mineria)>=40){
							
						}else if(sp.getLevel(SkillType.Mineria)>=50){
						
						}else if(sp.getLevel(SkillType.Mineria)>=60){
							
						}else if(sp.getLevel(SkillType.Mineria)>=70){
						
						}
					}else if(inHand == 278){  // pico de acero
						if(sp.getLevel(SkillType.Mineria)>=20){
							
						}else if(sp.getLevel(SkillType.Mineria)>=30){
							
						}else if(sp.getLevel(SkillType.Mineria)>=40){
							
						}else if(sp.getLevel(SkillType.Mineria)>=50){
						
						}else if(sp.getLevel(SkillType.Mineria)>=60){
							
						}else if(sp.getLevel(SkillType.Mineria)>=70){
						
						}
					}
				}else if(!pm.isProspecting(name)){
					player.sendMessage("test romper stone sin prospectar");

					ItemStack cobblestone = new ItemStack(4);

					if (inHand == 274) {
						ipb.addDrop(new CustomDrop(cobblestone, sp.getLevel(SkillType.Mineria), 1, 50));
					}
					if (inHand == 257) {
						ipb.addDrop(new CustomDrop(cobblestone, sp.getLevel(SkillType.Mineria), 1, 70));
					}	
					if (inHand == 278) {
						ipb.addDrop(new CustomDrop(cobblestone, sp.getLevel(SkillType.Mineria), 1, 80));
					}
					if (ipb.getDrops().size() > 0){
						for (ItemStack is : ipb.getDrops()) {
							this.pl.getServer().getWorld("world").dropItem(blockLocation, is);
						}
					}

					sp.addExperience(SkillType.Mineria, 200);
					player.sendMessage("Experiencia en mineria subio en 200 puntos");
					player.sendMessage("Experiencia en mineria: " + sp.getLevel(SkillType.Mineria));
					player.sendMessage("Nivel de mineria: " + sp.getLevel(SkillType.Mineria));
					player.sendMessage("Nivel total: " + sp.getTotalLevel());

					ev.setCancelled(true);
					ev.getBlock().setTypeId(0);
				}
			}
		}
	}
}