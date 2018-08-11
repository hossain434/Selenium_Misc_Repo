package Inject_Page_Object_Using_Guice1;
import org.openqa.selenium.remote.RemoteWebDriver;

public interface WebDriverProducer {
    RemoteWebDriver newInstance();
}
