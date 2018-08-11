package PageObjectsDesign.PageObjectsDesign;
import org.openqa.selenium.WebDriver;

import PageObjectsDesign.PageObjectsDesign.LoginPage;
import PageObjectsDesign.PageObjectsDesign.RegistrationPage;
public class fluentStyleProcess {
	public static WebDriver driver;
	public static void main(String args[]) {
	
	RegistrationPage.using(driver)
    .launch()
    //.setFirstName("fn")
    //.setLastName("ln")
    .setUserName("abcd")
    .setPassword("abcd")
    .setConfirmPassword("abcd")
    .submit();

LoginPage.using(driver)
     .setUsername("abcd")
     .setPassword("abcd")
     .login();

}
}
