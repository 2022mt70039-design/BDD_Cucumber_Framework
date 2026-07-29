package PageObject;

import org.openqa.selenium.WebDriver;

import utilities.ElementUtil;

public class MessageTemplatePage {

    WebDriver driver;
    ElementUtil elementUtil;

    public MessageTemplatePage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    private String lnkMessageTemplates =
            "//p[normalize-space()='Message templates']";

    private String txtSearch =
            "//input[@id='SearchKeywords']";

    private String btnSearch =
            "//button[@id='search-templates']";

    private String btnEdit =
            "(//a[contains(@href,'/Admin/MessageTemplate/Edit')])[1]";

    private String txtSubject =
            "//input[@id='Subject']";

    private String txtBody =
            "//textarea[@id='Body']";

    private String btnSave =
            "//button[@name='save']";


    public void clickMessageTemplatesMenu() {
        elementUtil.click(lnkMessageTemplates);
    }

    public void searchTemplate(String template) {
        elementUtil.clear(txtSearch);
        elementUtil.type(txtSearch, template);
    }

    public void clickSearch() {
        elementUtil.click(btnSearch);
    }

    public void clickEdit() {
        elementUtil.click(btnEdit);
    }

    public void updateSubject(String subject) {
        elementUtil.clear(txtSubject);
        elementUtil.type(txtSubject, subject);
    }

    public void updateBody(String body) {
        elementUtil.clear(txtBody);
        elementUtil.type(txtBody, body);
    }

    public void clickSave() {
        elementUtil.click(btnSave);
    }
}