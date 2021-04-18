package com.smallcase.automation.flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class FlipkartCart {
    private WebDriver webDriver;

    public FlipkartCart(WebDriver driver) {
        this.webDriver = driver;

    }

    public void increaseQuantity() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_23FHuj")));
        WebElement quantity = webDriver.findElement(By.xpath("//button[text()='+']"));
        quantity.click();
        Reporter.log("Quantity increased by 1:", true);
    }

    public String printPrice() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Reporter.log("Exception :" + e, true);
        }
        WebElement finalPrice = webDriver.findElement(By.xpath(("//span[@class='_2-ut7f _1WpvJ7']")));
        String priceFlipkart = finalPrice.getAttribute("textContent");

        System.out.println("Final Price at Flipkart:" + priceFlipkart);
        return priceFlipkart;
    }
}
