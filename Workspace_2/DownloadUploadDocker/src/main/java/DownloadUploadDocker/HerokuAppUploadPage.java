package DownloadUploadDocker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HerokuAppUploadPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id="file-upload")
    private WebElement fileUpload;

    @FindBy(id="file-submit")
    private WebElement uploadBtn;

    @FindBy(id="uploaded-files")
    private WebElement uploadedFileName;

    public HerokuAppUploadPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 30);
    }

    public void goTo() {
        this.driver.get("http://the-internet.herokuapp.com/upload");
    }

    public void uploadFile(String path){
        if(driver instanceof RemoteWebDriver){
            ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
        }
        this.fileUpload.sendKeys(path);
        this.uploadBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploaded-files")));
    }

    //once the upload is success, get the name of the file uploaded
    public String getUploadedFileName(){
        return this.uploadedFileName.getText().trim();
    }
}