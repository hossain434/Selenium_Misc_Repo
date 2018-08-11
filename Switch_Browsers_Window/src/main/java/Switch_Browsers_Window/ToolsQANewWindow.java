package Switch_Browsers_Window;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.inject.Inject;


@Window(1)
public class ToolsQANewWindow {

    private final WebDriver driver;
/*    @FindBy(id = "button1")
    private WebElement newWindow;
*/
    @Inject
    public ToolsQANewWindow(WebDriver driver) {
        this.driver = driver;
    }
    
/*    public void launchWindow() {
        this.newWindow.click();
    }
*/
    public String getTitle() {
        return driver.getTitle();
    }
}