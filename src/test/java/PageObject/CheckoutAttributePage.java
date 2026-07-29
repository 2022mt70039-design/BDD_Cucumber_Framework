package PageObject;

import org.openqa.selenium.WebDriver;
import utilities.ElementUtil;

public class CheckoutAttributePage {

    WebDriver driver;
    ElementUtil elementUtil;

    public CheckoutAttributePage(WebDriver driver) {

        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    //================ Locators ================//

    private String checkoutAttributesMenu =
            "//p[normalize-space()='Checkout attributes']";

    //================ Methods ================//

    public void clickCheckoutAttributesMenu() {

        elementUtil.click(checkoutAttributesMenu);
    }

    public String getPageTitle() {

        return driver.getTitle();
    }
}