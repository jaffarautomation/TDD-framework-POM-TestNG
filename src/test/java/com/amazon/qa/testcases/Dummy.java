package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.ExtendreportListerner.ExtentTestManager;

@Listeners(com.qa.ExtendreportListerner.TestListener.class)
public class Dummy {

	@Test(priority = 1)
	public void testCase1() {
		ExtentTestManager.getTest().log(Status.INFO, "Test started ****");

		System.out.println("In test case 1 ");
		String b = "abc";
		Assert.assertEquals("abc", b);
		ExtentTestManager.getTest().log(Status.PASS, "Test Passed ****");

	}

	@Test(priority = 2)
	public void testCase2() {

		System.out.println("In test case 2");
		String b = "ac";
		Assert.assertEquals("abc", "b");

		String y = "ab";
		Assert.assertEquals("ab", y);

	}

	@Test(priority = 3)
	public void testCase3() {

		System.out.println("In test case 3");
		String b = "abc";
		Assert.assertEquals("abc", b);

	}
}
