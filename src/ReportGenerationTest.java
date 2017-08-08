import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


public class ReportGenerationTest extends BaseTest{


	@Test
	public void testApp_1() throws IOException {
		try {
			// Start test. Mention test script name
			test = reports.createTest("test1", "Validate Page Navigation - 1");

			driver.manage().window().maximize();

			// Launch URL
			driver.get(appUrl);
			test.log(Status.INFO, "Application is launched");

			// Validate Home page title
			Assert.assertEquals(driver.getTitle(), "Automate Apps - Way to learn Automation");
			// Print log info in HTML report
			test.log(Status.INFO, "Home Page Title Validated");

			// Clicking on Contents tab
			driver.findElement(By.linkText("Contents")).click();
			// Validating Contents Page title
			Assert.assertEquals(driver.getTitle(), "Contents  Automate Apps");
			// Print log info in HTML report
			test.log(Status.INFO, "Contens Page Title Validated");

		} catch (Throwable t) {
			// Print fail info in HTML report
			test.log(Status.FAIL, t.getMessage());
			int rn = getRandomNumber(5);
			// Take screen shot of page
			takeScreenShot(driver, System.getProperty("user.dir") + "/HtmlReport/Failure" + rn + ".png");

			// Attach screen shot in HTML report
			test.log(Status.INFO, "Snapshot below: " + test.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "/HtmlReport/Failure" + rn + ".png"));
			Assert.assertTrue(false);
		}

	}

	
	@Test
	public void testApp_2() throws IOException {
		try {
			// Start test. Mention test script name
			test = reports.createTest("test2", "Validate Page Navigation - 2");

			driver.manage().window().maximize();

			// Launch URL
			driver.get(appUrl);
			test.log(Status.INFO, "Application is launched");

			// Validate Home page title
			Assert.assertEquals(driver.getTitle(), "Automate Apps | Way to learn Automation");
			// Print log info in HTML report
			test.log(Status.INFO, "Home Page Title Validated");

			// Clicking on Contents tab
			driver.findElement(By.linkText("Contents")).click();
			// Validating Contents Page title
			Assert.assertEquals(driver.getTitle(), "Contents  Automate Apps");
			// Print log info in HTML report
			test.log(Status.INFO, "Contens Page Title Validated");

		} catch (Throwable t) {
			// Print fail info in HTML report
			test.log(Status.FAIL, t.getMessage());
			int rn = getRandomNumber(5);
			// Take screen shot of page
			takeScreenShot(driver, System.getProperty("user.dir") + "/HtmlReport/Failure" + rn + ".png");

			// Attach screen shot in HTML report
			test.log(Status.INFO, "Snapshot below: " + test.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "/HtmlReport/Failure" + rn + ".png"));
			Assert.assertTrue(false);
		}

	}

	
	@Test
	public void testApp_3() throws IOException {
		try {
			// Start test. Mention test script name
			test = reports.createTest("test3", "Validate Page Navigation - 2");

			driver.manage().window().maximize();

			// Launch URL
			driver.get(appUrl);
			test.log(Status.INFO, "Application is launched");

			// Validate Home page title
			Assert.assertEquals(driver.getTitle(), "Automate Apps | Way to learn Automation");
			// Print log info in HTML report
			test.log(Status.INFO, "Home Page Title Validated");

			// Clicking on Contents tab
			driver.findElement(By.linkText("CONTENTS")).click();
			// Validating Contents Page title
			Assert.assertEquals(driver.getTitle(), "Content Automate Apps");
			// Print log info in HTML report
			test.log(Status.INFO, "Contens Page Title Validated");

		} catch (Throwable t) {
			// Print fail info in HTML report
			test.log(Status.FAIL, t.getMessage());
			int rn = getRandomNumber(5);
			// Take screen shot of page
			takeScreenShot(driver, System.getProperty("user.dir") + "/HtmlReport/Failure" + rn + ".png");

			// Attach screen shot in HTML report
			test.log(Status.INFO, "Snapshot below: " + test.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "/HtmlReport/Failure" + rn + ".png"));
			
			Assert.assertTrue(false);

		}

	}


	
}
