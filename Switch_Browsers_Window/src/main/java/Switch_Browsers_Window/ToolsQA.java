package Switch_Browsers_Window;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.inject.Inject;

public class ToolsQA {

    private final WebDriver driver;

    @FindBy(css = "[onclick=\"newMsgWin\\(\\)\"]")
    private WebElement newWindow;

    @Inject
    public ToolsQA(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


	public void goTo() {
    			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
    			WebDriver driver = new ChromeDriver();
        this.driver.get("http://toolsqa.com/automation-practice-switch-windows/");
    }

    public void launchWindow() {
        this.newWindow.click();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}