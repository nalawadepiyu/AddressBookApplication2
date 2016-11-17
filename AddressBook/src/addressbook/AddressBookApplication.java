package addressbook;

import address.gui.event.*;
import java.sql.SQLException;
import javax.swing.*;

/*
 *@author :Priyanka Nalawade
 *This class contains a main() method
 **/

public class AddressBookApplication extends JFrame
{

	public static void main(String[] args) throws SQLException,ClassNotFoundException
	{

		GUIEvents.createAndShowGUI();

	}


}

















//		Class.forName ("oracle.jdbc.driver.OracleDriver"); //name of driver may change w/ versions
//
//		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:vu2628/C6UdsTBM@mcsdb1.sci.csueastbay.edu:1521/MCSDB1");
//
//		Statement stmt = conn.createStatement();
//
//		ResultSet rset =  stmt.executeQuery("SELECT * FROM ADDRESSENTRY");
//
//		System.out.println(rset);
//
//		while (rset.next ()) //get next row of table returned
//
//		{         for(int i=1; i<=rset.getMetaData().getColumnCount(); i++) //visit each column
//
//			System.out.print(rset.getString(i) + " | ");
//
//		System.out.println(" ");
//
//		System.out.println("========================================");
//
//		}
//
//		rset.close();
//
//		stmt.close();
//
//		conn.close();













