package com.amazon.qa.helper.databaseHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.amazon.qa.helper.logger.LoggerHelper;

public class DataBaseHelper {

	private static Logger log = LoggerHelper.getlogger(DataBaseHelper.class);
	private static String URL = "jdbc:mysql://localhost:3306/student";
	private static String Username = "root";
	private static String Password = "jaffar786";
	private static Connection con;
	private static DataBaseHelper Connection_instance;
	private static PreparedStatement	st;
	
	
	

	public DataBaseHelper() {

		Create_Connection();

	}

	public static DataBaseHelper getInstance() {
		if (Connection_instance == null) {
			Connection_instance = new DataBaseHelper();

		}
		return Connection_instance;
	}

	public static  Connection Create_Connection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con = DriverManager.getConnection(URL, Username, Password);
				if (con != null) {
					log.info("Connection to DataBase created");
				}
			}

			catch (SQLException e) {
				log.info("Failed to create the database connection" + e);

			}
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			log.info("Driver not found " + e);
		}
		return con;
	}

	public Connection getConnection()

	{
      System.out.println(con);
		return con;
	}

	public static ResultSet ResultSet(String DBquery) {

		DataBaseHelper r = getInstance();
		Connection h = r.getConnection();
		try {
			Statement y = h.createStatement();
			ResultSet b = y.executeQuery(DBquery);
			return b;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void SetValues(String query, int no_of_rows) throws SQLException {

		DataBaseHelper r = getInstance();
		Connection h = r.getConnection();
	

		for (int i = 0; i < no_of_rows; i++) {
			
			
			try {
				st = h.prepareStatement(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Null pointer");
				e.printStackTrace();
			}
			
			Scanner v = new Scanner(System.in);
			System.out.println("Please Enter the Value in Column 1");
			int value1 = v.nextInt();
			st.setInt(1, value1);
			System.out.println("Please Enter the Value in Column 2");
			String value2 = v.next();
			st.setString(2, value2);
			System.out.println("Please Enter the Value in Column 1");
			int value3 = v.nextInt();
			st.setInt(3, value3);
			int count = st.executeUpdate();
			System.out.println(count);
		}
		
		h.close();

	}
	
	

}
