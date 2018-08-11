package manageMultipleWindow.manageMultipleWindow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;

public class DriverUtil {

    public static void switchToWindow(WebDriver driver, int index) {
        String handle = driver.getWindowHandles().toArray(new String[0])[index];
        driver.switchTo().window(handle);
    }

    public static void switchToWindow(WebDriver driver, Class<?> clazz) {
        String title = clazz.getAnnotation(Window.class).value();
        switchToWindow(driver, title);
    }

    private static void switchToWindow(final WebDriver driver, final String title){
        driver.getWindowHandles()
                .stream()
                .map(h -> driver.switchTo().window(h).getTitle())
                .filter(title::contains)
                .findFirst()
                .orElseThrow(() -> {
                    throw new RuntimeException("No Such Window");
                });
    }

}

@Window("Page A")
public class PageA {

    private final WebDriver driver;

    @FindBy(name="fn")
    private WebElement fn;

    @FindBy(name="ln")
    private WebElement ln;

    @FindBy(name="addr")
    private WebElement addr;

    public PageA(final WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //execute around method pattern
    public void onNewWindow(Consumer<PageA> consumer){
        DriverUtil.switchToWindow(driver, this.getClass());
        consumer.accept(this);
        DriverUtil.switchToWindow(driver, 0);
    }

    public void setFn(String val){
        fn.sendKeys(val);
    }

    public void setLn(String val){
        ln.sendKeys(val);
    }

    public void setAddr(String val){
        addr.sendKeys(val);
    }

}

