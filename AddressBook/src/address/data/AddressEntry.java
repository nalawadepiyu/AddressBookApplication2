package address.data;


/*
 *@author :Priyanka Nalawade
 *This class contains all information ,fields about every address entries.
 **/
public class AddressEntry
{
	public int id;
	public String phoneNumber;
	public String emailId;
	public Address adr;
	public Name name;

	public AddressEntry()
	{
		id=0;
		phoneNumber="";
		emailId="";
		adr=null;
		name=null;

	}

	public AddressEntry(int id,String phoneNumber,String emailId,Name n,Address adr)
	{
		this.adr=adr;
		this.name=n;
		this.id=id;
		this.emailId=emailId;
		this.phoneNumber=phoneNumber;
	}

	/*This method returns Id*/
	public int getId()
	{
		return id;

	}


	public void setId(int Id)
	{
		id=Id;
	}

	/*This method returns phone number*/
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phonenumber)
	{
		phoneNumber=phonenumber;
	}

	/*This method returns email id*/
	public String getEmailId()
	{
		return emailId;
	}

	public void setEmail(String email)
	{
		emailId=email;
	}

	/*This method returns Name*/
	public String getName(Name nameObj)
	{
		return nameObj.getFirstName() + " " + nameObj.getLastName();

	}

	public void setNameObj(Name nameObj){
		this.name = nameObj;
	}

	public void setAddrObj(Address addrObj){
		this.adr = addrObj;
	}

	/*This method returns Address*/
	public String getAddress(Address addressObj)

	{
		return addressObj.getStreetName()+""+addressObj.getCityName()+""+addressObj.getStateName()+""+addressObj.getZipCode();
	}


}





















