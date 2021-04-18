package com.smallcase.automation.flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class FlipkartProductPage {
    private WebDriver webDriver;

    public FlipkartProductPage(WebDriver driver) {
        this.webDriver = driver;

    }

    public void printPrice() {
        String newWindow = webDriver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String windowHandle : webDriver.getWindowHandles()) {
            if (!newWindow.contentEquals(windowHandle)) {
                webDriver.switchTo().window(windowHandle);
                break;
            }
        }

        WebElement priceFlipkart = webDriver.findElement(By.xpath("//div[@class='_30jeq3 _16Jk6d']"));
        String priceFirst = priceFlipkart.getText();
        Reporter.log("Price of the first product:" + priceFirst, true);
    }

    public void addToCart() {
        webDriver.manage().window().fullscreen();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement addToCart = webDriver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
        addToCart.click();
        Reporter.log("Product is added to the cart:", true);
    }
}
