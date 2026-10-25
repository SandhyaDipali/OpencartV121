package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
//Constructor
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
//Locator
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']") 
	WebElement txtLastName;

	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtPhoneNumber;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtInputPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")//oncce account successfully register then will get this msg that is validation part 
	//and validation is always part of test case and we keep inside test case not inside page object class
	WebElement msgConfirmation;
	
//Action
	public void firstName(String fname) {// enter first name
		txtFirstName.sendKeys(fname);
		
	}	
	public void lastName(String lname) {//enter last name
		
		txtLastName.sendKeys(lname);
		
	}
	public void setEmail(String email) {//enter email id
		txtEmail.sendKeys(email);
		
	}
	public void setTelephone(String tele) {//enter telephone no		
		txtPhoneNumber.sendKeys(tele);
		
	}
	public void setPassword(String pwd) {// enter password 
		
		txtInputPassword.sendKeys(pwd);		
	}
	
     public void setConfirmPassword(String pwd) {//enter confirm password
		
    	 txtConfirmPassword.sendKeys(pwd);		
	}
     public void checkPolicyMsg() {//select the check box 
 		
    	 checkPolicy.click();	
	}
     public void checkContinuebtn() {//after selecting checkbox we need to click continue button but sometimes click method not working
  		//solution 1
    	 btnContinue.click();
    	 
    	 //solution 2
    	 //btncontinue.submit();
    	 
    	 //solution 3
    	 //Action act=new Actions(driver);
    	 //act.moveToElement(btncontinue).click().perform();
    	 
    	 //solution 4
    	 //JavascriptExecuter js=(JavascriptExecuter)driver;
    	 //js.executeScript("argument[0].click();", btncontinue);
    	 
    	 //solution 5
    	 //btncontinue.sendKeys(keys.RETURN)
    	 
    	 //solution 6
    	// WebDriverwait mywait=new WebDriverwait(driver,Duration.ofSeconds(10));
    	 //mywait.until(ExpectConditions.elementToBeClickable(btnContinue)).click();
    	 }
     public String getconfirmmsg()  {
    	 try {
    
    	return (msgConfirmation.getText());
    	 }catch (Exception e) {
    		 return (e.getMessage());
    	 }
	}


}
