package address.data;
/*
 *@author :Priyanka Nalawade
 *This class contains all information ,fields about Address-street,state,city,zip.
 **/
public class Address
{
	public String streetName;
	public String cityName;
	public String stateName;
	public int zipcode;

	public Address()
	{
		streetName="";
		stateName="";
		cityName="";
		zipcode=0;

	}

	public Address(String streetName,String cityName,String stateName, int zipcode)
	{
		this.streetName=streetName;
		this.stateName=stateName;
		this.cityName=cityName;
		this.zipcode=zipcode;
	}

	/*This method returns street name*/
	public String getStreetName()
	{
		return streetName;
	}

	public void setStreetName(String streetname )
	{
		streetName=streetname;
	}

	/*This method returns city name*/
	public String getCityName()
	{
		return cityName;
	}

	public void setCityName(String cityname )
	{
		cityName=cityname;
	}

	/*This method returns state name*/
	public String getStateName()
	{
		return stateName;
	}


	public void setStateName(String statename)
	{
		stateName=statename;
	}

	/*This method returns zip code*/
	public int getZipCode()
	{
		return zipcode;
	}

	public void setZip(int zip)
	{
		zipcode=zip;
	}

}
