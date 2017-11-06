package com.senla.bookshop.utils;

import com.senla.bookshop.storages.BookStorage;
import com.senla.bookshop.storages.OrderStorage;
import com.senla.bookshop.storages.RequestStorage;

public class GeneratorId {
	public static Integer generateBookId() {
		BookStorage.setLastId(BookStorage.getLastId()+3);
		return BookStorage.getLastId();
	}
	
	public static Integer generateOrderId() {
		OrderStorage.setLastId(OrderStorage.getLastId()+3);
		return OrderStorage.getLastId();
	}
	
	public static Integer generateRequestId() {
		RequestStorage.setLastId(RequestStorage.getLastId()+3);
		return RequestStorage.getLastId();
	}


}
