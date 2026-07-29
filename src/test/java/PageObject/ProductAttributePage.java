package PageObject;

import org.openqa.selenium.WebDriver;
import utilities.ElementUtil;

public class ProductAttributePage {

    WebDriver driver;
    ElementUtil elementUtil;

    public ProductAttributePage(WebDriver driver) {

        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    private String attributesMenu =
            "//p[normalize-space()='Attributes']";

    private String productAttributesMenu =
            "//a[normalize-space()='Product attributes']";
    
    public void clickAttributesMenu() {
        elementUtil.click(attributesMenu);
    }

    public void clickProductAttributesMenu() {
        elementUtil.click(productAttributesMenu);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

}