package com.senla.bookshop.comparators.books;

import java.util.Comparator;

import com.senla.bookshop.entities.Book;
import com.senla.bookshop.enums.Availability;

public class CompareBooksByAvailability implements Comparator<Book> {

	@Override
	public int compare(Book book1, Book book2) {
		if (book1 != null && book2 != null) {
			Availability availability1 = book1.getAvailability();
			Availability availability2 = book2.getAvailability();
			return availability1.compareTo(availability2);
		} else if (book1 != null && book2 == null) {
			return 1;
		} else
			return -1;
	}

}
