package Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_element {
	WebDriver driver;
	@FindBy(how=How.NAME,using="username")
	public WebElement UserName;
	
	@FindBy(how=How.NAME,using="password")
	public WebElement Password;
	
	@FindBy(how=How.XPATH,using="//*[@type='submit']")
	public WebElement Login;
	
	
	@FindBy(how=How.XPATH,using="//*[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
	public WebElement dashbord_logo;
	
	@FindBy(how=How.XPATH,using="//*[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	public WebElement ADDEMP;
	
	@FindBy(how=How.NAME,using = "firstName")
     public WebElement Name;
	@FindBy(how=How.NAME,using = "middleName")
    public WebElement middleName;
	@FindBy(how=How.NAME,using = "lastName")
    public WebElement lastName;
	
	@FindBy(how=How.XPATH,using="(//*[@class='oxd-input oxd-input--active'])[2]")
	public WebElement EmpID;
	
   @FindBy(how=How.XPATH,using="//*[@class='oxd-switch-input oxd-switch-input--active --label-right']")
   public WebElement radioButton;
   
   
   @FindBy(how=How.XPATH,using="(//*[@class='oxd-input oxd-input--active oxd-input--error'])[2]")
   public WebElement Username;
   
   
 
   
	
	
	@FindBy(how=How.XPATH,using="//*[text()='Enabled']")
	public WebElement Enable;
	
	@FindBy(how=How.XPATH,using="//*[text()='Disable']")
	public WebElement Disable;
	@FindBy(how=How.XPATH,using="//*[text()=' Save ']")
	public WebElement Save_button;
	 @FindBy (how=How.XPATH,using="//*[text()=' Cancel ']")
	public WebElement Cancle_Button;
	
	
	
	
	
	
    
    
    
    
    
    
    
    
   
	
	
	public LoginPage_element(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	
	
	
	
	
	

}
