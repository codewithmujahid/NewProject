package CommonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class CommonUtils {
	public static String path;
	public static String sheetName;
	
	 protected static WebDriver driver;
	    public static String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	public void Driver(String Browser) {
		
		switch(Browser.toLowerCase()) {
		case "chrome":
			ChromeOptions options =new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
		driver =new ChromeDriver();	
		break;
		case "firefox":
			driver =new FirefoxDriver();
			break;
		case "edge":
		 driver=new EdgeDriver();
		 break;
		}
		driver.manage().window().maximize();
	}
    public void ScreenShot(WebDriver driver, String Screenshotname,String TestCase) throws IOException {
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File(Excle.ExcleUtils.filepath2 + "/pass/" + Screenshotname + ".png" ));
		}
    
    public static String  excledata(String path, String sheetName, int rowno, int columno) throws IOException
    {
       FileInputStream f=new FileInputStream(path);
       XSSFWorkbook wb = new XSSFWorkbook(f);
       XSSFSheet sheet = wb.getSheet(sheetName);
      
      
       Row row = sheet.getRow(rowno);
       if (row == null) return ""; // Returns empty string if row doesn't exist
       
       Cell cell = row.getCell(columno);
       if (cell == null) return ""; // Returns empty string if cell doesn't exist
       
       DataFormatter formatter = new DataFormatter();
       String value = formatter.formatCellValue(cell);
   
       wb.close();
       f.close();
	   return value;
      
    }
   
    public static String getExcelData(int rowIndex, int colIndex, Sheet sheet) {
	    // Get the row at the specified index (0-based)
	    Row row = sheet.getRow(rowIndex);
	    
	    if (row != null) {  // If the row is not null
	        // Get the cell at the specified column index
	        Cell cell = row.getCell(colIndex);
	        
	        if (cell != null) {  // If the cell is not null
	            // Return the cell content as a string (use .toString() for general cases)
	            return cell.toString();
	        }
	    }
	    
	    // If row or cell is null, return an empty string or a default value
	    return "";
	}
    
    
    public static WebElement fluentWait(WebDriver driver, int totalTime, int pollingTime, WebElement element) {
        // 1. Initialize Fluent Wait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(totalTime))      
            .pollingEvery(Duration.ofSeconds(pollingTime))   
            .ignoring(NoSuchElementException.class);
   
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    
    public void Wait(int time) throws InterruptedException
    {
    	Thread.sleep(time);
    	
    	
    }
    
    public void scrolltoElement(WebDriver driver, WebElement element) {
   
    JavascriptExecutor js = (JavascriptExecutor) driver;

    // This will scroll the page until the element is in view
    js.executeScript("arguments[0].scrollIntoView(true);", element);
    
    }
    
    public void scrolldown(int a) {
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	// Scroll down by 1000 pixels
    
    	
    	
    }
    }
    	
    	
    
	
	
	
	


