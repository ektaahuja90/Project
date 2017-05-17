package pageObects;

import baseclass.baseClass;
import org.openqa.selenium.By;

/**
 * Created by Eahuja on 4/4/2017.
 */
public class ContactUsPage extends baseClass {
    By contactUsBtn = By.xpath(".//*[@id='contact-link']/a");
    By subjectHeadingDropDown = By.xpath(".//*[@id='id_contact']");
    By orderDropDown = By.xpath(".//*[@name='id_order']");
    By product = By.xpath(".//*[@id='11149_order_products']");
    By messageTextBox = By.xpath(".//*[@id='message']");
    By sendBtn = By.xpath(".//*[@id='submitMessage']");
    By successMessage = By.xpath(".//p[@class='alert alert-success']");
    By signoutBtn = By.xpath(".//a[@class='logout']");
    public void clickContactUs()
    {
        driver.findElement(contactUsBtn).click();
    }

    public void selectSubject()
    {
        selectByValue(subjectHeadingDropDown,"2");
    }

    public void selectOrderRef()
    {
        selectByValue(orderDropDown,"11149");
    }

    public void selectProduct()
    {
        selectByValue(product,"1");
    }

    public void enterMessage()
    {
        typeInTextBox(messageTextBox,"TestTest");
    }

    public void sendMessageBtn()
    {
        clickAction(sendBtn);
    }

    public void successMessageSent()
    {
        try {
            if(getMessage(successMessage).contains("successfully"))
            {
                clickAction(signoutBtn);
            }
        }
        catch(Exception ex)
        {
            System.out.print("FAIL");
        }


    }
}
