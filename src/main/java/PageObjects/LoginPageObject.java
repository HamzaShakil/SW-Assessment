package PageObjects;

import Util.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject extends PageObject {

    public LoginPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    private WebElement userNameTxtField;

    @FindBy(id = "password")
    private WebElement passwordTxtField;

    @FindBy(id = "login-button")
    private WebElement submitLoginBtnElem;

    @FindBy(className = "app_logo")
    private WebElement appLogoElem;

    @FindBy (xpath="//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private WebElement errorMessageElem;


    public WebElement getUserEmailTxtFieldElem(){
        return this.userNameTxtField;
    }
    public WebElement getPasswordTxtFieldElem(){
        return this.passwordTxtField;
    }
    public WebElement getLoginBtnElem(){return this.submitLoginBtnElem;}
    public WebElement getAppLogoElem(){return this.appLogoElem;}
    public WebElement getErrorMessageElem(){return this.errorMessageElem;}
    public void navigateToLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public void enterCredentials(String username, String password) {
        getUserEmailTxtFieldElem().sendKeys(username);
        getPasswordTxtFieldElem().sendKeys(password);
    }

    public void login(String username, String Pass){
        navigateToLoginPage();
        enterCredentials(username,Pass);
        clickLoginButton();
    }

    public void clickLoginButton() {
        getLoginBtnElem().click();
    }

    public boolean isUserLoggedIn() {
        return getAppLogoElem().isDisplayed();
    }

    public String getErrorMessage() {
        return getErrorMessageElem().getText();
    }
}
