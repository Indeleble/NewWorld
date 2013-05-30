package husbandry;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import core.husbrandy.HusAnimalManager;
import core.skills.SkillPlayer;

public class WolfCommands implements CommandExecutor {

	Logger				log;
	HusAnimalManager	hum;
	Player				player;
	SkillPlayer			sp;
	PermissionUser		user;

	public WolfCommands(HusAnimalManager hum) {
		this.hum = hum;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("lobos")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only be run by a player.");
				return true;

			} else {

				player = (Player) sender;

				if (args.length == 0) {

					user = PermissionsEx.getUser(player);

					if (user.inGroup("ganaderia")) {
						// Comprobamos si tiene lobos
						if (hum.getWolfs(player.getName()) != null) {

							if (checkCommand(args[0]) != null) {

								makeAction(args[0]);
								return true;

							} else {

								player.sendMessage("Comando mal escrito");
								return true;
							}

							// Si no tiene lobos
						} else {
							player.sendMessage("No tienes lobos adiestrados");
							return true;
						}

						// Si no es ganadero o tameador
					} else {
						player.sendMessage("No sabes adiestrar lobos");
						return true;
					}

				} else {
					player.sendMessage("Pocos o demasiados parametros");
					return true;
				}
			}

		}

		return true;
	}

	private String checkCommand(String string) {

		for (WolfCall s : WolfCall.values()) {

			if (string.equalsIgnoreCase(s.toString()))
				return string;

		}
		return null;

	}

	private void makeAction(String string) {
		
		string = string.toLowerCase();
		
		switch (string){
			
			case "llamar":
			break;
			
			case "esperar":
			break;
			
			case "ganado":
			break;
		}

	}
}
