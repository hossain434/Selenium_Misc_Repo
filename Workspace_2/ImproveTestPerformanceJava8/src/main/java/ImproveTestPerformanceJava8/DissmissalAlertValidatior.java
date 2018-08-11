/*package ImproveTestPerformanceJava8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DissmissalAlertValidatior extends ElementValidator {

    private final WebElement dissmissalSection;

    public DissmissalAlertValidatior(final WebElement component){
        this.dissmissalSection = component;
    }

    @Override
    public boolean validate() {

        //all messages should be displayed first; the below result is true
        boolean result = this.dissmissalSection.findElements(By.cssSelector("button.close"))
                .stream()
                .allMatch(WebElement::isDisplayed);

        //close all the messages
        this.dissmissalSection.findElements(By.cssSelector("button.close"))
                .stream()
                .forEach(WebElement::click);

        //none of the messages should be displayed now
        result = result && this.dissmissalSection.findElements(By.cssSelector("button.close"))
                .stream()
                .noneMatch(WebElement::isDisplayed);

        return result;
    }
}*/