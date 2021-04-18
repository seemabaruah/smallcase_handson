package com.smallcase.automation.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class AmazonProductPage {
    private WebDriver webDriver;

    public AmazonProductPage(WebDriver driver) {
        this.webDriver = driver;
    }


    public void printPrice() {
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.numberOfWindowsToBe(4));
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        System.out.println("Switch to new tab");
        webDriver.switchTo().window(tabs.get(3));
        WebElement price = webDriver.findElement(By.id("priceblock_ourprice"));
        String priceFirst = price.getText();
        Reporter.log("Price of the product:" + priceFirst, true);
    }

    public void addToCart() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement addtoCart = webDriver.findElement(By.id("add-to-cart-button"));
        addtoCart.click();
        Reporter.log("Product is added to the cart:", true);
    }
}
