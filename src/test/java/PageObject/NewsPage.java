package PageObject;

import org.openqa.selenium.WebDriver;

import utilities.ElementUtil;

public class NewsPage {

    WebDriver driver;
    ElementUtil elementUtil;

    public NewsPage(WebDriver driver) {

        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    private String configurationMenu =
            "//p[normalize-space()='Configuration']";

    private String contentManagementMenu =
            "//p[normalize-space()='Content management']";

    private String newsMenu =
            "//p[normalize-space()='News']";

    private String newsItemsMenu =
            "//p[normalize-space()='News items']";


    private String btnAddNew =
            "//a[contains(@href,'/Admin/News/NewsItemCreate')]";

    private String btnSave =
            "//button[@name='save']";


    private String txtTitle =
            "//input[@id='Title']";

    private String txtShortDescription =
            "//textarea[@id='Short']";

    private String txtFullDescription =
            "//div[@class='note-editable card-block']";


    public void clickConfigurationMenu() {

        elementUtil.click(configurationMenu);
    }

    public void clickContentManagementMenu() {

        elementUtil.click(contentManagementMenu);
    }

    public void clickNewsMenu() {

        elementUtil.click(newsMenu);
    }

    public void clickNewsItemsMenu() {

        elementUtil.click(newsItemsMenu);
    }


    public void clickAddNew() {

        elementUtil.click(btnAddNew);
    }

    public void clickSave() {

        elementUtil.click(btnSave);
    }


    public void setTitle(String title) {

        elementUtil.type(txtTitle, title);
    }

    public void setShortDescription(String description) {

        elementUtil.type(txtShortDescription, description);
    }

    public void setFullDescription(String description) {

        elementUtil.type(txtFullDescription, description);
    }


    public String getPageTitle() {

        return driver.getTitle();
    }

}