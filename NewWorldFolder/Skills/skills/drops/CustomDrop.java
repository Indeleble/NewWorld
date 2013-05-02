package skills.drops;

import org.bukkit.inventory.ItemStack;


public class CustomDrop {

	ItemStack itemStack;
	int maxLevel;
	int amount;

	public CustomDrop(ItemStack itemStack, int maxLevel, int amount) {

		this.itemStack = itemStack;
		this.maxLevel = maxLevel;
		this.amount = amount;

	}

	public ItemStack getItemStack() {
		return itemStack;
	}

	public void setItemStack(ItemStack itemStack) {
		this.itemStack = itemStack;
	}

	public int getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}





}
