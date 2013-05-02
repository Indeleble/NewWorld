package listeners;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemPurityBuilder {

	ItemStack is;
	int prob;

	public ItemPurityBuilder() {

	}

	public ItemStack buildItem(ItemStack is, int probability) {
		
		this.is = is;
		this.prob = probability;
		
		if (!hasPurity(is)) {

			Random r = new Random();
			r.setSeed(r.nextLong());
			int v = r.nextInt(prob);
			if (v==0)v=1;

			ItemMeta im = is.getItemMeta();

			ArrayList<String> lore = new ArrayList<String>();

			lore.add("Calidad: " + v);

			im.setLore(lore);

			is.setItemMeta(im);
		}
		
		return is;
	}

	private boolean hasPurity(ItemStack is) {

		boolean result = false;

		if (is.getItemMeta().getLore() != null) {

			ArrayList<String> lore = (ArrayList<String>) is.getItemMeta()
					.getLore();

			for (int i = 0; i < lore.size(); i++) {

				if (lore.get(i).contains("Calidad")) {

					result = true;
					break;
				}
			}
		}
		return result;
	}

}
