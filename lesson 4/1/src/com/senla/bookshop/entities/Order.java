package com.senla.bookshop.entities;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.senla.bookshop.enums.Status;
import com.senla.bookshop.utils.GeneratorId;;

public class Order extends AEntity {
	private Integer id;
	private Date executionDate;
	private Double price;
	private Status status;
	private Integer booksId;

	public Order(String executionDate, Double price, Status status, Integer booksId) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		this.id = GeneratorId.generateOrdersId();
		this.executionDate = sdf.parse(executionDate);
		this.price = price;
		this.status = status;
		this.booksId = booksId;
	}

	public Order(Double price, Status status, Integer booksId) throws ParseException {
		this.id = GeneratorId.generateOrdersId();
		this.price = price;
		this.status = status;
		this.booksId = booksId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getExecutionDate() {
		return executionDate;
	}

	public Double getPrice() {
		return price;
	}

	public Status getStatus() {
		return status;
	}

	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		return id + " " + sdf.format(executionDate) + " " + price + " " + status;
	}

}
