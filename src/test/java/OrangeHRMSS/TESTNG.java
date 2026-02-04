package OrangeHRMSS;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class TESTNG {
	
	WebDriver driver =new FirefoxDriver();
	
	public void Xass() throws InterruptedException {
		driver.manage().window().maximize();
		
		 driver.get("https://saucelabs.com/");
		 Thread.sleep(2000);
		
		WebElement element = driver.findElement(By.xpath("//*[text()='Try it free']"));
		
		
		
		
		String colour=element.getCssValue("color");
		String HXclour=Color.fromString(colour).asHex();
		
		assertEquals(HXclour, "#000000");
		
		
		
	}

}
