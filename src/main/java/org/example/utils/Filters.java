package org.example.utils;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

public class Filters {
    public static WebElement filterText(List<WebElement> elements, String text) throws ElementNotFound {
        Optional<WebElement> target = elements.stream()
                .filter(e -> e.getText().contains(text))
                .findFirst();
        if (target.isPresent()) {
            return target.get();
        }
        throw new ElementNotFound("Element " + text + " doesn't exist.");
    }
}
