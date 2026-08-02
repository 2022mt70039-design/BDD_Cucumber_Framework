package PageObject;

import org.openqa.selenium.WebDriver;
import utilities.ElementUtil;

public class CountryPage {

    WebDriver driver;
    ElementUtil elementUtil;

    public CountryPage(WebDriver driver) {

        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    // ================= MENUS =================

    private String configurationMenu =
            "//p[normalize-space()='Configuration']";

    private String countriesMenu =
            "//p[normalize-space()='Countries']";

    // ================= BUTTONS =================

    private String btnAddNew =
            "//a[contains(@href,'/Admin/Country/Create')]";

    private String btnSave =
            "//button[@name='save']";

    // ================= ADD FIELDS =================

    private String txtName =
            "//input[@id='Name']";

    private String txtTwoLetterISO =
            "//input[@id='TwoLetterIsoCode']";

    private String txtThreeLetterISO =
            "//input[@id='ThreeLetterIsoCode']";

    private String txtNumericISO =
            "//input[@id='NumericIsoCode']";

    // ================= GRID =================

    private String firstEditButton =
            "//*[@id='countries-grid']//tbody//tr[1]//a[contains(@href,'Edit')]";

    // ================= DELETE =================

    private String btnDelete =
            "//*[@id='country-delete']";

    private String btnConfirmDelete =
            "//button[@type='submit' and contains(text(),'Delete')]";

    // ================= MESSAGES =================

    private String addMessage =
            "//span[contains(text(),'The new country has been added successfully')]";

    private String updateMessage =
            "//span[contains(text(),'The country has been updated successfully')]";

    private String deleteMessage =
            "//span[contains(text(),'The country has been deleted successfully')]";

    // ================= METHODS =================

    public void clickConfigurationMenu() {
        elementUtil.click(configurationMenu);
    }

    public void clickCountriesMenu() {
        elementUtil.click(countriesMenu);
    }

    public void clickAddNew() {
        elementUtil.click(btnAddNew);
    }

    public void setCountryName(String name) {
        elementUtil.clear(txtName);
        elementUtil.type(txtName, name);
    }

    public void setTwoLetterISO(String code) {
        elementUtil.clear(txtTwoLetterISO);
        elementUtil.type(txtTwoLetterISO, code);
    }

    public void setThreeLetterISO(String code) {
        elementUtil.clear(txtThreeLetterISO);
        elementUtil.type(txtThreeLetterISO, code);
    }

    public void setNumericISO(String code) {
        elementUtil.clear(txtNumericISO);
        elementUtil.type(txtNumericISO, code);
    }

    public void clickSave() {
        elementUtil.click(btnSave);
    }

    // ================= EDIT =================

    public void clickFirstEditButton() {
        elementUtil.click(firstEditButton);
    }

    // ================= DELETE =================

    public void clickDeleteButton() {
        elementUtil.click(btnDelete);
    }

    public void confirmDelete() {
        elementUtil.click(btnConfirmDelete);
    }

    // ================= VALIDATION =================

    public String getAddMessage() {
        return elementUtil.getText(addMessage);
    }

    public String getUpdateMessage() {
        return elementUtil.getText(updateMessage);
    }

    public String getDeleteMessage() {
        return elementUtil.getText(deleteMessage);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}