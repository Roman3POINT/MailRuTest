package SoftClub.test_pages;

import SoftClub.driver.SeleniumDriverUtil;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(SeleniumDriverUtil.getDriver(), this);
    }
}
