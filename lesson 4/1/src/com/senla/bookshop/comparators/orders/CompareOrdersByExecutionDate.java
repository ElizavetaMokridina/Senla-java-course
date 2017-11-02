package com.senla.bookshop.comparators.orders;

import java.util.Comparator;
import java.util.Date;

import com.senla.bookshop.entities.Order;

public class CompareOrdersByExecutionDate implements Comparator<Order> {

	@Override
	public int compare(Order order1, Order order2) {
		if (order1 != null && order2 != null) {
			Date executionDate1 = order1.getExecutionDate();
			Date executionDate2 = order2.getExecutionDate();
			return executionDate1.compareTo(executionDate2);
		} else if (order1 != null && order2 == null) {
			return 1;
		} else
			return -1;
	}
}
