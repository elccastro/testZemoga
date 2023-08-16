package pages;

import org.openqa.selenium.By;

public class SearchPage {
    public By contentResults = By.cssSelector("div#__next > div > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(3)");
    public By btnFilterPrice = By.cssSelector("li.sfn-nav__item.sfn-nav__item-pricing");
    public By circleMinFilterPrice = By.cssSelector("span.rz-pointer.rz-pointer-min");
    public By btnLearnMore = By.cssSelector("a.vrgf-learn-more__text.ng-binding");
    public By lbDayCruise = By.cssSelector("span.cgc-cruise-glance__days.ng-binding");
}
