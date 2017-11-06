package com.senla.bookshop.storages;

import java.util.Arrays;

import com.danco.training.TextFileWorker;
import com.senla.bookshop.entities.AEntity;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.utils.ArrayWorker;

public class RequestStorage {
	private static Request[] requests = new Request[10];
	private static Integer lastId = 0;
	private TextFileWorker textFileWorker;

	public Request[] getRequest() {
		return requests;
	}

	public static Integer getLastId() {
		return lastId;
	}

	public static void setLastId(Integer newlastId) {
		lastId = newlastId;
	}

	public static Request[] getRequests() {
		return requests;
	}

	public RequestStorage() {
		this.textFileWorker = new TextFileWorker("D:\\ó÷¸áêà\\Senla\\Lesson4_Task1\\Requests.txt");
		String[] stringArray = textFileWorker.readFromFile();
		while (requests.length < stringArray.length) {
			requests = castEntitiesArray(ArrayWorker.resize(requests));
		}
		for (int i = 0; i < stringArray.length; i++) {
			requests[i] = new Request(stringArray[i]);
		}
	}

	private Request[] castEntitiesArray(AEntity[] entities) {
		Request[] requests = Arrays.copyOf(entities, entities.length, Request[].class);
		return requests;
	}

	public void addRequest(Request request) {
		int position = ArrayWorker.getPosition(requests);
		if (position == -1) {
			requests = castEntitiesArray(ArrayWorker.resize(requests));
			position = ArrayWorker.getPosition(requests);
		}
		requests[position] = request;
	}

	public void writeToFile() {
		int length = ArrayWorker.getLength(requests);
		String[] stringArray = new String[length];
		for (int i = 0; i < length; i++) {
			stringArray[i] = requests[i].toString();
		}
		textFileWorker.writeToFile(stringArray);
	}

}
