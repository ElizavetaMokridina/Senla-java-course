package com.senla.bookshop.entities;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.senla.bookshop.enums.Availability;
import com.senla.bookshop.utils.GeneratorId;
import com.senla.bookshop.utils.Sdf;
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
		this.id = GeneratorId.generateBookId();
		this.author = author;
		this.name = name;
		this.dateOfPublication = Sdf.parse(dateOfPublication);
		this.price = price;
		this.availability = availability;
		this.dateOfReceipt = Sdf.parse(dateOfReceipt);

	}

	public Book(String string) throws ParseException {
		String[] stringArray = string.split(" ");
		this.id = Integer.parseInt(stringArray[0]);
		this.author = stringArray[1];
		this.name = stringArray[2];
		this.dateOfPublication = Sdf.parse(stringArray[3]);
		this.price = Double.parseDouble(stringArray[4]);
		this.availability = Convert.convertAvailability(stringArray[5]);
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

	public Availability getAvailability() {
		return availability;
	}
	
	public void setAvailability(Availability availability) {
		this.availability=availability;
	}

	public Date getDateOfReceipt() {
		return dateOfReceipt;
	}

	@Override
	public String toString() {
		return id + " " + author + " " + name + " " + Sdf.format(dateOfPublication) + " " + price + " " + availability
				+ " " + Sdf.format(dateOfReceipt);
	}

}
