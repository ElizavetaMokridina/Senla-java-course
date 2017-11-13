package com.senla.bookshop.ui.navigator;

import com.senla.bookshop.ui.menu.Menu;
import com.senla.bookshop.utils.Printer;
import com.senla.bookshop.ui.item.MenuItem;

public class Navigator {
	private Menu currentMenu;

	public Navigator(Menu currentMenu) {
		this.currentMenu=currentMenu;
	}
	public void printMenu() {
		for(MenuItem item : currentMenu.getItems()) {
			Printer.print(item.getTitle());
		}
	}

	public void navigate(Integer index) {
		currentMenu.getItems().get(index-1).doAction();
		printMenu();
	}
}
