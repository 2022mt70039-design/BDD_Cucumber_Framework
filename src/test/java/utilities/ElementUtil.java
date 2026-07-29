package utilities;

import java.time.Duration;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

    WebDriver driver;
    WebDriverWait wait;

    public ElementUtil(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public WebElement getElement(String xpath) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void click(String xpath) {

        getElement(xpath).click();
    }

    public void type(String xpath, String value) {

        WebElement ele = getElement(xpath);

        ele.clear();

        ele.sendKeys(value);
    }

    public String getText(String xpath) {

        return getElement(xpath).getText();
    }

    public boolean isDisplayed(String xpath) {

        return getElement(xpath).isDisplayed();
    }
    
    public void clickWhenClickable(String xpath) {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }
    
    public void typeRichText(String locator, String text) {

        WebElement editor = getElement(locator);

        editor.click();

        editor.clear();

        editor.sendKeys(text);
    }
    
    public void clear(String xpath) {

        getElement(xpath).clear();
    }
    
    public void clearRichText(String locator) {

        WebElement editor = getElement(locator);

        editor.click();

        editor.clear();
    }
    public void selectByVisibleText(String locator, String text)
    {
        WebElement element = getElement(locator);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
    
    public boolean isSelected(String locator) {

        return getElement(locator).isSelected();
    }
    

}