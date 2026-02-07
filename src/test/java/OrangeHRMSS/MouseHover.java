package OrangeHRMSS;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonUtils.CommonUtils;

public class MouseHover extends CommonUtils {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup(){
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		
	}
	@Test
	public void mousehover() throws InterruptedException {
		
	
		Thread.sleep(2000);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement a=driver.findElement(By.xpath("//*[contains(text(),'Valentine Day Sale')]"));
		js.executeScript("arguments[0].scrollIntoView();", a);
		
		
	Actions ac= new Actions(driver);
	ac.moveToElement(a).perform();
	
		System.out.println(a.getText());
		
		
	}
	

}
