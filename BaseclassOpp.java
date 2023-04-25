package assignmentWk5Day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



public class BaseclassOpp {
	public ChromeDriver driver;
	public ChromeOptions Options;
	@Parameters({"url", "username", "password" })
	@BeforeMethod
	public void precondition(String Url, String Uname, String Password) {
		Options=new ChromeOptions();
		Options.addArguments("--disable-notifications");
		driver=new ChromeDriver(Options);
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		driver.findElement(By.id("username")).sendKeys(Uname);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.id("Login")).click();
		
	}
	
@AfterMethod
public void postcondition() {

driver.close();



}
}
