package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
public static WebDriver driver;
public Logger logger;
public Properties p;


     @BeforeClass(groups={"Sanity","Regression","Master"})
    @Parameters({"os","browser"})// two parameter i passed
	public void setup(String os, String br) throws IOException
	{
	     FileReader file=new FileReader("./src//test//resources//config.properties");     
	   p=new Properties();
	    p.load(file);
		 
		logger=LogManager.getLogger(this.getClass());
	  if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{		
			
			DesiredCapabilities cap=new DesiredCapabilities();
			//os
			
			if(os.equalsIgnoreCase("windows"))
			{
				   cap.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				   cap.setPlatform(Platform.LINUX);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				 cap.setPlatform(Platform.MAC);
			}
			
	else  
		 {
		System.out.println("No matchingg os");
		return;
		 }			
			//browser
			
			switch(br.toLowerCase())
			{
			
			case "chrome": cap.setBrowserName("chrome"); break;
			case "firefox": cap.setBrowserName("firefox"); break;
			default: System.out.println("No matching browser"); return;
		
			} 
			driver = new RemoteWebDriver(new URL("http://localhost:4444"),cap);
		}
		
		// this is for local execution in grid setup
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase()) 
			{
			case "chrome" : driver=new ChromeDriver(); break;	
			case "firefox" : driver=new FirefoxDriver(); break;
			default : System.out.println("Invalid browser name.."); return;
			}
		}
		
// this is for local execution previously
		
		//this is how we can pass parameter from xml file to setup method
		/*switch(br.toLowerCase())//based on variable and condition we need to launch our particular browser and particular operating system
		{	
		case "chrome" : driver=new ChromeDriver(); break;	
		case "firefox" : driver=new FirefoxDriver(); break;
		default : System.out.println("Invalid browser name.."); return;
		}*/
		
		
		
		//driver=new ChromeDriver();	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://tutorialsninja.com/demo");
		driver.get(p.getProperty("appURL"));		
		driver.manage().window().maximize();
	}
	@AfterClass(groups={"Sanity","Regression","Master"})
	public void tearDown() {
		driver.quit();
	}
	public String randomeString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);//you can put any number of string here and same number of string will return
		return  generatedstring;
	}
	public String RandomNumber() {
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	public String randomAlphaNumber() {
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return (generatedstring+"@"+generatednumber);
	}
	public String captureScreen(String tname) throws IOException{
		String timeStamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname +"_" + timeStamp + ".png";
		
			File targetFile=new File(targetFilePath);
			
			sourceFile.renameTo(targetFile);
			
			return targetFilePath;
	
	
	
	}
	
	


}
