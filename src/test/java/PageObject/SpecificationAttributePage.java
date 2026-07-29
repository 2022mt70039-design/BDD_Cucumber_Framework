package PageObject;

import org.openqa.selenium.WebDriver;
import utilities.ElementUtil;

public class SpecificationAttributePage {

    WebDriver driver;
    ElementUtil elementUtil;

    public SpecificationAttributePage(WebDriver driver) {

        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    //==================== Locators ====================//

    private String attributesMenu =
            "//p[normalize-space()='Attributes']";

    private String specificationAttributesMenu =
            "//p[normalize-space()='Specification attributes']";

    //==================== Actions ====================//

    public void clickAttributesMenu() {

        elementUtil.click(attributesMenu);
    }

    public void clickSpecificationAttributesMenu() {

        elementUtil.click(specificationAttributesMenu);
    }

    public String getPageTitle() {

        return driver.getTitle();
    }

}