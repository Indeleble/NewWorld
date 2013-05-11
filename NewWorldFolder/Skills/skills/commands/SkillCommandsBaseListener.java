package skills.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import core.skills.Skill;
import core.skills.SkillPlayer;
import core.skills.SkillPlayerManager;
import core.skills.SkillType;

public class SkillCommandsBaseListener implements CommandExecutor {

	SkillPlayerManager	spm;

	public SkillCommandsBaseListener(SkillPlayerManager spm) {
		this.spm = spm;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

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

						sender.sendMessage(ChatColor.RED + "-----------------------------");
						sender.sendMessage(ChatColor.GOLD + "::::: SACRA RP || HABILIDADES :::::");
						sender.sendMessage(ChatColor.RED + "-----------------------------");

						for (Skill skill : spm.getSkillPlayer(sender.getName()).getSkills().values()) {
							sender.sendMessage(ChatColor.BLUE + skill.getName() + skill.getLevel() + "/" + skill.getMaxLevel());
						}
						sender.sendMessage(ChatColor.RED + "-----------------------------");
						sender.sendMessage(ChatColor.AQUA + "Tu nivel total: " + sp.getTotalLevel() + "/125");
					} else {
						if (args[0].equalsIgnoreCase("ver"))
							sender.sendMessage(ChatColor.RED + "Escribe /skills ver");
					}

					if (args[0].equalsIgnoreCase("aprender") && args.length == 2) {

						String skill = args[1];
						if (skill.contains("_")) {

							skill = skill.split("_", 2)[0];
						}

						for (int i = 0; i < pex.getGroups().length; i++) {

							if (pex.getGroups()[i].getName().equalsIgnoreCase(skill) == true) {

								if (!user.inGroup(skill)) {

									for (SkillType st : SkillType.values()) {

										if (sp.getSkills().containsKey(st)) {
											sender.sendMessage(ChatColor.RED + "Ya conoces esa habilidad");
										} else {
											if (st.toString().equalsIgnoreCase(skill)) {

												user.addGroup(skill);

												sp.getSkill(st).setMaxLevel(st.getLevel());
												sp.getSkill(st).setLevel(st.getLevel() / 10);
												sp.getSkill(st).setName(st.toString());

												sender.sendMessage(ChatColor.LIGHT_PURPLE + "Decides aprender:  " + skill + " y empieza a nivel " + st.getLevel() / 10);
												return true;
											}
										}
									}
								}
							}
						}
						sender.sendMessage(ChatColor.RED + "Esa habilidad no existe o ya la est�s aprendiendo.");
						return true;

					} else {
						if (args[0].equalsIgnoreCase("aprender"))
							sender.sendMessage(ChatColor.RED + "Escribe /skills aprender <nombre de habilidad>");

						return true;
					}

				} else {
					sender.sendMessage(ChatColor.RED + "No has puesto bien el comando: /skills <aprender>/<ver> <habilidad>");
					return true;
				}
			}
			return true;
		}
		return true;
	}
}