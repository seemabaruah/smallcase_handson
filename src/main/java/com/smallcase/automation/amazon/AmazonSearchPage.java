package com.smallcase.automation.amazon;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class AmazonSearchPage {

    private WebDriver webDriver;

    public AmazonSearchPage(WebDriver driver) {
        this.webDriver = driver;
    }

    public void selectProduct() {

        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement product = webDriver.findElement(By.xpath("//span[contains(@class, 'a-size-medium a-color-base a-text-normal') and text() = 'Redmi 9 (Sky Blue, 4GB RAM, 64GB Storage)']"));
        product.click();
        Reporter.log("Product is selected", true);
    }
}
