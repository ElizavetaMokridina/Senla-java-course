package com.senla.bookshop.comparators.orders;

import java.util.Comparator;

import com.senla.bookshop.entities.Order;

public class CompareOrdersByPrice implements Comparator<Order> {
	@Override
	public int compare(Order order1, Order order2) {
		if (order1 != null && order2 != null) {
			Double price1 = order1.getPrice();
			Double price2 = order2.getPrice();
			return price1.compareTo(price2);
		} else if (order1 != null && order2 == null) {
			return 1;
		} else
			return -1;
	}
}
