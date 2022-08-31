package org.example;

import org.example.components.header.EVarItems;
import org.example.pages.HomePage;
import org.example.pages.ProductPage;
import org.example.pages.SalesPage;
import org.example.utils.ElementNotFound;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.*;

public class SalesPageTests extends BaseTest {
    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setUp(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (browser) {
            case "chrome" -> capabilities.setBrowserName("chrome");
            case "firefox" -> capabilities.setBrowserName("firefox");
            case "edge" -> capabilities.setBrowserName("edge");
            default -> capabilities.setBrowserName("opera");
        }
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        System.out.println(driver + " asdfasdf");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
    @Test(groups = "product")
    public void selectProductByIndex() throws ElementNotFound {
        HomePage homePage = new HomePage(driver);

        SalesPage salesPage = (SalesPage) homePage.getHeader().navItem(EVarItems.SALES);
        ProductPage productPage = salesPage.selectProduct(0);
        assertEquals(productPage.availableCountOfDues(), 3);
    }

    @Test(groups = {"product", "sadf"})
    public void  compareTotalPrices() throws ElementNotFound {
        HomePage homePage = new HomePage(driver);

        SalesPage salesPage = (SalesPage) homePage.getHeader().navItem(EVarItems.SALES);
        ProductPage productPage = salesPage.selectProduct(0);
        assertTrue(productPage.totalPriceWithDues() > productPage.getPrice());
    }
}
