package org.example.pages;

import org.example.components.header.HeaderPage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private HeaderPage header;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HeaderPage getHeader() {
        if (header == null) {
            header = new HeaderPage(driver);
        }
        return header;
    }
}
