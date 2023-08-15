package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;

import java.util.List;

public class HomeActions {

    private WebDriver driver;
    private HomePage homePage;

    public HomeActions(WebDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage();
    }

    public void validateSearchForm() throws InterruptedException {
        WebElement alertPromo = TestActions.waitForElement(driver, homePage.alertClose, 5);
        if(alertPromo != null){
            Actions builder = new Actions(driver);
            builder.click(alertPromo).perform();
        }
        WebElement alertCookies = TestActions.waitForElement(driver, homePage.alertCookies, 5);
        if(alertCookies != null){
            Actions builder = new Actions(driver);
            builder.click(alertCookies).perform();
        }

        for (By item: homePage.itemsSearch()) {
            WebElement itemSearch = TestActions.waitForElement(driver, item, 5);
            if(itemSearch == null) {
                System.out.println("Error");
            }
        }
    }

    public void selectSailTo() throws InterruptedException {
        TestActions.click(driver, homePage.filterOrigin);

        WebElement ulOptions = driver.findElement(homePage.ulOptionsOrigin);
        List<WebElement> optionsSailTo = ulOptions.findElements(By.tagName("li"));
        for(WebElement item : optionsSailTo) {
            if(item.getText().equals("The Bahamas")) {
                Thread.sleep(1000);
                item.click();
            }
        }
    }

    public void selectDuration() throws InterruptedException {
        TestActions.click(driver, homePage.filterDuration);
        WebElement ulOptions = driver.findElement(homePage.ulOptionsDuration);
        List<WebElement> optionsDuration = ulOptions.findElements(By.tagName("li"));
        for(WebElement item : optionsDuration) {
            if(item.getText().equals("6 - 9 Days")) {
                Thread.sleep(1000);
                item.click();
            }
        }
    }
    public void clicBtnSearchCruises() {
        TestActions.click(driver, homePage.btnSearchCruises);
    }

}
