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


import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.OrderServices;


@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	
	/**
	 *  The thing I want to fake functionlity for
	 */
	@Mock
	private OrderServices orderServices;
	
;


	
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer controller
	 */
	@Spy
	@InjectMocks
	private OrderController orderController;

	@Test
	public void readAllTest() {
		OrderController orderController = new OrderController(orderServices);
		List<Order> orders = new ArrayList<>();
		orders.add(new Order("1","50","1","1"));
		orders.add(new Order("1","1","1", "100"));
		orders.add(new Order("1","1","1","1"));
		Mockito.when(orderServices.readAll()).thenReturn(orders);
		assertEquals(orders, orderController.readAll());
	}



	/**
	 * 
	 */
	
	
	

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String order_id = "1";
		Mockito.doReturn(order_id).when(orderController).getInput();
		orderController.delete();
		Mockito.verify(orderServices, Mockito.times(1)).delete(1L);
	}
	
}
