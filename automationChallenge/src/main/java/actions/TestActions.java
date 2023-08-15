package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestActions {

    public static void click(WebDriver driver, By locator) {
        driver.findElement(locator).click();
    }

    public static WebElement getElementInList(WebDriver driver, By locator, String text) {
        List<WebElement> options = driver.findElements(locator);
        for(WebElement item : options) {
            if(item.getText().equals(text)) {
                return item;
            }
        }
        return null;
    }

    public static WebElement waitForElement(WebDriver driver, By locator, int timeOut) throws InterruptedException {
        if(timeOut == 0) {
            return null;
        }
        List<WebElement> elements = driver.findElements(locator);
        if(elements.size() > 0) {
            return elements.get(0);
        }
        Thread.sleep(1000);
        return waitForElement(driver, locator, timeOut - 1);
    }

    public static WebElement waitForElement(WebDriver driver, By locator, String text, int timeOut) throws InterruptedException {
        if(timeOut == 0) {
            return null;
        }
        List<WebElement> elements = driver.findElements(locator);
        if(elements.size() > 0) {
            for (WebElement item: elements) {
                if(item.getText() == text) {
                    return item;
                } else {
                    return waitForElement(driver, locator, text, timeOut - 1);
                }
            }
        }
        Thread.sleep(1000);
        return waitForElement(driver, locator, timeOut - 1);
    }

    public static void scroll(WebDriver driver, int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")");
    }
}
