package com.senla.bookshop.storages;

import com.danco.training.TextFileWorker;
import com.senla.bookshop.entities.Request;

public class StorageOfRequests {
	private Request[] requests = new Request[10];
	private static Integer lastId = 0;
	private TextFileWorker textFileWorker;

	public Request[] getRequest() {
		return requests;
	}

	public static Integer getLastId() {
		return lastId;
	}

	public static void setLastId(Integer newlastId) {
		lastId = newlastId;

	}
}
