package pages;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage() {

    }

    public By alertClose= By.xpath("/html/body/div[2]/div/button");
    public By alertCookies= By.id("cookie-consent-btn");
    public By filterOrigin = By.id("cdc-destinations");
    public By ulOptionsOrigin = By.xpath("//*[@id=\"ccl-cruise-search\"]/ccl-cruise-search/div[3]/ccl-cruise-search-bar/div/div[2]/div/div[2]/div/ccl-search-bar-expandable-filter/div/ul");
    //public  By validateCheckOption=By.xpath("");
    public By filterDuration = By.id("cdc-durations");
    public By ulOptionsDuration = By.xpath("//*[@id=\"ccl-cruise-search\"]/ccl-cruise-search/div[3]/ccl-cruise-search-bar/div/div[2]/div/div[2]/div/ul");
    public By formSearchCruises = By.id("ccl-cruise-search");

    public By GridOptions = By.xpath("//*[@id=\"ccl-refresh-homepage\"]/div/div/div/div/div/ccl-cruise-search/div[3]/ccl-view-result-container/div");
    public By btnSearchCruises = By.xpath("//*[@id=\"ccl-cruise-search\"]/ccl-cruise-search/div[3]/ccl-cruise-search-bar/div/div[2]/div/ul/li[5]/a");

    public List<By> itemsSearch() {
        return Arrays.asList(filterOrigin, filterDuration);
    }

}
