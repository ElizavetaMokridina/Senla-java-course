package com.senla.bookshop.ui.navigator;

import com.senla.bookshop.ui.menu.Menu;
import com.senla.bookshop.utils.Printer;
import com.senla.bookshop.ui.item.MenuItem;

public class Navigator {
	private Menu currentMenu;

	public Navigator(Menu currentMenu) {
		this.currentMenu = currentMenu;
	}

	public void printMenu() {
		Printer.print("_______________________________________________________");
		Printer.print(currentMenu.getName());
		for (MenuItem item : currentMenu.getItems()) {
			Printer.print(item.getTitle());
		}
		Printer.print("_______________________________________________________");
	}

	public void navigate(Integer index) {
		try {
			MenuItem item = currentMenu.getItems().get(index - 1);
			if (item.getAction() != null) {
				item.doAction();
			}
			currentMenu = item.getNextMenu();
		} catch (IndexOutOfBoundsException e) {
			Printer.print("invalid input");

		}

	}
}
