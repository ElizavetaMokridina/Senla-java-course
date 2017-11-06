package com.senla.bookshop.services;

import com.senla.bookshop.entities.Request;
import com.senla.bookshop.storages.RequestStorage;

public class RequestService {
	private RequestStorage requestStorage;

	public RequestService() {
		this.requestStorage = new RequestStorage();
	}

	public void addRequest(Request request) {
		requestStorage.addRequest(request);
	}
	
	public void writeToFile() {
		requestStorage.writeToFile();
	}
}
