package SoftClub.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWebDriverWait {

    public static void waitElementToBeClickable(WebElement element, int seconds) {
        (new WebDriverWait(SeleniumDriverUtil.getDriver(), seconds))
                .until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitElementinvisibilityOf(WebElement element, int seconds) {
        (new WebDriverWait(SeleniumDriverUtil.getDriver(), seconds))
                .until(ExpectedConditions.invisibilityOf(element));
    }
    public static void waitElementToBeSelected(WebElement element, int seconds) {
        (new WebDriverWait(SeleniumDriverUtil.getDriver(), seconds))
                .until(ExpectedConditions.elementToBeSelected(element));
    }
    public static void waitElementFrameToBeAvailableAndSwitchTo(WebElement element, int seconds) {
        (new WebDriverWait(SeleniumDriverUtil.getDriver(), seconds))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }
}
