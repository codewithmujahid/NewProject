package OrangeHRMSS;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import CommonUtils.CommonUtils;

public class Dropdown_list extends CommonUtils {
      WebDriver driver;
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {

//		login a=new login();
//		a.setup();
//		a.loginpage();
		
		driver =new ChromeDriver();
		
		driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
		driver.manage().window().maximize();
	}
	@Test
	public void dropdown() {
		WebElement SS=driver.findElement(By.xpath("(//*[@class='et_pb_blurb_description'])[7]"));
		Actions ac=new Actions(driver);
		ac.scrollToElement(SS).perform();
		
		
		Select sc=new Select(SS);
		List<WebElement> LW=sc.getOptions();

		System.out.println(LW.size());


		for(WebElement FR:LW) {
			;
			System.out.println(	FR.getText());




		}













	}
}
