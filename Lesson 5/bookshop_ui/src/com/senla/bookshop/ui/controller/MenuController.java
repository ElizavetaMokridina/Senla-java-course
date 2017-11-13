package com.senla.bookshop.ui.controller;

import java.util.Scanner;

import com.senla.bookshop.ui.builder.Builder;
import com.senla.bookshop.ui.navigator.Navigator;

public class MenuController {
	private Builder builder = new Builder();
	private Navigator navigator = new Navigator(builder.getRootMenu());

	public void run() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			navigator.printMenu();
			int index = scanner.nextInt();
			navigator.navigate(index);

		}
	}
}