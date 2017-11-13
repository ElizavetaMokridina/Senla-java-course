package com.senla.bookshop.comparators.books;

import java.util.Comparator;

import com.senla.bookshop.entities.Book;
import com.senla.bookshop.enums.BookStatus;

public class CompareBooksByStatus implements Comparator<Book> {

	@Override
	public int compare(Book book1, Book book2) {
		if (book1 != null && book2 != null) {
			BookStatus status1 = book1.getBookStatus();
			BookStatus status2 = book2.getBookStatus();
			return status1.compareTo(status2);
		} else if (book1 != null && book2 == null) {
			return 1;
		} else
			return -1;
	}

}
