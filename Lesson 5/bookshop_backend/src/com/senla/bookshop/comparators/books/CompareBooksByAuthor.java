package com.senla.bookshop.comparators.books;

import java.util.Comparator;

import com.senla.bookshop.entities.Book;

public class CompareBooksByAuthor implements Comparator<Book> {

	@Override
	public int compare(Book book1, Book book2) {
		if (book1 != null && book2 != null) {
			String author1 = book1.getAuthor();
			String author2 = book2.getAuthor();
			return author1.compareTo(author2);
		} else if (book1 != null && book2 == null) {
			return 1;
		} else
			return -1;
	}
}
