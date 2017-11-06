package com.senla.bookshop.entities;

import com.senla.bookshop.enums.Status;
import com.senla.bookshop.utils.Convert;
import com.senla.bookshop.utils.GeneratorId;

public class Request extends AEntity {
	private Integer id;
	private Integer bookId;
	private Status status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setStatus(Status status) {
		this.status=status;
	}

	public Integer getBookId() {
		return bookId;
	}
	public Request(Integer bookId, Status status) {
		this.id = GeneratorId.generateRequestId();
		this.bookId = bookId;
		this.status = status;
	}

	public Request(String string) {
		String[] stringArray = string.split(" ");
		this.id = Integer.parseInt(stringArray[0]);
		this.bookId = Integer.parseInt(stringArray[1]);
		this.status = Convert.convertStatus(stringArray[2]);
	}
	
	public String toString() {
		return id+" "+bookId+" "+status;
	}

}
