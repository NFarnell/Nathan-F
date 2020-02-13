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
import com.qa.ims.persistence.domain.Items;

@RunWith(MockitoJUnitRunner.class)
public class ItemsServicesTest {
	
	@Mock
	private Dao<Items> itemDao;
	
	@InjectMocks
	private ItemServices itemServices;
	
	@Test
	public void itemServicesCreate() {
		Items items = new Items("Case", "50");
		itemServices.create(items);
		Mockito.verify(itemDao, Mockito.times(1)).create(items);
	}
	
	@Test
	public void itemServicesRead() {
		itemServices.readAll();
		Mockito.verify(itemDao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void itemServicesUpdate() {
		Items items = new Items("Case", "50");
		itemServices.update(items);
		Mockito.verify(itemDao, Mockito.times(1)).update(items);
	}
	
	@Test
	public void customerServicesDelete() {
		itemServices.delete(1L);;
		Mockito.verify(itemDao, Mockito.times(1)).delete(1L);
	}
}
