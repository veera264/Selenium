package demo;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailCreation {
	public static void main(String[] args) throws Exception {
		File file=new File("D:\\gmail.xlsx");
		FileInputStream fi=new FileInputStream(file);
		XSSFWorkbook book= new XSSFWorkbook(fi);
		XSSFSheet sheet = book.getSheetAt(0);
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\eclipse-workspace\\xml\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://accounts.google.com/signup");
		driver.findElement(By.id("firstName")).sendKeys(sheet.getRow(0).getCell(0).getStringCellValue());
		driver.findElement(By.id("lastName")).sendKeys(sheet.getRow(0).getCell(1).getStringCellValue());
		driver.findElement(By.id("username")).sendKeys(sheet.getRow(0).getCell(2).getStringCellValue());
		driver.findElement(By.cssSelector("input[name='Passwd']")).sendKeys(sheet.getRow(0).getCell(3).getStringCellValue());
		driver.findElement(By.cssSelector("input[name='ConfirmPasswd']")).sendKeys(sheet.getRow(0).getCell(4).getStringCellValue());
		driver.findElement(By.xpath("(//span[@class='VfPpkd-vQzf8d'])[2]")).click();
		book.close();
		
	}

}
