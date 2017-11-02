package com.senla.bookshop.comparators.books;

import java.util.Comparator;

import com.senla.bookshop.entities.Book;

public class CompareBooksByName implements Comparator<Book> {
	@Override
	public int compare(Book book1, Book book2) {
		if (book1 != null && book2 != null) {
			String name1 = book1.getName();
			String name2 = book2.getName();
			return name1.compareTo(name2);
		} else if (book1 != null && book2 == null) {
			return 1;
		} else
			return -1;
	}
}
