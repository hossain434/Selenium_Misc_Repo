package DownloadUploadDocker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppDownloadPage {
    
    private final WebDriver driver;

    @FindBy(linkText="some-file.txt")
    private WebElement downloadFile;

    public HerokuAppDownloadPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("http://the-internet.herokuapp.com/download");
    }

    public void downloadFile(){
        //this will download file into the /home/seluser/Downloads directory
        this.downloadFile.click();
    }

}