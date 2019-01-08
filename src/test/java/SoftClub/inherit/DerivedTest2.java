package SoftClub.inherit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DerivedTest2 extends DerivedTest1 {

    @BeforeTest
    public void derivedBeforeTest2() {
        System.out.println("DerivedTest2:derivedBeforeTest2");
    }

    @Test(alwaysRun = true)
    public void derivedTest2() {
        System.out.println("DerivedTest2:derivedTest2");
    }

    @AfterTest
    public void derivedAfterTest2() {
        System.out.println("DerivedTest2:derivedAfterTest2");
    }

}
