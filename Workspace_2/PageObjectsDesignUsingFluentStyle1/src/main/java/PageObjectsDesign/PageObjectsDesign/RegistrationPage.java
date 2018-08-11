package PageObjectsDesign.PageObjectsDesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	   public WebDriver driver; 

    @FindBy(name = "firstName")
    public WebElement firstName;

    @FindBy(name = "lastName")
    public WebElement lastName;

    @FindBy(name = "email")
    public WebElement userName;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(name = "confirmPassword")
    public WebElement confirmPassword;

    @FindBy(name = "register")
    public WebElement submit;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static RegistrationPage using(WebDriver driver) {
        return new RegistrationPage(driver);
    }

    public RegistrationPage launch() {
    	System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe"); 
    	 driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/mercuryregister.php");
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
        return this;
    }

    public RegistrationPage setUserName(String userName) {
        this.userName.sendKeys(userName);
        return this;
    }

    public RegistrationPage setPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public RegistrationPage setConfirmPassword(String confirmPassword) {
        this.confirmPassword.sendKeys(confirmPassword);
        return this;
    }

    public void submit() {
        this.submit.click();
    }
}