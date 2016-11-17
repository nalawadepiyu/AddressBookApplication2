package address.data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/*
 *@author :Priyanka Nalawade
 *This class contains all methods for CRUD operations of DB.
 **/
public class DBOperation
{

	ArrayList<AddressEntry> addressEntryList=new ArrayList<AddressEntry>();

    /*This method will add new record in database*/
	public void addToDB(AddressEntry ae) throws SQLException, ClassNotFoundException
	{
		DBConnect db=new DBConnect();
		Connection conn=db.createConnection();
		String query="Insert into ADDRESSENTRY (ID,FIRSTNAME,LASTNAME,STREETNAME,CITYNAME,STATENAME,ZIP,PHONENUMBER,EMAILID) VALUES"
				+ " (?,?,?,?,?,?,?,?,?)";

		PreparedStatement pst=((Connection) conn).prepareStatement(query);

		pst.setInt(1, ae.getId());
		pst.setString(2, ae.name.getFirstName());
		pst.setString(3, ae.name.getLastName());
		pst.setString(4, ae.adr.getStreetName());
		pst.setString(5, ae.adr.getCityName());
		pst.setString(6, ae.adr.getStateName());
		pst.setInt(7, ae.adr.getZipCode());
		pst.setString(8, ae.getPhoneNumber());
		pst.setString(9, ae.getEmailId());


		int inserted=pst.executeUpdate();
		if(inserted>0){

			JOptionPane.showMessageDialog(null, "Data Saved");

		}
		db.closeConnection();

	}

	/*This method will load all records from database*/
	public ArrayList<AddressEntry> loadFromDB()throws ClassNotFoundException, SQLException
	{
		DBConnect db=new DBConnect();

		Connection con = db.createConnection();
		Statement stmt =  con.createStatement();


		ResultSet rset =  stmt.executeQuery("SELECT * FROM ADDRESSENTRY ORDER BY LASTNAME");


		while (rset.next ()) //get next row of table returned

		{
			AddressEntry ae=new AddressEntry();
			ae.setId(rset.getInt("ID"));

			//rset.getString();
			Name name=new Name();
			name.setFirstName(rset.getString("FIRSTNAME"));
			name.setLastName(rset.getString("LASTNAME"));

			Address adr=new Address();
			adr.setStreetName(rset.getString("STREETNAME"));
			adr.setCityName(rset.getString("CITYNAME"));
			adr.setStateName(rset.getString("STATENAME"));
			adr.setZip(rset.getInt("ZIP"));

			ae.setPhoneNumber(rset.getString("PHONENUMBER"));
			ae.setEmail(rset.getString("EMAILID"));
			ae.setNameObj(name);
			ae.setAddrObj(adr);

			addressEntryList.add(ae);

			db.closeConnection();

		}
		return addressEntryList;

	}

	/*This method will update a selected record in database*/
	public void updateToDB(AddressEntry ae) throws ClassNotFoundException, SQLException
	{

		DBConnect db=new DBConnect();
		Connection conn=db.createConnection();

		String updateQuery="Update ADDRESSENTRY set FIRSTNAME =? ,LASTNAME= ?,STREETNAME = ?,CITYNAME = ?,STATENAME = ?,ZIP = ?,PHONENUMBER = ?,EMAILID = ? where ID = ?";

		PreparedStatement pst = conn.prepareStatement(updateQuery);

		pst.setString(1, ae.name.getFirstName());
		pst.setString(2, ae.name.getLastName());
		pst.setString(3, ae.adr.getStreetName());
		pst.setString(4, ae.adr.getCityName());
		pst.setString(5, ae.adr.getStateName());
		pst.setInt(6, ae.adr.getZipCode());
		pst.setString(7, ae.getPhoneNumber());
		pst.setString(8, ae.getEmailId());
		pst.setInt(9, ae.getId());

		int updated=pst.executeUpdate();
		if(updated>0){

			JOptionPane.showMessageDialog(null, "Updated Record!!");

		}

		db.closeConnection();
	}

	/*This method will delete selected record from database*/
	public ArrayList<AddressEntry> deleteRecord(int id) throws ClassNotFoundException, SQLException
	{
		DBConnect db=new DBConnect();
		Connection conn=db.createConnection();


		String deleteQuery = "DELETE FROM ADDRESSENTRY WHERE ID = "+"?";
		PreparedStatement myPs = conn.prepareStatement(deleteQuery);
		myPs.setInt(1,id);
		myPs.executeUpdate();

		db.closeConnection();

		JOptionPane.showMessageDialog(null,"Records deleted");
		return addressEntryList;



	}




}
