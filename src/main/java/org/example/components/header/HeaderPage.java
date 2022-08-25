package org.example.components.header;

import org.example.pages.BasePage;
import org.example.pages.SalesPage;
import org.example.utils.ElementNotFound;
import org.example.utils.Filters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HeaderPage extends BasePage {

    private final WebElement searchBar;
    private final List<WebElement> navBar;
    public HeaderPage(WebDriver driver) {
        super(driver);
        this.searchBar = driver.findElement(By.id("cb1-edit"));
        this.navBar = driver.findElements(By.xpath("//li[@class= 'nav-menu-item'][position()!=1]/a"));
    }

    public void search(String target) {
        searchBar.sendKeys(target);
    }

    public IHeaderPage navItem(EVarItems item) throws ElementNotFound {
        selectNavItem(item).click();

        return switch (item) {
            case SALES -> new SalesPage(driver);
            default -> null;
        };
    }
    private WebElement selectNavItem (EVarItems item) throws ElementNotFound {
        return Filters.filterText(navBar, item.getText());

    }

}
