package org.example;

import org.example.components.header.EVarItems;
import org.example.pages.SalesPage;
import org.example.utils.ElementNotFound;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HomePageTests extends BaseTest {
    @Test(groups = "smoke")
    public void clickHeaderItem() throws ElementNotFound {
        SalesPage salesPage = (SalesPage) homePage.getHeader().navItem(EVarItems.SALES);

        assertEquals(driver.getCurrentUrl(), "https://www.mercadolibre.com.ar/ofertas#nav-header");


    }
}
