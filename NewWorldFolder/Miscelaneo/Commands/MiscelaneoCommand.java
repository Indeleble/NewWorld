package Commands;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Miscelaneo.Miscelaneo;

public class MiscelaneoCommand implements CommandExecutor{
	@SuppressWarnings("unused")
	private Miscelaneo plugin;

	public MiscelaneoCommand(Miscelaneo plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {

		Player player = (Player) sender;
		Random r = new Random();
		int random = 0;
		
		if(command.getName().equalsIgnoreCase("dado")){
			if (!(sender instanceof Player)) {
				sender.sendMessage("este comando solo puede ser usado por un usuario.");
			}else if(args.length==0){
	    		random = r.nextInt(6);
	    		if(random==0){
	    			random=6;
	    		}
	        	player.chat(ChatColor.LIGHT_PURPLE+"/me lanza un dado al aire que cae en "+random);
			}
		}else if(command.getName().equalsIgnoreCase("moneda")){
			if (!(sender instanceof Player)) {
				sender.sendMessage("este comando solo puede ser usado por un usuario.");
			}else if(args.length==0){
	    		random = r.nextInt(2);
	    		if(random==0){
	    			player.chat(ChatColor.LIGHT_PURPLE+"/me lanza una moneda al aire que cae en cara");
	    		}else if(random==1){
	    			player.chat(ChatColor.LIGHT_PURPLE+"/me lanza una moneda al aire que cae en cruz");
	    		}
			}
		}
		return false;
	}
}
