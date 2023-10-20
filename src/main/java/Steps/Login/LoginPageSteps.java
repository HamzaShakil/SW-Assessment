package Steps.Login;

import PageObjects.LoginPageObject;
import Util.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class LoginPageSteps {
    private LoginPageObject loginPageObject;
    private String message;

    private boolean isInvalidCreds,isEmptyCreds;

    @Given("I am on the login page")
    public void navigateToLoginPage() {
        loginPageObject = new LoginPageObject(DriverManager.webDriver);
        loginPageObject.navigateToLoginPage();
    }

    @When("I enter valid credentials")
    public void enterValidCredentials() {
        loginPageObject.enterCredentials("standard_user", "secret_sauce");
    }
    @When("I enter an invalid username")
    public void enterInValidUserNameCredentials() {
        loginPageObject.enterCredentials("standard_users", "secret_sauce");
        isInvalidCreds =true;

    }
    @When("I enter an invalid password")
    public void enterInValidPasswordCredentials() {
        loginPageObject.enterCredentials("standard_user", "secret_sauces");
        isInvalidCreds =true;
    }

    @When("click the login button")
    public void click_the_login_button() { loginPageObject.clickLoginButton();}

    @When("Leave user name and password field empty")
    public void leaveUsernameFieldEmpty() {
        loginPageObject.enterCredentials("", "");
        isEmptyCreds=true;
    }

    @Then("I should be logged in")
    public void verifyLoggedIn() {
        boolean isLoggedIn = loginPageObject.isUserLoggedIn();
        assertEquals(true, isLoggedIn);
    }
    @Then("I should see an error message")
    public void errorMessageDisplayed() {
        if(isInvalidCreds){
            message="Epic sadface: Username and password do not match any user in this service";
        }
        if(isEmptyCreds){
            message= "Epic sadface: Username is required";
        }
        assertEquals(message,loginPageObject.getErrorMessage());
    }
}
