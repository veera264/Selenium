package objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
		
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-password")
	private WebElement  password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement login;
	
	public WebElement emailField() {
		return email;
	}
	public WebElement passwordfield() {
		return password;
	}
	public WebElement loginbutton() {
		return login;
	}
	
}
