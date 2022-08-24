package org.example.pages;

import org.example.components.Header;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private Header header;

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
