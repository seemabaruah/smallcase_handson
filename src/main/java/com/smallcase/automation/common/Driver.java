package com.smallcase.automation.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

import java.util.ArrayList;

public class Driver {

    private WebDriver webDriver;

    public WebDriver launchBrowser(String appURL) {

        String browserType = System.getProperty("chrome");
        if ("chrome".equals(browserType)) {
            webDriver = initChromeDriver(appURL);
        } else if ("firefox".equals(browserType)) {
            webDriver = initFirefoxDriver(appURL);
        } else if ("IE".equals(browserType)) {
            webDriver = initIEDriver(appURL);
        } else {
            System.out.println(("browser : " + browserType + " is invalid, Launching Chrome as browser of choice.."));
            webDriver = initChromeDriver(appURL);
        }
        return webDriver;
    }

    private WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching google chrome with new profile..");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(appURL);
        return driver;
    }

    private WebDriver initFirefoxDriver(String appURL) {
        System.out.println("Launching Firefox browser..");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to(appURL);
        return driver;
    }

    private WebDriver initIEDriver(String appURL) {
        System.out.println("Launching IE browser..");
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        driver.navigate().to(appURL);
        return driver;
    }
    public void openNewTab(String url) {
        ((JavascriptExecutor) webDriver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(2));
        webDriver.get(url);
        Reporter.log(url + " open in a new tab", true);
    }

    public void closeBrowser() {
        webDriver.quit();
    }

}



