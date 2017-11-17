package com.senla.bookshop.services;

import java.text.ParseException;
import java.util.Comparator;
import java.util.List;

import com.senla.bookshop.entities.RequestHistory;
import com.senla.bookshop.storages.RequestHistoryStorage;

public class RequestHistoryService {
	private RequestHistoryStorage requestHistoryStorage;

	public RequestHistoryService() throws ParseException {
		requestHistoryStorage = RequestHistoryStorage.getInstance();
	}

	public List <RequestHistory> sortRequests(Comparator<RequestHistory> comparator) {
		List <RequestHistory> requestHistory = requestHistoryStorage.getRequestHistory();
		requestHistory.sort(comparator);
		return requestHistory;
	}
}
