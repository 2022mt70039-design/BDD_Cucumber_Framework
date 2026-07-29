package PageObject;

import org.openqa.selenium.WebDriver;

import utilities.ElementUtil;

public class CurrencyPage {

    WebDriver driver;
    ElementUtil elementUtil;

    public CurrencyPage(WebDriver driver) {

        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    // Locators
    private String nameTextbox =
            "//input[@id='Name']";

    private String currencyCodeTextbox =
            "//input[@id='CurrencyCode']";

    private String rateTextbox =
            "//input[@id='Rate']";

    private String displayLocaleDropdown =
            "//span[@id='select2-DisplayLocale-container']";

    private String displayLocaleSearchBox =
            "//input[@class='select2-search__field']";

    private String saveButton =
            "//button[@name='save']";
    private String currenciesMenu =
            "//a[contains(@href,'/Admin/Currency/List')]";

    private String addNewButton =
            "//a[contains(@href,'/Admin/Currency/Create')]";

    // Actions
    public void setCurrencyName(String name) {
        elementUtil.type(nameTextbox, name);
    }

    public void setCurrencyCode(String code) {
        elementUtil.type(currencyCodeTextbox, code);
    }

    public void setRate(String rate) {
        elementUtil.type(rateTextbox, rate);
    }

    public void selectDisplayLocale(String locale) {

        elementUtil.click(displayLocaleDropdown);

        elementUtil.type(displayLocaleSearchBox, locale);

        elementUtil.click("//li[contains(text(),'" + locale + "')]");
    }

    public void clickSave() {
        elementUtil.click(saveButton);
    }
    public void clickCurrenciesMenu() {
        elementUtil.click(currenciesMenu);
    }

    public void clickAddNew() {
        elementUtil.click(addNewButton);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

}