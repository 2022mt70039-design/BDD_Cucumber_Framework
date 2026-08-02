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
    

    // Navigation
    private String attributesMenu =
            "//p[normalize-space()='Attributes']";

    private String productAttributesMenu =
            "//a[normalize-space()='Product attributes']";

    // Add Product Attribute
    private String addNewButton =
            "//a[contains(@href,'/Admin/ProductAttribute/Create')]";

    private String txtAttributeName =
            "//*[@id='Name']";

    private String txtDescription =
            "//div[@class='note-editable card-block']";

    private String btnSave =
            "//button[@name='save']";
    private String noDataMessage = "//td[@class='dt-empty']";
    // Search
    private String txtSearchProductAttribute =
            "//*[@id='SearchProductAttributeName']";

    private String btnSearch =
            "//*[@id='search-productattributes']";

    // Grid
    private String firstRowProductName =
            "//*[@id='products-grid']//tbody//tr[1]/td[2]";

    private String firstRowEditButton =
            "//*[@id='products-grid']//tbody//tr[1]//a[contains(@href,'Edit')]";

    private String firstRowCheckbox =
            "//*[@id='products-grid']//tbody//tr[1]//input[@type='checkbox']";

    // Delete
    private String btnDeleteSelected =
            "//*[@id='delete-selected']";

    private String btnConfirmDelete =
            "//*[@id='delete-selected-action-confirmation-submit-button']";

    // Success Message
    private String successMessage =
    		"//div[contains(@class,'alert-success')]//span";
    private String updateMessage =
    		"//span[contains(text(),'updated successfully')]";

    // ---------------- Navigation ----------------

    public void clickAttributesMenu() {
        elementUtil.click(attributesMenu);
    }

    public void clickProductAttributesMenu() {
        elementUtil.click(productAttributesMenu);
    }

    // ---------------- Add ----------------

    public void clickAddNewButton() {
        elementUtil.click(addNewButton);
    }

    public void enterAttributeName(String name) {
    	elementUtil.type(txtAttributeName, name);
    }

    public void enterDescription(String description) {
    	elementUtil.typeRichText(txtDescription, description);
    }

    public void clickSaveButton() {
        elementUtil.click(btnSave);
    }

    // ---------------- Search ----------------

    public void searchProductAttribute(String name) {

    	 elementUtil.clear(txtSearchProductAttribute);

    	    elementUtil.type(txtSearchProductAttribute, name);

    	    elementUtil.click(btnSearch);
    }

    public String getFirstRowProductAttributeName() {
    	 return elementUtil.getText(firstRowProductName);
    }

    // ---------------- Edit ----------------

    public void clickFirstEditButton() {
    	elementUtil.clickWhenClickable(firstRowEditButton);
    }

    public void updateProductAttributeName(String name) {

    	elementUtil.clear(txtAttributeName);

        elementUtil.type(txtAttributeName, name);
    }

    // ---------------- Delete ----------------

    public void selectFirstRowCheckbox() {
        elementUtil.click(firstRowCheckbox);
    }

    public void clickDeleteSelected() {
        elementUtil.click(btnDeleteSelected);
    }

    public void clickConfirmDelete() {
        elementUtil.click(btnConfirmDelete);
    }

    // ---------------- Validation ----------------

    public String getSuccessMessage() {
    	   elementUtil.waitForVisible(successMessage);

    	    return elementUtil.getText(successMessage);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
    public String getUpdateMessage() {
        return elementUtil.getText(updateMessage);
    }
    
    public boolean isProductAttributeDeleted() {

        return elementUtil.getText(noDataMessage)
                .equalsIgnoreCase("No data available in table");
    }

}