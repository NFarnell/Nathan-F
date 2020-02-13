package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	private Items item;
	private Items other;
	
	@Before
	public void setUp() {
		item = new Items(1L, "Case", "50");
		other = new Items(1L, "Case", "50");
	}
	
	@SuppressWarnings("null")
	@Test
	public void settersTest() {
		assertNotNull(item.getItem_Id());
		assertNotNull(item.getItem_Name());
		assertNotNull(item.getCost());
		
		item.setOrder_Id(null);
		assertNull(item.getItem_Id());
		item.setItem_Name(null);
		assertNull(item.getItem_Name());
		item.setCost((Long) null);
		assertNull(item.getCost());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(item.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(item.equals(new Object()));
	}
	
	@Test
	public void createitemWithId() {
		assertEquals(1, item.getItem_Id(), 0);
		assertEquals("Case", item.getItem_Name());
		assertEquals("50", item.getCost());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(item.equals(item));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(item.equals(other));
	}
	
	@Test
	public void itemNameNullButOtherNameNotNull() {
		item.setItem_Name(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void itemNamesNotEqual() {
		other.setItem_Name("Headset");
		assertFalse(item.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		item.setItem_Name(null);
		other.setItem_Name(null);
		assertTrue(item.equals(other));
	}
	
	

	@Test
	public void constructorWithoutId() {
		Items item = new Items("1" ,"Case", "50");
		assertNull(item.getItem_Id());
		assertNotNull(item.getItem_Name());
		assertNotNull(item.getCost());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(item.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Items item = new Items(null, null);
		Items other = new Items(null, null);
		assertEquals(item.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "item_id:1 item_name:case cost:50";
		assertEquals(toString, item.toString());
	}
}


