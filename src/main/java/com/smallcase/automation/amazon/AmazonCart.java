package com.smallcase.automation.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class AmazonCart {
    private WebDriver webDriver;

    public AmazonCart(WebDriver driver) {
        this.webDriver = driver;
    }


    public String printPrice() {
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement goToCart = webDriver.findElement(By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input"));
        goToCart.click();

        WebElement amazonPrice = webDriver.findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']"));

        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String priceAmazon = amazonPrice.getAttribute("textContent");

        System.out.println("Final Price at Amazon:" + priceAmazon);
        return priceAmazon;
    }
}

