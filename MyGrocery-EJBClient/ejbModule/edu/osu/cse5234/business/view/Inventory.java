package edu.osu.cse5234.business.view;

import java.util.List;

public class Inventory implements java.io.Serializable {
	private List<Item> list;

	public List<Item> getList() {
		return list;
	}

	public void setList(List<Item> list) {
		this.list = list;
	}

	public void setItems(List<Item> items) {
		// TODO Auto-generated method stub
		
	}
	
}
