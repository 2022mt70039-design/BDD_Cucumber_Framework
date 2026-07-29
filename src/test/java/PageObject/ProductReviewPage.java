package PageObject;
import org.openqa.selenium.WebDriver;
import utilities.ElementUtil;

public class ProductReviewPage {
	   WebDriver driver;
	    ElementUtil elementUtil;

	    public ProductReviewPage(WebDriver driver) {
	        this.driver = driver;
	        elementUtil = new ElementUtil(driver);
	    }
	    
	 // ================= MENU =================

	    private String catalogMenu =
	            "//p[normalize-space()='Catalog']";

	    private String productReviewsMenu =
	            "//p[normalize-space()='Product reviews']";

	    // ================= SEARCH =================

	    private String txtSearchTitle =
	            "//input[@id='SearchTitle']";

	    private String btnSearch =
	            "//button[@id='search-product-reviews']";

	    // ================= GRID =================

	    private String firstReviewTitle =
	            "(//table//tbody//tr/td[3])[1]";

	    private String firstEditButton =
	            "(//table//tbody//tr//a[contains(@href,'/Admin/ProductReview/Edit')])[1]";

	    private String firstCheckbox =
	            "(//table//tbody//tr//input[@type='checkbox'])[1]";

	    // ================= EDIT =================

	    private String chkApproved =
	            "//input[@id='IsApproved']";

	    private String btnSave =
	            "//button[@name='save']";

	    // ================= DELETE =================

	    private String btnDeleteSelected =
	            "//button[@id='delete-selected']";

	    private String btnDeleteConfirm =
	            "//button[@id='delete-selected-action-confirmation-submit-button']";
	    
	    public void clickCatalogMenu() {
	        elementUtil.click(catalogMenu);
	    }

	    public void clickProductReviewsMenu() {
	        elementUtil.click(productReviewsMenu);
	    }

	    public void searchReview(String reviewTitle) {
	        elementUtil.type(txtSearchTitle, reviewTitle);
	        elementUtil.click(btnSearch);
	    }

	    public String getFirstReviewTitle() {
	        return elementUtil.getText(firstReviewTitle);
	    }

	    public void clickFirstReview() {
	        elementUtil.click(firstEditButton);
	    }

	    public void clickApprovedCheckbox() {
	        elementUtil.click(chkApproved);
	    }

	    public void clickSave() {
	        elementUtil.click(btnSave);
	    }

	    public void selectFirstReview() {
	        elementUtil.click(firstCheckbox);
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
