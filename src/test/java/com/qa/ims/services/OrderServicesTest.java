package com.qa.ims.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Order;

@RunWith(MockitoJUnitRunner.class)
public class OrderServicesTest {
	
	@Mock
	private Dao<Order> orderDao;
	
	@InjectMocks
	private OrderServices orderServices;
	
	@Test
	public void orderervicesCreate() {
		Order order = new Order("1", "1000", "10");
		orderServices.create(order);
		Mockito.verify(orderDao, Mockito.times(1)).create(order);
	}
	
	@Test
	public void orderervicesRead() {
		orderServices.readAll();
		Mockito.verify(orderDao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void orderervicesUpdate() {
		Order order = new Order("1", "1000", "10");
		orderServices.update(order);
		Mockito.verify(orderDao, Mockito.times(1)).update(order);
	}
	
	@Test
	public void customerServicesDelete() {
		orderServices.delete(1L);;
		Mockito.verify(orderDao, Mockito.times(1)).delete(1L);
	}
}
