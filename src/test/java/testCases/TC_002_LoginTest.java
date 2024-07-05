package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

import java.util.logging.Logger;

public class TC_002_LoginTest extends BaseClass {



    @Test(groups = {"sanity","Master"})
    public void login(){
        try {
            Logger.getLogger("**Test case TC_002_LoginTest started execution");
            //Home page
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();
            //Login page
            LoginPage lp = new LoginPage(driver);
            lp.EnterEmail(p.getProperty("email"));
            lp.EnterPassword(p.getProperty("password"));
            lp.ClickLogin();
            //My account page
            MyAccountPage map = new MyAccountPage(driver);
            boolean targetPage = map.IsHeadingDisplayed();
            Assert.assertEquals(targetPage, true, "Login failed");
        }catch (Exception e){
            Assert.fail();
        }

        Logger.getLogger("**Test case TC_002_LoginTest execution Finished ");

    }

}
