package com.smallcase.automation.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class AmazonHomePage {
    private WebDriver webDriver;

    public AmazonHomePage(WebDriver driver) {
        this.webDriver = driver;
    }

    public void searchProduct(String searchString) {
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement searchBar = webDriver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertEquals(searchBar.isDisplayed(), true);
        Reporter.log("Search Box is displayed.", true);
        searchBar.sendKeys(searchString);

        WebElement searchButton = webDriver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        WebElement resultTextDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")));
        Assert.assertEquals(resultTextDisplayed.isDisplayed(), true);
        Reporter.log("Search Box set with value :" + searchString + " and search results displayed", true);
    }


}




