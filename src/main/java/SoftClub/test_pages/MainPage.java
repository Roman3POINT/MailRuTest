package SoftClub.test_pages;

import SoftClub.driver.SeleniumDriverUtil;
import SoftClub.driver.SeleniumWebDriverWait;
import SoftClub.logger.TestLogger;
import SoftClub.test_pages.model.Message;
import SoftClub.test_pages.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(id = "PH_user-email")
    private WebElement login;

    @FindBy(xpath = "//*[@id=\"b-toolbar__left\"]/div/div/div[2]/div/a")
    private WebElement sendMessage;

    @FindBy(css = "textarea[data-original-name='To']")
    private WebElement toUser;

    @FindBy(css = "iframe[id^='toolkit']")
    private WebElement body;

    @FindBy(css = "div[id='b-toolbar__right'] div[data-name='send'] span")
    private WebElement send;

    @FindBy(css = "div[id='b-compose__sent'] span")
    private WebElement toUserName;

    @FindBy(id = "PH_logoutLink")
    private WebElement exit;

    @FindBy(id = "PH_authLink")
    private WebElement logIn;


    public void sendMessage(Message message) {

        SeleniumWebDriverWait.waitElementToBeClickable(sendMessage, 10);
        sendMessage.click();
        TestLogger.getLogger().info("Нажата кнопка \"Написать письмо\"");
        toUser.sendKeys(message.getTo());

        TestLogger.getLogger().info("Получатель: " + message.getTo());

        body = SeleniumDriverUtil.getDriver().switchTo().frame(body).findElement(By.tagName("body"));

        body.clear();
        body.sendKeys(message.getMessage());

        TestLogger.getLogger().info("Отправка сообщения...");

        SeleniumDriverUtil.getDriver().switchTo().defaultContent();

        send.click();
    }

    public boolean assertMessage(User user) {
        boolean rc = false;

        SeleniumWebDriverWait.waitElementToBeClickable(toUserName, 10);

        if(toUserName.getText().contains(user.getLogin())) {
            TestLogger.getLogger().info("Сообщение успешно отправлено");
            rc = true;
        }
        else
            TestLogger.getLogger().fatal("Ошибка отправки сообщения");
        TestLogger.getLogger().info("-----------------------------------------");
        return rc;
    }

    public boolean assertUser(User user) {
        boolean rc = false;

        SeleniumWebDriverWait.waitElementToBeClickable(login, 10);

        if(user.getLogin().equals(login.getText())) {
            TestLogger.getLogger().info("Авторизация прошла успешно");
            rc = true;
        }
        else
            TestLogger.getLogger().fatal("Ошибка авторизации");

        TestLogger.getLogger().info("----------------------------------");
        return rc;
    }

    public void logOut() {
        SeleniumWebDriverWait.waitElementToBeClickable(exit, 10);
        exit.click();
        TestLogger.getLogger().info("Ожидание разъединения...");
    }

    public boolean assertLogOut() {
        boolean rc = false;
        SeleniumWebDriverWait.waitElementToBeClickable(logIn, 15);

        if(logIn.getText().equals("Вход")) {
            TestLogger.getLogger().info("Выход с аккаунта");
            rc = true;
        } else
            TestLogger.getLogger().info("Ошибка разъединения");

        TestLogger.getLogger().info("----------------------------------");
        return rc;
    }
}