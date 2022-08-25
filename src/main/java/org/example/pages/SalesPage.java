package org.example.pages;

import org.example.components.header.IHeaderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SalesPage extends BasePage implements IHeaderPage {
    private List<WebElement> products;
    public SalesPage(WebDriver driver) {
        super(driver);
        this.products = driver.findElements(By.xpath("//ol[@class='items_container']/li/a"));
    }


}
