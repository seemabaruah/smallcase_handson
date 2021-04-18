package com.smallcase.automation.flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;


public class FlipkartSearchPage {

    private WebDriver webDriver;

    public FlipkartSearchPage(WebDriver driver) {
        this.webDriver = driver;
    }

    public String selectFirstProduct() {
        assert webDriver.getWindowHandles().size() == 1;
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement firstProduct = webDriver.findElement(By.xpath("//div[@class='_4rR01T']"));
        firstProduct.click();
        return firstProduct.getText();
    }

}
