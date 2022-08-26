package org.example;

import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.lang.invoke.MethodHandles;

import static org.testng.Assert.assertEquals;

public abstract class BaseTest {
    protected static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    protected WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "rcs/chromedriver-mac");
        driver = new ChromeDriver();
        driver.get("https://www.mercadolibre.com.ar/");
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
