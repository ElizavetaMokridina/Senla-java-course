package com.senla.bookshop.storages;

import java.text.ParseException;
import java.util.Arrays;

import com.senla.bookshop.entities.AEntity;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.entities.RequestHistory;
import com.senla.bookshop.storages.BookStorage;
import com.senla.bookshop.utils.ArrayWorker;

public class RequestHistoryStorage {
	private RequestHistory[] requestHistory = new RequestHistory[10];

	public RequestHistory[] getRequestHistory() {
		return requestHistory;
	}

	private Request[] castEntitiesArray(AEntity[] entities) {
		Request[] requests = Arrays.copyOf(entities, entities.length, Request[].class);
		return requests;
	}

	private RequestHistory[] castEntitiesArrayHistory(AEntity[] entities) {
		RequestHistory[] requestHistory = Arrays.copyOf(entities, entities.length, RequestHistory[].class);
		return requestHistory;
	}

	public RequestHistoryStorage() {
		Request[] requests = RequestStorage.getRequests();
		boolean flag = false;
		for (int i = 0; i < ArrayWorker.getLength(requests); i++) {
			for (int j = 0; j < ArrayWorker.getLength(requestHistory); j++) {
				if (requests[i].getBookId().equals(requestHistory[j].getBook().getId())) {
					Request[] bookRequests = requestHistory[j].getRequests();
					int position = ArrayWorker.getPosition(bookRequests);
					if (position == -1) {
						bookRequests = castEntitiesArray(ArrayWorker.resize(bookRequests));
						position = ArrayWorker.getPosition(bookRequests);
					}
					bookRequests[position] = requests[i];
					flag = true;
					break;
				}
			}

			if (!flag) {
				int position = ArrayWorker.getPosition(requestHistory);
				if (position == -1) {
					requestHistory = castEntitiesArrayHistory(ArrayWorker.resize(requestHistory));
					position = ArrayWorker.getPosition(requestHistory);
				}
				requestHistory[position]
						.setBook((Book) ArrayWorker.getEntityById(requests[i].getBookId(), BookStorage.getBooks()));
				Request[] bookRequests = requestHistory[position].getRequests();
				int position1 = ArrayWorker.getPosition(bookRequests);
				if (position1 == -1) {
					bookRequests = castEntitiesArray(ArrayWorker.resize(bookRequests));
					position1 = ArrayWorker.getPosition(bookRequests);
				}
				bookRequests[position1] = requests[i];
			}
		}
	}

}
