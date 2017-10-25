package edu.osu.cse5234.business.view;

public class Item implements java.io.Serializable  {
	
	private String name;
	
	private String quantity;
	
	public Item()
	{
		
	}
	
	public Item(String name, String quantity)
	{
		this.name = name;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quntity) {
		this.quantity = quntity;
	}
	
	

}
