package Automate_JQueryUI_Sortable_Elements;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.testng.Arquillian;
import org.testng.Assert;
import org.testng.annotations.Test;

@RunAsClient
public class JQueryUIPageTest extends Arquillian {

    @Page
    private JQueryUIPage sortablePage;

    @Test(priority = 1)
    public void goTo() {
        sortablePage.goTo();
    }

    @Test(priority = 2)
    public void verifyCount() {
        Assert.assertEquals(7, sortablePage.getSortables().getElementsCount());
    }

    @Test(priority = 3)
    public void moveByIndex() {
        sortablePage.getSortables().reorder(1, 2);
    }


    @Test(priority = 4)
    public void moveByText() {
        sortablePage.getSortables().reorder("Item 1", "Item 7");
    }
}