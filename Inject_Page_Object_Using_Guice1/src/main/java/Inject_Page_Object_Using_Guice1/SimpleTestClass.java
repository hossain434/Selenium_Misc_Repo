package Inject_Page_Object_Using_Guice1;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;
 
import javax.inject.Inject;
 
@Guice(modules = WebDriverModule.class)
@Test
public class SimpleTestClass {
 
    private RemoteWebDriver driver;
 
    @Inject
    public SimpleTestClass(WebDriverProducer producer) {
        driver = producer.newInstance();
    }
 
    public void testMethod() {
        driver.get("http://the-internet.herokuapp.com/");
        Assert.assertEquals("The Internet", driver.getTitle());
    }
 
    @AfterClass
    public void cleanup() {
        driver.quit();
    }
}