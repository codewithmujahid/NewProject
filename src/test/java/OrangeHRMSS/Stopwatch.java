package OrangeHRMSS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Stopwatch {
	
	WebDriver driver;
	@Test
	public void stopwatch() throws InterruptedException {
		
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.timeanddate.com/stopwatch/");		
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,150)", "");
		driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
		String a=driver.findElement(By.xpath("//*[@class='duration-time-display stopwatch__duration']")).getText();
		System.out.println(a);
		
		driver.quit();
		
	}
	

}
