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

    // Menus
    private String configurationMenu =
            "//p[normalize-space()='Configuration']";

    private String countriesMenu =
            "//p[normalize-space()='Countries']";

    // Buttons
    private String btnAddNew =
            "//a[contains(@href,'/Admin/Country/Create')]";

    private String btnSave =
            "//button[@name='save']";

    // Fields
    private String txtName =
            "//input[@id='Name']";

    private String txtTwoLetterISO =
            "//input[@id='TwoLetterIsoCode']";

    private String txtThreeLetterISO =
            "//input[@id='ThreeLetterIsoCode']";

    private String txtNumericISO =
            "//input[@id='NumericIsoCode']";

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
        elementUtil.type(txtName, name);
    }

    public void setTwoLetterISO(String code) {
        elementUtil.type(txtTwoLetterISO, code);
    }

    public void setThreeLetterISO(String code) {
        elementUtil.type(txtThreeLetterISO, code);
    }

    public void setNumericISO(String code) {
        elementUtil.type(txtNumericISO, code);
    }

    public void clickSave() {
        elementUtil.click(btnSave);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}