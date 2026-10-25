package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	//constructor
	
	public HomePage(WebDriver driver) //without creating child class constructor we cannot invoke parent class constructor
	{
		super(driver);
	}
	
	//locator
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkmyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkmyRegister;
	
	@FindBy(linkText="Login")
	WebElement linkLogin;
	
	
	//action method
	public void clickmyaccount(){
		lnkmyaccount.click();		
	}
	
	public void clickmyregister() {
		lnkmyRegister.click();
	}
	public void clicklogin() {
		linkLogin.click();
	}
	

}
