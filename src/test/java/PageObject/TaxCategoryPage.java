package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.ElementUtil;

public class TaxCategoryPage {

    WebDriver driver;
    ElementUtil elementUtil;

    public TaxCategoryPage(WebDriver driver) {

        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    // ---------------- Navigation ----------------

    private String configurationMenu =
            "//p[normalize-space()='Configuration']";

    private String taxCategoriesMenu =
            "//p[normalize-space()='Tax categories']";

    // ---------------- Add Record ----------------

    private String txtName =
            "//input[@id='AddTaxCategory_Name']";

    private String txtDisplayOrder =
            "//input[@id='AddTaxCategory_DisplayOrder']";

    private String btnAddRecord =
            "//button[@id='addTaxCategory']";

    // ---------------- Methods ----------------

    public void clickConfigurationMenu() {

        elementUtil.click(configurationMenu);
    }

    public void clickTaxCategoriesMenu() {

        elementUtil.click(taxCategoriesMenu);
    }

    public String getPageTitle() {

        return driver.getTitle();
    }

    public void setName(String name) {

        elementUtil.type(txtName, name);
    }

    public void setDisplayOrder(String order) {

        elementUtil.type(txtDisplayOrder, order);
    }

    public void clickAddRecord() {

        elementUtil.click(btnAddRecord);
    }

}