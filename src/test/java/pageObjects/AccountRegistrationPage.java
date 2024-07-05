package pageObjects;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountRegistrationPage extends BasePage{

    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

        @FindBy(xpath="//input[@id='input-firstname']")
        WebElement txtFirstName;
    @FindBy(xpath="//input[@id='input-lastname']")
    WebElement txtLastName;
    @FindBy(xpath="//input[@id='input-email']")
    WebElement txtEmail;
    @FindBy(xpath="//input[@id='input-telephone']")
    WebElement txtTelephone;
    @FindBy(xpath="//input[@id='input-password']")
    WebElement txtPassword;
    @FindBy(xpath="//input[@id='input-confirm']")
    WebElement txtConfirmPassword;
    @FindBy(xpath="//input[@value='0']")
    WebElement chkNewsLetterCheck;
    @FindBy(xpath="//input[@name='agree']")
    WebElement chkPrivacyPolicy;
    @FindBy(xpath="//input[@value='Continue']")
    WebElement btnContinue;
    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;

    public void SetFirstName(String FirstName){
        txtFirstName.sendKeys(FirstName);
    }
    public void SetLastName(String Lastname){
        txtLastName.sendKeys(Lastname);
    }
    public void SetEmail(String Email){
        txtEmail.sendKeys(Email);
    }
    public void SetTelephone(String TNumber){
        txtTelephone.sendKeys(TNumber);
    }
    public void SetPassword(String Password){
        txtPassword.sendKeys(Password);
    }
    public void SetConfirmPassword(String ConfirmPassword){
        txtConfirmPassword.sendKeys(ConfirmPassword);
    }
    public void CheckNewsLetter(){
        chkNewsLetterCheck.click();
    }
    public  void CheckPrivacyPolicy(){
        chkPrivacyPolicy.click();
    }
    public void ClickContinue(){
        btnContinue.click();
    }

    public String getConfirmationMsg(){
        try {
            return (msgConfirmation.getText());
        }catch (Exception e){
            return (e.getMessage());
        }
    }






}
