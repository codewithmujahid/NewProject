package OrangeHRMSS;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

import CommonUtils.CommonUtils;

public class colour_font_posstin_validation extends CommonUtils {
	
	
	WebDriver driver;
	
	@Test
	public void clour() throws InterruptedException {
		driver=new ChromeDriver();
		 driver.manage().window().maximize();
			
		 driver.get("https://saucelabs.com/");
		 Thread.sleep(2000);
		
		WebElement element = driver.findElement(By.xpath("//*[text()='Try it free']"));
		
		
		
		
		String colour=element.getCssValue("color");
		String HXclour=Color.fromString(colour).asHex();
		
		assertEquals(HXclour, "#000000");
		
		
		
	}
	
	
	
	
	
	
	
	

}
