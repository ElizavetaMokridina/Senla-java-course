package com.senla.bookshop.storages;

import java.util.Arrays;

import com.senla.bookshop.entities.AEntity;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.enums.Availability;
import com.senla.bookshop.enums.Status;
import com.senla.bookshop.utils.ArrayWorker;
import com.senla.bookshop.utils.Printer;

public class StorageOfOrders {
	private Order[] orders = new Order[10];
	private static Integer lastId = 0;

	public Order[] getOrders() {
		return orders;
	}

	public static Integer getLastId() {
		return lastId;
	}

	public static void setLastId(Integer newlastId) {
		lastId = newlastId;
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

	public void changeOrdersStatus(Status status, Integer id) {
		int position = ArrayWorker.findById(id, orders);
		if (position != -1) {
			Status status1 = orders[position].getStatus();
			status1 = status;
		} else
			Printer.print("order not found");
	}

}
