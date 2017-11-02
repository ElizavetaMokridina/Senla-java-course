package com.senla.bookshop.entities;

import com.senla.bookshop.enums.Status;
import com.senla.bookshop.utils.Convert;
import com.senla.bookshop.utils.GeneratorId;

public class Request extends AEntity {
	private Integer id;
	private Integer booksId;
	private Status status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Request(Integer bookId, Status status) {
		this.id = GeneratorId.generateRequestId();
		this.booksId = booksId;
		this.status = status;
	}

	public Request(String string) {
		String[] stringArray = string.split(" ");
		this.id = Integer.parseInt(stringArray[0]);
		this.booksId = Integer.parseInt(stringArray[1]);
		this.status = Convert.convertStatus(stringArray[2]);
	}

}
