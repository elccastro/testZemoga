package pages;

import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

public class ItineraryPage {
    public By days = By.xpath("//*[@id=\"section-itinerary\"]/div/cruise-glance/div/header/div/div/p/span");
    public By title = By.id("cruiseDescrGlance");
    public By booking = By.id("sm-booking-btn");

    public List<By> getItemsInformationItinerary() {
        return Arrays.asList(days, title);
    }
}
