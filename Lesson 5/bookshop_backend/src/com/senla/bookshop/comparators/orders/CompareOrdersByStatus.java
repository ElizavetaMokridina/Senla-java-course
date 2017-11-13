package com.senla.bookshop.comparators.orders;

import java.util.Comparator;

import com.senla.bookshop.entities.Order;
import com.senla.bookshop.enums.Status;

public class CompareOrdersByStatus implements Comparator<Order> {
	@Override
	public int compare(Order order1, Order order2) {
		if (order1 != null && order2 != null) {
			Status status1 = order1.getStatus();
			Status status2 = order2.getStatus();
			return status1.compareTo(status2);
		} else if (order1 != null && order2 == null) {
			return 1;
		} else
			return -1;

	}
}
