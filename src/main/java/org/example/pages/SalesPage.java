package org.example.pages;

import org.example.components.header.IHeaderPage;
import org.example.utils.ElementNotFound;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class SalesPage extends BasePage implements IHeaderPage {
    public SalesPage(RemoteWebDriver driver) {
        super(driver);
    }

    public ProductPage selectProduct(int index) throws ElementNotFound {
        List<WebElement>  products = driver.findElements(By.xpath("//ol[@class='items_container']/li/a"));
        if (index < products.size() -1) {
            products.get(index).click();
            return new ProductPage(driver);
        }
        throw new ElementNotFound("Index: " + index + " is bigger than the list size: " + products.size());
    }
}
