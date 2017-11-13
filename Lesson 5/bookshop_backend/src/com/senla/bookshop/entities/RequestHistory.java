package com.senla.bookshop.entities;

import java.util.ArrayList;
import java.util.List;

import com.senla.bookshop.storages.BookStorage;
import com.senla.bookshop.utils.ListWorker;

public class RequestHistory extends AEntity {
	private Integer id;
	private Book book;
	private List <Request> requests=new ArrayList<>();

	public Book getBook() {
		return book;
	}

	public List <Request> getRequests() {
		return requests;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;

	}
	
	public void setBook(Book book) {
		this.book=book;
	}

	public RequestHistory(Request request) {
		this.book=(Book) ListWorker.getEntityById(request.getBookId(), BookStorage.getBooks());
		this.requests.add(request);
	}
}
