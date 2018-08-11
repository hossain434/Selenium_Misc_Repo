package inject_Page_Object_Using_Guice_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.inject.Inject;

public class GoogleSearchWidget {

    @FindBy(name = "q")
    WebElement searchBox;

    @FindBy(name = "btnG")
    WebElement searchButton;

    @Inject
    public GoogleSearchWidget(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchFor(String txt) {
        searchBox.sendKeys(txt);
        searchButton.click();
    }

}