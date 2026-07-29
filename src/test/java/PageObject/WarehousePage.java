package PageObject;

import org.openqa.selenium.WebDriver;
import utilities.ElementUtil;

public class WarehousePage {

    WebDriver driver;
    ElementUtil elementUtil;

    public WarehousePage(WebDriver driver) {

        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    // Menus
    private String shippingMenu =
            "//p[normalize-space()='Shipping']";

    private String warehousesMenu =
            "//p[normalize-space()='Warehouses']";

    // Buttons

    private String btnAddNew =
            "//a[contains(@href,'/Admin/Shipping/CreateWarehouse')]";

    private String btnSave =
            "//button[@name='save']";

    // Fields

    private String txtName =
            "//input[@id='Name']";

    private String txtFirstName =
            "//input[@id='Address_FirstName']";

    private String txtLastName =
            "//input[@id='Address_LastName']";

    private String txtEmail =
            "//input[@id='Address_Email']";

    private String txtCompany =
            "//input[@id='Address_Company']";

    private String ddlCountry =
            "//select[@id='Address_CountryId']";

    private String txtCity =
            "//input[@id='Address_City']";

    private String txtAddress1 =
            "//input[@id='Address_Address1']";

    private String txtZip =
            "//input[@id='Address_ZipPostalCode']";


    public void clickShippingMenu() {

        elementUtil.click(shippingMenu);
    }

    public void clickWarehousesMenu() {

        elementUtil.click(warehousesMenu);
    }

    public void clickAddNew() {

        elementUtil.click(btnAddNew);
    }

    public void setName(String value) {

        elementUtil.type(txtName, value);
    }

    public void setFirstName(String value) {

        elementUtil.type(txtFirstName, value);
    }

    public void setLastName(String value) {

        elementUtil.type(txtLastName, value);
    }

    public void setEmail(String value) {

        elementUtil.type(txtEmail, value);
    }

    public void setCompany(String value) {

        elementUtil.type(txtCompany, value);
    }

    public void selectCountry(String value) {

        elementUtil.selectByVisibleText(ddlCountry, value);
    }

    public void setCity(String value) {

        elementUtil.type(txtCity, value);
    }

    public void setAddress1(String value) {

        elementUtil.type(txtAddress1, value);
    }

    public void setZip(String value) {

        elementUtil.type(txtZip, value);
    }

    public void clickSave() {

        elementUtil.click(btnSave);
    }

}