package address.data;

/*
 *@author :Priyanka Nalawade
 *This class contains fields for Name -first name , lastname.
 **/

public class Name
{
	public String firstName;
	public String lastName;

	public Name()
	{
		firstName="";
		lastName="";
	}

	public Name(String firstName,String lastName)
	{
		this.firstName=firstName;
		this.lastName=lastName;
	}

	/*This method returns firstname*/
	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String fname )
	{
		firstName=fname;
	}

	/*This method returns lastname*/
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lname )
	{
		lastName=lname;
	}
}