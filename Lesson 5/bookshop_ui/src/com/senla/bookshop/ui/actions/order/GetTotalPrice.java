package com.senla.bookshop.ui.actions.order;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.senla.bookshop.facade.BookShop;
import com.senla.bookshop.ui.actions.IAction;
import com.senla.bookshop.utils.Printer;
import com.senla.bookshop.utils.Sdf;

public class GetTotalPrice implements IAction{

	private Scanner scanner;
	private Logger logger = Logger.getLogger(GetTotalPrice.class);
	@Override
	public void execute() {
		scanner = new Scanner(System.in);
		try {
			Printer.print("enter date1 ");
			Date date1 = Sdf.parse(scanner.nextLine());
			Printer.print("enter date2 ");
			Date date2 = Sdf.parse(scanner.nextLine());
			Printer.print("total price: ");
			Printer.print(BookShop.getInstance().getTotalPrice(date1, date2));
		} catch (ParseException e) {
			Printer.print("invalid input");
			logger.error("invalid input", e);
		}

		
	}

}
