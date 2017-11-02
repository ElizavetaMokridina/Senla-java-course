package com.senla.bookshop.entities;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.senla.bookshop.enums.Availability;
import com.senla.bookshop.utils.GeneratorId;
import com.senla.bookshop.utils.Convert;

public class Book extends AEntity {
	private Integer id;
	private String author;
	private String name;
	private Date dateOfPublication;
	private Double price;
	private Availability availability;
	private Date dateOfReceipt;

	public Book(String author, String name, String dateOfPublication, Double price, Availability availability,
			String dateOfReceipt) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		this.id = GeneratorId.generateBooksId();
		this.author = author;
		this.name = name;
		this.dateOfPublication = sdf.parse(dateOfPublication);
		this.price = price;
		this.availability = availability;
		this.dateOfReceipt = sdf.parse(dateOfReceipt);

	}

	public Book(String string) throws ParseException {
		String[] stringArray = string.split(" ");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		this.id = Integer.parseInt(stringArray[0]);
		this.author = stringArray[1];
		this.name = stringArray[2];
		this.dateOfPublication = sdf.parse(stringArray[3]);
		this.price = Double.parseDouble(stringArray[4]);
		this.availability = Convert.convertAvailability(stringArray[5]);
		this.dateOfReceipt = sdf.parse(stringArray[6]);

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

	public Availability getAvailability() {
		return availability;
	}

	public Date getDateOfReceipt() {
		return dateOfReceipt;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		return id + " " + author + " " + name + " " + sdf.format(dateOfPublication) + " " + price + " " + availability
				+ " " + sdf.format(dateOfReceipt);
	}

}
