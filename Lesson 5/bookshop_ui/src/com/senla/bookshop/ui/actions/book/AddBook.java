package com.senla.bookshop.ui.actions.book;

import java.text.ParseException;
import java.util.Scanner;

import com.senla.bookshop.entities.Book;
import com.senla.bookshop.enums.BookStatus;
import com.senla.bookshop.facade.BookShop;
import com.senla.bookshop.ui.actions.IAction;
import com.senla.bookshop.utils.Convert;
import com.senla.bookshop.utils.Printer;
import org.apache.log4j.Logger;

public class AddBook implements IAction {

	private Scanner scanner;
	private Logger logger = Logger.getLogger(AddBook.class);

	@Override
	public void execute() {
		scanner = new Scanner(System.in);

		Printer.print("enter author");
		String author = scanner.nextLine();
		Printer.print("enter name");
		String name = scanner.nextLine();
		Printer.print("enter date of publication");
		String dateOfPublication = scanner.nextLine();
		Printer.print("enter price");
		Double price = Double.parseDouble(scanner.nextLine());
		Printer.print("enter status");
		BookStatus status = Convert.convertBookStatus(scanner.nextLine());
		Printer.print("enter date of receipt");
		String dateOfReceipt = scanner.nextLine();

		try {
			BookShop.getInstance().addBook(new Book(author, name, dateOfPublication, price, status, dateOfReceipt));
		} catch (ParseException e) {
			Printer.print("invalid input");
			logger.error("invalid input", e);
		}
	}

}
