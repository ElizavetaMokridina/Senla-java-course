package com.senla.bookshop.ui.actions.request;

import com.senla.bookshop.facade.BookShop;
import com.senla.bookshop.ui.actions.IAction;
import com.senla.bookshop.utils.Printer;

public class SortRequestsByNumber implements IAction{

	@Override
	public void execute() {
		Printer.print("requests sorted by number:");
		Printer.printArrayRequests(BookShop.getInstance().sortRequestsByNumber());
		
	}

}
