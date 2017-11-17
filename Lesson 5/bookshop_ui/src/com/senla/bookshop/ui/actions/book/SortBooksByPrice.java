package com.senla.bookshop.ui.actions.book;

import com.senla.bookshop.facade.BookShop;
import com.senla.bookshop.ui.actions.IAction;
import com.senla.bookshop.utils.Printer;

public class SortBooksByPrice implements IAction {

	@Override
	public void execute() {
		Printer.print("books sorted by price:");
		Printer.printArray(BookShop.getInstance().sortBooksByPrice());

	}

}
