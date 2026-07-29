package PageObject;

import org.openqa.selenium.WebDriver;
import utilities.ElementUtil;

public class ProductPage {

    WebDriver driver;
    ElementUtil elementUtil;
    
    

    public ProductPage(WebDriver driver) {

        this.driver = driver;
        elementUtil = new ElementUtil(driver);
        
        

    }
 // Catalog Menu
    private String catalogMenu =
            "//p[normalize-space()='Catalog']";

    // Products Menu
    private String productsMenu =
            "//p[normalize-space()='Products']";

    // Add New Button
    private String addNewButton =
            "//a[contains(@href,'/Admin/Product/Create')]";

    // Product Name
    private String txtProductName =
            "//input[@id='Name']";

    // Save Button
    private String btnSave =
            "//button[@name='save']";
    
   // private String txtProductName = "//input[@id='Name']";

    private String txtShortDescription =
            "//textarea[@id='ShortDescription']";

    private String txtSku =
            "//input[@id='Sku']";

    private String txtPrice =
            "//input[@id='Price']";

    private String chkPublished =
            "//input[@id='Published']";

   // private String btnSave ="//button[@name='save']";
    
 // Product Search
    private String txtSearchProductName =
            "//input[@id='SearchProductName']";

    private String btnSearch =
            "//button[@id='search-products']";

    // First Edit Button
    private String firstEditButton =
            "(//table[contains(@class,'table')]//tbody/tr//a[contains(@href,'/Admin/Product/Edit')])[1]";

    private String btnConfirmDelete =
    		"//button[@id='delete-selected-action-confirmation-submit-button']";
   // private String btnConfirmDelete ="//button[@id='delete-selected-action-confirmation-submit-button']";
    
 // First product checkbox
    private String firstProductCheckbox =
    "(//table[contains(@class,'table')]//tbody/tr//input[@type='checkbox'])[1]";

    // Delete Selected button
    private String btnDeleteSelected =
    "//button[@id='delete-selected']";
    
    
    public void clickCatalogMenu() {

        elementUtil.click(catalogMenu);

    }

    public void clickProductsMenu() {

        elementUtil.click(productsMenu);

    }

    public void clickAddNewProduct() {

        elementUtil.click(addNewButton);

    }

    public void setProductName(String name) {

        elementUtil.type(txtProductName, name);

    }

    public void clickSave() {

        elementUtil.click(btnSave);

    }

    public String getPageTitle() {

        return driver.getTitle();

    }
    

    public void setShortDescription(String desc) {

        elementUtil.type(txtShortDescription, desc);

    }

    public void setSKU(String sku) {

        elementUtil.type(txtSku, sku);

    }

    public void setPrice(String price) {

        elementUtil.type(txtPrice, price);

    }
    public void searchProduct(String productName) {

        elementUtil.type(txtSearchProductName, productName);

        elementUtil.click(btnSearch);

    }
    public void clickFirstProduct() {

        elementUtil.click(firstEditButton);

    }
    public void confirmDelete() {

        elementUtil.click(btnConfirmDelete);

    }
    private String firstProductName =
    	    "(//table[contains(@class,'table')]//tbody/tr/td[3])[1]";

    	public String getFirstProductName() {
    	    return elementUtil.getText(firstProductName);
    	}
    	
    	public void selectFirstProduct() {

    	    elementUtil.click(firstProductCheckbox);

    	}

    	public void clickDeleteSelected() {

    	    elementUtil.click(btnDeleteSelected);

    	}
    	
    	

    
    

}