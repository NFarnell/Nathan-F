package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.services.ItemServices;


@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	
	/**
	 *  The thing I want to fake functionlity for
	 */
	@Mock
	private ItemServices itemServices;
	
;


	
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer controller
	 */
	@Spy
	@InjectMocks
	private ItemController itemController;

	@Test
	public void readAllTest() {
		ItemController itemController = new ItemController(itemServices);
		List<Items> items = new ArrayList<>();
		items.add(new Items("Case", "50"));
		items.add(new Items("Monitor", "100"));
		items.add(new Items("Keyboard", "J"));
		Mockito.when(itemServices.readAll()).thenReturn(items);
		assertEquals(items, itemController.readAll());
	}

	@Test
	public void createTest() {
		String item_name = "case";
		String cost = "50";
		Mockito.doReturn(item_name, cost).when(itemController).getInput();
		Items item = new Items(item_name, cost);
		Items savedItem = new Items(1L, "Case", "50");
		Mockito.when(itemServices.create(item)).thenReturn(savedItem);
		assertEquals(savedItem, itemController.create());
	}

	/**
	 * 
	 */
	
	
	

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String item_id = "1";
		Mockito.doReturn(item_id).when(itemController).getInput();
		itemController.delete();
		Mockito.verify(itemServices, Mockito.times(1)).delete(1L);
	}
	
}
