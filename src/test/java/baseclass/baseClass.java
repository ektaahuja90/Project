package baseclass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class baseClass {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;

    public static Logger log;

    static {
        driver = new FirefoxDriver();
        webDriverWait = new WebDriverWait(driver, 30);
        log = LogManager.getLogger(baseClass.class.getName());
    }

    public void openWebSite() {
        Properties properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("test.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.get(properties.getProperty("url"));
    }


    protected void typeInTextBox(WebElement element, String textToType) {
        element.sendKeys(textToType);
    }


    protected void typeInTextBox(By by, String textToType) {
        getElementWhenClickable(by).sendKeys(textToType);
    }

    protected void clearAndTypeInTextBox(By by, String textToType) {
        WebElement webElement =  getElementWhenClickable(by);
        webElement.clear();
        webElement.sendKeys(textToType);
    }


    protected WebElement getElementWhenClickable(By by) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    protected void clickAction(By by) {
        getElementWhenClickable(by).click();

    }

    protected void clickAction1(By by) {
        WebElement element= webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        element.click();
    }


    protected String getMessage(By by)
    {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by)).getText();
    }

    protected void clearTextBoxAction(By by)
    {
        getElementWhenClickable(by).clear();
    }

    protected void selectByVisibleText(By by, String textToSelect) {
        Select select =  new Select(driver.findElement(by));
        select.selectByVisibleText(textToSelect);
    }

   protected void selectByValue(By by, String valueToSelect)
   {
       Select dropdown = new Select(driver.findElement(by));
       dropdown.selectByValue(valueToSelect);
   }



    protected void hoverAndClickElement(By toHover, By toClick)
   {
       Actions action = new Actions(driver);
       action.moveToElement(getElementWhenClickable(toHover)).build().perform();
       try {
           Thread.sleep(5 * 1000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       List<WebElement> allButtons = driver.findElements(toClick);
       for (int i = 0; i < allButtons.size(); i++) {
           if (allButtons.get(i).isDisplayed()) {
               allButtons.get(i).click();
               break;
           }
       }
   }

   protected void switchWindow(String title) {
       for (String winHandle : driver.getWindowHandles()) {
           driver.switchTo().window(winHandle);
           if(getTitle().contains(title)) {
               break;
           }
       }
   }

   protected String getTitle()
   {
       return driver.getTitle();
   }

    protected String getParentHandle()
    {
        return driver.getWindowHandle();

    }

   protected void switchToParentHandle(String handle)
   {
       driver.switchTo().window(handle);
   }

   protected void closeBrowser()
   {
       driver.close();
   }

   public boolean isObjectPresent(By by) {
        try {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
   }

}