package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FbCreateUsingExcel {

	public static void main(String[] args)throws Exception {
		//Getting Excel file
		File file=new File("D:\\test.xlsx");
		FileInputStream fi=new FileInputStream(file);
		XSSFWorkbook book=new XSSFWorkbook(fi);
		XSSFSheet sheet = book.getSheetAt(0);
		  
		//data to the sheet
		
		sheet.createRow(0).createCell(0).setCellValue("Veera");
		sheet.getRow(0).createCell(1).setCellValue("K");
		sheet.getRow(0).createCell(2).setCellValue("Kveera24@gmail.com");
		sheet.getRow(0).createCell(3).setCellValue("kveera24@gmail.com");
		sheet.getRow(0).createCell(4).setCellValue("VEEERAN123");
		sheet.getRow(0).createCell(5).setCellValue("13");
		sheet.getRow(0).createCell(6).setCellValue("Dec");
		sheet.getRow(0).createCell(7).setCellValue("1999");
		sheet.getRow(0).createCell(8).setCellValue("male");
		FileOutputStream fo=new FileOutputStream(file);
		book.write(fo);
		sheet.createRow(1).createCell(0).setCellValue("Mani");
		sheet.getRow(1).createCell(1).setCellValue("K");
		sheet.getRow(1).createCell(2).setCellValue("mani12@gmail.com");
		sheet.getRow(1).createCell(3).setCellValue("mani12@gmail.com");
		sheet.getRow(1).createCell(4).setCellValue("mani123");
		sheet.getRow(1).createCell(5).setCellValue("1");
		sheet.getRow(1).createCell(6).setCellValue("Sep");
		sheet.getRow(1).createCell(7).setCellValue("2001");
		sheet.getRow(1).createCell(8).setCellValue("female");
		FileOutputStream fo1=new FileOutputStream(file);
		book.write(fo1);
	
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\eclipse-workspace\\xml\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		int row=sheet.getLastRowNum();
		for(int i=0;i<=row;i++) {
			driver.findElement(By.xpath("//*[text()=\"Create New Account\"]")).click();
			Thread.sleep(3000);
			driver.findElement(By.name("firstname")).sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
			
			driver.findElement(By.name("lastname")).sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());	
			
			driver.findElement(By.name("reg_email__")).sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys(sheet.getRow(i).getCell(3).getStringCellValue());
			driver.findElement(By.name("reg_passwd__")).sendKeys(sheet.getRow(i).getCell(4).getStringCellValue());
			
			Select select=new Select(driver.findElement(By.id("day")));
			select.selectByVisibleText(sheet.getRow(i).getCell(5).getStringCellValue());
		
			Select select1=new Select(driver.findElement(By.id("month")));
			select1.selectByVisibleText(sheet.getRow(i).getCell(6).getStringCellValue());
	
			Select select2=new Select(driver.findElement(By.id("year")));
			select2.selectByVisibleText(sheet.getRow(i).getCell(7).getStringCellValue());
			
			
			if(sheet.getRow(0).getCell(8).getStringCellValue().equalsIgnoreCase("male")) {
				driver.findElement(By.xpath("//label[text()=\'Male\']")).click();
			}
			else {
				driver.findElement(By.xpath("//label[@class='_58mt']")).click();
			}
			
			
			//driver .findElement(By.xpath("//button[text()=\'Sign Up\']")).click();

			System.out.println("Account created");
			Thread.sleep(2000);
		
			driver.findElement(By.xpath("//img[@src='https://static.xx.fbcdn.net/rsrc.php/v3/y2/r/__geKiQnSG-.png']")).click();
			
		}
		Thread.sleep(5000);
		driver.close();
		book.close();
		
		
		
		
		
		
		
		

	}

}
