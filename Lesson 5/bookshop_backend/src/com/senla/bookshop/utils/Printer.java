package com.senla.bookshop.utils;

import java.util.List;

import com.senla.bookshop.entities.AEntity;
import com.senla.bookshop.entities.RequestHistory;

public class Printer {
	public static void print(String string) {
		System.out.println(string);
	}

	public static void printArray(List<? extends AEntity> list) {
		int i=1;
		for (AEntity entity : list) {
			if (entity != null) {
				System.out.println(i+"-"+entity.toString());
				i++;
			}
		}
	}

	public static void printArrayRequests(List<RequestHistory> list) {
		for (RequestHistory entity : list) {
			if (entity != null) {
				printArray(entity.getRequests());
			}
		}
	}
}
