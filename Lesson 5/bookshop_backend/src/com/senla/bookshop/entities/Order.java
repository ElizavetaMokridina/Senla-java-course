package com.senla.bookshop.entities;

import java.util.Date;
import java.text.ParseException;
import com.senla.bookshop.enums.Status;
import com.senla.bookshop.utils.Convert;
import com.senla.bookshop.utils.GeneratorId;
import com.senla.bookshop.utils.Sdf;;

public class Order extends AEntity {
	private Integer id;
	private Date executionDate;
	private Double price;
	private Status status;
	private Integer bookId;

	public Order(String executionDate, Double price, Status status, Integer bookId) throws ParseException {
		this.id = GeneratorId.generateOrderId();
		this.executionDate = Sdf.parse(executionDate);
		this.price = price;
		this.status = status;
		this.bookId = bookId;
	}

	public Order(String string) throws ParseException {
		String[] stringArray = string.split(" ");
		this.id = Integer.parseInt(stringArray[0]);
		this.executionDate = Sdf.parse(stringArray[1]);
		this.price = Double.parseDouble(stringArray[2]);
		this.status = Convert.convertStatus(stringArray[3]);
		this.bookId = Integer.parseInt(stringArray[4]);
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

	public Integer getBookId() {
		return bookId;
	}
	
	public void setStatus(Status status){
		this.status=status;
	}

	public String toString() {
		return id + " " + Sdf.format(executionDate) + " " + price + " " + status + " " + bookId;
	}

}
