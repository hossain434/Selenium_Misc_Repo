package ImproveTestPerformanceJava8;

import java.util.concurrent.TimeUnit;

import org.awaitility.Awaitility;
import org.openqa.selenium.WebElement;

public class NotificationValidator extends ElementValidator {

    private final WebElement button;
    private final WebElement notification;

    public NotificationValidator(final WebElement button, final WebElement notification){
        this.button = button;
        this.notification = notification;
    }

    @Override
    public boolean validate() {
        button.click();
        boolean result = notification.isDisplayed();

        Awaitility.await()
                .atMost(5, TimeUnit.SECONDS)
                .until(() -> !this.notification.isDisplayed());
        
        return result && (!this.notification.isDisplayed());
    }
    
}