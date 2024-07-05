package testCases;

import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public  class TC_001_RegistrationTest extends BaseClass {


    @Test(groups = {"Regression","Master"})
    public void Verify_Account_registration() {
        logger.info("Test case TC_001_RegistrationTest Starting...");
try {
    HomePage hp = new HomePage(driver);
    hp.clickMyAccount();
    logger.info("Clicked on My account link");
    hp.lnkRegister();
    logger.info("Clicked on register link");
    AccountRegistrationPage ar = new AccountRegistrationPage(driver);
    logger.info("Providing customer details ");
    ar.SetFirstName(RandomNumber().toUpperCase());
    ar.SetLastName(RandomString().toUpperCase());
    ar.SetEmail(RandomString() + "@GMAIL.COM");
    ar.SetTelephone(RandomNumber());
    //  String pass=hp.RandomString()+"@"+hp.RandomNumber();
    String Pass = RandomAlphaNumberic();
    ar.SetPassword(Pass);
    ar.SetConfirmPassword(Pass);
    ar.CheckNewsLetter();
    ar.CheckPrivacyPolicy();
    ar.ClickContinue();
    logger.info("Clicked on continue button");
    String confimMsg = ar.getConfirmationMsg();
    Assert.assertEquals(confimMsg, "Your Account Has Been Created!");
    System.out.println(confimMsg);
}catch (Exception e){
    logger.error("Test failed ");
    logger.debug("Debug log.");
}
logger.info("Test completed ");
    }




}
