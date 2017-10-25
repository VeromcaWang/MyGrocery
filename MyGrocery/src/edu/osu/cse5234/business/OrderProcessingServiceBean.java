package edu.osu.cse5234.business;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.business.view.OrderProcessingServiceBeanRemote;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;

import java.awt.List;
import java.util.Collection;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@Remote(OrderProcessingServiceBeanRemote.class)
@LocalBean
public class OrderProcessingServiceBean implements OrderProcessingServiceBeanRemote {

    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public boolean validateItemAvailability(Order order) 
    {
//    		InventoryService inventoryService = ServiceLocator.getInventoryService();
//    	 	return inventoryService.validateQuantity((Collection)order.getItems());
    	return true;
    }
    
   
    public String processOrder(Order order) 
    {
    		return "12345";
    }

}
