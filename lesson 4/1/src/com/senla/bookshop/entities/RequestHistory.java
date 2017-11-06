package com.senla.bookshop.entities;

public class RequestHistory extends AEntity {
	private Integer id;
	private Book book;
	private Request[] requests;

	public Book getBook() {
		return book;
	}

	public Request[] getRequests() {
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

}
