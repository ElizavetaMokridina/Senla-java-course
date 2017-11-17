package com.senla.bookshop.ui.actions.order;

import java.text.ParseException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.senla.bookshop.entities.Order;
import com.senla.bookshop.enums.Status;
import com.senla.bookshop.facade.BookShop;
import com.senla.bookshop.ui.actions.IAction;
import com.senla.bookshop.utils.Convert;
import com.senla.bookshop.utils.Printer;

public class AddOrder 	implements IAction {
	private Scanner scanner;
	private Logger logger = Logger.getLogger(AddOrder.class);
	@Override
	public void execute() {
		scanner = new Scanner(System.in);
		Printer.print("enter execution date");
		String executionDate = scanner.nextLine();
		Printer.print("enter price");
		Double price = Double.parseDouble(scanner.nextLine());
		Printer.print("enter status");
		Status status = Convert.convertStatus(scanner.nextLine());
		Printer.print("enter bookId");
		Integer bookId = scanner.nextInt();
		try {
			BookShop.getInstance().addOrder(new Order(executionDate,price,status,bookId));
		} catch (ParseException e) {
			Printer.print("invalid input");
			logger.error("invalid input", e);
		}
	}

}
