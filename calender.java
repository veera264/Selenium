package MvnPack;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calender {

	@Test
	public void Screenshot() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TakesScreenshot src = (TakesScreenshot) driver;
		File sorce = src.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sorce, new File("./screen/s.png"));

	}

	@Test
	public void autosuggestdropdown() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement m = driver.findElement(By.xpath("//a[@class='mmtLogo makeFlex']"));
		Actions action = new Actions(driver);
		action.moveToElement(m).click().build().perform();
		Thread.sleep(5000);
		driver.findElement(By.id("fromCity")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("del");

		int i = 0;
		while (i <= 4) {
			Thread.sleep(1000);
			WebElement s1 = driver.findElement(By.xpath("//input[@placeholder='From']"));
			s1.sendKeys(Keys.ARROW_DOWN);
			if (i == 4) {
				s1.sendKeys(Keys.ENTER);
			}
			i++;
		}

		Thread.sleep(4000);

		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("singa");
		Thread.sleep(2000);
		WebElement s = driver.findElement(By.xpath("//input[@placeholder='To']"));
		s.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		s.sendKeys(Keys.ENTER);
	}

	@Test
	public void calenderDate() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement m = driver.findElement(By.xpath("//a[@class='mmtLogo makeFlex']"));
		Actions action = new Actions(driver);
		action.moveToElement(m).click().build().perform();

		driver.findElement(By.xpath("//label[@for='departure']")).click();
		Thread.sleep(2000);

		while (!driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText().toString()
				.contains("January 2022")) {

			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label,'Thu Jan 13 2022')]")).click();
	}

		@Test
		public void tables() throws Exception {
			 
		}
}