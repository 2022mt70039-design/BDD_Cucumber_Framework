package PageObject;
import org.openqa.selenium.WebDriver;
import utilities.ElementUtil;

public class ManufacturerPage {
	
	  WebDriver driver;
	    ElementUtil elementUtil;

	    public ManufacturerPage(WebDriver driver) {
	        this.driver = driver;
	        elementUtil = new ElementUtil(driver);
	    }
	
	private String catalogMenu =
			"//p[normalize-space()='Catalog']";

			private String manufacturersMenu =
			"//p[normalize-space()='Manufacturers']";
			
			private String btnAddNew =
					"//a[contains(@href,'/Admin/Manufacturer/Create')]";
			private String txtManufacturerName =
					"//input[@id='Name']";
			private String txtDescription =
					"//div[contains(@class,'note-editable')]";
			private String btnSave =
					"//button[@name='save']";
			private String txtSearchManufacturer =
					"//input[@id='SearchManufacturerName']";
			private String btnSearch =
					"//button[@id='search-manufacturers']";
			private String firstManufacturerName =
					"(//table//tbody//tr/td[2])[1]";
			private String firstEditButton =
					"(//table//tbody//tr//a[contains(@href,'/Admin/Manufacturer/Edit')])[1]";
			private String firstCheckbox =
					"(//table//tbody//tr//input[@type='checkbox'])[1]";
			private String btnDeleteSelected =
					"//button[@id='delete-selected']";
			private String btnDeleteConfirm =
					"//button[@id='delete-selected-action-confirmation-submit-button']";
			
			public void clickCatalogMenu() {
			    elementUtil.click(catalogMenu);
			}

			public void clickManufacturersMenu() {
			    elementUtil.click(manufacturersMenu);
			}

			public void clickAddNewManufacturer() {
			    elementUtil.click(btnAddNew);
			}

			public void setManufacturerName(String name) {
			    elementUtil.type(txtManufacturerName, name);
			}

			public void setDescription(String desc) {
			    elementUtil.typeRichText(txtDescription, desc);
			}

			public void clickSave() {
			    elementUtil.click(btnSave);
			}

			public String getPageTitle() {
			    return driver.getTitle();
			}
			
			public void searchManufacturer(String manufacturerName) {

			    elementUtil.type(txtSearchManufacturer, manufacturerName);

			    elementUtil.click(btnSearch);
			}

			public String getFirstManufacturerName() {

			    return elementUtil.getText(firstManufacturerName);
			}
			
			public void clickFirstManufacturer() {
			    elementUtil.click(firstEditButton);
			}

			public void selectFirstManufacturer() {
			    elementUtil.click(firstCheckbox);
			}

			public void clickDeleteSelected() {
			    elementUtil.click(btnDeleteSelected);
			}

			public void confirmDelete() {
			    elementUtil.click(btnDeleteConfirm);
			}

}
