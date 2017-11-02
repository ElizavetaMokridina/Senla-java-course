package com.senla.bookshop.facade;

import java.text.ParseException;
import java.util.Date;

import com.senla.bookshop.comparators.books.*;
import com.senla.bookshop.comparators.orders.*;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.enums.Availability;
import com.senla.bookshop.enums.Status;
import com.senla.bookshop.services.ServiceOfBooks;
import com.senla.bookshop.services.ServiceOfOrders;
import com.senla.bookshop.utils.Printer;

public class BookShop {
	private ServiceOfBooks serviceOfBooks;
	private ServiceOfOrders serviceOfOrders;

	public BookShop() throws ParseException {
		this.serviceOfBooks = new ServiceOfBooks();
		this.serviceOfOrders = new ServiceOfOrders();
	}

	public void sortBooksByAuthor() {
		Printer.print("books sorted by author:");
		Printer.printArray(serviceOfBooks.sortBooks(new CompareBooksByAuthor()));
	}

	public void sortBooksByName() {
		Printer.print("books sorted by name:");
		Printer.printArray(serviceOfBooks.sortBooks(new CompareBooksByName()));
	}

	public void sortBooksByDateOfPublication() {
		Printer.print("books sorted by date of publication:");
		Printer.printArray(serviceOfBooks.sortBooks(new CompareBooksByDateOfPublication()));
	}

	public void sortBooksByPrice() {
		Printer.print("books sorted by price:");
		Printer.printArray(serviceOfBooks.sortBooks(new CompareBooksByPrice()));
	}

	public void sortBooksByAvailabiliry() {
		Printer.print("books sorted by availability:");
		Printer.printArray(serviceOfBooks.sortBooks(new CompareBooksByAvailability()));
	}

	public void sortOrdersByExecutionDate() {
		Printer.print("orders sorted by execution date:");
		Printer.printArray(serviceOfOrders.sortOrders(new CompareOrdersByExecutionDate()));
	}

	public void sortOrdersByPrice() {
		Printer.print("orders sorted by price:");
		Printer.printArray(serviceOfOrders.sortOrders(new CompareOrdersByPrice()));
	}

	public void sortOrdersByStatus() {
		Printer.print("orders sorted by status:");
		Printer.printArray(serviceOfOrders.sortOrders(new CompareOrdersByStatus()));
	}

	public void getDoneByDate(Date date1, Date date2) {
		Printer.print("done orders by date: ");
		Printer.printArray(serviceOfOrders.getDoneByDate(date1, date2));
	}

	public void getDoneByPrice(Date date1, Date date2) {
		Printer.print("done orders by price: ");
		Printer.printArray(serviceOfOrders.getDoneByPrice(date1, date2));
	}

	public void getTotalPrice(Date date1, Date date2) {
		Printer.print("total price: ");
		Printer.print(serviceOfOrders.getTotalPrice(date1, date2).toString());
	}

	public void getNumberOfOrder(Date date1, Date date2) {
		Printer.print("number of orders: ");
		Printer.print(serviceOfOrders.getNumberOfOrders(date1, date2).toString());
	}

	public void getOrderDetails(Integer id) {
		Printer.print("order details:");
		Printer.print(serviceOfOrders.getOrderDetails(id));
	}

	public void getBookDetails(Integer id) {
		Printer.print("book details:");
		Printer.print(serviceOfBooks.getBookDetails(id));
	}

	public void changeBooksStatus(Availability availability, Integer id) {
		serviceOfBooks.changeBooksStatus(availability, id);
	}

	public void changeOrdersStatus(Status status, Integer id) {
		serviceOfOrders.changeOrdersStatus(status, id);
	}

	public void addBook(Book book) {
		serviceOfBooks.addBook(book);
	}

	public void addOrder(Order order) {
		serviceOfOrders.addOrder(order);
	}

	public void writeToFileBooks() {
		serviceOfBooks.writeToFile();
	}

}
