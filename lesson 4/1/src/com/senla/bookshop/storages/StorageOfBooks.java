package com.senla.bookshop.storages;

import java.text.ParseException;
import java.util.Arrays;

import com.danco.training.TextFileWorker;
import com.senla.bookshop.entities.AEntity;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.enums.Availability;
import com.senla.bookshop.utils.ArrayWorker;
import com.senla.bookshop.utils.Printer;

public class StorageOfBooks {
	private Book[] books = new Book[10];
	private static Integer lastId = 0;
	private TextFileWorker textFileWorker;

	public Book[] getBooks() {
		return books;
	}

	public static Integer getLastId() {
		return lastId;
	}

	public static void setLastId(Integer newlastId) {
		lastId = newlastId;
	}

	public StorageOfBooks() throws ParseException {
		this.textFileWorker = new TextFileWorker("D:\\ó÷¸áêà\\Senla\\Lesson4_Task1\\Books.txt");
		String[] stringArray = textFileWorker.readFromFile();
		if (books.length < stringArray.length) {
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
		int position = ArrayWorker.getPosition(books);
		if (position == -1) {
			books = castEntitiesArray(ArrayWorker.resize(books));
			position = ArrayWorker.getPosition(books);
		}
		books[position] = book;
	}

	public void changeBooksStatus(Availability availability, Integer id) {
		int position = ArrayWorker.findById(id, books);
		if (position != -1) {
			Availability status = books[position].getAvailability();
			status = availability;
		} else
			Printer.print("book not found");
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
