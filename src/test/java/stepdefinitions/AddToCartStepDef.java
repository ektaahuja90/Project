package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObects.CartActions;
import pageObects.CreateNewAccount;

/**
 * Created by Eahuja on 4/4/2017.
 */
public class AddToCartStepDef {
    CreateNewAccount createNewAccount;
    CartActions cartActions;

    public AddToCartStepDef(CreateNewAccount createNewAccount, CartActions cartActions) {
        this.createNewAccount = createNewAccount;
        this.cartActions = cartActions;
    }

    @Given("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterAnd(String email, String pwd)  {
        createNewAccount.signInAction(email, pwd);
    }


    @When("^I open home page$")
    public void iOpenHomePage()  {
        cartActions.clickHome();

    }

    @Then("^I select item and add to cart$")
    public void iSelectItemAndAddToCart()  {
        cartActions.hoverOnImage();
        cartActions.closeWindow();
        cartActions.viewCart();
        cartActions.proceedTocheckOut();
        cartActions.proceedAddress();
        cartActions.checkServiceAgreement();
        cartActions.proceedCarrier();
        cartActions.paymentBankWire();
        cartActions.confirm();
        cartActions.signOut();
    }

    @When("^I open particular item$")
    public void iOpenParticularItem()  {
        cartActions.clickHome();
        cartActions.hoverAndClick();
    }

    @Then("^I click on Add to wishlist$")
    public void iClickOnAddToWishlist()  {
        cartActions.clickWishListBtn();
        cartActions.closePopup();
        cartActions.signOut();
    }

    @When("^I open wishlist and click on view$")
    public void iOpenWishlistAndClickOnView()  {

        cartActions.clickAccountBtn();
        cartActions.clickMyWishlistBtn();
        cartActions.ClickViewWishListBtn();
    }

    @Then("^^Click on send and enter email addresses \"([^\"]*)\" \"([^\"]*)\"$$")
    public void clickOnSendAndEnterEmailAddresses(String emailadd1, String emailadd2)  {
        cartActions.clickSendWishlistBtn();
        cartActions.enterEmailIds(emailadd1, emailadd2);
    }

    @And("^click on send$")
    public void clickOnSend()  {
        cartActions.sendWishList();
    }

    @When("^I open cart and verify message$")
    public void iOpenCartAndVerifyMessage() throws InterruptedException {
        cartActions.viewCart();
        cartActions.verifyEmptyCartMessage();
        cartActions.clickHome();
    }

    @Then("^If cart is Empty I sign out$")
    public void ifCartIsEmptyISignOut()  {
        cartActions.signOut();
    }

    @Given("^something$")
    public void something() throws Throwable {
        Logger log = LogManager.getLogger(AddToCartStepDef.class.getName());
        log.fatal("some error");
    }
}
