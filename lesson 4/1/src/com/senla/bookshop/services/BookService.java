package com.senla.bookshop.services;

import java.text.ParseException;
import java.util.Arrays;

import com.senla.bookshop.entities.Book;
import com.senla.bookshop.enums.Availability;
import com.senla.bookshop.storages.BookStorage;
import com.senla.bookshop.utils.ArrayWorker;
import com.senla.bookshop.utils.Printer;

import java.util.Comparator;

public class BookService {
	private final BookStorage bookStorage;

	public BookService() throws ParseException {
		this.bookStorage = new BookStorage();
	}

	public Book[] sortBooks(Comparator comparator) {
		Book[] books = bookStorage.getBooks();
		Arrays.sort(books, comparator);
		return books;
	}

	public String getBookDetails(Integer id) {
		Book[] books = bookStorage.getBooks();
		int position = ArrayWorker.findById(id, books);
		if (position != -1) {
			return books[position].toString();
		} else {
		return null;
		}
	}

	public boolean changeBookStatus(Availability availability, Integer id) {
		if(bookStorage.changeBookStatus(availability, id)==false){
		return false;
		}
		else return true;
		
	}

	public void addBook(Book book) {
		bookStorage.addBook(book);
	}

	public void writeToFile() {
		bookStorage.writeToFile();
	}
}
