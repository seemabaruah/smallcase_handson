package com.smallcase.automation;

import com.smallcase.automation.amazon.AmazonCart;
import com.smallcase.automation.amazon.AmazonHomePage;
import com.smallcase.automation.amazon.AmazonProductPage;
import com.smallcase.automation.amazon.AmazonSearchPage;
import com.smallcase.automation.common.Driver;
import com.smallcase.automation.flipkart.FlipkartCart;
import com.smallcase.automation.flipkart.FlipkartHomePage;
import com.smallcase.automation.flipkart.FlipkartProductPage;
import com.smallcase.automation.flipkart.FlipkartSearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static com.smallcase.automation.common.MathUtils.convertStringToFloat;

public class UiTestCases {
    @Test
    public void scenarioOne() {
        Driver driver = new Driver();
        WebDriver webDriver = driver.launchBrowser("https://www.flipkart.com");
        FlipkartHomePage homePage = new FlipkartHomePage(webDriver);
        FlipkartSearchPage searchPage = new FlipkartSearchPage(webDriver);
        FlipkartCart cartPage = new FlipkartCart(webDriver);
        FlipkartProductPage productPage = new FlipkartProductPage(webDriver);
        homePage.closeSignInPopUp(webDriver);
        homePage.searchBox("redmi");
        searchPage.selectFirstProduct();
        productPage.printPrice();
        productPage.addToCart();
        cartPage.increaseQuantity();
        cartPage.printPrice();
        driver.closeBrowser();

    }

    @Test
    public void scenarioTwo() {
        Driver driver = new Driver();
        WebDriver webDriver = driver.launchBrowser("https://www.flipkart.com");
        FlipkartHomePage homePage = new FlipkartHomePage(webDriver);
        FlipkartSearchPage searchPage = new FlipkartSearchPage(webDriver);
        FlipkartCart cartPage = new FlipkartCart(webDriver);
        FlipkartProductPage productPage = new FlipkartProductPage(webDriver);
        homePage.closeSignInPopUp(webDriver);
        homePage.searchBox("Redmi 9 Sky Blue 64 GB  4 GB RAM");
        searchPage.selectFirstProduct();
        productPage.printPrice();
        productPage.addToCart();
        String flipkartPrice = cartPage.printPrice();

        AmazonHomePage amazonHomePage = new AmazonHomePage(webDriver);
        AmazonSearchPage amazonSearchPage = new AmazonSearchPage(webDriver);
        AmazonCart addToCartAmazon = new AmazonCart(webDriver);
        AmazonProductPage amProductPage = new AmazonProductPage(webDriver);
        driver.openNewTab("https://amazon.in/");
        amazonHomePage.searchProduct("Redmi 9 Sky Blue 64 GB  4 GB RAM");
        amazonSearchPage.selectProduct();
        amProductPage.printPrice();
        amProductPage.addToCart();
        String amazonPrice = addToCartAmazon.printPrice();
        comparePrice(flipkartPrice, amazonPrice);
        driver.closeBrowser();

    }

    public void comparePrice(String priceFlipkart, String priceAmazon) {
        System.out.println("Print the Price, Amazon - " + priceAmazon);
        System.out.println("Print the Price, Flipkart - " + priceFlipkart);

        Float flipkartPrice = convertStringToFloat(priceFlipkart);
        Float amazonPrice = convertStringToFloat(priceAmazon);
        if (flipkartPrice > amazonPrice) {
            System.out.println("Product is Cheaper in Amazon - " + amazonPrice);
        } else if (flipkartPrice < amazonPrice) {
            System.out.println("Product is Cheaper in Flipkart - " + flipkartPrice);
        } else {
            System.out.println("Product have same price in Both Sites.");
        }
    }
}
