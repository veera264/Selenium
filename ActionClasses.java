package MvnPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClasses {
	
	@Test(priority=1)
	public void move() throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://themeforest.net/category/site-templates?tags=bootstrap&term=vertical%20slider");
		Thread.sleep(5000);
		WebElement move=driver.findElement(By.xpath("//ul[@class='_2Fj-e']/li[9]/a[@class='_3cJ2E _3cJ2E']"));
		WebElement link=driver.findElement(By.xpath("//a[text()='Photoshop ']"));
		Actions action=new Actions(driver);
		action.moveToElement(move).build().perform();
		Thread.sleep(3000);
		action.moveToElement(link).click(link).build().perform();
		
		}
	//Drag And Drop
	@Test(priority=2)
	public void draganddrop()throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		Thread.sleep(5000);
		WebElement hold=driver.findElement(By.id("box1"));
		WebElement drop=driver.findElement(By.id("box101"));
		Actions action=new Actions(driver);
		action.dragAndDrop(hold, drop).build().perform();
	}
	//DragAndDropBy
	@Test(priority=3)
	public void draganddropby()throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.globalsqa.com/demoSite/practice/slider/range.html");
		WebElement drag=driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"));
		Actions action=new Actions(driver);
		Thread.sleep(3000);
		action.dragAndDropBy(drag,120, 0).perform();
		Thread.sleep(3000);
		action.dragAndDropBy(drag,-190, 0).perform();
	}
	@Test(priority=4)
	public void key()throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		WebElement send=driver.findElement(By.name("q"));
		Actions action=new Actions(driver);
		Thread.sleep(3000);
		action.keyDown(send,Keys.SHIFT).sendKeys("selinium").keyUp(send, Keys.SHIFT).build().perform();
		}
	@Test(priority=5)
	public void doubleclick()throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		WebElement send=driver.findElement(By.name("q"));
		Actions action=new Actions(driver);
		action.sendKeys(send,"selinium").perform();
		Thread.sleep(3000);
		action.doubleClick(send).perform();
	}
	@Test(priority=6)
	public void contextclick()throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		//WebElement send=driver.findElement(By.name("q"));
		Actions action=new Actions(driver);
		Thread.sleep(3000);
		//action.contextClick(send).perform();
		action.contextClick().perform();
	}
}
