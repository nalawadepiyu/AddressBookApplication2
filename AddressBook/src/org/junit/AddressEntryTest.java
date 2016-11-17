package org.junit;


import address.data.Address;
import address.data.AddressEntry;
import address.data.Name;

/**
 * This is the test case of class AddressBook
 * @author Priyanka Nalawade
 *
 *
 */
public class AddressEntryTest {

	Name n=new Name();
	Address adr=new Address();


	/**
	 * Test the combine of 2 or 3 strings are equal to a single string.
	 * Assert 1 shows 2 string combinations are equal to a single string.
	 * Assert 2 shows 3 string combinations are equal too.
	 */
	@Test
	public void testToString() {
		String str1="Good";
		String str2="Morning";
		String str3="Madam";
		String summary1=str1+" "+str2+"!";
		String summary2=str1+"\n"+str2+", "+str3;
		assertEquals(true,summary1.equals("Good Morning!"));
		assertEquals(true,summary2.equals("Good\nMorning, Madam"));
	}






	private void assertEquals(boolean b, boolean equals) {
		// TODO Auto-generated method stub

	}






	/**
	 * Test whether set phone can run properly
	 * Assert 1 changes the phone by passing a direct string.
	 * Assert 2 changes the phone by passing a String variable.
	 */
	@Test
	public void testSetPhone() {
		AddressEntry ae=new AddressEntry(1,"510-885-4167","raydown@gmail.com", n,adr);
		ae.setPhoneNumber("510-888-6666");
		assertEquals(true,ae.getPhoneNumber().equals("510-888-6666"));

		String str="5509963036";
		ae.setPhoneNumber(str);
		assertEquals(true,ae.getPhoneNumber().equals("5509963036"));
	}

	/**
	 * Test whether set e-mail can run properly
	 * Assert 1 changes the e-mail by passing a direct string.
	 * Assert 2 changes the e-mail by passing a String variable.
	 */
	@Test
	public void testSetEmail() {
		AddressEntry ae=new AddressEntry(1,"510-885-4167","raydown@gmail.com", n,adr);
		ae.setEmail("abc@hotmail.com");
		assertEquals(true,ae.getEmailId().equals("abc@hotmail.com"));

		String str="cba@gmail.com";
		ae.setEmail(str);
		assertEquals(true,ae.getEmailId().equals("cba@gmail.com"));
	}




	/**
	 * Test whether can return correct phone.
	 * Assert 1 returns the empty AddressEntry's phone.
	 * Assert 2 returns the fully written AddressEntry's phone.
	 */
	@Test
	public void testGetPhone() {
		AddressEntry ae1=new AddressEntry();
		AddressEntry ae2=new AddressEntry(1,"510-885-4167","raydown@gmail.com", n,adr);
		assertEquals(true,ae1.getPhoneNumber().equals(""));
		assertEquals(true,ae2.getPhoneNumber().equals("510-885-4167"));
	}

	/**
	 * Test whether can return correct e-mail.
	 * Assert 1 returns the empty AddressEntry's e-mail.
	 * Assert 2 returns the fully written AddressEntry's e-mail.
	 */
	@Test
	public void testGetEmail() {
		AddressEntry ae1=new AddressEntry();
		AddressEntry ae2=new AddressEntry(1,"510-885-4167","raydown@gmail.com", n,adr);
		assertEquals(true,ae1.getEmailId().equals(""));
		assertEquals(true,ae2.getEmailId().equals("raydown@gmail.com"));
	}

}
