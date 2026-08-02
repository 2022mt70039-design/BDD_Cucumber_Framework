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

    // Navigation
    private String checkoutAttributesMenu =
            "//p[normalize-space()='Checkout attributes']";

    // Add
    private String btnAddNew =
            "//a[contains(@href,'CheckoutAttribute/Create')]";

    private String txtName =
            "//*[@id='Name']";

    private String ddlControlType =
            "//*[@id='select2-AttributeControlTypeId-container']";

    private String optionTextbox =
            "//li[contains(text(),'Textbox')]";

    private String chkRequired =
            "//*[@id='IsRequired']";

    private String txtDisplayOrder =
            "//*[@id='DisplayOrder']";

    private String btnSave =
            "//button[@name='save']";

    // Grid
    private String firstRowName =
            "//*[@id='checkoutattributes-grid']//tbody//tr[1]/td[2]";

    private String firstRowEdit =
            "//*[@id='checkoutattributes-grid']//tbody//tr[1]//a[contains(@href,'Edit')]";

    private String firstRowCheckbox =
            "//*[@id='checkoutattributes-grid']//tbody//tr[1]//input[@type='checkbox']";

    // Delete
    private String btnDeleteSelected =
            "//*[@id='delete-selected']";

    private String btnConfirmDelete =
            "//*[@id='delete-selected-action-confirmation-submit-button']";

    // Messages
    private String addSuccess =
            "//span[contains(text(),'added successfully')]";

    private String updateSuccess =
            "//span[contains(text(),'updated successfully')]";

    private String noData =
            "//td[@class='dt-empty']";

    // Navigation

    public void clickCheckoutAttributesMenu() {
        elementUtil.click(checkoutAttributesMenu);
    }

    // Add

    public void clickAddNew() {
        elementUtil.click(btnAddNew);
    }

    public void enterName(String name) {
        elementUtil.type(txtName, name);
    }

    public void selectTextboxControl() {

        elementUtil.click(ddlControlType);

        elementUtil.click(optionTextbox);
    }

    public void clickRequired() {
        elementUtil.click(chkRequired);
    }

    public void enterDisplayOrder(String order) {

        elementUtil.clear(txtDisplayOrder);

        elementUtil.type(txtDisplayOrder, order);
    }

    public void clickSave() {
        elementUtil.click(btnSave);
    }

    // Grid

    public String getFirstRowName() {
        return elementUtil.getText(firstRowName);
    }

    // Edit

    public void clickFirstEdit() {
        elementUtil.click(firstRowEdit);
    }

    public void updateName(String name) {

        elementUtil.clear(txtName);

        elementUtil.type(txtName, name);
    }

    // Delete

    public void selectFirstRow() {
        elementUtil.click(firstRowCheckbox);
    }

    public void clickDeleteSelected() {
        elementUtil.click(btnDeleteSelected);
    }

    public void confirmDelete() {
        elementUtil.click(btnConfirmDelete);
    }

    // Validation

    public String getAddSuccessMessage() {
        return elementUtil.getText(addSuccess);
    }

    public String getUpdateSuccessMessage() {
        return elementUtil.getText(updateSuccess);
    }

    public boolean isDeleted() {

        return elementUtil.getText(noData)
                .equalsIgnoreCase("No data available in table");
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}