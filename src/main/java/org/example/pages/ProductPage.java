package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductPage extends BasePage {
    private Map<WebElement, WebElement> images;
    private final WebElement title;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.images = fillImages();
        this.title = driver.findElement(By.tagName("h1"));

    }

    public Integer availableCountOfDues() {

        String dues = driver.findElement(By.xpath("//div[@class = 'ui-pdp-price__subtitles']/p[1]")).getText();
        return Integer.valueOf(dues.substring(dues.indexOf(" ") + 1, dues.indexOf("x")));
    }

    public Integer priceOfDue() {
        String price = driver.findElement(By.xpath("//div[@class='ui-pdp-price__subtitles']/p//span[@class='andes-money-amount__fraction']")).getText();
        price = price.replace(".", String.valueOf(price.charAt(price.indexOf(".") + 1)));
        return Integer.valueOf(price);
    }

    public Integer totalPriceWithDues() {
        return availableCountOfDues() * priceOfDue();
    }
    private Map<WebElement, WebElement> fillImages() {

        Map<WebElement, WebElement> filledImages = new HashMap<>();
        List<WebElement> smallImages = driver.findElements(By.xpath("//span[@class = 'ui-pdp-gallery__wrapper']"));
        List<WebElement> figureImages = driver.findElements(By.xpath("//figure[@class = 'ui-pdp-gallery__figure']"));

        for (int i = 0; i < smallImages.size(); i++) {
            filledImages.put(smallImages.get(i), figureImages.get(i));
        }
        return filledImages;
    }

    public Float getPrice() {
        String price = driver.findElement(By.xpath("//div[@class='ui-pdp-price__second-line']//span[@class='andes-money-amount__fraction']")).getText();

        return Float.valueOf(price);
    }

    public WebElement getTitle() {
        return title;
    }
}
