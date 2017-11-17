package com.senla.bookshop.storages;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.danco.training.TextFileWorker;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.enums.BookStatus;
import com.senla.bookshop.enums.Status;
import com.senla.bookshop.utils.ListWorker;

public class BookStorage {
	private static BookStorage bookStorage;
	private static List<Book> books = new ArrayList<>();
	private static Integer lastId = 0;
	private TextFileWorker textFileWorker;

	public static List<Book> getBooks() {
		return books;
	}

	public static Integer getLastId() {
		return lastId;
	}

	public static void setLastId(Integer newlastId) {
		lastId = newlastId;
	}

	public static BookStorage getInstance() throws ParseException {
		if (bookStorage == null) {
			bookStorage = new BookStorage();
		}
		return bookStorage;
	}

	private BookStorage() throws ParseException {
		this.textFileWorker = new TextFileWorker("D:\\ó÷¸áêà\\Senla\\Lesson4_Task1\\Books.txt");
		List<String> strings = new ArrayList<>(Arrays.asList(textFileWorker.readFromFile()));

		for (String string : strings) {
			books.add(new Book(string));
		}
	}

	public void addBook(Book newBook) {
		boolean flag = false;
		for (Book book : books) {
			if (book.getAuthor().equals(newBook.getAuthor()) && book.getName().equals(newBook.getName())) {
				changeBookStatus(BookStatus.IN_STOCK, book.getId());
				List<Request> requests = RequestStorage.getRequests();
				for (Request request : requests) {
					if (request.getBookId().equals(book.getId())) {
						request.setStatus(Status.DONE);
					}
				}

				flag = true;
				break;
			}
		}
		if (!flag) {
			books.add(newBook);
		}
	}

	public void changeBookStatus(BookStatus status, Integer id) {
		Book book = (Book) ListWorker.getEntityById(id, books);
		book.setBookStatus(status);

	}

	public void writeToFile() {
		List<String> strings = new ArrayList<>();
		for (Book book : books) {
			strings.add(book.toString());
		}
		textFileWorker.writeToFile(strings.toArray(new String[strings.size()]));
	}

}
