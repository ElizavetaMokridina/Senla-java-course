package com.senla.bookshop.ui.builder;

import com.senla.bookshop.ui.menu.Menu;
import com.senla.bookshop.ui.actions.*;
import com.senla.bookshop.ui.item.MenuItem;

public class Builder {
	private Menu rootMenu = new Menu("Menu");

	public void buildMenu() {
		rootMenu.addItem(new MenuItem("1-Sort books by author",new SortBooksByAuthor()));
		
	}

	public Menu getRootMenu() {
		return rootMenu;
	}

}
