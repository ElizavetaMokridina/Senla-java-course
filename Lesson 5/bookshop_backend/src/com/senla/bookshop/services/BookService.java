package com.senla.bookshop.services;

import java.text.ParseException;
import java.util.Comparator;
import java.util.List;

import com.senla.bookshop.entities.Book;
import com.senla.bookshop.enums.BookStatus;
import com.senla.bookshop.storages.BookStorage;
import com.senla.bookshop.utils.ListWorker;

public class BookService {
	private final BookStorage bookStorage;

	public BookService() throws ParseException {
		this.bookStorage = BookStorage.getInstance();
	}

	public List<Book> sortBooks(Comparator<Book> comparator) {
		List<Book> books = BookStorage.getBooks();
		books.sort(comparator);
		return books;
	}

	public Book getBookById(Integer id) {
		List<Book> books = BookStorage.getBooks();
		int position = ListWorker.findById(id, books);
		return books.get(position);

	}

	public void WriteOffBook(Integer id) {
		bookStorage.changeBookStatus(BookStatus.NOT_IN_STOCK, id);

	}

	public void addBook(Book book) {
		bookStorage.addBook(book);
	}

	public void writeToFile() {
		bookStorage.writeToFile();
	}
}
