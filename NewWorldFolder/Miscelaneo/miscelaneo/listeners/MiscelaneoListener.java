package miscelaneo.listeners;

import java.util.Timer;
import java.util.TimerTask;

import miscelaneo.Miscelaneo;

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
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Door;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@SuppressWarnings("deprecation")
public class MiscelaneoListener implements Listener{
	
	Miscelaneo plugin;
	
	public MiscelaneoListener(Miscelaneo listener) {
		plugin=listener;
	}
	
	@EventHandler //----- Abrir la puerta de hierro
    public void onPlayerInteract(PlayerInteractEvent evnt) {
		
        Player player = evnt.getPlayer();
        Action action = evnt.getAction();
        Block block = evnt.getClickedBlock();
        ItemStack inHand = evnt.getPlayer().getItemInHand();
        Material material;
        
        if (player.hasMetadata("NPC")) return; // Checkear si el jugador es NPC.

        /* Fix for NPE on interacting with air */
        if (block == null) {
            material = Material.AIR;
        }else {
            material = block.getType();
        }
        
        switch (action) {
	        case RIGHT_CLICK_BLOCK:
			if (material == Material.IRON_DOOR_BLOCK) {

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
