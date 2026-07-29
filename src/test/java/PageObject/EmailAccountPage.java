package PageObject;

import org.openqa.selenium.WebDriver;
import utilities.ElementUtil;

public class EmailAccountPage {

    WebDriver driver;
    ElementUtil elementUtil;

    public EmailAccountPage(WebDriver driver) {

        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }
    private String btnAddNew =
            "//a[contains(@href,'/Admin/EmailAccount/Create')]";
    private String emailAccountsMenu =
            "//p[normalize-space()='Email accounts']";

    private String txtEmail =
            "//input[@id='Email']";

    private String txtDisplayName =
            "//input[@id='DisplayName']";

    private String txtHost =
            "//input[@id='Host']";

    private String txtPort =
            "//input[@id='Port']";

    private String txtMaxEmails =
            "//input[@id='MaxNumberOfEmails']";

    private String ddlAuthentication =
            "//select[@id='EmailAuthenticationMethod']";

    private String btnSave =
            "//button[@name='save']";
    
    public void setEmail(String email)
    {
        elementUtil.type(txtEmail, email);
    }

    public void setDisplayName(String name)
    {
        elementUtil.type(txtDisplayName, name);
    }

    public void setHost(String host)
    {
        elementUtil.type(txtHost, host);
    }

    public void setPort(String port)
    {
        elementUtil.clear(txtPort);
        elementUtil.type(txtPort, port);
    }

    public void setMaxEmails(String max)
    {
        elementUtil.clear(txtMaxEmails);
        elementUtil.type(txtMaxEmails, max);
    }

    public void selectAuthenticationMethod(String value)
    {
        elementUtil.selectByVisibleText(ddlAuthentication, value);
    }

    public void clickSave()
    {
        elementUtil.click(btnSave);
    }
    public void clickAddNew()
    {
        elementUtil.click(btnAddNew);
    }
    public void clickEmailAccountsMenu()
    {
        elementUtil.click(emailAccountsMenu);
    }
}