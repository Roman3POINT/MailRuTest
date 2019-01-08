package SoftClub.reportng;

import org.testng.annotations.Test;

public class ReportNG {

    @Test
    public void firstTest() {
        System.out.println("ReportNG:firstTest");
    }

    @Test
    public void twoTest() {
        System.out.println("ReportNG:twoTest");
    }

    @Test
    public void ParseDouble() {
        System.out.println("Double = " + Double.parseDouble("Hello"));
    }
}