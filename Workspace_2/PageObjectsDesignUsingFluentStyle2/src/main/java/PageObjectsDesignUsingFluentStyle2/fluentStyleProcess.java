package PageObjectsDesignUsingFluentStyle2;
import org.openqa.selenium.WebDriver;

public class fluentStyleProcess {
	public static WebDriver driver;
	public static void main(String args[]) {
	
		RegistrationWorkflow.userDetailsPage(u -> {
			u.launch();
		    u.setUsername("arf");
		    u.setpassword("arf");
		    u.login();
		}).productSearchPage(p -> {
		    p.search();
		    p.choose();
		}).orderSummaryPage(o -> {
		    o.enterCC();
		    o.enterBillingAddress();
		}).orderConfirmationPage(o -> {
		    o.verify();
		    o.print();
		});

}
}