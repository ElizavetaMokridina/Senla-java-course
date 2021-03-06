package com.senla.bookshop.storages;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.senla.bookshop.entities.Request;
import com.senla.bookshop.entities.RequestHistory;

public class RequestHistoryStorage {
	private static RequestHistoryStorage requestHistoryStorage;
	private List<RequestHistory> requestHistory = new ArrayList<>();

	public List<RequestHistory> getRequestHistory() {
		return requestHistory;
	}
	
	public static RequestHistoryStorage getInstance() throws ParseException {
		if (requestHistoryStorage == null) {
			requestHistoryStorage = new RequestHistoryStorage();
		}
		return requestHistoryStorage;
	}

	private RequestHistoryStorage() {
		List<Request> requests = RequestStorage.getRequests();
		for (Request request : requests) {
			boolean flag = false;
			for (RequestHistory history : requestHistory) {
				if (request.getBookId().equals(history.getBook().getId())) {
					List<Request> bookRequests = history.getRequests();
					bookRequests.add(request);
					flag = true;
					break;
				}
			}

			if (!flag) {

				requestHistory.add(new RequestHistory(request));

			}
		}
	}

}
