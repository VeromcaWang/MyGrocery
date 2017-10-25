package edu.osu.cse5234.business;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
@Remote(InventoryService.class)
@LocalBean
public class InventoryServiceBean implements InventoryService {

    /**
     * Default constructor. 
     */
    public InventoryServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Inventory getAvailableInventory() {
		// TODO Auto-generated method stub
		Inventory inventory = new Inventory();
		List<Item> items = new ArrayList<>(); 
		for (int i = 0; i < 5; i++)
		{
			items.add(new Item("Item " + (i + 1), String.valueOf(3)));
		}
		inventory.setItems(items);
		
		return inventory;
	}

	@Override
	public boolean validateQuantity(Collection<Item> items) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateInventory(Collection<Item> items) {
		// TODO Auto-generated method stub
		return true;
	}

	
}
