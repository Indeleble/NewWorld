package skills.drops;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemPurityBuilder {

	ItemStack is;
	int prob;
	ArrayList<CustomDrop> drops;

	public ItemPurityBuilder() {

		this.drops = new ArrayList<CustomDrop>();

	}

	public void addDrop(CustomDrop drop) {
		this.drops.add(drop);
	}

	public ArrayList<ItemStack> getDrops() {
		
		//Array de drops que devolvera
		ArrayList<ItemStack> finalDrops = new ArrayList<ItemStack>();
		
		//Cantidad de posibles drops. Cada drop puede tener su propia cantidad final
		int total = this.drops.size();
		
		Random r = new Random();
		
		// P es la posicion del tipo de drop que se dropeara
		int p = r.nextInt(total);
		
		r.setSeed(r.nextLong());
		
		for (int i = 0; i < drops.get(p).getAmount(); i++) {
			
			// 50% de posibilidades de añadir el drop
			if (r.nextInt(4) != 0){
			
			// Añadimos a la lista de drops final los drops con su purity basada en el nivel maximo
			// que pueden llegar a tener
			finalDrops.add(this.buildItem(drops.get(p).getItemStack(), drops
					.get(p).getMaxLevel()));
			}
		}

		return finalDrops;
	}

	private ItemStack buildItem(ItemStack is, int probability) {

		this.is = is;
		this.prob = probability;

		if (!hasPurity(is)) {

			Random r = new Random();
			r.setSeed(r.nextLong());
			int v = r.nextInt(prob + 1);
			if (v == 0)
				v = 1;

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
