package SoftClub;

import SoftClub.driver.SeleniumDriverUtil;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Test(groups = "MailRuTest")
public class MainPageTest {

    @BeforeSuite
    public void init(){
        SeleniumDriverUtil.init();
        PropertyConfigurator.configure("resources/log4j.properties");
    }

    @Test
    public void test() {
        System.out.println("MailRuTest:test");
    }
}