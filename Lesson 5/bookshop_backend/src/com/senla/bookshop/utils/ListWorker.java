package com.senla.bookshop.utils;

import java.util.List;

import com.senla.bookshop.entities.AEntity;

public class ListWorker {



	public static int findById(Integer id, List <? extends AEntity> list) {
		int position = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				position = i;
				break;
			}
		}
		return position;
	}

	public static AEntity getEntityById(Integer id, List <? extends AEntity> list) {
		AEntity entity = null;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				entity = list.get(i);
				break;
			}
		}
		return entity;
	}
}
