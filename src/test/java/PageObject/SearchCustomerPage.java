package PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.SelfHealingDriver;

public class SearchCustomerPage {

    WebDriver ldriver;
    private SelfHealingDriver shDriver;

    public SearchCustomerPage(WebDriver rdriver) {

        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);

        shDriver = new SelfHealingDriver(ldriver);
    }

    // =========================
    // Search Filters
    // =========================

    public void setEmail(String email) {

        WebElement txtEmail = shDriver.findElement(

                By.id("SearchEmail"),
                By.name("SearchEmail"),
                By.xpath("//input[@id='SearchEmail']"),
                By.cssSelector("#SearchEmail")

        );

        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void setFirstName(String fname) {

        WebElement txtFirstName = shDriver.findElement(

                By.id("SearchFirstName"),
                By.name("SearchFirstName"),
                By.xpath("//input[@id='SearchFirstName']"),
                By.cssSelector("#SearchFirstName")

        );

        txtFirstName.clear();
        txtFirstName.sendKeys(fname);
    }

    public void setLastName(String lname) {

        WebElement txtLastName = shDriver.findElement(

                By.id("SearchLastName"),
                By.name("SearchLastName"),
                By.xpath("//input[@id='SearchLastName']"),
                By.cssSelector("#SearchLastName")

        );

        txtLastName.clear();
        txtLastName.sendKeys(lname);
    }

    public void clickSearch() {

        shDriver.findElement(

                By.id("search-customers"),
                By.cssSelector("#search-customers"),
                By.xpath("//button[@id='search-customers']")

        ).click();

        WebDriverWait wait =
                new WebDriverWait(ldriver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table[contains(@class,'table')]//tbody/tr")));
    }

    // =========================
    // Search By Email
    // =========================

    public boolean searchCustomerByEmail(String email) {

        List<WebElement> rows = ldriver.findElements(
                By.xpath("//table[contains(@class,'table')]//tbody/tr"));

        for (WebElement row : rows) {

            String actualEmail = row.findElement(By.xpath("./td[2]"))
                                    .getText()
                                    .trim();

            if (actualEmail.equalsIgnoreCase(email)) {

                return true;
            }
        }

        return false;
    }

    // =========================
    // Search By Name
    // =========================

    public boolean searchCustomerByName(String firstName, String lastName) {

        List<WebElement> rows = ldriver.findElements(
                By.xpath("//table[contains(@class,'table')]//tbody/tr"));

        System.out.println("Total Rows = " + rows.size());

        for (WebElement row : rows) {

            String fullName = row.findElement(By.xpath("./td[3]"))
                                 .getText()
                                 .trim();

            System.out.println(fullName);

            if (fullName.equalsIgnoreCase(firstName + " " + lastName)) {

                return true;
            }
        }

        return false;
    }
}