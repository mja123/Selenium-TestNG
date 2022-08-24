package org.example.components;

import org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Header extends BasePage {

    private final WebElement searchBar;
    private final List<WebElement> navBar;
    public Header(WebDriver driver) {
        super(driver);
        this.searchBar = driver.findElement(By.id("cb1-edit"));
        this.navBar = driver.findElements(By.xpath("//li[@class= 'nav-menu-item'][position()!=1]/a"));
    }

    public void search(String target) {
        searchBar.sendKeys(target);
    }

    public void selectNavItem (EVarItems item) {
        //
    }
}
