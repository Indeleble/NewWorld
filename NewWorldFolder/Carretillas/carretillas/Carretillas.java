package carretillas;

import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Carretillas extends JavaPlugin implements CommandExecutor {

	Logger log;

	@Override
	public void onEnable() {

		log = this.getLogger();
		getCommand("carretilla").setExecutor(this);

		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new CarretillasListener(this), this);
		//Entity carretilla = new Entity(EntityType.MINECART_CHEST);
		
		

	}

	@Override
	public void onDisable() {
		// TODO Insert logic to be performed when the plugin is disabled
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (cmd.getName().equalsIgnoreCase("carretilla")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only be run by a player.");
				return true;
			} else {
				Player player = (Player) sender;
				Location loc = player.getLocation();


				//getServer().getWorld(player.getWorld().getName()).spawnEntity(loc, type)
				
				return true;
			}
		}

		return false;

	}

}
