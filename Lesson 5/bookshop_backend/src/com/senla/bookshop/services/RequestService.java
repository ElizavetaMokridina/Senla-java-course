package com.senla.bookshop.services;

import java.text.ParseException;

import com.senla.bookshop.entities.Request;
import com.senla.bookshop.storages.RequestStorage;

public class RequestService {
	private RequestStorage requestStorage;

	public RequestService() throws ParseException {
		this.requestStorage = RequestStorage.getInstance();
	}

	public void addRequest(Request request) {
		requestStorage.addRequest(request);
	}
	
	public void writeToFile() {
		requestStorage.writeToFile();
	}
}
