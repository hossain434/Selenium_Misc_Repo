package MultiFactorAuth_SMS;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SMSTest {

    private WebDriver driver;
    //private LoginPage page;
    private SMSUtil sms;
    private final String fromPhoneNumber = "1234567"; //this is the number your application uses

    @BeforeTest
    public void setup(){
       // driver = DriverManager.getDriver();
       // page = new LoginPage(driver);
        sms = new SMSUtil();
    }


    @Test
    public void smsTest(){
        //get a phone number
        String phoneNumber = sms.getNumber();

        //use the number in the application
       // page.setNumber(phoneNumber);
        //clean all the existing messages if any
        sms.deleteMessages();

       // page.login("username", "password");
        //if the page is asking for SMS code
       // if(page.isMFArequired()){
        	String code = sms.getMessage(phoneNumber, fromPhoneNumber);
        }
    }

