package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demotest {
	WebDriver driver;
	ExtentReports extent=new ExtentReports();
	
	@BeforeMethod
	public void path() {
		String file=System.getProperty("user.dir")+"\\reports\\index.html";
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(file);
		reporter.config().setReportName("omayo test report");
		reporter.config().setDocumentTitle("omayo test title");
		
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Operating System","Windows 10");
		
		
	}
	
	@Test
	public void test() {
		
		ExtentTest etest = extent.createTest("test started");
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		etest.info("Chrome browser lanched");
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com");
		etest.info("navigated to omayo home page");
		String actuval=driver.findElement(By.id("pah")).getText();
		
		
		Assert.assertEquals(actuval,"PracticeAutomationHere");
		
	}
	
	@AfterMethod
	public void close() {
		driver.close();
		
		extent.flush();
	}
}
