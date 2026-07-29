package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementUtil;

public class NewsItemPage {

    WebDriver driver;
    ElementUtil elementUtil;

    public NewsItemPage(WebDriver driver) {

        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }


    private String configurationMenu =
            "//p[normalize-space()='Configuration']";

    private String contentManagementMenu =
            "//p[normalize-space()='Content management']";

    private String newsItemsMenu =
            "//a[@href='/Admin/News/NewsItems']";

    private String newsMenu =
            "//p[normalize-space()='News']";

    private String btnAddNew =
            "//a[contains(@href,'/Admin/News/NewsItemCreate')]";

    private String btnSave =
            "//button[@name='save']";



    private String txtTitle =
            "//input[@id='Title']";

    private String txtShortDescription =
            "//textarea[@id='Short']";

    // Summernote Editor
    private String txtFullDescription =
            "//div[@class='note-editable card-block']";



    private String successMessage =
            "//span[contains(text(),'The new news item has been added successfully.')]";

    public void clickConfigurationMenu() {

        elementUtil.click(configurationMenu);
    }

    public void clickContentManagementMenu() {

        elementUtil.click(contentManagementMenu);
    }
    
    public void clickNewsMenu()
    {
        elementUtil.click(newsMenu);
    }

    public void clickNewsItemsMenu() {

        elementUtil.click(newsItemsMenu);
    }


    public void clickAddNew() {

        elementUtil.click(btnAddNew);
    }


    public void setTitle(String title) {

        elementUtil.type(txtTitle, title);
    }

    public void setShortDescription(String shortDescription) {

        elementUtil.type(txtShortDescription, shortDescription);
    }

    public void setFullDescription(String fullDescription) {

        elementUtil.type(txtFullDescription, fullDescription);
    }


    public void clickSave() {

        elementUtil.click(btnSave);
    }


    public boolean isNewsItemsPageDisplayed() {

        return driver.getTitle().contains("News items");
    }

    public boolean isAddNewsItemPageDisplayed() {
        return driver.findElement(By.id("Title")).isDisplayed();
    }

    public boolean isNewsAddedSuccessfully() {

        return elementUtil.isDisplayed(successMessage);
    }

    public String getPageTitle() {

        return driver.getTitle();
    }
    
    

}