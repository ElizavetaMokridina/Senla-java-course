package com.senla.bookshop.ui.actions.order;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.senla.bookshop.facade.BookShop;
import com.senla.bookshop.storages.OrderStorage;
import com.senla.bookshop.ui.actions.IAction;
import com.senla.bookshop.utils.ListWorker;
import com.senla.bookshop.utils.Printer;

public class CancelOrder implements IAction {

	private Scanner scanner;
	private Logger logger = Logger.getLogger(CancelOrder.class);

	@Override
	public void execute() {
		scanner = new Scanner(System.in);
		Printer.printArray(OrderStorage.getOrders());
		Printer.print("enter index");
		Integer index = scanner.nextInt();
		try {
			BookShop.getInstance().cancelOrder(ListWorker.getIdByIndex(index, OrderStorage.getOrders()));
		} catch (IndexOutOfBoundsException e) {
			Printer.print("invalid input");
			logger.error("invalid input", e);
		}

	}

}
