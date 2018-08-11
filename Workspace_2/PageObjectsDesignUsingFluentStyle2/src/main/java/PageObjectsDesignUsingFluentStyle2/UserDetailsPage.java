package PageObjectsDesignUsingFluentStyle2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDetailsPage extends Page{
	private WebDriver driver;

    @FindBy(name = "email")
    public WebElement userName;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(name = "register")
    public WebElement loginBtn;

    public UserDetailsPage() {
        PageFactory.initElements(driver, this);
    }

/*    public static UserDetailsPage using(WebDriver driver) {
        return new UserDetailsPage(driver);
    }*/
    public UserDetailsPage launch() {
    	System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe"); 
    	 this.driver = new ChromeDriver();
        this.driver.get("http://newtours.demoaut.com/mercuryregister.php");
        return this;
    }

    public UserDetailsPage setUsername(String userName) {
        this.userName.sendKeys(userName);
        System.out.println("entering username");
        return this;
    }

    public UserDetailsPage setpassword(String password) {
        this.password.sendKeys(password);
        System.out.println("entering password");
        return this;
    }

    public void login() {
        this.loginBtn.click();
    }
    
    @Override
    public boolean isAt() {
        return true;
    }

}