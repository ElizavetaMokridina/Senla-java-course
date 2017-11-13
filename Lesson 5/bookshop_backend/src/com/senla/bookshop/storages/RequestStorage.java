package com.senla.bookshop.storages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.danco.training.TextFileWorker;
import com.senla.bookshop.entities.Request;

public class RequestStorage {
	private static List<Request> requests = new ArrayList<>();
	private static Integer lastId = 0;
	private TextFileWorker textFileWorker;

	public static List<Request> getRequests() {
		return requests;
	}

	public static Integer getLastId() {
		return lastId;
	}

	public static void setLastId(Integer newlastId) {
		lastId = newlastId;
	}

	public RequestStorage() {
		this.textFileWorker = new TextFileWorker("D:\\ó÷¸áêà\\Senla\\Lesson4_Task1\\Requests.txt");
		List<String> strings = new ArrayList<>(Arrays.asList(textFileWorker.readFromFile()));

		for (String string : strings) {
			requests.add(new Request(string));
		}
	}

	public void addRequest(Request request) {
		requests.add(request);
	}

	public void writeToFile() {
		List<String> strings = new ArrayList<>();
		for (Request request : requests) {
			strings.add(request.toString());
		}
		textFileWorker.writeToFile(strings.toArray(new String[strings.size()]));
	}

}
