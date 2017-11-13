package com.senla.bookshop.entities;

import java.text.ParseException;
import java.util.Date;

import com.senla.bookshop.enums.BookStatus;
import com.senla.bookshop.utils.Convert;
import com.senla.bookshop.utils.GeneratorId;
import com.senla.bookshop.utils.Sdf;

public class Book extends AEntity {
	private Integer id;
	private String author;
	private String name;
	private Date dateOfPublication;
	private Double price;
	private BookStatus status;
	private Date dateOfReceipt;

	public Book(String author, String name, String dateOfPublication, Double price, BookStatus status,
			String dateOfReceipt) throws ParseException {
		this.id = GeneratorId.generateBookId();
		this.author = author;
		this.name = name;
		this.dateOfPublication = Sdf.parse(dateOfPublication);
		this.price = price;
		this.status = status;
		this.dateOfReceipt = Sdf.parse(dateOfReceipt);

	}

	public Book(String string) throws ParseException {
		String[] stringArray = string.split(" ");
		this.id = Integer.parseInt(stringArray[0]);
		this.author = stringArray[1];
		this.name = stringArray[2];
		this.dateOfPublication = Sdf.parse(stringArray[3]);
		this.price = Double.parseDouble(stringArray[4]);
		this.status = Convert.convertBookStatus(stringArray[5]);
		this.dateOfReceipt = Sdf.parse(stringArray[6]);

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public String getName() {
		return name;
	}

	public Date getDateOfPublication() {
		return dateOfPublication;
	}

	public Double getPrice() {
		return price;
	}

	public BookStatus getBookStatus() {
		return status;
	}
	
	public void setBookStatus(BookStatus status) {
		this.status=status;
	}

	public Date getDateOfReceipt() {
		return dateOfReceipt;
	}

	@Override
	public String toString() {
		return id + " " + author + " " + name + " " + Sdf.format(dateOfPublication) + " " + price + " " + status
				+ " " + Sdf.format(dateOfReceipt);
	}

}
