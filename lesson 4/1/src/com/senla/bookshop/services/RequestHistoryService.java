package com.senla.bookshop.services;

import java.util.Arrays;
import java.util.Comparator;

import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.RequestHistory;
import com.senla.bookshop.storages.RequestHistoryStorage;

public class RequestHistoryService {
	private RequestHistoryStorage requestHistoryStorage;

	public RequestHistoryService() {
		requestHistoryStorage = new RequestHistoryStorage();
	}

	public RequestHistory[] sortRequests(Comparator comparator) {
		RequestHistory[] requestHistory = requestHistoryStorage.getRequestHistory();
		Arrays.sort(requestHistory, comparator);
		return requestHistory;
	}
}
