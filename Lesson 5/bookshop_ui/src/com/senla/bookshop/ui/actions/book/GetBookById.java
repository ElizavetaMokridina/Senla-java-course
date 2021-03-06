package com.senla.bookshop.ui.actions.book;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.senla.bookshop.facade.BookShop;
import com.senla.bookshop.storages.BookStorage;
import com.senla.bookshop.ui.actions.IAction;
import com.senla.bookshop.utils.ListWorker;
import com.senla.bookshop.utils.Printer;

public class GetBookById implements IAction {

	private Scanner scanner;
	private Logger logger = Logger.getLogger(GetBookById.class);

	@Override
	public void execute() {
		scanner = new Scanner(System.in);
		Printer.printArray(BookStorage.getBooks());
		Printer.print("enter index");
		Integer index = scanner.nextInt();
		try {
			Printer.print("book details: "+BookShop.getInstance().getBookById(ListWorker.getIdByIndex(index, BookStorage.getBooks())));
		} catch (IndexOutOfBoundsException e) {
			Printer.print("invalid input");
			logger.error("invalid input", e);
		}
	}

}
