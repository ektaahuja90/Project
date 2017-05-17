package stepdefinitions;

import cucumber.api.java.en.Given;
import pageObects.CreateNewAccount;
import pageObects.SocialBlockPage;

import java.io.IOException;

/**
 * Created by Eahuja on 4/7/2017.
 */
public class SocialBlockStepDef {


    SocialBlockPage socialBlockPage;
    CreateNewAccount createNewAccount;

    public SocialBlockStepDef(SocialBlockPage socialBlockPage,CreateNewAccount createNewAccount) {
        this.socialBlockPage = socialBlockPage;
        this.createNewAccount = createNewAccount;
    }

    @Given("^I click on facebook and get heading$")
    public void iClickOnFacebook() {
        socialBlockPage.switchingToFacebookWindow();
    }


    @Given("^I click on twitter and get heading$")
    public void iClickOnTwitter() throws IOException {
        socialBlockPage.switchingToTwitterWindow();
    }



    @Given("^I click on google and get heading$")
    public void iClickOnGoogle()  {

        socialBlockPage.switchingToGoogleWindow();
    }


    @Given("^I open website$")
    public void iOpenWebsite() {
        createNewAccount.openWebSite();
    }
}
