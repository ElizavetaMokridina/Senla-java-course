package com.senla.bookshop.ui.actions;

import com.senla.bookshop.facade.BookShop;
import com.senla.bookshop.utils.Printer;

public class SortBooksByAuthor implements IAction {
	public void execute() {
		Printer.print("books sorted by author:");
		Printer.printArray(BookShop.getInstance().sortBooksByAuthor());
	}
}
