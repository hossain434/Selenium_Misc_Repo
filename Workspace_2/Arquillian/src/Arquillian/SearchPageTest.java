package Arquillian;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.testng.Arquillian;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@RunAsClient
public class SearchPageTest extends Arquillian {

    @Page
    SearchPage google;

    @Test(dataProvider = "search-keywords")
    public void googleTest(String searchKeyword) {
        google.goTo();
        google.searchFor(searchKeyword);
        Assert.assertTrue(google.getResults().size()>0);
    }
   
    @DataProvider(name = "search-keywords")
    public static Object[][] credentials() {
          return new Object[][] {
              { "test automation guru" },
              { "selenium webdriver" },
              { "dockerized selenium grid" },
              { "test automation blog" },
              { "jmeter docker" } ,
              { "test automation guru" },
              { "selenium webdriver" },
              { "dockerized selenium grid" },
              { "test automation blog" },
              { "jmeter docker" }               
          };
    }

}