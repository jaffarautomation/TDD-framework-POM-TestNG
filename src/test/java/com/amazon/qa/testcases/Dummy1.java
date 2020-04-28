package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(com.qa.ExtendreportListerner.TestListener.class)
public class Dummy1 {

	
	
	
	
	  @Test(priority =4)
	    public void testCase4() {
		  
		  
		  
		  System.out.println("In test case 4 ");
		  String b ="abc";
		  Assert.assertEquals("abc", b);
	     
	    }
	    
	    @Test(priority =5)
	    public void testCase5() {
	    	
	    	
	    	
	    	  System.out.println("In test case 5");
	    	  String b ="ac";
			  Assert.assertEquals("abc", "b");
			  
			  
			  
			  String y = "ab";
			  Assert.assertEquals("ab", y);
			  
	        
	    }
	    
	    @Test(priority =6)
	    public void testCase6() {
	    	
	    	  System.out.println("In test case 6");
	    	  String b ="abc";
			  Assert.assertEquals("abc", b);
	        
	    }
}
