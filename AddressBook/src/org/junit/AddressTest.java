package org.junit;
import static org.junit.Assert.*;

import org.junit.Test;

import address.data.Address;


public class AddressTest {

	/**
	 * Test whether can return correct street.
	 * Assert 1 returns the empty AddressEntry's street.
	 * Assert 2 returns the fully written AddressEntry's street.
	 */
	@Test
	public void testGetStreet() {
		Address adr1=new Address();
		Address adr2=new Address("Oxford Street","Hayward","CA",94542);
		assertEquals(true,adr1.getStreetName().equals(""));
		assertEquals(true,adr2.getStreetName().equals("Oxford Street"));
	}

	/**
	 * Test whether can return correct city.
	 * Assert 1 returns the empty AddressEntry's city.
	 * Assert 2 returns the fully written AddressEntry's city.
	 */
	@Test
	public void testGetCity() {
		Address adr1=new Address();
		Address adr2=new Address("Oxford Street","Hayward","CA",94542);
		assertEquals(true,adr1.getCityName().equals(""));
		assertEquals(true,adr2.getCityName().equals("Hayward"));
	}

	/**
	 * Test whether can return correct state.
	 * Assert 1 returns the empty AddressEntry's state.
	 * Assert 2 returns the fully written AddressEntry's state.
	 */
	@Test
	public void testGetState() {
		Address adr1=new Address();
		Address adr2=new Address("Oxford Street","Hayward","CA",94542);
		assertEquals(true,adr1.getStateName().equals(""));
		assertEquals(true,adr2.getStateName().equals("CA"));
	}

	/**
	 * Test whether can return correct zip.
	 * Assert 1 returns the empty AddressEntry's zip.
	 * Assert 2 returns the fully written AddressEntry's zip.
	 */
	@Test
	public void testGetZip() {
		Address adr1=new Address();
		Address adr2=new Address("Oxford Street","Hayward","CA",94542);
		assertEquals(0,adr1.getZipCode());
		assertEquals(94542,adr2.getZipCode());
	}

	/**
	 * Test whether set street can run properly
	 * Assert 1 changes the street by passing a direct string.
	 * Assert 2 changes the street by passing a String variable.
	 */
	@Test
	public void testSetStreet() {

		Address adr2=new Address("Oxford Street","Hayward","CA",94542);
		adr2.setStreetName("123 Sixth Ave");
		assertEquals(true,adr2.getStreetName().equals("123 Sixth Ave"));

		String str="321 Mission Blvd";
		adr2.setStreetName(str);
		assertEquals(true,adr2.getStreetName().equals("321 Mission Blvd"));
	}

	/**
	 * Test whether set city can run properly
	 * Assert 1 changes the city by passing a direct string.
	 * Assert 2 changes the city by passing a String variable.
	 */
	@Test
	public void testSetCity() {
		Address adr2=new Address("Oxford Street","Hayward","CA",94542);
		adr2.setCityName("SF");
		assertEquals(true,adr2.getCityName().equals("SF"));

		String str="San Jose";
		adr2.setCityName(str);
		assertEquals(true,adr2.getCityName().equals("San Jose"));
	}

	/**
	 * Test whether set state can run properly
	 * Assert 1 changes the state by passing a direct string.
	 * Assert 2 changes the state by passing a String variable.
	 */
	@Test
	public void testSetState() {
		Address adr2=new Address("Oxford Street","Hayward","CA",94542);
		adr2.setStateName("CA");
		assertEquals(true,adr2.getStateName().equals("CA"));

		String str="MI";
		adr2.setStateName(str);
		assertEquals(true,adr2.getStateName().equals("MI"));
	}

	/**
	 * Test whether set zip can run properly
	 * Assert 1 changes the zip by passing a direct integer.
	 * Assert 2 changes the zip by passing an Integer-converted-String-variable.
	 */
	@Test
	public void testSetZip() {
		Address adr2=new Address("Oxford Street","Hayward","CA",94542);
		adr2.setZip(93530);
		assertEquals(93530,adr2.getZipCode());

		String str="93532";
		Integer zip=Integer.parseInt(str);
		assertEquals(93532,zip.intValue());
	}


}
