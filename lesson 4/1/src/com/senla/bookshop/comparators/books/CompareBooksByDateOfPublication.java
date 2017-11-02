package com.senla.bookshop.comparators.books;

import java.util.Comparator;
import java.util.Date;

import com.senla.bookshop.entities.Book;

public class CompareBooksByDateOfPublication implements Comparator<Book> {
	@Override
	public int compare(Book book1, Book book2) {
		if (book1 != null && book2 != null) {
			Date dateOfPublication1 = book1.getDateOfPublication();
			Date dateOfPublication2 = book2.getDateOfPublication();
			return dateOfPublication1.compareTo(dateOfPublication2);
		} else if (book1 != null && book2 == null) {
			return 1;
		} else
			return -1;
	}
}
