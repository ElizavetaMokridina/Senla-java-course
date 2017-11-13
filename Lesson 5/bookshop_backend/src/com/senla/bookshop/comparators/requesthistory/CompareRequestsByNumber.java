package com.senla.bookshop.comparators.requesthistory;

import java.util.Comparator;

import com.senla.bookshop.entities.RequestHistory;

public class CompareRequestsByNumber implements Comparator<RequestHistory>{
	@Override
	public int compare(RequestHistory requestHistory1, RequestHistory requestHistory2) {
		if (requestHistory1 != null && requestHistory2 != null) {
			Integer number1 =requestHistory1.getRequests().size();
			Integer number2 = requestHistory2.getRequests().size();
			return number1.compareTo(number2);
		} else if (requestHistory1 != null && requestHistory2 == null) {
			return 1;
		} else
			return -1;
	}
}
