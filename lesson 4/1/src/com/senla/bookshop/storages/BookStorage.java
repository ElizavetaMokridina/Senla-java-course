package com.senla.bookshop.storages;

import java.text.ParseException;
import java.util.Arrays;

import com.danco.training.TextFileWorker;
import com.senla.bookshop.entities.AEntity;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.enums.Availability;
import com.senla.bookshop.enums.Status;
import com.senla.bookshop.utils.ArrayWorker;
import com.senla.bookshop.utils.Printer;

public class BookStorage {
	private static Book[] books = new Book[10];
	private static Integer lastId = 0;
	private TextFileWorker textFileWorker;

	public static Book[] getBooks() {
		return books;
	}

	public static Integer getLastId() {
		return lastId;
	}

	public static void setLastId(Integer newlastId) {
		lastId = newlastId;
	}

	public BookStorage() throws ParseException {
		this.textFileWorker = new TextFileWorker("D:\\ó÷¸áêà\\Senla\\Lesson4_Task1\\Books.txt");
		String[] stringArray = textFileWorker.readFromFile();
		while (books.length < stringArray.length) {
			books = castEntitiesArray(ArrayWorker.resize(books));
		}
		for (int i = 0; i < stringArray.length; i++) {
			books[i] = new Book(stringArray[i]);
		}
	}

	private Book[] castEntitiesArray(AEntity[] entities) {
		Book[] books = Arrays.copyOf(entities, entities.length, Book[].class);
		return books;
	}

	public void addBook(Book book) {
		boolean flag = false;
		for (int i = 0; i < ArrayWorker.getLength(books); i++) {
			if (books[i].getAuthor().equals(book.getAuthor()) && books[i].getName().equals(book.getName())) {
				changeBookStatus(Availability.IN_STOCK, books[i].getId());
				Request[] requests = RequestStorage.getRequests();
				for (int j = 0; j < ArrayWorker.getLength(requests); j++) {
					if(requests[j].getBookId().equals(books[i].getId())) {
						requests[j].setStatus(Status.DONE);
					}
				}
				
				flag = true;
				break;
			}
		}
		if (!flag) {
			int position = ArrayWorker.getPosition(books);
			if (position == -1) {
				books = castEntitiesArray(ArrayWorker.resize(books));
				position = ArrayWorker.getPosition(books);
			}
			books[position] = book;
		}
	}

	public boolean changeBookStatus(Availability availability, Integer id) {
		Book book = (Book) ArrayWorker.getEntityById(id, books);
		if (book != null) {
			book.setAvailability(availability);
			return true;
		} else
			return false;
	}

	public void writeToFile() {
		int length = ArrayWorker.getLength(books);
		String[] stringArray = new String[length];
		for (int i = 0; i < length; i++) {
			stringArray[i] = books[i].toString();
		}
		textFileWorker.writeToFile(stringArray);
	}

}
