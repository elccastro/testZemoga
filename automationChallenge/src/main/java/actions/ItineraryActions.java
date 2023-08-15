package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ItineraryPage;

import java.util.List;

public class ItineraryActions {
    private WebDriver driver;
    private ItineraryPage itineraryPage;

    public ItineraryActions(WebDriver driver) {
        this.driver = driver;
        this.itineraryPage = new ItineraryPage();
    }

    public void validateInformationItinerary() throws InterruptedException {
        for (By item: itineraryPage.getItemsInformationItinerary()) {
            WebElement itemSearch = TestActions.waitForElement(driver, item, 5);
            if(itemSearch == null) {
                System.out.println("Error");
            }
        }
    }

    public void validateDetailOfDay() {
        List<WebElement> btnsLearnMore = driver.findElements(By.className("about-cta"));
        TestActions.scroll(driver, 500);
        btnsLearnMore.get(1).click();
    }

    public void validateBtnBooking() throws InterruptedException {
        WebElement booking = TestActions.waitForElement(driver, itineraryPage.booking, 5);
        if(booking == null) {
            System.out.println("Error");
        }
        booking.click();
    }
}
