package test;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @BeforeMethod
    public void preConditions() {
        if (app.getUser().isLogged()) {
            app.getUser().logOut();
        }
    }

    @Test
    public void testLogin() throws InterruptedException {
        User user = new User().withEmail("korona1504@gmail.com").withPassword("FinkeL10!");
       logger.info("Test login Positive 1 "+ user.getEmail() +" "
       + user.getPassword());
        app.getUser().initLogin();
        // app.getUser().fillLoginForm("korona1504@gmail.com", "FinkeL10!");
        app.getUser().fillLoginForm(user);
        Thread.sleep(15000);
        app.getUser().submitLogin();
        app.getUser().isLoggedSuccess();
        Assert.assertTrue(app.getUser().isLoggedSuccess());

        //Assert.assertTrue(app.getUser().isLoggedSuccess());
        //Assert.assertTrue(app.getUser().returnToHomePage();
    }

    @Test
    public void negativeLoginWithoutPassword() throws InterruptedException {
        User user = new User().withEmail("korona1504@gmail.com").withPassword("");
        logger.info("Test login Negative 1 "+ user.getEmail() +" "
                + user.getPassword());
        app.getUser().initLogin();
        //app.getUser().fillLoginForm("korona1504@gmail.com", "");
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
    }

    @Test
    public void negativeLoginWithoutEmail() throws InterruptedException {
        User user = new User().withEmail("korona1504@gmail.com").withPassword("");
        logger.info("Test login Negative 2 "+ user.getEmail() +" "
                + user.getPassword());
        app.getUser().initLogin();
       // app.getUser().fillLoginForm("", "Dfthtrh459!!");
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
    }

    @Test
    public void negativeLoginIncorrectEmail() throws InterruptedException {

        app.getUser().initLogin();
        app.getUser().fillLoginForm("kotit.jkgmail.com", "FinkeL10");

    }

        @AfterMethod
    public void postConditions(){
        app.getUser().clickOnLoginButton();
    }

}
