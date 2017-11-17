package com.senla.bookshop.ui.actions.book;

import com.senla.bookshop.facade.BookShop;
import com.senla.bookshop.ui.actions.IAction;
import com.senla.bookshop.utils.Printer;

public class SortBooksByDate implements IAction{

	@Override
	public void execute() {
		Printer.print("books sorted by date of publication:");
		Printer.printArray(BookShop.getInstance().sortBooksByDate());
		
	}

}
