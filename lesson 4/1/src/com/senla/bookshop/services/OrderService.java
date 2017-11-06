package com.senla.bookshop.services;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

import com.senla.bookshop.enums.Availability;
import com.senla.bookshop.enums.Status;
import com.senla.bookshop.storages.BookStorage;
import com.senla.bookshop.storages.OrderStorage;
import com.senla.bookshop.comparators.orders.CompareOrdersByExecutionDate;
import com.senla.bookshop.comparators.orders.CompareOrdersByPrice;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.utils.ArrayWorker;
import com.senla.bookshop.utils.Printer;

public class OrderService {
	private final OrderStorage orderStorage;

	public OrderService() throws ParseException {
		this.orderStorage = new OrderStorage();
	}

	public Order[] sortOrders(Comparator comparator) {
		Order[] orders = orderStorage.getOrders();
		Arrays.sort(orders, comparator);
		return orders;
	}

	public Order[] getDoneByDate(Date date1, Date date2) {
		Order[] orders = sortOrders(new CompareOrdersByExecutionDate());
		Order[] newOrders = new Order[ArrayWorker.getLength(orders)];
		int j = 0;
		for (int i = 0; i < ArrayWorker.getLength(orders); i++) {
			if (orders[i].getStatus().equals(Status.DONE) && orders[i].getExecutionDate().after(date1)
					&& orders[i].getExecutionDate().before(date2)) {
				newOrders[j] = orders[i];
				j++;
			}
		}
		return newOrders;
	}

	public Order[] getDoneByPrice(Date date1, Date date2) {
		Order[] orders = sortOrders(new CompareOrdersByPrice());
		Order[] newOrders = new Order[ArrayWorker.getLength(orders)];
		int j = 0;
		for (int i = 0; i < ArrayWorker.getLength(orders); i++) {
			if (orders[i].getStatus().equals(Status.DONE) && orders[i].getExecutionDate().after(date1)
					&& orders[i].getExecutionDate().before(date2)) {
				newOrders[j] = orders[i];
				j++;
			}
		}
		return newOrders;
	}

	public Double getTotalPrice(Date date1, Date date2) {
		Order[] orders = orderStorage.getOrders();
		Double price = 0.0;
		for (int i = 0; i < ArrayWorker.getLength(orders); i++) {
			if (orders[i].getStatus().equals(Status.DONE) && orders[i].getExecutionDate().after(date1)
					&& orders[i].getExecutionDate().before(date2)) {
				price += orders[i].getPrice();
			}
		}
		return price;
	}

	public Integer getNumberOfOrders(Date date1, Date date2) {
		Order[] orders = orderStorage.getOrders();
		Integer count = 0;
		for (int i = 0; i < ArrayWorker.getLength(orders); i++) {
			if (orders[i].getStatus().equals(Status.DONE) && orders[i].getExecutionDate().after(date1)
					&& orders[i].getExecutionDate().before(date2)) {
				count++;
			}
		}
		return count;
	}

	public String getOrderDetails(Integer id) {
		Order[] orders = orderStorage.getOrders();
		int position = ArrayWorker.findById(id, orders);
		if (position != -1) {
			return orders[position].toString();
		} else {
			return null;
		}
	}

	public boolean changeOrderStatus(Status status, Integer id) {
		if (orderStorage.changeOrderStatus(status, id) == false) {
			return false;
		} else
			return true;

	}

	public void addOrder(Order order) {
		orderStorage.addOrder(order);
	}
	
	public void completeOrder(Integer id) {
		changeOrderStatus(Status.DONE,id);
		Order order =(Order)ArrayWorker.getEntityById(id,orderStorage.getOrders() );
		Book book=(Book)ArrayWorker.getEntityById(order.getBookId(),BookStorage.getBooks());
		book.setAvailability(Availability.NOT_IN_STOCK);
	}

	public void writeToFile() {
		orderStorage.writeToFile();
	}

}
