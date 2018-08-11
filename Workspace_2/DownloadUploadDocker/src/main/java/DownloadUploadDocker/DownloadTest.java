package DownloadUploadDocker;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import org.awaitility.Awaitility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import DownloadUploadDocker.HerokuAppDownloadPage;

public class DownloadTest{
	private WebDriver driver;
	HerokuAppDownloadPage herokuAppDownloadPage;
	
	herokuAppDownloadPage = PageFactory.initElements(driver, HerokuAppDownloadPage.class);
	
@Test
public void downloadTest() {
	herokuAppDownloadPage.goTo();
	herokuAppDownloadPage.downloadFile();

    Path path = Paths.get("/home/vins/Downloads/some-file.txt");

    //this will wait until the file download is complete.
    Awaitility.await()
        .atMost(1, TimeUnit.MINUTES)
        .until(() -> {
            return path.toFile().exists();
        });


    Assert.assertTrue(path.toFile().exists());
}
}