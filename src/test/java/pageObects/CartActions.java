package pageObects;

import baseclass.baseClass;
import org.openqa.selenium.By;

/**
 * Created by Eahuja on 4/4/2017.
 */
public class CartActions extends baseClass {

    By selectedItem = By.xpath("//ul[@id='homefeatured']//img[@title='Printed Chiffon Dress']");
    By cartBtn = By.cssSelector("ul#homefeatured a[title='Add to cart']");
    By homeBtn = By.xpath("//a[@class='home']");
    By proced = By.xpath(".//*[@id='center_column']/p[2]/a[1]/span");
    By closeWindowBtn = By.xpath("//span[@title='Close window']");
    By viewCartBtn = By.xpath("//a[@title='View my shopping cart']");
    By proceedAddressBtn = By.xpath("//button[@name='processAddress']");
    By checkBoxServiceAgreemement = By.id("cgv");
    By proceedCarrierBtn = By.xpath("//button[@name='processCarrier']");
    By payByBankWire = By.xpath("//a[@class='bankwire']");
    By payByCheck = By.xpath("//a[@class='cheque']");
    By confirmOrderBtn = By.xpath(".//*[@id='cart_navigation']/button");
    By backToOrdersBtn = By.xpath("//a[@title='Back to orders']");
    By submitBtn = By.xpath(".//*[@id='SubmitLogin']");
    By signinBtn = By.xpath("//a[@class='login']");
    By emailtextBox = By.xpath(".//*[@id='email']");
    By passwordTextBox = By.xpath(".//*[@id='passwd']");
    By signoutBtn = By.xpath(".//a[@class='logout']");
    By itemToAddToWishList = By.xpath("//ul[@id='homefeatured']//img[@title='Faded Short Sleeve T-shirts']");
    By viewBtnDisplayed = By.cssSelector("ul#homefeatured a[title='View']");
    By wishListBtn = By.xpath(".//*[@id='wishlist_button']");
    By closePopupBtn = By.xpath(".//*[@id='product']//a[@title='Close']");
    By popupMessage = By.xpath(".//*[@id='product']/div[2]/div/div/div/div/p");
    By accountBtn = By.xpath("//a[@class='account']");
    By myWishlistBtn = By.xpath("//a[@title='My wishlists']");
    By viewWishlistBtn = By.xpath(".//*[@id='wishlist_1361']/td[5]/a");
    By sendWishListBtn = By.xpath(".//*[@id='showSendWishlist']/span");
    By emailId1 = By.xpath(".//*[@id='email1']");
    By emailId2 = By.xpath(".//*[@id='email2']");
    By sendBtn = By.xpath("//button[@name='submitWishlist']");
    By emptyCartMessage = By.xpath(".//*[@id='center_column']/p");

    public void signInAction(String email, String password) {
        clickAction(signinBtn);
        typeInTextBox(emailtextBox,email);
        typeInTextBox(passwordTextBox,password);
        clickAction(submitBtn);
    }

    public void clickHome() {
        clickAction(homeBtn);
    }

    public void selectItem() {
        clickAction(selectedItem);
    }



    public void hoverOnImage() {

        hoverAndClickElement(selectedItem,cartBtn);

        //        WebElement addToBasket = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@tiltle='Add to cart']")));
//        addToBasket.click();

//
//        driver.findElement(cartBtn).click();
    }

    public void proceedTocheckOut() {
        clickAction(proced);
    }

    public void closeWindow() {
        clickAction(closeWindowBtn);
    }

    public void viewCart() {
        clickAction(viewCartBtn);
    }

    public void proceedAddress() {
        clickAction(proceedAddressBtn);
    }



    public void checkServiceAgreement() {
        clickAction1(checkBoxServiceAgreemement);
       // clickAction(checkBoxServiceAgreemement);
    }

    public void proceedCarrier() {
        clickAction(proceedCarrierBtn);
    }

    public void paymentBankWire() {
        clickAction(payByBankWire);
    }

    public void paymentByCheck() {
        clickAction(payByCheck);
    }

    public void confirm() {
        clickAction(confirmOrderBtn);
    }

    public void signOut() {
        clickAction(signoutBtn);
    }

    public void hoverAndClick() {
        hoverAndClickElement(itemToAddToWishList,viewBtnDisplayed);
    }

    public void clickWishListBtn() {
        clickAction(wishListBtn);
    }

    public void closePopup() {
        if (getMessage(popupMessage).equals("Added to your wishlist.")) {
            getElementWhenClickable(closePopupBtn).click();
            //clickAction(closePopupBtn);
        }
    }

    public void clickAccountBtn() {
        clickAction(accountBtn);
    }

    public void clickMyWishlistBtn() {
        clickAction(myWishlistBtn);
    }

    public void ClickViewWishListBtn() {
        clickAction(viewWishlistBtn);
    }

    public void clickSendWishlistBtn() {
        getElementWhenClickable(sendWishListBtn).click();
        getElementWhenClickable(sendWishListBtn).click();
    }

    public void enterEmailIds(String txtEmailId1, String txtEmailId2) {
        typeInTextBox(emailId1,txtEmailId1);
        typeInTextBox(emailId2,txtEmailId2);
    }

    public void sendWishList()
    {
        clickAction(sendBtn);
    }
    public void verifyEmptyCartMessage() {
        if (getMessage(emptyCartMessage).equals("Your shopping cart is empty.")) {
            System.out.println("test");
        }
    }

}
