package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObects.ContactUsPage;
import pageObects.CreateNewAccount;

/**
 * Created by Eahuja on 4/4/2017.
 */
public class ContactUsStepDef {

    CreateNewAccount createNewAccount;
    ContactUsPage contactUsPage;

    public ContactUsStepDef(CreateNewAccount createNewAccount, ContactUsPage contactUsPage) {
        this.createNewAccount = createNewAccount;
        this.contactUsPage = contactUsPage;
    }

    @Given("^I enter \"([^\"]*)\" and \"([^\"]*)\" and I click on contact us$")
    public void iClickOnContactUs(String email, String pwd)  {
        createNewAccount.openWebSite();
        createNewAccount.signInAction(email, pwd);
        contactUsPage.clickContactUs();
    }

    @When("^I enter details anc send$")
    public void iEnterDetailsAncSend() {
        contactUsPage.selectSubject();
        contactUsPage.selectOrderRef();
        contactUsPage.selectProduct();
        contactUsPage.enterMessage();
        contactUsPage.sendMessageBtn();

    }

    @Then("^I see successful message$")
    public void iSeeSuccessfulMessage()  {
        contactUsPage.successMessageSent();
    }
}
