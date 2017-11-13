package com.senla.bookshop.ui.item;

import com.senla.bookshop.ui.actions.IAction;
import com.senla.bookshop.ui.menu.Menu;

public class MenuItem {
	private String title;
	private IAction action;
	private Menu nextMenu;

	public MenuItem(String title, IAction action) {
		this.title = title;
		this.action = action;
	}

	public String getTitle() {
		return title;
	}

	public void doAction() {
		action.execute();
	}

}
