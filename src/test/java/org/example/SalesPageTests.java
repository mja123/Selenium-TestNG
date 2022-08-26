package org.example;

import org.example.components.header.EVarItems;
import org.example.pages.HomePage;
import org.example.pages.ProductPage;
import org.example.pages.SalesPage;
import org.example.utils.ElementNotFound;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SalesPageTests extends BaseTest {

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
