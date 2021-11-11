package test;

import manger.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp() throws InterruptedException {
        app.init();

    }

    @AfterSuite
    public void tearDown() {
        app.stop();

    }
}
