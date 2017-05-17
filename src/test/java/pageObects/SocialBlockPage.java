package pageObects;

import baseclass.baseClass;
import org.openqa.selenium.By;

/**
 * Created by Eahuja on 4/7/2017.
 */
public class SocialBlockPage extends baseClass {

    By facebookBtn = By.xpath("//section[@id='social_block']/ul/li[@class='facebook']");
    By signoutBtn = By.xpath(".//a[@class='logout']");
    By twitterBtn = By.xpath("//section[@id='social_block']/ul/li[@class='twitter']");
    By googleBtn = By.xpath("//section[@id='social_block']/ul/li[@class='google-plus']");

    public void clickfacebookBtn()
    {
        clickAction(facebookBtn);
    }

    public void switchingToFacebookWindow()
    {
        String handle = getParentHandle();
        clickfacebookBtn();
        switchWindow("facebook");
        closeBrowser();
        switchToParentHandle(handle);
    }
    public void signOut()
    {
        clickAction(signoutBtn);
    }

    public void clickTwitterBtn()
    {
        clickAction(twitterBtn);
    }

    public void switchingToTwitterWindow()
    {
        String handle = getParentHandle();
        clickTwitterBtn();
        switchWindow("Twitter");
        closeBrowser();
        switchToParentHandle(handle);
    }
        public void clickGoogleBtn()
        {
            clickAction(googleBtn);
        }

        public void switchingToGoogleWindow()
        {
            String handle = getParentHandle();
            clickGoogleBtn();
            switchWindow("Google");
            closeBrowser();
            switchToParentHandle(handle);
        }
}
