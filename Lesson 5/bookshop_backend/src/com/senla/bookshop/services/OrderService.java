package com.senla.bookshop.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.senla.bookshop.comparators.orders.CompareOrdersByDate;
import com.senla.bookshop.comparators.orders.CompareOrdersByPrice;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.enums.BookStatus;
import com.senla.bookshop.enums.Status;
import com.senla.bookshop.storages.BookStorage;
import com.senla.bookshop.storages.OrderStorage;
import com.senla.bookshop.utils.ListWorker;

public class OrderService {
	private final OrderStorage orderStorage;

	public OrderService() throws ParseException {
		this.orderStorage = OrderStorage.getInstance();
	}

	public List <Order> sortOrders(Comparator<Order> comparator) {
		List <Order> orders  = OrderStorage.getOrders();
		orders.sort( comparator);
		return orders;
	}

	public List <Order> getDoneByDate(Date date1, Date date2) {
		List <Order> orders = sortOrders(new CompareOrdersByDate());
		List <Order> newOrders = new ArrayList<>();
		for (Order order : orders) {
			if (order.getStatus().equals(Status.DONE) && order.getExecutionDate().after(date1)
					&& order.getExecutionDate().before(date2)) {
				newOrders.add(order);
				
			}
		}
		return newOrders;
	}

	public List <Order> getDoneByPrice(Date date1, Date date2) {
		List <Order> orders = sortOrders(new CompareOrdersByPrice());
		List <Order> newOrders = new ArrayList<>();
		for (Order order : orders) {
			if (order.getStatus().equals(Status.DONE) && order.getExecutionDate().after(date1)
					&& order.getExecutionDate().before(date2)) {
				newOrders.add(order);
				
			}
		}
		return newOrders;
	}

	public Double getTotalPrice(Date date1, Date date2) {
		List <Order> orders = OrderStorage.getOrders();
		Double price = 0.0;
		for (Order order : orders) {
			if (order.getStatus().equals(Status.DONE) && order.getExecutionDate().after(date1)
					&& order.getExecutionDate().before(date2)) {
				price += order.getPrice();
			}
		}
		return price;
	}

	public Integer getNumberOfOrders(Date date1, Date date2) {
		List <Order> orders = OrderStorage.getOrders();
		Integer count = 0;
		for (Order order : orders) {
			if (order.getStatus().equals(Status.DONE) && order.getExecutionDate().after(date1)
					&& order.getExecutionDate().before(date2)) {
				count++;
			}
		}
		return count;
	}

	public Order getOrderById(Integer id) {
		List <Order> orders = OrderStorage.getOrders();
		int position = ListWorker.findById(id, orders);
		
			return orders.get(position);
	}

	public void cancelOrder(Integer id) {
		orderStorage.changeOrderStatus(Status.CANCELED, id);
			

	}

	public void addOrder(Order order) {
		orderStorage.addOrder(order);
	}
	
	public void completeOrder(Integer id) {
		orderStorage.changeOrderStatus(Status.DONE,id);
		Order order =(Order)ListWorker.getEntityById(id,OrderStorage.getOrders() );
		Book book=(Book)ListWorker.getEntityById(order.getBookId(),BookStorage.getBooks());
		book.setBookStatus(BookStatus.NOT_IN_STOCK);
	}

	public void writeToFile() {
		orderStorage.writeToFile();
	}

}
