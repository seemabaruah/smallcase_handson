package com.smallcase.automation.flipkart;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class FlipkartHomePage {
    private WebDriver webDriver;

    public FlipkartHomePage(WebDriver driver) {
        this.webDriver = driver;

    }

    public void closeSignInPopUp(WebDriver driver) {
        WebElement signInCross = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
        signInCross.click();
        Reporter.log("Sign In Window Closed.", true);
    }

    public void searchBox(String searchString) {
        WebElement searchBox = webDriver.findElement(By.xpath("//input[@name ='q' and @type='text']"));
        Assert.assertEquals(searchBox.isDisplayed(), true);
        Reporter.log("Search Box is displayed.", true);
        searchBox.sendKeys(searchString);

        webDriver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        WebElement resultTextDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='_10Ermr']")));
        Assert.assertEquals(resultTextDisplayed.isDisplayed(), true);
        Reporter.log("Search Box set with value :" + searchString + " and search results displayed", true);
    }

}
