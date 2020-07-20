package com.amazon.qa.helper.screenshotHelper;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import com.amzon.qa.base.TestBase;

public class ScreenShotHelperUtility extends TestBase {

	public ScreenShotHelperUtility() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*This ScreenShot Method is written to handle the dynamic response from ITestLister method.
	Depending upon the status of result screenshot is handle to respective folder.
	  // Test status
	  int CREATED = -1;
	  int SUCCESS = 1;
	  int FAILURE = 2;
	  int SKIP = 3;
	  int SUCCESS_PERCENTAGE_FAILURE = 4;
	  int STARTED= 16;*/

	public static void ScreenShot(String MethodName, int Value) throws IOException {

		// type casting file
		TakesScreenshot ss = (TakesScreenshot) driver;

		// In below code Screenshot is in form of file and storing in o reference
		File o = ss.getScreenshotAs(OutputType.FILE);

		if (Value == 1) {
			// in below code we are copying that o reference to your desired location.
			FileHandler.copy(o, new File(
					"C:\\Users\\ADMIN\\eclipse-workspace1\\Amzontest\\PassedTestCases\\" + MethodName + "_" + ".png"));

		} else {

			if (Value == 2) {
				// in below code we are copying that o reference to your desired location.
				FileHandler.copy(o, new File("C:\\Users\\ADMIN\\eclipse-workspace1\\Amzontest\\FailedTestCases\\"
						+ MethodName + "_" + ".png"));

			} else {

				if (Value == 3) {
					// in below code we are copying that o reference to your desired location.
					FileHandler.copy(o, new File("C:\\Users\\ADMIN\\eclipse-workspace1\\Amzontest\\SkippedTestCases\\"
							+ MethodName + "_" + ".png"));

				}

			}

		}
	}
}
