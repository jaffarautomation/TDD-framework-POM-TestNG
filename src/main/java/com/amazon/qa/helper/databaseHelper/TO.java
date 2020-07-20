package com.amazon.qa.helper.databaseHelper;

import java.sql.SQLException;

public class TO {


public static 	String query2 = "select * from student_information";
	public static String query3 = "insert into student_information value (? ,?, ?)";
	
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		DataBaseHelper.SetValues(query3, 3);

	}

}
