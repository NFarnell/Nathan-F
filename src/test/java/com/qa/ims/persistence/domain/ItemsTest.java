package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ItemsTest {
	
	private Items Items;
	private Items other;
	
	@Before
	public void setUp() {
		Items = new Items(1L, "monitor", "100");
		other = new Items(1L, "monitor", "100");
	}
	

	
	@Test
	public void equalsWithNull() {
		assertFalse(Items.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(Items.equals(new Object()));
	}
	

	
	@Test
	public void checkEquality() {
		assertTrue(Items.equals(Items));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(Items.equals(other));
	}
	

	
	@Test
	public void ItemsNamesNotEqual() {
		other.setItem_Name("rhys");
		assertFalse(Items.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		Items.setItem_Name(null);
		other.setItem_Name(null);
		assertTrue(Items.equals(other));
	}
	
	
	
	@Test
	public void nullIdOnBoth() {
		Items.setItem_Id(null);
		other.setItem_Id(null);
		assertTrue(Items.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setItem_Id(2L);
		assertFalse(Items.equals(other));
	}
	
	
	
	@Test
	public void nullSurnameOnBoth() {
		Items.setCost(null);
		other.setCost(null);
		assertTrue(Items.equals(other));
	}
	


	
	@Test
	public void hashCodeTest() {
		assertEquals(Items.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Items Items = new Items(null, null);
		Items other = new Items(null, null);
		assertEquals(Items.hashCode(), other.hashCode());
	}
}	
	