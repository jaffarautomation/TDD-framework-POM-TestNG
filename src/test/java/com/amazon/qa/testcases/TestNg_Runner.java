package com.amazon.qa.testcases;

import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;


 
// This is the Testng runner class, which will get executed when user open or double click on jar file when project is wrapped in jar files
//Creating the jar file for this project which which call this class.
public class TestNg_Runner {

	static TestNG testng;
	
	public static void main(String args[])
	{
		testng=new TestNG();
		
		 //Below method flow is created to add the testng xml file in list of string and called the setTestsuites method to pass the variable of list.
		    List<String> suites = Lists.newArrayList();
		    suites.add("C:\\Users\\ADMIN\\eclipse-workspace1\\Amzontest\\src\\test\\java\\com\\amazon\\qa\\testcases\\testng.xml");
		  //  suites.add("C:\\Users\\ADMIN\\eclipse-workspace1\\Amzontest\\testnglogin.xml");
		    testng.setTestSuites(suites);
		    testng.run();
	}
	
}
