package com.senla.bookshop.ui.builder;

import com.senla.bookshop.ui.actions.book.*;
import com.senla.bookshop.ui.actions.order.*;
import com.senla.bookshop.ui.actions.request.*;
import com.senla.bookshop.ui.item.MenuItem;
import com.senla.bookshop.ui.menu.Menu;

public class Builder {
	private Menu rootMenu = new Menu("Menu");
	private Menu bookMenu = new Menu("Book menu");
	private Menu orderMenu = new Menu("Order menu");
	private Menu requestMenu = new Menu("Request Menu");

	public void buildMenu() {
		
		rootMenu.addItem(new MenuItem("1-Book Menu",bookMenu ));
		rootMenu.addItem(new MenuItem("2-Order Menu",orderMenu ));
		rootMenu.addItem(new MenuItem("3-Request Menu",requestMenu ));
		
		bookMenu.addItem(new MenuItem("1-Add book",new AddBook(),bookMenu));
		bookMenu.addItem(new MenuItem("2-Get book by id ",new GetBookById(),bookMenu));
		bookMenu.addItem(new MenuItem("3-Sort books by author",new SortBooksByAuthor(),bookMenu));
		bookMenu.addItem(new MenuItem("4-Sort books by date of publication",new SortBooksByDate(),bookMenu));
		bookMenu.addItem(new MenuItem("5-Sort books by name",new SortBooksByName(),bookMenu));
		bookMenu.addItem(new MenuItem("6-Sort books by price",new SortBooksByPrice(),bookMenu));
		bookMenu.addItem(new MenuItem("7-Sort books by status",new SortBooksByStatus(),bookMenu));
		bookMenu.addItem(new MenuItem("8-Write off book",new WriteOffBook(),bookMenu));
		
		
		orderMenu.addItem(new MenuItem("1-Add order",new AddOrder(),orderMenu));
		orderMenu.addItem(new MenuItem("2-Cancel order",new CancelOrder(),orderMenu));
		orderMenu.addItem(new MenuItem("3-Complete order",new CompleteOrder(),orderMenu));
		orderMenu.addItem(new MenuItem("4-Get done by date",new GetDoneByDate(),orderMenu));
		orderMenu.addItem(new MenuItem("5-Get done by price",new GetDoneByPrice(),orderMenu));
		orderMenu.addItem(new MenuItem("6-Get number of order",new GetNumberOfOrder(),orderMenu));
		orderMenu.addItem(new MenuItem("7-Get order by id",new GetOrderById(),orderMenu));
		orderMenu.addItem(new MenuItem("8-Get total price",new GetTotalPrice(),orderMenu));
		orderMenu.addItem(new MenuItem("9-Sort order by execution date",new SortOrdersByDate(),orderMenu));
		orderMenu.addItem(new MenuItem("10-Sort order by price",new SortOrdersByPrice(),orderMenu));
		orderMenu.addItem(new MenuItem("11-Sort order by status",new SortOrdersByStatus(),orderMenu));
		
		requestMenu.addItem(new MenuItem("1-Add request",new AddRequest(),requestMenu));
		requestMenu.addItem(new MenuItem("2-Sort request by alphabet",new SortRequestsByAlphabet(),requestMenu));
		requestMenu.addItem(new MenuItem("3-Sort request bymumber",new SortRequestsByNumber(),requestMenu));

	}

	public Menu getRootMenu() {
		return rootMenu;
	}

}
