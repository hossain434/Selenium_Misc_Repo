package testng_design_test.testng_design_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.awaitility.Awaitility.*;

public abstract class Page {
    private TimeUnit timeunit;
	private WebDriver driver;

	public abstract boolean isAt();
    
    public boolean isAt(long timeout, TimeUnit timeunt){
        try{
            await().atMost(timeout, timeunit)
                   .ignoreExceptions()
                   .until(() -> isAt());
            return true;        
        }catch(Exception e){
            return false;
        }
    }
}