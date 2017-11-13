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
		this.bookStorage = new BookStorage();
	}

	public List <Book> sortBooks(Comparator comparator) {
		List <Book>  books = BookStorage.getBooks();
		books.sort(comparator);
		return books;
	}

	public Book getBookById(Integer id) {
		List <Book>  books = BookStorage.getBooks();
		int position = ListWorker.findById(id, books);
		if (position != -1) {
			return books.get(position);
		} else {
		return null;
		}
	}

	public boolean changeBookStatus(BookStatus status, Integer id) {
		if(bookStorage.changeBookStatus(status, id)==false){
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
