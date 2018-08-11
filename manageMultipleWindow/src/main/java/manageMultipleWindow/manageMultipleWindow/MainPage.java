package manageMultipleWindow.manageMultipleWindow;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private final WebDriver driver;

    @FindBy(id = "pageA")
    private WebElement pageALink;

    @FindBy(id = "pageB")
    private WebElement pageBLink;

    @FindBy(id = "pageC")
    private WebElement pageCLink;


    public MainPage(final WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        this.driver.get("file:///home/vins/execute-around/main.html");
    }

    public void launchPageA(){
        this.pageALink.click();
    }

    public void launchPageB(){
        this.pageBLink.click();
    }

    public void launchPageC(){
        this.pageCLink.click();
    }
    @Target({
        TYPE
}) 
    @Retention(RUNTIME)
public @interface Window {
    String value() default "";
}


}


