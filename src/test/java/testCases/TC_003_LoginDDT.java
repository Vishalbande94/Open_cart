package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

import java.util.logging.Logger;

public class TC_003_LoginDDT extends BaseClass {
    @Test(groups = {"dataDriven","Master"}, dataProvider="LoginData",dataProviderClass= DataProviders.class)

    public void Verify_LoginDDT(String email,String pass,String exp){
        Logger.getLogger("**Test case TC_002_LoginTest started execution");
        //Home page
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();
        //Login page
        LoginPage lp = new LoginPage(driver);
        lp.EnterEmail(email);
        lp.EnterPassword(pass);
        lp.ClickLogin();
        //My account page
        MyAccountPage map = new MyAccountPage(driver);
        boolean targetPage = map.IsHeadingDisplayed();
        if (exp.equalsIgnoreCase("Valid")){
            if (targetPage==true){
                Assert.assertTrue(true);
                map.clickLogout();
            }else {
                Assert.assertTrue(false);
            }
        }
        if (exp.equalsIgnoreCase("Invalid")){
            if ((targetPage==false)){
                Assert.assertTrue(true);
            }else {
                map.clickLogout();
                Assert.assertTrue(false);
            }
        }
    }

}
