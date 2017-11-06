package com.senla.bookshop.test;

import java.text.ParseException;

import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.enums.Availability;
import com.senla.bookshop.enums.Status;
import com.senla.bookshop.facade.BookShop;

public class Test {
	
	public static void main(String[] arg) throws ParseException {
		BookShop bookShop=new BookShop();
		/*
		Book book1=new Book("author1","name1","12-10-1950",20.0,Availability.NOT_IN_STOCK,"10-10-2017");
		Book book2=new Book("author2","name2","12-10-1998",20.0,Availability.IN_STOCK,"10-01-2017");
		Book book3=new Book("author3","name3","12-10-1990",20.0,Availability.IN_STOCK,"10-05-2017");
		
		Order order1=new Order("15-11-2017",20.0,Status.NOT_DONE,3);
		Order order2=new Order("01-11-2017",20.0,Status.DONE,6);
		Order order3=new Order("20-10-2017",20.0,Status.DONE,3);
		
		Request request1 = new Request(3,Status.NOT_DONE);
		
		bookShop.addBook(book1);
		bookShop.addBook(book2);
		bookShop.addBook(book3);
		
		bookShop.addOrder(order1);
		bookShop.addOrder(order2);
		bookShop.addOrder(order3);
		
		bookShop.addRequest(request1);
		
		bookShop.writeToFile();
		*/
		
		
		bookShop.sortBooksByDateOfPublication();
	}

}
