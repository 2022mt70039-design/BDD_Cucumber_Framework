package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import utilities.ElementUtil;

public class MeasurePage {

    WebDriver driver;
    ElementUtil elementUtil;

    public MeasurePage(WebDriver driver) {

        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }
    
    private String btnAddNewRecord =
            "//button[@id='addMeasureDimension']";

    private String txtName =
    		 "//input[@id='AddMeasureDimension_Name']";

    private String txtSystemKeyword =
    		"//input[@id='AddMeasureDimension_SystemKeyword']";

    private String txtRatio =
    		  "//input[@id='AddMeasureDimension_Ratio']";

    private String txtDisplayOrder =
    		"//input[@id='AddMeasureDimension_DisplayOrder']";

    private String btnAddRecord =
            "//button[@id='addMeasureDimension']";
    
    private String shippingMenu =
            "//p[normalize-space()='Shipping']";
    private String configurationMenu =
            "//p[normalize-space()='Configuration']";

    private String measuresMenu =
            "//p[normalize-space()='Measures']";


    public void clickConfigurationMenu() {

        elementUtil.click(configurationMenu);
    }

    public void clickMeasuresMenu() {

        elementUtil.click(measuresMenu);
    }

    

    public String getPageTitle() {

        return driver.getTitle();
    }
    public void clickShippingMenu() {

        elementUtil.click(shippingMenu);
    }
    
    public void clickAddNewRecord() {

        elementUtil.click(btnAddNewRecord);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setName(String name)
    {
        elementUtil.type(txtName, name);
    }

    public void setSystemKeyword(String keyword)
    {
        elementUtil.type(txtSystemKeyword, keyword);
    }

    public void setRatio(String ratio)
    {
        elementUtil.type(txtRatio, ratio);
    }

    public void setDisplayOrder(String order)
    {
        elementUtil.type(txtDisplayOrder, order);
    }

    public void clickAddRecord()
    {
        elementUtil.click(btnAddRecord);
    }
   
}