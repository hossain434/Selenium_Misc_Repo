package PageObjectsDesign.PageObjectsDesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(name = "email")
    public WebElement userName;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(name = "login")
    public WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static LoginPage using(WebDriver driver) {
        return new LoginPage(driver);
    }

    public LoginPage setUsername(String username) {
        this.userName.sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public void login() {
        this.loginBtn.click();
    }

}