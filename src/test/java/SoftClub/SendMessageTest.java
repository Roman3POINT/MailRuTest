package SoftClub;

import SoftClub.driver.SeleniumDriverUtil;
import SoftClub.logger.TestLogger;
import SoftClub.test_pages.LoginPage;
import SoftClub.test_pages.MainPage;
import SoftClub.test_pages.model.Message;
import SoftClub.test_pages.model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(groups = "MailRuTest")
public class SendMessageTest {

    private User user;

    @BeforeMethod()
    public void init() {
        SeleniumDriverUtil.getDriver().get("https://mail.ru");

        user = new User("romanbogatko1998@mail.ru", "fghfxfysxfkfdtr999FGHFXFYS199823");
        new LoginPage().sign(user);
        Assert.assertTrue(new MainPage().assertUser(user));
    }

    @Test(groups = "MailRuTest")
    public void sendMessage() {
        TestLogger.getLogger().info("---------Тест Отправки сообщения---------");

        Message message = new Message(user.getLogin(), "Привет, это я - Рома.");
        new MainPage().sendMessage(message);
        Assert.assertTrue(new MainPage().assertMessage(user));
    }

    @AfterMethod
    public void destroy() {
        new MainPage().logOut();
    }
}