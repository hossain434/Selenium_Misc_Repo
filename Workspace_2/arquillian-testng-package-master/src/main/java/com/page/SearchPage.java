package com.page;

import java.util.List;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {

    @Drone
    private WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(css = "input.lsb")
    private WebElement searchButton;

    @FindBy(className = "rc")
    private List<WebElement> searchResults;

    @FindBy(id = "foot")
    private WebElement footer;

    public void goTo() {
        this.driver.get("https://www.google.com");
        System.out.println("Browser launched and navigated to Google");
    }

    public void searchFor(String text) {
        this.searchBox.sendKeys(text);
        System.out.println(text + " - entered for search");
        
        Graphene.waitGui().until().element(this.searchButton).is().clickable();

        System.out.println("Search button clicked");
        this.searchButton.click();
        
        Graphene.waitModel().until().element(By.className("rc")).is().visible();
        System.out.println("Results appeared");
    }

    public List<WebElement> getResults() {
        System.out.println("Results Count : " + this.searchResults.size());
        System.out.println("---------------------------------------------");
        return this.searchResults;
    }

}