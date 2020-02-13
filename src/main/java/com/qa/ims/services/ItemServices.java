package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Items;

public class ItemServices implements CrudServices<Items> {

	private Dao<Items> ItemsDao;
	
	public ItemServices(Dao<Items> ItemsDao) {
		this.ItemsDao = ItemsDao;
	}
	
	public List<Items> readAll() {
		return ItemsDao.readAll();
	}

	public Items create(Items Items) {
		return ItemsDao.create(Items);
	}

	public Items update(Items Items) {
		return ItemsDao.update(Items);
	}

	public void delete(Long item_id) {
		ItemsDao.delete(item_id);
	}

}

