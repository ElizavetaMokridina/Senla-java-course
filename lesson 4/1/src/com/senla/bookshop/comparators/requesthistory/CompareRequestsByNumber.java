package com.senla.bookshop.comparators.requesthistory;

import com.senla.bookshop.entities.RequestHistory;
import com.senla.bookshop.utils.ArrayWorker;

import java.util.Comparator;

public class CompareRequestsByNumber implements Comparator<RequestHistory>{
	@Override
	public int compare(RequestHistory requestHistory1, RequestHistory requestHistory2) {
		if (requestHistory1 != null && requestHistory2 != null) {
			Integer number1 = ArrayWorker.getLength(requestHistory1.getRequests());
			Integer number2 = ArrayWorker.getLength(requestHistory1.getRequests());
			return number1.compareTo(number2);
		} else if (requestHistory1 != null && requestHistory2 == null) {
			return 1;
		} else
			return -1;
	}
}
