package com.senla.bookshop.storages;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.danco.training.TextFileWorker;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.enums.Status;
import com.senla.bookshop.utils.ListWorker;

public class OrderStorage {
	private static OrderStorage orderStorage;
	private static List<Order> orders = new ArrayList<>();
	private static Integer lastId = 0;
	private TextFileWorker textFileWorker;

	public static List<Order> getOrders() {
		return orders;
	}

	public static Integer getLastId() {
		return lastId;
	}

	public static void setLastId(Integer newlastId) {
		lastId = newlastId;
	}

	private OrderStorage() throws ParseException {
		this.textFileWorker = new TextFileWorker("D:\\ó÷¸áêà\\Senla\\Lesson4_Task1\\Orders.txt");
		List<String> strings = new ArrayList<>(Arrays.asList(textFileWorker.readFromFile()));

		for (String string : strings) {
			orders.add(new Order(string));
		}
	}

	public static OrderStorage getInstance() throws ParseException {
		if (orderStorage == null) {
			orderStorage = new OrderStorage();
		}
		return orderStorage;
	}

	public void addOrder(Order order) {
		orders.add(order);
	}

	public void changeOrderStatus(Status status, Integer id) {
		Order order = (Order) ListWorker.getEntityById(id, orders);

		order.setStatus(status);

	}

	public void writeToFile() {
		List<String> strings = new ArrayList<>();
		for (Order order : orders) {
			strings.add(order.toString());
		}
		textFileWorker.writeToFile(strings.toArray(new String[strings.size()]));
	}

}
