package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObects.AccountsPage;
import pageObects.CreateNewAccount;

/**
 * Created by Eahuja on 4/4/2017.
 */
public class AccountActionsStepDef {
    CreateNewAccount createNewAccount;
    AccountsPage accountsPage;

    public AccountActionsStepDef(CreateNewAccount createNewAccount, AccountsPage accountsPage) {
        this.createNewAccount = createNewAccount;
        this.accountsPage = accountsPage;
    }


    @Given("^I enter \"([^\"]*)\" and \"([^\"]*)\" and I click on address$")
    public void i_go_to_my_address_option(String email, String pwd)  {
        createNewAccount.signInAction(email, pwd);
        accountsPage.clickAccount();
        accountsPage.clickAddressOption();
        accountsPage.clickAddAddress();
    }

    @When("^I enter details of address \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void i_enter_details_of_address(String address,String city, String zip, String phone, String alias) {
        accountsPage.enterAddress(address,city,zip,phone,alias);
        accountsPage.clickSubmitAddress();

    }

    @Then("^address is added and logout$")
    public void address_is_added() {
        accountsPage.addressAlreadyPresentWarning();
        accountsPage.signOut();
    }


    @Given("^I login using \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iLoginUsingAnd(String email, String pwd) {
        createNewAccount.openWebSite();
        createNewAccount.signInAction(email, pwd);
    }

    @When("^I enter \"([^\"]*)\" in text box$")
    public void iEnterInTextBox(String email)  {
        accountsPage.enteremailIdForNewsletter(email);
    }

    @Then("^I see successful message and I logout$")
    public void iSeeSuccessfulMessageAndILogout()  {
        accountsPage.verifyNwsletterSubscribe();
    }

    @And("^I open credit slip page$")
    public void iOpenCreditSlipPage()  {
        accountsPage.clickCreditSlipsBtn();
    }

    @When("^I see message of no credit slips$")
    public void iSeeMessageOfNoCreditSlips()  {
        accountsPage.verifyCreditSlips();
    }

    @Then("^I logout$")
    public void iLogout() {
        accountsPage.signOut();
    }
}
