package com.qa.ExtendreportListerner;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.amazon.qa.helper.logger.LoggerHelper;
import com.amzon.qa.base.TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListener extends TestBase implements ITestListener {

	static Logger log = LoggerHelper.getlogger(TestListener.class);

	public TestListener() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}

	public void onStart(ITestContext context) {
	
		log.info("*** Started Running Class : " + context.getName());
		ExtentTest r = ExtentTestManager.startTest(context.getName());
		r.log(Status.INFO, "Starting to executed all method in class");

	}

	public void onFinish(ITestContext context) {

		log.info("*** Test Class got Ended : " + context.getName());

		// This code will print the names of all the method present in the test suite
		// which got passed
		IResultMap r = context.getPassedTests();
		Collection<ITestNGMethod> passedtestcase = r.getAllMethods();
		for (ITestNGMethod iTestNGMethod : passedtestcase) {

			System.out.println("Name of the method which got passed is = " + iTestNGMethod.getMethodName());

		}

		IResultMap o = context.getFailedTests();
		Collection<ITestNGMethod> failedtestcase = r.getAllMethods();
		for (ITestNGMethod iTestNGMethod : failedtestcase) {

			System.out.println("Name of the method which got failed is = " + iTestNGMethod.getMethodName());

		}

		ExtentTestManager.getTest().log(Status.INFO, "All Test Method have been executed Successfully");
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		log.info("*** Started Running Test Method : " + result.getMethod().getMethodName());
		// ExtentTest r =
		// ExtentTestManager.startTest(result.getMethod().getMethodName());
		// r.log(Status.INFO, result.getMethod().getMethodName()+" is Started ");
		ExtentTestManager.getTest().log(Status.PASS,
				"Started Running Test Method : " + result.getMethod().getMethodName());
		ExtentTestManager.MapID();

	}

	public void onTestSuccess(ITestResult result) {
		log.info("*** Test Method " + result.getMethod().getMethodName() + " got Executed Successfully");
		ExtentTestManager.getTest().log(Status.PASS,
				"Test Method : " + result.getMethod().getMethodName() + " got  Successfully Passed");
	}

	public void onTestFailure(ITestResult result) {

		log.info("*** Test Method : " + result.getMethod().getMethodName() + " got  failed...");
		ExtentTestManager.getTest().log(Status.FAIL,
				"Test Method : " + result.getMethod().getMethodName() + " got  Failed");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test Method : " + result.getMethod().getMethodName() + " got skipped...");
		ExtentTestManager.getTest().log(Status.SKIP,
				"Test Method : " + result.getMethod().getMethodName() + " got Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());

	}

}
