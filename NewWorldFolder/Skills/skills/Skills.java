package skills;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import skills.mineria.MiningListener;
import skills.tala.TalaListener;
import core.Core;
import core.skills.SkillPlayer;
import core.skills.SkillPlayerManager;

public class Skills extends JavaPlugin {

	Logger log;
	SkillPlayerManager spm;

	@Override
	public void onEnable() {

		log = this.getLogger();

		PluginManager pm = this.getServer().getPluginManager();

		Core core = (Core) pm.getPlugin("NWCore");
		spm = core.getSkillPlayerManager();

		pm.registerEvents(new MiningListener(), this);
		pm.registerEvents(new TalaListener(spm, log), this);

	}

	@Override
	public void onDisable() {
		// TODO Insert logic to be performed when the plugin is disabled
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		SkillPlayer sp;
		PermissionUser user;
		PermissionManager pex;
		
		boolean flag = false;

		if (cmd.getName().equalsIgnoreCase("skills")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only be run by a player.");
			} else {

				if (args.length > 0 && args.length < 3) {
					
					sp = spm.getSkillPlayer(sender.getName());
					user = PermissionsEx.getUser(sender.getName());
					pex = PermissionsEx.getPermissionManager();

					if (args[0].equalsIgnoreCase("ver")	&& args.length == 1) {

						sender.sendMessage(ChatColor.RED
								+ "-----------------------------");
						sender.sendMessage(ChatColor.GOLD
								+ "::::: SACRA RP || HABILIDADES :::::");
						sender.sendMessage(ChatColor.RED
								+ "-----------------------------");
						sender.sendMessage(ChatColor.BLUE + "Tala: "
								+ spm.getSkillPlayer(sender.getName()).getTalaLvl());
						sender.sendMessage(ChatColor.BLUE + "Mineria: "
								+ sp.getMineriaLvl());
						sender.sendMessage(ChatColor.RED
								+ "-----------------------------");
						sender.sendMessage(ChatColor.AQUA + "Tu nivel total: "
								+ sp.getTotalLevel());
					} else {
						sender.sendMessage(ChatColor.RED
								+ "Escribe /skills ver");
					}

					if (args[0].equalsIgnoreCase("aprender") && args.length == 2) {

						for (int i = 0; i < pex.getGroups().length; i++) {

							if (pex.getGroups()[i].getName().equalsIgnoreCase(
									args[1]) == true) {

								if (!user.inGroup(args[1].toLowerCase())) {
									user.addGroup(args[1].toLowerCase());
									sender.sendMessage(ChatColor.RED
											+ "Decides aprender:  " + args[1]);
									return true;
								} 
							}
						} 
						sender.sendMessage(ChatColor.RED
								+ "Esa habilidad no existe o ya la estás aprendiendo.");
						return true;
							

					} else {
						sender.sendMessage(ChatColor.RED
								+ "Escribe /skills aprender <nombre de habilidad>");

						return true;
					}

				} else {
					sender.sendMessage(ChatColor.RED
							+ "No has puesto bien el comando: /skills <aprender/ver> <habilidad>");
					return true;
				}
			}
			return true;
		}
		return true;
	}

}
