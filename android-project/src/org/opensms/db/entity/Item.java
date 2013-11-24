package org.opensms.db.entity;

public class Item {

	private String itemId;
	private String name;
	private Profit defaultProfit;
	private Unit unit;
	private Category category;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Profit getDefaultProfit() {
		return defaultProfit;
	}

	public void setDefaultProfit(Profit defaultProfit) {
		this.defaultProfit = defaultProfit;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
