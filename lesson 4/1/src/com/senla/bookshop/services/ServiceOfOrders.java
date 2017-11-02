package com.senla.bookshop.services;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

import com.senla.bookshop.enums.Availability;
import com.senla.bookshop.enums.Status;

import com.senla.bookshop.comparators.orders.CompareOrdersByExecutionDate;
import com.senla.bookshop.comparators.orders.CompareOrdersByPrice;
import com.senla.bookshop.comparators.orders.CompareOrdersByStatus;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.storages.StorageOfOrders;
import com.senla.bookshop.utils.ArrayWorker;
import com.senla.bookshop.utils.Printer;

public class ServiceOfOrders {
	private final StorageOfOrders storageOfOrders;

	public ServiceOfOrders() {
		this.storageOfOrders = new StorageOfOrders();
	}

	public Order[] sortOrders(Comparator comparator) {
		Order[] orders = storageOfOrders.getOrders();
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
		Order[] orders = storageOfOrders.getOrders();
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
		Order[] orders = storageOfOrders.getOrders();
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
		Order[] orders = storageOfOrders.getOrders();
		int position = ArrayWorker.findById(id, orders);
		if (position != -1) {
			return orders[position].toString();
		} else
			Printer.print("order not found");
		return null;
	}

	public void changeOrdersStatus(Status status, Integer id) {
		storageOfOrders.changeOrdersStatus(status, id);
	}

	public void addOrder(Order order) {
		storageOfOrders.addOrder(order);
	}

}
