package chimpPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Waitforanelement {
	 
	public void waitForElement(WebDriver driver,By strWebelement)
	{
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			    .withTimeout(1000, TimeUnit.SECONDS)
			    .pollingEvery(5, TimeUnit.SECONDS)
			    .ignoring(NoSuchElementException.class);
		WebElement waitFortheElement = wait.until(new Function<WebDriver, WebElement>() 
		{
		  public WebElement apply(WebDriver driver) {
		  return driver.findElement(strWebelement);
		}
		});
		System.out.println(waitFortheElement.toString());
	}

	public WebElement waitForanElementtobeclickable(WebDriver driver,By strWebelement){
		WebElement element = (new WebDriverWait(driver, 10))
		               .until(ExpectedConditions.elementToBeClickable(strWebelement));
		
		return element;
		
		
	}
}
