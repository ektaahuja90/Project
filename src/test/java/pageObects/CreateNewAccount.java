package pageObects;

import baseclass.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class CreateNewAccount extends baseClass {

By signinBtn = By.xpath("//a[@class='login']");
By emailId = By.xpath(".//*[@id='email_create']");
By createAcntBtn = By.xpath(".//*[@id='SubmitCreate']");
By firstnameTextBox = By.xpath(".//*[@id='customer_firstname']");
By lastnameTextBox = By.xpath(".//*[@id='customer_lastname']");
By pwdTextBox = By.xpath(".//*[@id='passwd']");
By addressTxtBox = By.xpath(".//*[@id='address1']");
By cityTextBox = By.xpath(".//*[@id='city']");
By stateDropBox = By.xpath(".//*[@id='id_state']");
By zipCodeTextBox = By.xpath(".//*[@id='postcode']");
By phoneTextBox = By.xpath(".//*[@id='phone_mobile']");
By aliasTextBox = By.xpath(".//*[@id='alias']");
By registerBtn = By.xpath(".//*[@id='submitAccount']");
By signoutBtn = By.xpath(".//a[@class='logout']");
By emailtextBox = By.xpath(".//*[@id='email']");
By passwordTextBox = By.xpath(".//*[@id='passwd']");
By submitBtn = By.xpath(".//*[@id='SubmitLogin']");
By successAcntCreatedMsg = By.xpath("//p[@class='info-account']");

    Actions action = new Actions(driver);
public void createAccnt(String email)
{
    clickAction(signinBtn);
    typeInTextBox(emailId,email);
    clickAction(createAcntBtn);
}
public void inputData(String firstname, String lastname, String password, String address, String city, String zip,String phone, String alias)
{
    typeInTextBox(getElementWhenClickable(firstnameTextBox),firstname);
    typeInTextBox(lastnameTextBox,lastname);
    typeInTextBox(pwdTextBox,password);
    typeInTextBox(addressTxtBox,address);
    typeInTextBox(cityTextBox,city);
    selectByVisibleText(stateDropBox,"New York");
    typeInTextBox(zipCodeTextBox,zip);
    typeInTextBox(phoneTextBox,phone);
    clearAndTypeInTextBox(aliasTextBox,alias);
    clickAction(registerBtn);
}

public void signOut()
{
    clickAction(signoutBtn);
}

public void signInAction(String email, String password)
{

    clickAction(signinBtn);
    typeInTextBox(emailtextBox,email);
    typeInTextBox(passwordTextBox,password);
    clickAction(submitBtn);
}

//    public void inputData(Map<String, String> dataAsMap) {
//        typeInTextBox(firstnameTextBox,dataAsMap.get("First name"));
//        typeInTextBox(lastnameTextBox,dataAsMap.get("Last name"));
//        typeInTextBox(pwdTextBox,dataAsMap.get("Password"));
//        typeInTextBox(addressTxtBox,dataAsMap.get("Address"));
//        typeInTextBox(cityTextBox,dataAsMap.get("City"));
//        selectByVisibleText(stateDropBox,"New York");
//        typeInTextBox(zipCodeTextBox,dataAsMap.get("Zip"));;
//        typeInTextBox(phoneTextBox,dataAsMap.get("Phone"));
//        clearAndTypeInTextBox(aliasTextBox,dataAsMap.get("Alias"));
//        clickAction(registerBtn);
//    }

    public void setSuccessAcntCreatedMsg()
    {
        if(getMessage(successAcntCreatedMsg).contains("Welcome to your account. Here you can manage all of your personal information and orders."))
        {
            clickAction(signoutBtn);
        }
    }

}
