package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

/**
 * Takes in Items details for CRUD functionality
 *
 */
public class ItemController implements CrudController<Items>{

	public static final Logger LOGGER = Logger.getLogger(ItemController.class);
	
	private CrudServices<Items> itemService;
	
	public ItemController(CrudServices<Items> itemServices) {
		this.itemService = itemServices;
	}
	

	String getInput() {
		return Utils.getInput();
	}
	
	/**
	 * Reads all Items to the logger
	 */
	@Override
	
	public List<Items> readAll() {
		List<Items> items = itemService.readAll();
		for(Items item: items) {
			LOGGER.info(item.toString());
		}
		return items;
	}
	
	


	/**
	 * Creates a Items by taking in user input
	 */
	@Override
	public Items create() {
		LOGGER.info("Enter Item name");
		String item_name = getInput();
		LOGGER.info("enter cost");
		Long cost = Long.valueOf(getInput());
		Items Items = itemService.create(new Items(item_name, cost));
		LOGGER.info("Items created");
		return Items;
	}

	/**
	 * Updates an existing Items by taking in user input
	 */
	@Override
	public Items update() {
		LOGGER.info("Please enter the id of the Items you would like to update");
		Long user_id = Long.valueOf(getInput());
		LOGGER.info("Enter a new item name");
		String item_name = getInput();
		LOGGER.info("Please enter a cost");
		Long cost = Long.valueOf(getInput());
		Items Items = itemService.update(new Items(user_id, item_name, cost));
		LOGGER.info("Items Updated");
		return Items;
	}

	/**
	 * Deletes an existing Items by the id of the Items
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the Items you would like to delete");
		Long user_id = Long.valueOf(getInput());
		itemService.delete(user_id);
		LOGGER.info("Item deleted");
	}



}
