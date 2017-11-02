package com.senla.bookshop.comparators.books;

import java.util.Comparator;

import com.senla.bookshop.entities.Book;

public class CompareBooksByPrice implements Comparator<Book> {
	@Override
	public int compare(Book book1, Book book2) {
		if (book1 != null && book2 != null) {
			Double price1 = book1.getPrice();
			Double price2 = book2.getPrice();
			return price1.compareTo(price2);
		} else if (book1 != null && book2 == null) {
			return 1;
		} else
			return -1;
	}

}
