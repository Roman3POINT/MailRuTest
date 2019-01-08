package SoftClub.logger;

import SoftClub.test_pages.BasePage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLogger {

    private final static Logger logger = Logger.getLogger(BasePage.class);

    public TestLogger() {
        PropertyConfigurator.configure("log4j.properties");
    }

    public static Logger getLogger() {
        return logger ;
    }
}
