package Automate_JQueryUI_Sortable_Elements;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.InFrame;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class JQueryUIPage {

    @Drone
    private WebDriver driver;

    @FindBy(id = "sortable")
    @InFrame(index = 0)
    private JQuerySortableElement sortable;

    public void goTo() {
        driver.get("https://jqueryui.com/sortable/");
    }

    public JQuerySortableElement getSortables() {
        return sortable;
    }

}