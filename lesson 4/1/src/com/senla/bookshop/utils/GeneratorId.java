package com.senla.bookshop.utils;

import com.senla.bookshop.storages.StorageOfBooks;
import com.senla.bookshop.storages.StorageOfOrders;
import com.senla.bookshop.storages.StorageOfRequests;

public class GeneratorId {
	public static Integer generateBooksId() {
		StorageOfBooks.setLastId(StorageOfBooks.getLastId()+3);
		return StorageOfBooks.getLastId();
	}
	
	public static Integer generateOrdersId() {
		StorageOfOrders.setLastId(StorageOfOrders.getLastId()+3);
		return StorageOfOrders.getLastId();
	}
	
	public static Integer generateRequestId() {
		StorageOfRequests.setLastId(StorageOfRequests.getLastId()+3);
		return StorageOfRequests.getLastId();
	}


}
