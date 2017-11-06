package com.senla.bookshop.utils;

import com.senla.bookshop.entities.AEntity;
import com.senla.bookshop.entities.RequestHistory;

public class Printer {
	public static void print(String string) {
		System.out.println(string);
	}

	public static void printArray(AEntity[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				System.out.println(array[i].toString());
			}
		}
	}
	
	public static void printArrayRequests(RequestHistory[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				System.out.println(array[i].getBook().getName());
			}
		}
	}
}
