package SoftClub.test_pages;

import SoftClub.driver.SeleniumWebDriverWait;
import SoftClub.logger.TestLogger;
import SoftClub.test_pages.model.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "mailbox:login")
    private WebElement login;

    @FindBy(id = "mailbox:password")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"mailbox:submit\"]/input")
    private WebElement signIn;

    public void sign(User user) {
        SeleniumWebDriverWait.waitElementToBeClickable(login, 10);

        login.clear();
        password.clear();

        login.sendKeys(user.getLogin());
        password.sendKeys(user.getPassword());
        TestLogger.getLogger().info("Авторизация...");

        signIn.click();
    }

    public WebElement getLogin() {
        return login;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getSignIn() {
        return signIn;
    }
}