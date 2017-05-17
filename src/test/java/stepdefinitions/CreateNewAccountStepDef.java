package stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObects.ContactUsPage;
import pageObects.CreateNewAccount;

import java.util.Map;

/**
 * Created by Eahuja on 3/23/2017.
 */
public class CreateNewAccountStepDef {

    CreateNewAccount createNewAccount;
    ContactUsPage contactUsPage;

    public CreateNewAccountStepDef(CreateNewAccount createNewAccount, ContactUsPage contactUsPage) {
        this.createNewAccount = createNewAccount;
        this.contactUsPage = contactUsPage;
    }

    @Given("^I enter email id \"([^\"]*)\"$")
    public void iEnterEmailId(String email) {
        createNewAccount.createAccnt(email);
    }

    @When("^I enter following registration details:$")
    public void iEnterFollowingRegistrationDetails(DataTable data) {
        Map<String, String> dataAsMap = data.asMap(String.class,String.class);

        createNewAccount.inputData(dataAsMap.get("First name"),dataAsMap.get("Last name"),dataAsMap.get("Password"),
                dataAsMap.get("Address"),dataAsMap.get("City"),dataAsMap.get("Zip"),dataAsMap.get("Phone"),dataAsMap.get("Alias"));
    }

    @Then("^I create new account and signout$")
    public void i_create_new_account()  {
        createNewAccount.setSuccessAcntCreatedMsg();
    }


}
