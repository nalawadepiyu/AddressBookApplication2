package address.data;
import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;

/*
 *@author :Priyanka Nalawade
 *This class contains all information ,fields about every address entries.
 **/


public class AddressBook {

	/*create instance of array list of AddressEntries */
	private ArrayList<AddressEntry> addressEntryList=new ArrayList<AddressEntry>() ;


	/*This method will return list of all addressentries */
	public ArrayList<AddressEntry> list() throws ClassNotFoundException, SQLException {

		DBOperation operation=new DBOperation();
		return addressEntryList = operation.loadFromDB();
	}

	/*This method will add new record in list of all addressentries */
	public ArrayList<AddressEntry> addNewRecords(AddressEntry ae) throws SQLException, ClassNotFoundException {
		this.addressEntryList.add(ae);
		DBOperation operation=new DBOperation();
		operation.addToDB(ae);
		return addressEntryList;
	}


	/*This method will add update record in list of all addressentries */
	public void upateRecords(AddressEntry ae) throws SQLException, ClassNotFoundException {
		this.addressEntryList.add(ae);
		DBOperation operation=new DBOperation();
		operation.updateToDB(ae);

	}


	/*This method will remove a record in list of all addressentries */
	public void removeRecord(int id) throws ClassNotFoundException, SQLException {

		//		for (AddressEntry addressEntry : addressEntryList) {
		//
		//			if (addressEntry.getId()==id) {
		//
		//				addressEntryList.remove(addressEntry);
		//
		//				DBOperation operation = new DBOperation();
		//				operation.deleteRecord(id);
		//
		//			}
		//		}

		AddressEntry [] datavalues=addressEntryList.toArray(new AddressEntry[addressEntryList.size()] );
		for (int i=0;i<datavalues.length;i++)
		{

			if (datavalues[i].getId() == id) {

				addressEntryList.remove(i);

				DBOperation operation = new DBOperation();
				operation.deleteRecord(id);

			}

		}



	}


	/*This method will find record by start of lastname in list of all addressentries */
	public ArrayList<AddressEntry> find(String lastName) {
		ArrayList<AddressEntry> addrss = new ArrayList<AddressEntry>();
		for (AddressEntry addressEntry : addressEntryList) {
			if (addressEntry.name.getLastName().toLowerCase().matches(lastName.toLowerCase() + ".*")) {
				addrss.add(addressEntry);
			}

		}
		return addrss;
	}


	public void sort()
	{
		this.addressEntryList.sort(new Comparator<AddressEntry>()
		{
			public int compare(AddressEntry o1, AddressEntry o2)
			{
				return o1.name.getLastName().toUpperCase().compareTo(o2.name.getLastName().toUpperCase());
			}
		});

	}



}









