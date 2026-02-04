package OrangeHRMSS;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import CommonUtils.CommonUtils;
import Elements.LoginPage_element;


public class Create_Employe extends CommonUtils {  
	LoginPage_element elements;
	public static String sheetName = "EmployeDeatils";
	public static String path=Excle.ExcleUtils.filepath3+"//TestData.xlsx";

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		login lp=new login();
		lp.setup();
		lp.loginpage();
		elements =PageFactory.initElements(driver, LoginPage_element.class);
	}

	@Test
	public void Employedetails() throws InterruptedException, IOException {
        int rowCount = 1;
		for(int i=1; i<=rowCount; i++) {
         	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement PIM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='PIM']")));
			PIM.click();
			Thread.sleep(2000);
			elements.ADDEMP.click();
			Thread.sleep(3000);
			fluentWait(driver,4,2,elements.Name).sendKeys(excledata(path,sheetName,i,1));

			elements.middleName.sendKeys(excledata(path,sheetName,i,2));
			elements.lastName.sendKeys(excledata(path,sheetName,i,3));
			fluentWait(driver,4,2,elements.EmpID).clear();

			elements.EmpID.sendKeys(excledata(path,sheetName,i,4));
			Wait(2000);
			switch(excledata(path,sheetName,i,5)) {
		    case "Yes":
				fluentWait(driver,4,2,elements.radioButton).click();
			//	Wait(2000);
				WebElement USERNAME=driver.findElement(By.xpath("(//*[contains(@class,'oxd-input oxd-input--active')])[6]"));
				WebDriverWait S =new WebDriverWait(driver,Duration.ofSeconds(2000));
				S.until(ExpectedConditions.elementToBeClickable(USERNAME));
				
				
				fluentWait(driver,4,2,USERNAME).sendKeys(excledata(path,sheetName,i,6));
			       if(elements.Enable.isSelected()) {
			    	   
			    	   System.out.println("Enable the radio Button");
				}else {
					switch (excledata(path,sheetName,i,7)) {
					case "Yes":
						elements.Enable.click();
						break;
					case "No":
						elements.Disable.click();
						break;
					}
					
					
					
				}
                List <WebElement> RPassword= driver.findElements(By.xpath("//*[@type='password']"));
				RPassword.get(0).sendKeys(excledata(path,sheetName,i,8));
				RPassword.get(1).sendKeys(excledata(path,sheetName,i,8));
				Wait(1000);
                scrolltoElement(driver, elements.Save_button);
				switch(excledata(path,sheetName,i ,9)) {
				case"Yes": 
					elements.Save_button.click();
					break;
				case "No":
					elements.Cancle_Button.click();
					break;
				}
                if(elements.Save_button.isDisplayed()) {
                	ScreenShot(driver, "Craerte Employe", "TC-02");
				}
				else {
					System.out.println("Fail Screen shot");
				}
				break;
			case "No":
				switch(excledata(path,sheetName,i ,9)) {
				case"Yes": 
					elements.Save_button.click();
					break;
				case "No":
					elements.Cancle_Button.click();
					break;
				}

				if(elements.Save_button.isDisplayed()) {
					ScreenShot(driver, "Craerte Employe", "TC-02");
				}
				else {
					System.out.println("Fail Screen shot");
				}
                }  
		        break;
		        }
}

	//@AfterMethod
	public void close() {
		if (driver != null) {
			driver.quit();
		}

	}}





