package com.cs.Driver;

import static com.cs.ReadProperties.ReadProperties.prop;

import DriverFactory.DriverFactory;
import DriverManager.DriverManager;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class Driver {
    private Driver() {

    }

    public static WebDriver driver;

    public static void initDriver() {
        String browserName = prop.getProperty("browser");
        if (DriverManager.getDriver() == null) {
            driver = DriverFactory.getDriver(browserName);
            DriverManager.setDriver(driver); // parallel testing
        }
        driver.get(prop.getProperty("url"));
        if (prop.getProperty("maxwindow").equalsIgnoreCase("true"))
            DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("timeout"))));
    }

    public static void quitBrowser() {
        if (DriverManager.getDriver() != null) {

            DriverManager.getDriver().quit();
            DriverManager.setDriver(null);
        }
    }
}