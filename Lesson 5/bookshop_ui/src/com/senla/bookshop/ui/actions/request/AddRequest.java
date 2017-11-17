package com.senla.bookshop.ui.actions.request;

import java.util.Scanner;

import com.senla.bookshop.entities.Request;
import com.senla.bookshop.enums.Status;
import com.senla.bookshop.facade.BookShop;
import com.senla.bookshop.ui.actions.IAction;
import com.senla.bookshop.utils.Convert;
import com.senla.bookshop.utils.Printer;

public class AddRequest implements IAction{
	private Scanner scanner;
	@Override
	public void execute() {
		scanner = new Scanner(System.in);
		Printer.print("enter book id");
		Integer bookId = scanner.nextInt();
		Printer.print("enter status");
		Status status = Convert.convertStatus(scanner.nextLine());
		BookShop.getInstance().addRequest(new Request(bookId,status));
		
	}
	
}
