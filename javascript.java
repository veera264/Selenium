package MvnPack;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class javascript {
	public static void flash(WebElement element,WebDriver driver) {
		String bgcolor=element.getCssValue("backgroundColor");
		for(int i=0;i<500;i++) {
			change("#000000",element,driver);
			change(bgcolor,element,driver);
		}
	}
	public static void change(String color,WebElement element,WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",element);
		
	}
	public static void border(WebElement element,WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	public static String title(WebDriver driver) {
		JavascriptExecutor js= ((JavascriptExecutor) driver);
		String t=js.executeScript("return document.title;").toString();
		return t;
	}
	public static void click(WebElement element,WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	public static void alert(WebDriver driver,String meassage) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("alert('"+meassage+"')");
	}
	public static void refesh(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}
	public static void scroll(WebElement element,WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	public static void scrolldown( WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
}
