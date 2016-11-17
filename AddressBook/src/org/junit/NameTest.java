package org.junit;
import static org.junit.Assert.*;
import org.junit.Test;
import address.data.Name;

public class NameTest {

	/**
	 * Test whether set first name can run properly
	 * Assert 1 changes the first name by passing a direct string.
	 * Assert 2 changes the first name by passing a String variable.
	 */
	@Test
	public void testSetFirstName() {

		Name name=new Name("Lynne","Grewe");
		name.setFirstName("Bill");
		assertEquals(true,name.getFirstName().equals("Bill"));

		String str="Oven";
		name.setFirstName(str);
		assertEquals(true,name.getFirstName().equals("Oven"));
	}


	/**
	 * Test whether set last name can run properly
	 * Assert 1 changes the last name by passing a direct string.
	 * Assert 2 changes the last name by passing a String variable.
	 */
	@Test
	public void testSetLastName() {
		Name name=new Name("Lynne","Grewe");
		name.setLastName("Stark");
		assertEquals(true,name.getLastName().equals("Stark"));

		String str="Oven";
		name.setLastName(str);
		assertEquals(true,name.getLastName().equals("Oven"));
	}


	/**
	 * Test whether can return correct first name.
	 * Assert 1 returns the empty AddressEntry's first name.
	 * Assert 2 returns the fully written AddressEntry's first name.
	 */
	@Test
	public void testGetFirstName() {
		Name name1=new Name();
		Name name2=new Name("Lynne","Grewe");
		assertEquals(true,name1.getFirstName().equals(""));
		assertEquals(true,name2.getFirstName().equals("Lynne"));
	}

	/**
	 * Test whether can return correct last name.
	 * Assert 1 returns the empty AddressEntry's last name.
	 * Assert 2 returns the fully written AddressEntry's last name.
	 */
	@Test
	public void testGetLastName() {
		Name name1=new Name();
		Name name2=new Name("Lynne","Grewe");
		assertEquals(true,name1.getLastName().equals(""));
		assertEquals(true,name2.getLastName().equals("Grewe"));
	}
}
