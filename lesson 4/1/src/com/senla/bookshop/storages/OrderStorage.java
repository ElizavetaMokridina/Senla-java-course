package com.senla.bookshop.storages;

import java.text.ParseException;
import java.util.Arrays;

import com.danco.training.TextFileWorker;
import com.senla.bookshop.entities.AEntity;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.enums.Status;
import com.senla.bookshop.utils.ArrayWorker;
import com.senla.bookshop.utils.Printer;

public class OrderStorage {
	private Order[] orders = new Order[10];
	private static Integer lastId = 0;
	private TextFileWorker textFileWorker;

	public Order[] getOrders() {
		return orders;
	}

	public static Integer getLastId() {
		return lastId;
	}

	public static void setLastId(Integer newlastId) {
		lastId = newlastId;
	}

	public OrderStorage() throws ParseException {
		this.textFileWorker = new TextFileWorker("D:\\ó÷¸áêà\\Senla\\Lesson4_Task1\\Orders.txt");
		String[] stringArray = textFileWorker.readFromFile();
		while (orders.length < stringArray.length) {
			orders = castEntitiesArray(ArrayWorker.resize(orders));
		}
		for (int i = 0; i < stringArray.length; i++) {
			orders[i] = new Order(stringArray[i]);
		}
	}

	private Order[] castEntitiesArray(AEntity[] entities) {
		Order[] orders = Arrays.copyOf(entities, entities.length, Order[].class);
		return orders;
	}

	public void addOrder(Order order) {
		int position = ArrayWorker.getPosition(orders);
		if (position == -1) {
			orders = castEntitiesArray(ArrayWorker.resize(orders));
			position = ArrayWorker.getPosition(orders);
		}
		orders[position] = order;
	}

	public boolean changeOrderStatus(Status status, Integer id) {
		int position = ArrayWorker.findById(id, orders);
		if (position != -1) {
			Status status1 = orders[position].getStatus();
			status1 = status;
			return true;
		} else return false;
			
			
	}

	public void writeToFile() {
		int length = ArrayWorker.getLength(orders);
		String[] stringArray = new String[length];
		for (int i = 0; i < length; i++) {
			stringArray[i] = orders[i].toString();
		}
		textFileWorker.writeToFile(stringArray);
	}

}
