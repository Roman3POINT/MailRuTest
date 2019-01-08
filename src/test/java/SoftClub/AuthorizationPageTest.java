package SoftClub;

import SoftClub.driver.SeleniumDriverUtil;
import SoftClub.logger.TestLogger;
import SoftClub.test_pages.LoginPage;
import SoftClub.test_pages.MainPage;
import SoftClub.test_pages.model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = "MailRuTest")
public class AuthorizationPageTest {

    @BeforeMethod
    public void init() {
        SeleniumDriverUtil.getDriver().get("https://mail.ru");
    }

    @DataProvider(name = "getUser")
    public static Object[] getUser() {
        return new User[]{new User("romanbogatko1998@mail.ru", "fghfxfysxfkfdtr999FGHFXFYS199823")};
    }

    @Test(dataProvider = "getUser")
    public void logIn(User user) {
        TestLogger.getLogger().info("---------Тест Авторизации---------");
        new LoginPage().sign(user);
        Assert.assertTrue(new MainPage().assertUser(user));
    }

    @AfterMethod
    public void destroy() {
        new MainPage().logOut();
    }
}