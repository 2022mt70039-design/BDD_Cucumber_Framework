package PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.SelfHealingDriver;

public class LoginPage {

    WebDriver ldriver;
    SelfHealingDriver shDriver;

    // Constructor
    public LoginPage(WebDriver rdriver) {

        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);

        shDriver = new SelfHealingDriver(ldriver);
    }

    // Enter Username
    public void setUsername(String uname) {

        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));

        shDriver.findElement(

                By.id("Email"),
                By.name("Email"),
                By.cssSelector("#Email"),
                By.xpath("//input[@id='Email']")

        ).clear();

        shDriver.findElement(

                By.id("Email"),
                By.name("Email"),
                By.cssSelector("#Email"),
                By.xpath("//input[@id='Email']")

        ).sendKeys(uname);
    }

    // Enter Password
    public void setPassword(String pwd) {

        shDriver.findElement(

                By.id("Password"),
                By.name("Password"),
                By.cssSelector("#Password"),
                By.xpath("//input[@id='Password']")

        ).clear();

        shDriver.findElement(

                By.id("Password"),
                By.name("Password"),
                By.cssSelector("#Password"),
                By.xpath("//input[@id='Password']")

        ).sendKeys(pwd);
    }

    // Click Login
    public void clickLogin() {

        shDriver.findElement(

                By.cssSelector(".login-button"),
                By.cssSelector("button[type='submit']"),
                By.xpath("//button[contains(text(),'Log in')]"),
                By.xpath("//input[@value='Log in']")

        ).click();
    }

    // Click Logout
    public void clickLogout() {

        shDriver.findElement(

                By.linkText("Logout"),
                By.partialLinkText("Logout"),
                By.xpath("//a[text()='Logout']"),
                By.xpath("//a[contains(text(),'Logout')]")

        ).click();
    }
}