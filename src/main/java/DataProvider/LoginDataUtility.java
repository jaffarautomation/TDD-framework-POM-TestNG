package DataProvider;

import java.util.ArrayList;


//This Class is acting as a utlity class which fetch the login data from the Excel sheet
public class LoginDataUtility {

	
	
  public static ArrayList<Object[]> getdatafromexcel()
	  
	  {
		  
		  
		  
		    ArrayList<Object[]> mydata =new ArrayList<Object[]>();
		    
		    Xls_Reader r = new Xls_Reader("F:\\Selenium all\\Data Driven Testing\\LoginSheet.xlsx");
		     
			
		           int size=	r.getRowCount("Data");
		           System.out.println(size);
		           
		           for (int i =2; i<=size;i++)
		           {
		        	   String Username =	r.getCellData("Data","UserName", i);
		     	      System.out.println(Username);
		     	     

		     	      String password =	r.getCellData("Data","Password", i);
		     	      System.out.println(password);
		     	      
		     	   
		     	      
		     	      
		     	      
		     	      //Here we have created the array of type Object of size 11.
		     	      //All the column value are fetch from the excel sheet and store in the respective string variable such as FirstName, LastName.
		     	      //Then Those String variables are store in array in index from 0 to 10.
		     	      //No of arrays creation will depend upon the no of rows in excel sheet
		     	      
		     	      Object[] array  = {Username,password};
		  
		     	     
		     	      //In below code we are adding the array in ArrayList 
		     	      mydata.add(array);
		     	      
		     	      System.out.println(array);
		     	      
		     	     

		        }
		            
		           
		           //If we execute the below code it will give the reference of the arrays
		           System.out.println(mydata.get(0));
		      
		         
		                      
		  
		  return  mydata;
		  
	  }
}
