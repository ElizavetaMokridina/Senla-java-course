package com.senla.bookshop.comparators.requesthistory;

import java.util.Comparator;

import com.senla.bookshop.entities.RequestHistory;
import com.senla.bookshop.utils.ArrayWorker;

public class CompareRequestsByAlphabet implements Comparator<RequestHistory>{
	@Override
	public int compare(RequestHistory requestHistory1, RequestHistory requestHistory2) {
		if (requestHistory1 != null && requestHistory2 != null) {
			String name1 = requestHistory1.getBook().getName();
			String name2 = requestHistory1.getBook().getName();
			return name1.compareTo(name2);
		} else if (requestHistory1 != null && requestHistory2 == null) {
			return 1;
		} else
			return -1;
	}
}
