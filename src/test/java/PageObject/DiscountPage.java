package PageObject;

import org.openqa.selenium.WebDriver;

import utilities.ElementUtil;

public class DiscountPage {

    WebDriver driver;
    ElementUtil elementUtil;

    public DiscountPage(WebDriver driver) {

        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }


    private String promotionsMenu =
            "//p[normalize-space()='Promotions']";

    private String discountsMenu =
            "//p[normalize-space()='Discounts']";

    private String btnAddNew =
            "//a[contains(@href,'/Admin/Discount/Create')]";

    private String txtName =
            "//input[@id='Name']";

    private String chkUsePercentage =
            "//input[@id='UsePercentage']";

    private String txtDiscountAmount =
            "//input[@id='DiscountAmount']";

    private String btnSave =
            "//button[@name='save']";


    public void clickPromotionsMenu() {

        elementUtil.click(promotionsMenu);
    }

    public void clickDiscountsMenu() {

        elementUtil.click(discountsMenu);
    }

    public void clickAddNew() {

        elementUtil.click(btnAddNew);
    }

    public void setName(String name) {

        elementUtil.type(txtName, name);
    }

    public void uncheckUsePercentage() {

        if (elementUtil.isSelected(chkUsePercentage)) {

            elementUtil.click(chkUsePercentage);
        }
    }

    public void setDiscountAmount(String amount) {

        elementUtil.clear(txtDiscountAmount);
        elementUtil.type(txtDiscountAmount, amount);
    }

    public void clickSave() {

        elementUtil.click(btnSave);
    }

    public boolean isDiscountPageDisplayed() {

        return driver.getPageSource().contains("Discounts");
    }

    public boolean isAddDiscountPageDisplayed() {

        return driver.getTitle().contains("Add a discount");
    }

}