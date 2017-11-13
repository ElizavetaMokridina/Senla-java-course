package com.senla.bookshop.ui.menu;

import java.util.ArrayList;
import java.util.List;

import com.senla.bookshop.ui.item.MenuItem;

public class Menu {
	private String name;
	private List<MenuItem> items = new ArrayList<>();

	public Menu(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MenuItem> getItems() {
		return items;
	}

	public void setItems(List<MenuItem> items) {
		this.items = items;
	}
	
	public void addItem(MenuItem item) {
		items.add(item);
	}

}
