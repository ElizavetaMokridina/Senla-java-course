package com.senla.bookshop.facade;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.senla.bookshop.comparators.books.CompareBooksByAuthor;
import com.senla.bookshop.comparators.books.CompareBooksByDate;
import com.senla.bookshop.comparators.books.CompareBooksByName;
import com.senla.bookshop.comparators.books.CompareBooksByPrice;
import com.senla.bookshop.comparators.books.CompareBooksByStatus;
import com.senla.bookshop.comparators.orders.CompareOrdersByDate;
import com.senla.bookshop.comparators.orders.CompareOrdersByPrice;
import com.senla.bookshop.comparators.orders.CompareOrdersByStatus;
import com.senla.bookshop.comparators.requesthistory.CompareRequestsByAlphabet;
import com.senla.bookshop.comparators.requesthistory.CompareRequestsByNumber;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.entities.RequestHistory;
import com.senla.bookshop.services.BookService;
import com.senla.bookshop.services.OrderService;
import com.senla.bookshop.services.RequestHistoryService;
import com.senla.bookshop.services.RequestService;
import com.senla.bookshop.utils.Printer;
import org.apache.log4j.Logger;

public class BookShop {
	private static BookShop bookShop;
	private BookService bookService;
	private OrderService orderService;
	private RequestService requestService;
	private RequestHistoryService requestHistoryService;
	private Logger logger = Logger.getLogger(BookShop.class);

	private BookShop() {
		try {
			this.bookService = new BookService();
			this.orderService = new OrderService();
			this.requestService = new RequestService();
			this.requestHistoryService = new RequestHistoryService();
		} catch (ParseException e) {
			Printer.print("invalid input");
			logger.error("invalid input", e);
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

	public List<Book> sortBooksByName() {
		return bookService.sortBooks(new CompareBooksByName());
	}

	public List<Book> sortBooksByDate() {
		return bookService.sortBooks(new CompareBooksByDate());
	}

	public List<Book> sortBooksByPrice() {

		return bookService.sortBooks(new CompareBooksByPrice());
	}

	public List<Book> sortBooksByStatus() {
		return bookService.sortBooks(new CompareBooksByStatus());
	}

	public List<Order> sortOrdersByDate() {

		return orderService.sortOrders(new CompareOrdersByDate());
	}

	public List<Order> sortOrdersByPrice() {

		return orderService.sortOrders(new CompareOrdersByPrice());
	}

	public List<Order> sortOrdersByStatus() {
		return orderService.sortOrders(new CompareOrdersByStatus());
	}

	public List<RequestHistory> sortRequestsByNumber() {

		return requestHistoryService.sortRequests(new CompareRequestsByNumber());
	}

	public List<RequestHistory> sortRequestsByAlphabet() {
		return requestHistoryService.sortRequests(new CompareRequestsByAlphabet());
	}

	public List<Order> getDoneByDate(Date date1, Date date2) {
		return orderService.getDoneByDate(date1, date2);
	}

	public List<Order> getDoneByPrice(Date date1, Date date2) {
		return orderService.getDoneByPrice(date1, date2);
	}

	public String getTotalPrice(Date date1, Date date2) {
		return orderService.getTotalPrice(date1, date2).toString();
	}

	public String getNumberOfOrder(Date date1, Date date2) {

		return orderService.getNumberOfOrders(date1, date2).toString();
	}

	public String getOrderById(Integer id) {

		return orderService.getOrderById(id).toString();
	}

	public String getBookById(Integer id) {

		return bookService.getBookById(id).toString();
	}

	public void writeOffBook(Integer id) {
		bookService.WriteOffBook(id);

	}

	public void cancelOrder(Integer id) {
		orderService.cancelOrder(id);

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
