package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.ItineraryPage;
import pages.SearchPage;

import java.util.List;

public class SearchActions {
    private WebDriver driver;
    private SearchPage searchPage;
    private ItineraryPage itineraryPage;

    public SearchActions(WebDriver driver) {
        this.driver = driver;
        this.searchPage = new SearchPage();
        this.itineraryPage = new ItineraryPage();
    }

    public void validateResultsSearch() throws InterruptedException {
        WebElement contentResults = TestActions.waitForElement(driver, searchPage.contentResults, 5);
        List<WebElement> velas = contentResults.findElements(By.cssSelector("div#__next > div > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(3) > div > div:nth-of-type(2) > div"));
        if(velas.size() == 0) {
            System.out.println("Error");
            return;
        }
        for (WebElement item : velas) {
            WebElement day = driver.findElement(searchPage.lbDayCruise);
            if(Integer.parseInt(day.getText()) < 6 || Integer.parseInt(day.getText()) > 9) {
                System.out.println("Error");
            }
        }
    }

    public void selectCruise() throws InterruptedException {
        WebElement contentResults = TestActions.waitForElement(driver, searchPage.contentResults, 5);
        List<WebElement> cruises = contentResults.findElements(By.tagName("article"));
        cruises.get(0).findElement(searchPage.btnLearnMore).click();
        TestActions.waitForElement(driver, itineraryPage.booking, 5);
    }

    public void validateFilterPrice() throws InterruptedException {
        TestActions.click(driver, searchPage.btnFilterPrice);
        Thread.sleep(1000);
        WebElement circleMin = driver.findElement(searchPage.circleMinFilterPrice);
        Actions build = new Actions(driver);
        build.dragAndDropBy(circleMin, 300, circleMin.getLocation().getY()).build().perform();
        Thread.sleep(1000);
        TestActions.click(driver, searchPage.btnFilterPrice);
        Thread.sleep(1000);

        WebElement contentResults = TestActions.waitForElement(driver, searchPage.contentResults, 5);
        List<WebElement> cruises = contentResults.findElements(By.tagName("article"));
        int mayor = 0;
        for (WebElement item : cruises) {
            WebElement price = driver.findElement(By.cssSelector("span.vrgf-price-box__price-value.ng-binding"));
            int priceItem = Integer.parseInt(price.getText());
            if(mayor <= priceItem) {
                mayor = priceItem;
            } else {
                System.out.println("Error");
            }
        }
    }

}
