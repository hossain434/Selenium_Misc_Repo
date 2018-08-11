package Automate_JQueryUI_Sortable_Elements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class JQuerySortableElement {

    @FindByJQuery(".ui-sortable-handle")
    private List < WebElement > sortableHandles;

    private Map < String, WebElement > map = new HashMap < String, WebElement > ();

    @ArquillianResource
    private Actions action;

    public int getElementsCount() {
        return sortableHandles.size();
    }

    public void reorder(int from, int to) {
        this.reorder(sortableHandles.get(from),
                     sortableHandles.get(to));
    }

    public void reorder(String from, String to) {
        if (null != map) {
            map = sortableHandles.stream()
                .collect(Collectors.toMap(
                    ele - > ele.getText(), //key
                    ele - > ele //value
                ));
        }
        this.reorder(map.get(from),
                     map.get(to));
    }

    private void reorder(WebElement source, WebElement target) {
        action.clickAndHold(source)
            .moveToElement(target)
            .release()
            .build()
            .perform();
    }
}