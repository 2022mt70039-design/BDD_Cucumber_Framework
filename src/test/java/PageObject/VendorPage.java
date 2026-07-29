package PageObject;

import org.openqa.selenium.WebDriver;

import utilities.ElementUtil;

public class VendorPage {

    WebDriver driver;
    ElementUtil elementUtil;

    public VendorPage(WebDriver driver) {

        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    private String vendorName = "//input[@id='Name']";

    private String vendorEmail = "//input[@id='Email']";

    private String vendorDescription = "//div[@role='textbox' and contains(@class,'note-editable')]";

    private String saveButton = "//button[@name='save']";

    private String customersMenu =
            "//p[normalize-space()='Customers']";

    private String vendorsMenu =
            "//p[normalize-space()='Vendors']";

    private String addNewButton =
            "//a[contains(@href,'/Admin/Vendor/Create')]";

    // Methods

    public void clickCustomersMenu() {

        elementUtil.click(customersMenu);
    }

    public void clickVendorsMenu() {

        elementUtil.click(vendorsMenu);
    }

    public void clickAddNewVendor() {

        elementUtil.click(addNewButton);
    }

    public String getPageTitle() {

        return driver.getTitle();
    }
    
    public void setVendorName(String name) {

        elementUtil.type(vendorName, name);
    }

    public void setVendorEmail(String email) {

        elementUtil.type(vendorEmail, email);
    }

    public void setVendorDescription(String description) {

        elementUtil.type(vendorDescription, description);
    }

    public void clickSave() {

        elementUtil.click(saveButton);
    }

}