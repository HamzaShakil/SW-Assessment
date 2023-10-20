package PageObjects;

import Util.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CartPageObject  extends PageObject {

    public CartPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "shopping_cart_container")
    private WebElement cartBtnElem;

    public WebElement getCartBtnElem(){
        return this.cartBtnElem;
    }

    @FindBy(className = "complete-header")
    private WebElement completeHeadingElem;

    public WebElement getCompleteHeadingElem(){
        return this.completeHeadingElem;
    }
    @FindBy(className = "complete-text")
    private WebElement completeTxtElem;

    public WebElement getCompleteTxtElem(){
        return this.completeTxtElem;
    }
    @FindBy(id = "checkout")
    private WebElement checkoutBtnElem;

    public WebElement getCheckoutBtnElem(){
        return this.checkoutBtnElem;
    }
    @FindBy(id = "continue")
    private WebElement continueBtnElem;

    public WebElement getContinueBtnElem(){
        return this.continueBtnElem;
    }

    @FindBy(id = "first-name")
    private WebElement firstNameTxtFieldElem;

    public WebElement getFirstNameTxtFieldElem(){
        return this.firstNameTxtFieldElem;
    }
    @FindBy(id = "postal-code")
    private WebElement postalCodeTxtFieldElem;

    public WebElement getPostalCodeTxtFieldElem(){
        return this.postalCodeTxtFieldElem;
    }

    @FindBy(id = "last-name")
    private WebElement lastNameTxtFieldElem;

    public WebElement getLastNameTxtFieldElem(){
        return this.lastNameTxtFieldElem;
    }

    @FindBy(id = "finish")
    private WebElement finishBtnElem;

    public WebElement getFinishBtnElem(){
        return this.finishBtnElem;
    }
    @FindBy(className = "header_secondary_container")
    private WebElement headingElem;

    public WebElement getHeadingElem(){
        return this.headingElem;
    }

    public void clickCheckOutBtnElem(){
        getCheckoutBtnElem().click();
    }
    public void clickContinueBtnElem(){
        getContinueBtnElem().click();
    }
    public void clickFinishBtnElem(){
        getFinishBtnElem().click();

    }

    public void addItemsInCart(String[] itemNames, Integer endIndex) {


        int actualEndIndex = endIndex != null ? 0 : itemNames.length - 1;

        for (int i = 0; i <= actualEndIndex; i++) {
            System.out.print((itemNames[i]));
            String itemName = itemNames[i];
            String modifiedItemName = itemName.replace(" ", "-").toLowerCase();
            String firstPart = "add-to-cart-";
            String itemId = firstPart + modifiedItemName;
            WebElement addToCartButton = driver.findElement(By.xpath("//*[contains(@id, '" + itemId + "')]"));
            addToCartButton.click();
        }
    }


    public String[] getItemsDisplayedInCart(String[] items, Integer endIndex) {
        getCartBtnElem().click();
        int actualEndIndex = endIndex != null ? endIndex : items.length - 1;
        String[] cartItems = new String[actualEndIndex + 1];

        for (int i = 0; i <= actualEndIndex; i++) {
            String cartItem = driver.findElement(By.xpath("//div[text()='" + items[i] + "']")).getText();
            cartItems[i] = cartItem;
        }

        return cartItems;
    }
    public void enterInformation(String firstName, String lastName, String postCode){

        getFirstNameTxtFieldElem().sendKeys(firstName);
        getLastNameTxtFieldElem().sendKeys(lastName);
        getPostalCodeTxtFieldElem().sendKeys(postCode);

    }

    public String getHeadingElemTxt(){
        return getHeadingElem().getText();
    }
    public String getCompleteOrderHeadingElemTxt(){
        return getCompleteHeadingElem().getText();
    }
    public String getCompleteTxtHeadingElemTxt(){
        return getCompleteTxtElem().getText();
    }


    public String getCartCount() {
        return getCartBtnElem().getText();
    }

}
