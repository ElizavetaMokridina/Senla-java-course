package com.senla.bookshop.ui.controller;

import java.util.Scanner;

import com.senla.bookshop.ui.builder.Builder;
import com.senla.bookshop.ui.navigator.Navigator;

public class MenuController {
	private Builder builder;
	private Navigator navigator;
	private Scanner scanner;

	public MenuController(){
		builder= new Builder();
		builder.buildMenu();
		navigator = new Navigator(builder.getRootMenu());
	}
	public void run() {
		scanner = new Scanner(System.in);
		while (true) {
			navigator.printMenu();
			int index = scanner.nextInt();
			navigator.navigate(index);

		}
	}
}