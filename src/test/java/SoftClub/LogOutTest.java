package SoftClub;

import SoftClub.driver.SeleniumDriverUtil;
import SoftClub.logger.TestLogger;
import SoftClub.test_pages.LoginPage;
import SoftClub.test_pages.MainPage;
import SoftClub.test_pages.model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(groups = "MailRuTest")
public class LogOutTest {

    @BeforeMethod()
    public void init() {
        SeleniumDriverUtil.getDriver().get("https://mail.ru");

        User user = new User("romanbogatko1998@mail.ru", "fghfxfysxfkfdtr999FGHFXFYS199823");
        new LoginPage().sign(user);
        Assert.assertTrue(new MainPage().assertUser(user));
    }

    public void logOutUser() {
        TestLogger.getLogger().info("---------Тест выхода---------");
        new MainPage().logOut();
        Assert.assertTrue(new MainPage().assertLogOut());
    }

    @AfterMethod
    public void destroy() {
        SeleniumDriverUtil.getDriver().close();
    }
}