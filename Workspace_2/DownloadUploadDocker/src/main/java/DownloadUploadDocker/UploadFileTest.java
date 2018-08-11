package DownloadUploadDocker;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadFileTest extends BaseTest {
	private WebDriver driver;

    private HerokuAppUploadPage herokuAppPage;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        super.setUp();
        herokuAppPage = new HerokuAppUploadPage(driver);
    }

    @Test
    public void uploadTest() throws InterruptedException {
        herokuAppPage.goTo();
        herokuAppPage.uploadFile("/home/qa/Downloads/sample.xlsx");
        Assert.assertEquals("sample.xlsx", herokuAppPage.getUploadedFileName());
    }

}
