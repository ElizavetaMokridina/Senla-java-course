package com.senla.bookshop.services;

import java.util.Comparator;
import java.util.List;

import com.senla.bookshop.entities.RequestHistory;
import com.senla.bookshop.storages.RequestHistoryStorage;

public class RequestHistoryService {
	private RequestHistoryStorage requestHistoryStorage;

	public RequestHistoryService() {
		requestHistoryStorage = new RequestHistoryStorage();
	}

	public List <RequestHistory> sortRequests(Comparator comparator) {
		List <RequestHistory> requestHistory = requestHistoryStorage.getRequestHistory();
		requestHistory.sort(comparator);
		return requestHistory;
	}
}
