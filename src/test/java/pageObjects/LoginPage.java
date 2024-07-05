package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.PasswordAuthentication;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);

    }

    @FindBy(xpath="//input[@id='input-email']")
    WebElement txtEmail;

    @FindBy(xpath="//input[@id='input-password']")
    WebElement txtPassword;

    @FindBy(xpath="//input[@value='Login']")
    WebElement btnLogin;

    public void EnterEmail(String email){
        txtEmail.sendKeys(email);
    }
    public void EnterPassword(String password){
        txtPassword.sendKeys(password);
    }

    public void ClickLogin(){
        btnLogin.click();
    }



}
