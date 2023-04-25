package assignmentWk5Day1;




import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




public class Checkalrtopp extends BaseclassOpp {
	@DataProvider(name="checking")
	public String[][] data() {
		String[][] keysSend=new String[1][1];
	 keysSend[0][0]="4/20/2023";
	return keysSend;
	
	
	
	}
	
@Test(dataProvider="checking")
	public void checkingAlert(String date) throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@data-key='chevrondown'][1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='slds-truncate']//span")).click();
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys(date);
				
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		Thread.sleep(2000);
		String namealrt=driver.findElement(By.xpath("//div[@part='help-text']")).getText();
		WebElement verifyname=driver.findElement(By.xpath("//div[@part='help-text']"));
		boolean isvisible=verifyname.isDisplayed();
		System.out.println(isvisible+", It throws an alert in Opportunity name as "+namealrt);
		
		
		String stagealrt = driver.findElement(By.xpath("(//div[text()='Complete this field.'])[2]")).getText();
		WebElement verifystage=driver.findElement(By.xpath("(//div[text()='Complete this field.'])[2]"));
		boolean isvisiblestg=verifystage.isDisplayed();
		System.out.println(isvisiblestg+", It throws an alert in Stage as "+stagealrt);
		driver.findElement(By.xpath("//button[@title='Close this window']")).click();


	}

}
