package com.senla.bookshop.utils;

import com.senla.bookshop.entities.AEntity;

public class ArrayWorker {
	public static AEntity[] resize(AEntity[] array) {
		AEntity[] newArray = new AEntity[array.length * 2];
		System.arraycopy(array, 0, newArray, 0, array.length);
		return newArray;
	}

	public static int getPosition(AEntity[] array) {
		int position = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				position = i;
				break;
			}
		}
		return position;
	}

	public static int getLength(AEntity[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null)
				count++;
		}
		return count;
	}

	public static int findById(Integer id, AEntity[] array) {
		int position = -1;
		for (int i = 0; i < getLength(array); i++) {
			if (array[i].getId().equals(id)) {
				position = i;
				break;
			}
		}
		return position;
	}

	public static AEntity getEntityById(Integer id, AEntity[] array) {
		AEntity entity = null;

		for (int i = 0; i < getLength(array); i++) {
			if (array[i].getId().equals(id)) {
				entity = array[i];
				break;
			}
		}
		return entity;
	}
}
