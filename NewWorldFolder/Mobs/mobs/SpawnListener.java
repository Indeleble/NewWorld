package mobs;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;


public class SpawnListener implements Listener {
	
	Mobs plugin;

	public SpawnListener(Mobs listener) {
		this.plugin = listener;
	}

	
 	public void CreatureSpawnEvent(final LivingEntity spawnee, final SpawnReason spawnReason){

 		SpawnReason SpawnCrianza = spawnReason.BREEDING;
 		SpawnReason SpawnHuevo = spawnReason.EGG;
 		SpawnReason SpawnPlugin = spawnReason.CUSTOM;
 		SpawnReason SpawnSpawner = spawnReason.SPAWNER;
 		
 		/* En proceso */
 		
 		
 		
 		
 		
 		
 	}
}
