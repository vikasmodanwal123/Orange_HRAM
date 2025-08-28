package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownHelper {
    WebDriver driver;

    public DropdownHelper(WebDriver driver) {
        this.driver = driver;
    }

    // 1️ Select by visible text
    public void selectOption(By locator, String visibleText) {
        WebElement element = driver.findElement(locator);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(visibleText);
    }

    // 2️ Select by index
    public void selectOption(By locator, int index) {
        WebElement element = driver.findElement(locator);
        Select dropdown = new Select(element);
        dropdown.selectByIndex(index);
    }

    // 3️ Select by value
    public void selectOption(By locator, String value, boolean byValue) {
        WebElement element = driver.findElement(locator);
        Select dropdown = new Select(element);
        if (byValue) {
            dropdown.selectByValue(value);
        } else {
            dropdown.selectByVisibleText(value);
        }
    }
}