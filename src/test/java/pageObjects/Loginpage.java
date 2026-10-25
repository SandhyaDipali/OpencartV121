package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends BasePage {
	//constructor
	public Loginpage(WebDriver driver)
	{
		super(driver);
	}
	
	//locator
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	//Action Method
	
	public void setEmail(String email) {
	txtEmailAddress.sendKeys(email);
	}
	public void setpsw(String pasword) {
		txtpassword.sendKeys(pasword);
	}
	public void clickLogin() {
		btnLogin.click();
		
		
	}
	
}
