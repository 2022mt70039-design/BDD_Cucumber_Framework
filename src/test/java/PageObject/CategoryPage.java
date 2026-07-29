package PageObject;

import org.openqa.selenium.WebDriver;
import utilities.ElementUtil;

public class CategoryPage {

    WebDriver driver;
    ElementUtil elementUtil;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    // ================= MENU =================

    private String catalogMenu =
            "//p[normalize-space()='Catalog']";

    private String categoriesMenu =
            "//p[normalize-space()='Categories']";

    // ================= ADD =================

    private String btnAddNew =
            "//a[contains(@href,'/Admin/Category/Create')]";

    private String txtCategoryName =
            "//input[@id='Name']";

    private String txtDescription =
    		"//div[contains(@class,'note-editable')]";

    private String btnSave =
            "//button[@name='save']";

    // ================= SEARCH =================

    private String txtSearchCategory =
            "//input[@id='SearchCategoryName']";

    private String btnSearch =
            "//button[@id='search-categories']";

    private String firstCategoryName =
            "(//table//tbody//tr/td[2])[1]";

    // ================= EDIT =================

    private String firstEditButton =
            "(//table//tbody//tr//a[contains(@href,'/Admin/Category/Edit')])[1]";

    // ================= DELETE =================

    private String firstCategoryCheckbox =
            "(//table//tbody//tr//input[@type='checkbox'])[1]";

    private String btnDeleteSelected =
            "//button[@id='delete-selected']";

    private String btnDeleteConfirm =
            "//button[@id='delete-selected-action-confirmation-submit-button']";

    // =====================================================

    public void clickCatalogMenu() {
        elementUtil.click(catalogMenu);
    }

    public void clickCategoriesMenu() {
        elementUtil.click(categoriesMenu);
    }

    public void clickAddNewCategory() {
        elementUtil.click(btnAddNew);
    }

    public void setCategoryName(String name) {
        elementUtil.type(txtCategoryName, name);
    }

    public void setDescription(String desc) {
        elementUtil.type(txtDescription, desc);
    }

    public void clickSave() {
        elementUtil.click(btnSave);
    }

    public void searchCategory(String categoryName) {

        elementUtil.type(txtSearchCategory, categoryName);
        elementUtil.click(btnSearch);

    }

    public String getFirstCategoryName() {
        return elementUtil.getText(firstCategoryName);
    }

    public void clickFirstCategory() {
        elementUtil.click(firstEditButton);
    }

    public void selectFirstCategory() {
        elementUtil.click(firstCategoryCheckbox);
    }

    public void clickDeleteSelected() {
        elementUtil.click(btnDeleteSelected);
    }

    public void confirmDelete() {
        elementUtil.click(btnDeleteConfirm);
    }
    
    public String getPageTitle() {
        return driver.getTitle();
    }

}