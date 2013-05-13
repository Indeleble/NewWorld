package miscelaneo.listeners;

import java.util.Random;

import miscelaneo.Miscelaneo;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Door;

@SuppressWarnings("deprecation")
public class MiscelaneoListener implements Listener{
	
	Miscelaneo plugin;
	
	public MiscelaneoListener(Miscelaneo listener) {
		plugin=listener;
	}
	
	@EventHandler //----- Abrir la puerta de hierro
    public void onPlayerInteract(PlayerInteractEvent evnt) {
		
		boolean canFarm = false;
        Player player = evnt.getPlayer();
        Action action = evnt.getAction();
        Block block = evnt.getClickedBlock();
        ItemStack inHand = evnt.getPlayer().getItemInHand();
        int inHandId = evnt.getPlayer().getItemInHand().getTypeId();
        Material material;
		Random r = new Random();
		int r2 = 0;
		int itemcalidad = 50;  // AQUI COLOCAR EL CHECK DE LA CALIDAD DEL ITEM EN LA MANO
		
        if (player.hasMetadata("NPC")) return; // Checkear si el jugador es NPC.

        /* Fix for NPE on interacting with air */
        if (block == null) {
            material = Material.AIR;
        }else {
            material = block.getType();
        }
        
        switch (action) {
	        case RIGHT_CLICK_BLOCK:
			if(material == Material.SOIL){
	        	if((inHandId==295) || (inHandId==338) || (inHandId==361) || (inHandId==362) || (inHandId==391) || (inHandId==392)){  // Wheat Seeds, Sugar Cane, Pumpkin Seeds, Melon Seeds, Carrot, Potato
	        		// checkear el radio alrededor del block. si no tiene bloque molino o espantapajaros, event.setcanceled
		        }
        	}else if(material == Material.STONE){  // Colocar los soportes de las minas en la piedra.
	        	if(inHandId==370){ // colocado como provisional, ghast tear (370)
	        		r2 = r.nextInt(100);
	        		if(inHand.getAmount()>1){
	        			player.getInventory().getItemInHand().setAmount(player.getInventory().getItemInHand().getAmount()-1);
	        		}else if(inHand.getAmount()<=1){
	        			player.getInventory().removeItem(player.getInventory().getItemInHand());
	        		}
	        		if(r2<=itemcalidad){
	        			block.setTypeIdAndData(98, (byte) 3, true); //chiseled stone brick
	        			player.sendMessage(ChatColor.GREEN+"Has colocado el soporte para la mina en la piedra");
	        		}else{
	        			evnt.setCancelled(true);
	        			player.sendMessage(ChatColor.RED+"El soporte para la mina no tenia suficiente calidad como para aguantar el peso de la roca y se ha roto");
	        		}
	        	}
	        }else if(material == Material.IRON_DOOR_BLOCK){ // Abrir las puertas de hierro con click derecho.
				BlockState state = block.getState();
				Door door = (Door) state.getData();
				BlockState state2;
				if (door.isTopHalf()) {
					Door top = door;
					state2 = block.getRelative(BlockFace.DOWN).getState();
					Door bottom = (Door) state2.getData();
					if (top.isOpen() == false) {
						top.setOpen(true);
						bottom.setOpen(true);
						player.getWorld().playSound(block.getLocation(), Sound.DOOR_CLOSE, 1, 1);
					}else {
						top.setOpen(false);
						bottom.setOpen(false);
						player.getWorld().playSound(block.getLocation(), Sound.DOOR_CLOSE, 1, 1);
					}
					state.update();
					state2.update();
				}else {
					Door bottom = door;
					state2 = block.getRelative(BlockFace.UP).getState();
					Door top = (Door) state2.getData();
					if (bottom.isOpen() == false) {
						bottom.setOpen(true);
						top.setOpen(true);
						player.getWorld().playSound(block.getLocation(), Sound.DOOR_CLOSE, 1, 1);
					}else {
						bottom.setOpen(false);
						top.setOpen(false);
						player.getWorld().playSound(block.getLocation(), Sound.DOOR_CLOSE, 1, 1);
					}
					state.update();
					state2.update();
				}
			}else if(inHand.getTypeId() == 385){
				evnt.setCancelled(true);
			}
			default:
				break;
		}
	}
	
	@EventHandler //----- Tocar a la puerta
	public void onBlockDamage(BlockDamageEvent event) {

        Player player = event.getPlayer();
        Block block = event.getBlock();
        int material = block.getTypeId();

		if(player.hasMetadata("NPC")) return;

		if((material==64) || (material==71)){
			player.getWorld().playSound(block.getLocation(), Sound.ZOMBIE_WOOD, 1, 1);
		}
	}

/*	@EventHandler //----- Sprint
	public void onPlayerSprint(final PlayerToggleSprintEvent event){
		
		final Player player = event.getPlayer();
	    final Timer tiempoespera = new Timer();    
	    long tiempoaguante = 5000; // Colocar 5000 (5 segs) * nivel de resistencia del jugador para que aumente la distancia que puedes sprintar sin cansarte.
	    
	    TimerTask timerTask = new TimerTask(){
	    	public void run(){
	    		if(player.isSprinting()){
		    		event.setCancelled(true);
					if(!player.hasPotionEffect(PotionEffectType.SLOW)){
						player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 3));
					}
					tiempoespera.cancel();
	    		}
		    }
	    };
	    
	    if(player.isSprinting()){
	    	tiempoespera.scheduleAtFixedRate(timerTask, tiempoaguante, 1); 
	    }

	}*/



}
