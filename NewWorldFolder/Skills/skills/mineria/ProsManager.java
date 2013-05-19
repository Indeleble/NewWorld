package skills.mineria;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ProsManager implements CommandExecutor {

	ArrayList<String>	Prospectors;

	public ProsManager() {

		this.Prospectors = new ArrayList<String>();
	}

	public boolean isProspecting(String name) {

		for (String n : Prospectors) {

			if (n.equalsIgnoreCase(name))
				return true;
		}

		return false;

	}

	public void removeProspecter(String name) {

		for (int i = 0; i < Prospectors.size(); i++) {

			if (Prospectors.get(i).equalsIgnoreCase(name)) {
				Prospectors.remove(i);
				break;
			}
		}
	}

	public void addProspecter(String name) {
		
		if (!isProspecting(name)){
			
			Prospectors.add(name);
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("prospectar")) {

			String name = sender.getName();
			PermissionUser user = PermissionsEx.getUser(name);
			if (user.inGroup("mineria")) {
				if (isProspecting(name)) {
					removeProspecter(name);
					sender.sendMessage("Dejas de prospectar");
				} else{
					addProspecter(name);
					sender.sendMessage("Decides prospectar");
					
				}return true;

			} else {
				sender.sendMessage("No eres minero");
				
			}
		}
		return false;
	}
}
