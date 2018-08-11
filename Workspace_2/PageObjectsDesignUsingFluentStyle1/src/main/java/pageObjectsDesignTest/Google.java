package pageObjectsDesignTest;

import java.util.List;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Location("https://www.google.com")
public class Google {

    @Drone
    private WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnG")
    private WebElement searchbutton;

    @FindByJQuery(".rc")
    private List < WebElement > results;

    public void searchFor(String searchQuery) {

        //Search
        searchBox.sendKeys(searchQuery);

        //Graphene gurads the request and waits for the response
        Graphene.guardAjax(this.searchbutton).click();

        //Print the result count
        System.out.println("Result count:" + results.size());

    }
}