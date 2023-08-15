package modules;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.HomePage;
import actions.HomeActions;
import pages.SearchPage;
import actions.SearchActions;

@DisplayName("Tests - Carnival")
public class MainTest {

    // User Story 1
    @Test
    @DisplayName("Validate the search of the cruise to The Bahamas")
    public void testValidateTheSearchOfTheCruiseToTheBahamas() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "C:\\Tools\\Drivers\\Edge\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.carnival.com/");

        HomeActions homeActions = new HomeActions(driver);

        homeActions.validateSearchForm();
        homeActions.selectSailTo();
        homeActions.selectDuration();
        homeActions.clicBtnSearchCruises();

        SearchActions searchActions = new SearchActions(driver);

        searchActions.validateResultsSearch();
        searchActions.validateFilterPrice();

        driver.quit();
    }

}
