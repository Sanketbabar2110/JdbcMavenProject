package com.jdbc.JdbcMavenPro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	
	static Connection connection;

	/*	>	It is an factory of Connections of database i.e. this method provides connection to the database
	 * 	>	returns connection to the database
	 */
	
	public static Connection getdbConnection() {
			
		try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "Sanket@2110");
				//System.out.println("Connection Established");
			}
			catch(SQLException e) {
				System.out.println("Connection faild!! check Console");
				e.printStackTrace();
			}
		return connection;
	}
	
	/*	>	it is used to close the connection of the database
	 */
	
	public static void closeDbConnection() {
		
		try {
				if(connection != null)
					connection.close();
				//System.out.println("Connection closed !!");
			}
			catch(SQLException e) {
				System.out.println("Error in closing Connection !!");
				e.printStackTrace();
			}
	}
}