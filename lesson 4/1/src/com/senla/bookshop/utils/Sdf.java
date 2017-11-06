package com.senla.bookshop.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sdf {
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");

	public static Date parse(String string) throws ParseException {
		return sdf.parse(string);
	}

	public static String format(Date date) {
		return sdf.format(date);
	}
}
