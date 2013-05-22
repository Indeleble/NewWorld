package skills.mineria;

import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
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
	public void BlockBreakEvent(BlockBreakEvent ev){
		
		Player player = ev.getPlayer();
		PermissionUser user = PermissionsEx.getUser(ev.getPlayer());
		
		if (user.inGroup("mineria")) {

			SkillPlayer sp;
			ItemPurityBuilder ipb;
			Block block = ev.getBlock();
			String name = player.getName();
			int b = block.getTypeId();
			
			if ((player.getGameMode() == GameMode.SURVIVAL)){ // cambiarlo a personaje en region de world guard de permitido prospectar
				
				Location blockLocation = ev.getBlock().getLocation();
				sp = spm.getSkillPlayer(player.getName());
				ipb = new ItemPurityBuilder();
				
				if (block.getType() == Material.STONE){
				
					Random r = new Random();
					int inHand = player.getItemInHand().getTypeId();
					int r2 = 0;
					r2 = r.nextInt(100);
				
					//setTypeIdAndData(98, (byte) 3, true);  //soporte de la mina
						
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
				}else if(block.getType() == Material.DIRT){
					int inHand = player.getItemInHand().getTypeId();
					ItemStack dirt = new ItemStack(3);
					
					
				}else if(block.getType() == Material.GRASS){
					int inHand = player.getItemInHand().getTypeId();
					ItemStack dirt = new ItemStack(3);			
					
					
				}else if(block.getType() == Material.SAND){
					int inHand = player.getItemInHand().getTypeId();
					ItemStack sand = new ItemStack(12);
					
					
				}else if(block.getType() == Material.CLAY){
					int inHand = player.getItemInHand().getTypeId();
					ItemStack clay = new ItemStack(337);
					
					
				}else if(block.getType() == Material.GRAVEL){ // revisar drops, algo mas dará a parte del bloque
					int inHand = player.getItemInHand().getTypeId();
					ItemStack gravel = new ItemStack(13);
					
					
				}else if(block.getType() == Material.SANDSTONE){
					int inHand = player.getItemInHand().getTypeId();
					ItemStack sandstone = new ItemStack(24);

					if(inHand == 274){ //pico de cobre
						
					}else if(inHand == 257){	// pico de hierro
						
					}else if(inHand == 278){  // pico de acero
						
					}
				}else if(block.getType() == Material.COAL_ORE){
					int inHand = player.getItemInHand().getTypeId();
					ItemStack coalore = new ItemStack(16);
					
					if(inHand == 274){ //pico de cobre
						
					}else if(inHand == 257){	// pico de hierro
						
					}else if(inHand == 278){  // pico de acero
						
					}
				}else if(block.getType() == Material.ENDER_STONE){ // piedra fallada al prospectar, dropea cobble.
					int inHand = player.getItemInHand().getTypeId();
					ItemStack cobblestone = new ItemStack(4);
					
					if(inHand == 274){ //pico de cobre
						
					}else if(inHand == 257){	// pico de hierro
						
					}else if(inHand == 278){  // pico de acero
						
					}
				}else if(block.getType() == Material.IRON_ORE){
					int inHand = player.getItemInHand().getTypeId();
					ItemStack ironore = new ItemStack(15);
					
					if(inHand == 274){ //pico de cobre
						
					}else if(inHand == 257){	// pico de hierro
						
					}else if(inHand == 278){  // pico de acero
						
					}
				}else if(block.getType() == Material.QUARTZ_ORE){
					int inHand = player.getItemInHand().getTypeId();
					ItemStack quartzore = new ItemStack(153);
					
					if(inHand == 274){ //pico de cobre
						
					}else if(inHand == 257){	// pico de hierro
						
					}else if(inHand == 278){  // pico de acero
						
					}
				}else if(block.getType() == Material.GOLD_ORE){
					int inHand = player.getItemInHand().getTypeId();
					ItemStack goldore = new ItemStack(14);
					
					if(inHand == 274){ //pico de cobre
						
					}else if(inHand == 257){	// pico de hierro
						
					}else if(inHand == 278){  // pico de acero
						
					}
				}else if(block.getType() == Material.EMERALD_ORE){
					int inHand = player.getItemInHand().getTypeId();
					ItemStack emerald = new ItemStack(388);
//					ItemStack lapis = new ItemStack(¿?¿?¿?¿?¿?); 351:4
					
					if(inHand == 274){ //pico de cobre
						
					}else if(inHand == 257){	// pico de hierro
						
					}else if(inHand == 278){  // pico de acero
						
					}
				}else if(block.getType() == Material.DIAMOND_ORE){
					int inHand = player.getItemInHand().getTypeId();
					ItemStack diamond = new ItemStack(264);
					
					if(inHand == 274){ //pico de cobre
						
					}else if(inHand == 257){	// pico de hierro
						
					}else if(inHand == 278){  // pico de acero
						
					}
				}else if(block.getType() == Material.LAPIS_ORE){    // ore de cobre. dropea cobre (en teoria)
					int inHand = player.getItemInHand().getTypeId();
//					ItemStack cobre = new ItemStack(¿?¿?¿?);    ¿item custom o algo?
					
					if(inHand == 274){ //pico de cobre
						
					}else if(inHand == 257){	// pico de hierro
						
					}else if(inHand == 278){  // pico de acero
						
					}
				}/*else if(block.getTypeId()){ // checkear 98:3 // soporte de minas
					ItemStack soporteminas = new ItemStack(¿?¿?¿?¿?¿?);    ¿item custom o algo?
					
					
				}*/
			}else{
				if(b==1){
					player.sendMessage(ChatColor.RED+"Esta no parece una buena zona para picar, prueba en una mina o cantera.");
				}
/*				if(!no esta en una region de cantera de worldguard){
					player.sendMessage(ChatColor.RED+"Esta piedra parece no tener ningun mineral, prueba en una mina o cantera.");
					pm.removeProspecter(name); // bien?
				}*/
			}
		}
	}
}