package ImproveTestPerformanceJava8;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SamplePage {
	private  WebDriverWait wait;

    private  WebDriver driver;

    @FindBy(how=How.CSS, using="div.button-box button.btn-info")
    private WebElement btnInfo;

    @FindBy(css="div.button-box button.btn-warning")
    private WebElement btnWarning;

    @FindBy(css="div.button-box button.btn-success")
    private WebElement btnSuccess;

    @FindBy(css="div.button-box button.btn-danger")
    private WebElement btnDanger;

    @FindBy(how=How.CSS, using="div.jq-icon-info")
    private WebElement infoAlert;

    @FindBy(css="div.jq-icon-warning")
    private WebElement warningAlert;

    @FindBy(css="div.jq-icon-success")
    private WebElement successAlert;

    @FindBy(css="div.jq-icon-error")
    private WebElement dangerAlert;
    
/*    @FindBy(css="div.col-lg-4:nth-child(2)")
    private WebElement dissmissalSection;

    @FindBy(css="div.col-lg-4:nth-child(3)")
    private WebElement alertWithImageIcon;*/
    
/*    public SamplePage(final WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }*/

    public void goTo(){
    	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.get("https://wrappixel.com/demos/admin-templates/admin-pro/main/ui-notification.html");
    }

/*    public List<ElementValidator> getElementValidators(){
        List<ElementValidator> elements = new ArrayList();
        elements.add(new NotificationValidator(btnInfo, infoAlert));
        elements.add(new NotificationValidator(btnWarning,warningAlert));
        elements.add(new NotificationValidator(btnSuccess, successAlert));
        elements.add(new NotificationValidator(btnDanger, dangerAlert));
        //elements.add(new DissmissalAlertValidatior(dissmissalSection));
        //elements.add(new DissmissalAlertValidatior(alertWithImageIcon));
        return elements;
    }*/
    
	   public void SamplePageWait() {
	        PageFactory.initElements(driver, this);
	        this.wait = new WebDriverWait(driver, 30);
	    }

	// Define Login Button Click Method
	public void ClickButton() {
		wait.until(ExpectedConditions.elementToBeClickable(this.btnInfo));
		btnInfo.click();

}
}