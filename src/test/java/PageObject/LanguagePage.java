package PageObject;

import org.openqa.selenium.WebDriver;
import utilities.ElementUtil;
import org.openqa.selenium.By;

public class LanguagePage {

    WebDriver driver;
    ElementUtil elementUtil;

    public LanguagePage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    // Locators
 // Opens the dropdown
    private String languageCultureDropdown =
            "//span[@id='select2-LanguageCulture-container']";

    // Search box inside the dropdown
    private String languageCultureSearchBox =
            "//input[@class='select2-search__field']";
    private String configurationMenu =
            "//p[normalize-space()='Configuration']";

    private String languagesMenu =
            "//p[normalize-space()='Languages']";

    private String addNewButton =
            "//a[contains(@href,'/Admin/Language/Create')]";

    private String languageName =
            "//input[@id='Name']";

    private String languageCulture =
    		"//span[@id='select2-LanguageCulture-container']";
    private String languageCultureSearch =
    		"//input[@class='select2-search__field']";

    private String uniqueSeoCode =
            "//input[@id='UniqueSeoCode']";

    private String flagImage =
            "//input[@id='FlagImageFileName']";

    private String displayOrder =
            "//input[@id='DisplayOrder']";

    private String saveButton =
            "//button[@name='save']";

    // Methods

    public void clickConfigurationMenu() {
        elementUtil.click(configurationMenu);
    }

    public void clickLanguagesMenu() {
        elementUtil.click(languagesMenu);
    }

    public void clickAddNew() {
        elementUtil.click(addNewButton);
    }

    public void setLanguageName(String value) {
        elementUtil.type(languageName, value);
    }

    public void setLanguageCulture(String culture)
    {
        elementUtil.click(languageCultureDropdown);

        elementUtil.type(languageCultureSearch, culture);

        driver.findElement(By.xpath("//li[contains(text(),'" + culture + "')]")).click();
    }

    public void setUniqueSeoCode(String value) {
        elementUtil.type(uniqueSeoCode, value);
    }

    public void setFlagImage(String value) {
        elementUtil.type(flagImage, value);
    }

    public void setDisplayOrder(String value) {
        elementUtil.type(displayOrder, value);
    }

    public void clickSave() {
        elementUtil.click(saveButton);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
    public void selectLanguageCulture(String language) {

        elementUtil.click(languageCultureDropdown);

        elementUtil.type(languageCultureSearchBox, language);

        elementUtil.click("//li[contains(text(),'" + language + "')]");
    }
}