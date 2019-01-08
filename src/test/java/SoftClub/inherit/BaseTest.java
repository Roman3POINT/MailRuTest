package SoftClub.inherit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {

    @BeforeTest
    public void baseBeforeTest() {
        System.out.println("BaseTest:baseBeforeTest");
    }

    @Test
    public void baseTest() {
        System.out.println("BaseTest:baseTest");
    }

    @AfterTest
    public void baseAfterTest() {
        System.out.println("BaseTest:baseAfterTest");
    }
}