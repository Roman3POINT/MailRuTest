package SoftClub.inherit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DerivedTest1 extends BaseTest {

    @BeforeTest
    public void derivedBeforeTest1() {
        System.out.println("DerivedTest1:derivedBeforeTest1");
    }

    @Test(alwaysRun = true)
    public void derivedTest1() {
        System.out.println("DerivedTest1:derivedTest1");
    }

    @AfterTest
    public void derivedAfterTest1() {
        System.out.println("DerivedTest1:derivedAfterTest1");
    }
}
