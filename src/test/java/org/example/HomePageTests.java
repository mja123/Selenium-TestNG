package org.example;

import org.example.components.header.EVarItems;
import org.example.pages.HomePage;
import org.example.pages.SalesPage;
import org.example.utils.ElementNotFound;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HomePageTests extends BaseTest {
    WebDriver driver = null;
    @Test(groups = { "smoke", "product"})
    public void clickHeaderItem() throws ElementNotFound {
        HomePage homePage = new HomePage(driver);
        SalesPage salesPage = (SalesPage) homePage.getHeader().navItem(EVarItems.SALES);

        assertEquals(driver.getCurrentUrl(), "https://www.mercadolibre.com.ar/ofertas#nav-header");
    }

    @Test(groups = { "smoke" })
    public void tempPracticeTest() throws ElementNotFound {
        assertTrue(true);
    }
}
