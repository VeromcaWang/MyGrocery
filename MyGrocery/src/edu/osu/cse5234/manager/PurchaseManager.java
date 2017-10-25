package edu.osu.cse5234.manager;

import java.util.ArrayList;
import java.util.List;

import edu.osu.cse5234.business.InventoryServiceBean;
import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;

import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.business.view.Item;
public class PurchaseManager {
	
	public Order createOrder()
	{
		Order order = new Order();
		
		List<Item> items = new ArrayList<>(); 
		for (int i = 0; i < 5; i++)
		{
			items.add(new Item("Item " + (i + 1), String.valueOf(3)));
		}
		order.setItems(items);
		return order;
	}
	
	public Item createItem(String name, String quantity)
	{
		return new Item(name, quantity);
	}

}
