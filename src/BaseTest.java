import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class BaseTest {
	
	WebDriver driver;
	String appUrl;

	static ExtentReports reports;
	static ExtentHtmlReporter htmlReporter;
	ExtentTest test;
	
	static boolean isReportInitialized = false;
	
	@BeforeClass
	public synchronized void initialize() {
		// Create an instance of ExtentsReports class and pass report storage
		// path as a parameter
		if (!isReportInitialized) {
			isReportInitialized = true;
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/HtmlReport/index.html");
			reports = new ExtentReports();
			reports.attachReporter(htmlReporter);
			
		}
	}
	
	@BeforeTest
	public void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/driver-servers/chromedriver.exe");
		driver = new ChromeDriver();
		appUrl = "https://keystone.bigrentzqa.com/quotelog";
	}
	
	@AfterTest
	public void tearDown() {
		// Ending Test
		//reports.endTest(test);

		// writing everything into HTML report
		reports.flush();
	}

	@AfterClass
	public void clearingSetup() {
		// Quitting browser
		driver.quit();
	}
	
	public void takeScreenShot(WebDriver driver, String filePath) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int getRandomNumber(final int digCount) {
		return getRandomNumber(digCount, new Random());
	}

	public static int getRandomNumber(final int digCount, Random rnd) {
		final char[] ch = new char[digCount];
		for (int i = 0; i < digCount; i++) {
			ch[i] = (char) ('0' + (i == 0 ? rnd.nextInt(9) + 1 : rnd.nextInt(10)));
		}
		return new Integer(new String(ch));
	}

}
