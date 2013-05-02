package skills.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import core.skills.SkillPlayer;
import core.skills.SkillPlayerManager;

public class SkillCommandsBaseListener implements CommandExecutor {

	SkillPlayerManager spm;

	public SkillCommandsBaseListener(SkillPlayerManager spm) {
		this.spm = spm;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		
		SkillPlayer sp;
		PermissionUser user;
		PermissionManager pex;

		if (cmd.getName().equalsIgnoreCase("skills")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only be run by a player.");
			} else {

				if (args.length > 0 && args.length < 3) {

					sp = spm.getSkillPlayer(sender.getName());
					user = PermissionsEx.getUser(sender.getName());
					pex = PermissionsEx.getPermissionManager();

					if (args[0].equalsIgnoreCase("ver") && args.length == 1) {

						sender.sendMessage(ChatColor.RED
								+ "-----------------------------");
						sender.sendMessage(ChatColor.GOLD
								+ "::::: SACRA RP || HABILIDADES :::::");
						sender.sendMessage(ChatColor.RED
								+ "-----------------------------");
						sender.sendMessage(ChatColor.BLUE
								+ "Tala: "
								+ spm.getSkillPlayer(sender.getName())
										.getTalaLvl());
						sender.sendMessage(ChatColor.BLUE + "Mineria: "
								+ sp.getMineriaLvl());
						sender.sendMessage(ChatColor.RED
								+ "-----------------------------");
						sender.sendMessage(ChatColor.AQUA + "Tu nivel total: "
								+ sp.getTotalLevel());
					} else {
						if (args[0].equalsIgnoreCase("ver"))
							sender.sendMessage(ChatColor.RED
									+ "Escribe /skills ver");
					}

					if (args[0].equalsIgnoreCase("aprender")
							&& args.length == 2) {

						for (int i = 0; i < pex.getGroups().length; i++) {

							if (pex.getGroups()[i].getName().equalsIgnoreCase(
									args[1]) == true) {

								if (!user.inGroup(args[1].toLowerCase())) {
									user.addGroup(args[1].toLowerCase());
									sender.sendMessage(ChatColor.RED
											+ "Decides aprender:  " + args[1]
											+ " y empieza a nivel 10");
									sp.addTotalLevel(10);
									sp.setTalaLvl(10);
									return true;
								}
							}
						}
						sender.sendMessage(ChatColor.RED
								+ "Esa habilidad no existe o ya la estás aprendiendo.");
						return true;

					} else {
						if (args[0].equalsIgnoreCase("aprender"))
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