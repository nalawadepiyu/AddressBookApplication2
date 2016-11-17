package address.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 *@author :Priyanka Nalawade
 *This class contains methods for Connection.
 **/

/* This will open the connection */
public class DBConnect {


	public Connection createConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName ("oracle.jdbc.driver.OracleDriver"); //name of driver may change w/ versions

		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:vu2628/C6UdsTBM@mcsdb1.sci.csueastbay.edu:1521/MCSDB1");

		return conn;

	}


	/* This will open the connection */
	public void closeConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName ("oracle.jdbc.driver.OracleDriver"); //name of driver may change w/ versions

		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:vu2628/C6UdsTBM@mcsdb1.sci.csueastbay.edu:1521/MCSDB1");

		conn.close();

	}

}
