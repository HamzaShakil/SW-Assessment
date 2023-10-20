package Steps.Cart;

import PageObjects.CartPageObject;
import PageObjects.LoginPageObject;
import Util.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

import static org.junit.Assert.assertEquals;




public class CartPageSteps {
    private LoginPageObject loginPageObject;
    private CartPageObject cartPageObject;
    private String[] items = {"Sauce Labs Backpack", "Sauce Labs Bike Light"};

    @Given("I am on the Swag Labs homepage")
    public void navigateToLoginPage() throws IOException {
        loginPageObject = new LoginPageObject(DriverManager.webDriver);
        loginPageObject.login("standard_user", "secret_sauce");
        cartPageObject = new CartPageObject(DriverManager.webDriver);
    }

    @When("I add the Sauce Labs Backpack to the cart")
    public void iAddItemToTheCart() {
        cartPageObject.addItemsInCart(items,0);
    }

    @Then("the single item should be added to the cart")
    public void theSingleItemShouldBeAddedToTheCart() {
        String[] itemsDisplayedInCart = cartPageObject.getItemsDisplayedInCart(items,0);
        assertEquals(items[0], itemsDisplayedInCart[0]);
    }
    @Then("the multiple item should be added to the cart")
    public void theMultipleItemShouldBeAddedToTheCart() {
        String[] itemsDisplayedInCart = cartPageObject.getItemsDisplayedInCart(items, null);
        Assert.assertArrayEquals(items, itemsDisplayedInCart);
    }


    @When("I add two item into a cart")
    public void iAddMultipleItemToTheCart() {
        cartPageObject.addItemsInCart(items,null);
    }

    @Then("the cart should display a count of 2 items")
    public void theCartShouldDisplayItemCount() {
        // Implement assertions or verifications to check if the cart displays the correct item count
        assertEquals("2", cartPageObject.getCartCount());
    }

    @When("I proceed to checkout")
    public void iProceedToCheckout() {
        cartPageObject.clickCheckOutBtnElem();
    }

    @Then("I should be redirected to the information page")
    public void iShouldBeRedirectedToInformationPage() {
        Assert.assertEquals("Checkout: Your Information",cartPageObject.getHeadingElemTxt());
    }

    @When("I add the information")
    public void iAddInformation() {
        cartPageObject.enterInformation("John", "Doe", "12345");
    }

    @And("click the continue button")
    public void clickContinueButton() {
        cartPageObject.clickContinueBtnElem();
    }

    @Then("I should be redirected to the checkout overview page")
    public void iShouldBeRedirectedToCheckoutOverviewPage() {
        Assert.assertEquals("Checkout: Overview",cartPageObject.getHeadingElemTxt());
    }

    @And("the checkout overview page should display the item I added")
    public void overviewPageShouldDisplayAddedItem() {
        String[] itemsDisplayedInCart = cartPageObject.getItemsDisplayedInCart(items, null);
        Assert.assertArrayEquals(items, itemsDisplayedInCart);
    }

    @When("I click the finish button")
    public void iClickFinishButton() {
        cartPageObject.clickFinishBtnElem();
    }

    @Then("I should be redirected to the complete page")
    public void iShouldBeRedirectedToCompletePage() {
        Assert.assertEquals("Thank you for your order!",cartPageObject.getCompleteOrderHeadingElemTxt());
    }

    @And("the page should display the thank you message")
    public void pageShouldDisplayThankYouMessage() {
        Assert.assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!",cartPageObject.getCompleteTxtHeadingElemTxt());
    }

}










