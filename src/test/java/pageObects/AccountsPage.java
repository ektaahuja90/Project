package pageObects;

import baseclass.baseClass;
import org.openqa.selenium.By;

/**
 * Created by Eahuja on 4/4/2017.
 */
public class AccountsPage extends baseClass {

    By accountBtn = By.xpath("//a[@class='account']");
    By addressBtn = By.xpath("//ul[@class='myaccount-link-list']/li[3]//a");
    By addAddressBtn = By.xpath("//a[@title='Add an address']");
    By addressTxtBox = By.xpath(".//*[@id='address1']");
    By cityTextBox = By.xpath(".//*[@id='city']");
    By stateDropBox = By.xpath(".//*[@id='id_state']");
    By zipCodeTextBox = By.xpath(".//*[@id='postcode']");
    By phoneTextBox = By.xpath(".//*[@id='phone_mobile']");
    By addressTitle = By.xpath(".//*[@id='alias']");
    By submitAddressBtn = By.xpath(".//*[@id='submitAddress']");
    By signoutBtn = By.xpath(".//a[@class='logout']");
    By addressWarning = By.xpath("///div[@class='alert alert-danger']/ol/li");
    By backToAddress = By.xpath(".//*[@id='center_column']/ul/li/a/span");
    By newsletterTextBox = By.xpath(".//*[@id='newsletter-input']");
    By submitNewsletterBtn = By.xpath("//button[@name='submitNewsletter']");
    By newsletterSuccessMsg = By.xpath("//p[@class='alert alert-success']");
    By newsletterFailMessage = By.xpath("//p[@class='alert alert-danger']");
    By creditSlipsBtn = By.xpath("//a[@title='My credit slips']");
    By creditSlipMessage = By.xpath(".//*[@id='block-history']/p");
    By backToAccountBtn = By.xpath(".//*[@id='center_column']/ul/li[1]/a/span");


    public void clickAccount()
    {
        clickAction(accountBtn);
    }

    public void clickAddressOption()
    {
        clickAction(addressBtn);
    }

    public void clickAddAddress()
    {
        clickAction(addAddressBtn);
    }

    public void enterAddress(String address, String city, String zip, String phone, String alias)
    {

        typeInTextBox(addressTxtBox,address);
        typeInTextBox(cityTextBox,city);
        selectByVisibleText(stateDropBox,"Texas");
        typeInTextBox(zipCodeTextBox,zip);
        typeInTextBox(phoneTextBox,phone);
        clearTextBoxAction(addressTitle);
        typeInTextBox(addressTitle,alias);
    }


    public void clickSubmitAddress()
    {
        clickAction(submitAddressBtn);
    }

    public void addressAlreadyPresentWarning()
    {
        if(getMessage(addressWarning).equals("The alias \"Office\" has already been used. Please select another one.")) {
            clickAction(backToAddress);
        }
    }
    public void signOut()
    {
        clickAction(signoutBtn);
    }

    public void enteremailIdForNewsletter(String email)
    {
        typeInTextBox(newsletterTextBox,email);
        clickAction(submitNewsletterBtn);
    }

    public void verifyNwsletterSubscribe()
    {
            if (isObjectPresent(newsletterSuccessMsg))
            {
                getMessage(newsletterSuccessMsg).equals("Newsletter : You have successfully subscribed to this newsletter.");
                signOut();
                //log.info("Successful news letter subscription");

            }
            else
            {
                System.out.print("Error");
                //log.error("Subscription not successful");
                signOut();
            }
    }

    public void clickCreditSlipsBtn()
    {
        clickAction(creditSlipsBtn);
    }

    public void verifyCreditSlips()
    {
        if(getMessage(creditSlipMessage).equals("You have not received any credit slips."))
        {
            clickAction(backToAccountBtn);
        }
    }
}
