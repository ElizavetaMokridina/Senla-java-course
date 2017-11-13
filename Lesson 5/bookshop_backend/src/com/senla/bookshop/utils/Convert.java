package com.senla.bookshop.utils;

import com.senla.bookshop.enums.BookStatus;
import com.senla.bookshop.enums.Status;

public class Convert {
	public static BookStatus convertBookStatus(String str) {
		if(str.equals("IN_STOCK")) {
			return BookStatus.IN_STOCK;
		}
		else if(str.equals("NOT_IN_STOCK")) {
			return BookStatus.NOT_IN_STOCK;
		}
		else return null;
	}
	
	public static Status convertStatus(String str) {
		if(str.equals("DONE")) {
			return Status.DONE;
		}
		else if(str.equals("NOT_DONE")) {
			return Status.NOT_DONE;
		}
		else if(str.equals("CANCELED")) {
			return Status.CANCELED;
		}
		else return null;
	}

}
