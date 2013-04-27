package core;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.PersistenceException;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

	Logger log;
	List<IndePlayer> IndePlayerList;

	List<MulaPlayer> MulaPlayerList;

	@Override
	public void onEnable() {

		log = this.getLogger();

		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new PlayerListener(this), this);

		setupDatabase();

	}

	@Override
	public void onDisable() {
		// TODO Insert logic to be performed when the plugin is disabled
	}

	public List<IndePlayer> getIndePlayerList() {
		return IndePlayerList;
	}

	public void setIndePlayerList(List<IndePlayer> indePlayerList) {
		IndePlayerList = indePlayerList;
	}

	public void addIndePlayer(IndePlayer indePlayer) {
		IndePlayerList.add(indePlayer);
	}

	public void removeIndePlayer(IndePlayer indePlayer) {

		for (int i = 0; i < IndePlayerList.size(); i++) {

			if (IndePlayerList.get(i).getId() == indePlayer.getId()) {

				IndePlayerList.remove(i);
				break;
			}
		}

	}

	public List<MulaPlayer> getMulaPlayerList() {
		return MulaPlayerList;
	}

	public void setMulaPlayerList(List<MulaPlayer> mulaPlayerList) {
		MulaPlayerList = mulaPlayerList;
	}

	private void setupDatabase() {
		try {
			getDatabase().find(IndePlayer.class).findRowCount();
		} catch (PersistenceException ex) {
			System.out.println("Installing database for "
					+ getDescription().getName() + " due to first time usage");
			installDDL();
		}
	}

	@Override
	public List<Class<?>> getDatabaseClasses() {

		List<Class<?>> classes = new LinkedList<Class<?>>();
		classes.add(IndePlayer.class);
		classes.add(MulaPlayer.class);

		return classes;
	}
}
