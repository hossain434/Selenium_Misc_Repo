package ImproveTestPerformanceJava8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NotificationParallelTest {


	private WebDriver driver;
    //private SamplePage samplePage;
    private  WebElement button;
    private  WebElement notification;

    @BeforeTest
    public void init(){
        //this.samplePage = new SamplePage(driver);
    	SamplePage samplePage = PageFactory.initElements(driver, SamplePage.class);
        samplePage.goTo();
    
       
    }

    @Test
    public void test(){

/*		NotificationValidator notificationValidator = new NotificationValidator(button, notification);
        this.samplePage.getElementValidators()  //list of element validators
                .stream()                       //iterate
                .parallel()                 //
                .map(ElementValidator::validate)//call the validate method
                .forEach(Assert::assertTrue);   //result should be true
        */

   SamplePage samplePage = PageFactory.initElements(driver, SamplePage.class);
   samplePage.ClickButton();
   
}
/*    
    @AfterTest
    public void tearDown(){
    driver.quit();
    }*/

}