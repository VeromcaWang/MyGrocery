package edu.osu.cse5234.model;
import edu.osu.cse5234.business.view.Item;

import java.util.List;

public class Order {
	
	private List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> list) {
		this.items = list;
	}

}
