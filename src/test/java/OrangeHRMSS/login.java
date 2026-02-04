package OrangeHRMSS;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import CommonUtils.CommonUtils;
import Elements.LoginPage_element;


public class login extends CommonUtils{
    LoginPage_element elements;
	public static String sheetName = "TestData";
	public static String path=Excle.ExcleUtils.filepath3+"//TestData.xlsx";

	@BeforeMethod
	public void setup() throws InterruptedException {
		Driver("Chrome");
		
		driver.get(URL);
		Wait(5000);
		elements =PageFactory.initElements(driver, LoginPage_element.class);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	                    }
	@Test
	public  void loginpage() throws IOException, InterruptedException {
	
		elements.UserName.sendKeys(excledata(path, sheetName, 1 , 0));
		elements.Password.sendKeys(excledata(path, sheetName, 1 , 1));
		elements.Login.click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOf(elements.dashbord_logo));
		if(elements.dashbord_logo.isDisplayed()) {
			ScreenShot(driver, "Dashborddisplay", "TC_01");
		}else {

     	System.out.println("TC_01 Fail");
		}
	}
	@AfterMethod
	public void close() {
		if (driver != null) {
            driver.quit();
        }

	}

}
