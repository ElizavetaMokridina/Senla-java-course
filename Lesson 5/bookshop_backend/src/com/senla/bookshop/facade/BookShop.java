package com.senla.bookshop.facade;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.senla.bookshop.comparators.books.CompareBooksByAuthor;
import com.senla.bookshop.comparators.books.CompareBooksByDateOfPublication;
import com.senla.bookshop.comparators.books.CompareBooksByName;
import com.senla.bookshop.comparators.books.CompareBooksByPrice;
import com.senla.bookshop.comparators.books.CompareBooksByStatus;
import com.senla.bookshop.comparators.orders.CompareOrdersByExecutionDate;
import com.senla.bookshop.comparators.orders.CompareOrdersByPrice;
import com.senla.bookshop.comparators.orders.CompareOrdersByStatus;
import com.senla.bookshop.comparators.requesthistory.CompareRequestsByAlphabet;
import com.senla.bookshop.comparators.requesthistory.CompareRequestsByNumber;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.enums.BookStatus;
import com.senla.bookshop.enums.Status;
import com.senla.bookshop.services.BookService;
import com.senla.bookshop.services.OrderService;
import com.senla.bookshop.services.RequestHistoryService;
import com.senla.bookshop.services.RequestService;
import com.senla.bookshop.utils.Printer;

public class BookShop {
	private static BookShop bookShop;
	private BookService bookService;
	private OrderService orderService;
	private RequestService requestService;
	private RequestHistoryService requestHistoryService;

	private BookShop() {
		try {
			this.bookService = new BookService();
			this.orderService = new OrderService();
			this.requestService = new RequestService();
			this.requestHistoryService = new RequestHistoryService();
		} catch (ParseException e) {
			Printer.print("error");
		}
	}

	public static BookShop getInstance() {
		if (bookShop == null) {
			bookShop = new BookShop();
		}
		return bookShop;
	}

	public List<Book> sortBooksByAuthor() {
		
		return bookService.sortBooks(new CompareBooksByAuthor());
	}

	public void sortBooksByName() {
		Printer.print("books sorted by name:");
		Printer.printArray(bookService.sortBooks(new CompareBooksByName()));
	}

	public void sortBooksByDateOfPublication() {
		Printer.print("books sorted by date of publication:");
		Printer.printArray(bookService.sortBooks(new CompareBooksByDateOfPublication()));
	}

	public void sortBooksByPrice() {
		Printer.print("books sorted by price:");
		Printer.printArray(bookService.sortBooks(new CompareBooksByPrice()));
	}

	public void sortBooksByAvailabiliry() {
		Printer.print("books sorted by availability:");
		Printer.printArray(bookService.sortBooks(new CompareBooksByStatus()));
	}

	public void sortOrdersByExecutionDate() {
		Printer.print("orders sorted by execution date:");
		Printer.printArray(orderService.sortOrders(new CompareOrdersByExecutionDate()));
	}

	public void sortOrdersByPrice() {
		Printer.print("orders sorted by price:");
		Printer.printArray(orderService.sortOrders(new CompareOrdersByPrice()));
	}

	public void sortOrdersByStatus() {
		Printer.print("orders sorted by status:");
		Printer.printArray(orderService.sortOrders(new CompareOrdersByStatus()));
	}

	public void sortRequestsByNumber() {
		Printer.print("requests sorted by number:");
		Printer.printArrayRequests(requestHistoryService.sortRequests(new CompareRequestsByNumber()));
	}

	public void sortRequestsByAlphabet() {
		Printer.print("requests sorted by alphabet:");
		Printer.printArrayRequests(requestHistoryService.sortRequests(new CompareRequestsByAlphabet()));
	}

	public void getDoneByDate(Date date1, Date date2) {
		Printer.print("done orders by date: ");
		Printer.printArray(orderService.getDoneByDate(date1, date2));
	}

	public void getDoneByPrice(Date date1, Date date2) {
		Printer.print("done orders by price: ");
		Printer.printArray(orderService.getDoneByPrice(date1, date2));
	}

	public void getTotalPrice(Date date1, Date date2) {
		Printer.print("total price: ");
		Printer.print(orderService.getTotalPrice(date1, date2).toString());
	}

	public void getNumberOfOrder(Date date1, Date date2) {
		Printer.print("number of orders: ");
		Printer.print(orderService.getNumberOfOrders(date1, date2).toString());
	}

	public void getOrderById(Integer id) {
		if (orderService.getOrderById(id) != null) {
			Printer.print("order details:");
			Printer.print(orderService.getOrderById(id).toString());
		} else {
			Printer.print("order not found");
		}
	}

	public void getBookById(Integer id) {
		if (bookService.getBookById(id) != null) {
			Printer.print("book details:");
			Printer.print(bookService.getBookById(id).toString());
		} else {
			Printer.print("book not found");
		}
	}

	public void changeBookStatus(BookStatus status, Integer id) {
		if (bookService.changeBookStatus(status, id) == false) {
			Printer.print("book not found");
		}
	}

	public void changeOrderStatus(Status status, Integer id) {
		if (orderService.changeOrderStatus(status, id) == false) {
			Printer.print("order nod found");
		}

	}

	public void completeOrder(Integer id) {
		orderService.completeOrder(id);
	}

	public void addBook(Book book) {
		bookService.addBook(book);
	}

	public void addOrder(Order order) {
		orderService.addOrder(order);
	}

	public void addRequest(Request request) {
		requestService.addRequest(request);
	}

	public void writeToFile() {
		bookService.writeToFile();
		requestService.writeToFile();
		orderService.writeToFile();
	}

}
