package com.senla.bookshop.services;

import java.text.ParseException;
import java.util.Arrays;

import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.enums.Availability;
import com.senla.bookshop.storages.StorageOfBooks;
import com.senla.bookshop.utils.ArrayWorker;
import com.senla.bookshop.utils.Printer;

import java.util.Comparator;

public class ServiceOfBooks {
	private final StorageOfBooks storageOfBooks;

	public ServiceOfBooks() throws ParseException {
		this.storageOfBooks = new StorageOfBooks();
	}

	public Book[] sortBooks(Comparator comparator) {
		Book[] books = storageOfBooks.getBooks();
		Arrays.sort(books, comparator);
		return books;
	}

	public String getBookDetails(Integer id) {
		Book[] books = storageOfBooks.getBooks();
		int position = ArrayWorker.findById(id, books);
		if (position != -1) {
			return books[position].toString();
		} else
			Printer.print("book not found");
		return null;
	}

	public void changeBooksStatus(Availability availability, Integer id) {
		storageOfBooks.changeBooksStatus(availability, id);
	}

	public void addBook(Book book) {
		storageOfBooks.addBook(book);
	}

	public void writeToFile() {
		storageOfBooks.writeToFile();
	}
}
