package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelfHealingDriver {

    WebDriver driver;

    public SelfHealingDriver(WebDriver driver) {

        this.driver = driver;
    }

    public WebElement findElement(By... locators) {

        for(By locator : locators) {

            try {

                List<WebElement> elements =
                        driver.findElements(locator);

                if(elements.size() > 0) {

                    System.out.println("Locator Found : " + locator);

                    return elements.get(0);
                }

            }

            catch(Exception e) {

            }

        }

        throw new NoSuchElementException("Element not found using fallback locators.");

    }

}