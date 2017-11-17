package com.senla.bookshop.ui.actions.order;

import com.senla.bookshop.facade.BookShop;
import com.senla.bookshop.ui.actions.IAction;
import com.senla.bookshop.utils.Printer;

public class SortOrdersByStatus implements IAction{

	@Override
	public void execute() {
		Printer.print("orders sorted by status:");
		Printer.printArray(BookShop.getInstance().sortOrdersByStatus());
		
	}

}
