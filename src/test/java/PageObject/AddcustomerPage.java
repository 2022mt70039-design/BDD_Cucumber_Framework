package PageObject;

import java.time.Duration;
import utilities.SelfHealingDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefination.BaseClass;

public class AddcustomerPage extends BaseClass {
	
	public WebDriver ldriver;
	private SelfHealingDriver shDriver;
	
	public AddcustomerPage(WebDriver rdriver)
	{
	    ldriver = rdriver;
	    PageFactory.initElements(ldriver, this);

	    shDriver = new SelfHealingDriver(ldriver);
	}
	
	
	By InkCustomers_menuitem =By.xpath("//a[@href='/Admin/Customer/List']");
	By btnAddnew = By.xpath("//a[contains(@href,'/Customer/Create')]");
	By txtEmail=By.xpath("//input[@id='Email']");
	By txtPassword=By.xpath("//input[@id='Password']");
	By txtcustomerRoles =By.xpath("//*[@id='SelectedCustomerRoleIds']");
	By lstitemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemRegistered=By.xpath("//li[contains (text(), 'Registered')]");
	By lstitemGuests=By.xpath("//li[contains (text(), 'Guests')]");
	By lstitemVendors=By.xpath("//li[contains (text(), 'Vendors')]");
	By drpmgrofVendor=By.xpath("//*[@id='VendorId']");
	By rdMaleGender=By.id("Gender_Male");
	By rdFeMaleGender=By.id("Gender_Female");
	By txtFirstName=By.xpath("//input[@id='FirstName']");
	By txtLastName=By.xpath("//input[@id='LastName']");
	By txtDob=By.xpath("//input[@id='DateOfBirth']");
	By txtCompanyName=By.xpath("//input[@id='Company']");
	By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");
	By btnSave=By.xpath("//button[@name='save']");
	
	//Action Methods
	
	public String gePageTitle() {
		return ldriver.getTitle();
	}

	public void clickOnCustomersMenu() {

	    WebDriverWait wait =
	            new WebDriverWait(ldriver, Duration.ofSeconds(20));

	    WebElement customersMenu = wait.until(
	            ExpectedConditions.presenceOfElementLocated(
	                    By.xpath("//a[@href='/Admin/Customer/List']")));

	    ((JavascriptExecutor) ldriver)
	            .executeScript("arguments[0].scrollIntoView(true);", customersMenu);

	    ((JavascriptExecutor) ldriver)
	            .executeScript("arguments[0].click();", customersMenu);
	}
	
	public void clickOnCustomersMenuItem() {
	    ldriver.findElement(InkCustomers_menuitem).click();
	}

	public void clickOnAddnew() {
	    ldriver.findElement(btnAddnew).click();
	}

	public void setEmail(String email) {

	    shDriver.findElement(

	            By.id("Email"),
	            By.name("Email"),
	            By.xpath("//input[@id='Email']"),
	            By.cssSelector("#Email")

	    ).sendKeys(email);
	}
	
	public void setPassword(String password) {

	    shDriver.findElement(

	            By.id("Password"),
	            By.name("Password"),
	            By.xpath("//input[@id='Password']"),
	            By.cssSelector("#Password")

	    ).sendKeys(password);
	}
	
		
	public void setCustomerRoles(String role) {

	    WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));

	    WebElement roleBox = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    By.xpath("//span[contains(@class,'select2-selection--multiple')]")));

	    roleBox.click();

	    WebElement option = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    By.xpath("//li[normalize-space()='" + role + "']")));

	    option.click();
	}
	
	public void setManagerOfVendor(String vendorName) {

	    WebDriverWait wait =
	            new WebDriverWait(ldriver, Duration.ofSeconds(10));

	    WebElement vendor =
	            wait.until(ExpectedConditions.visibilityOfElementLocated(drpmgrofVendor));

	    Select drp = new Select(vendor);

	    boolean found = false;

	    for (WebElement option : drp.getOptions()) {

	        if (option.getText().trim().equalsIgnoreCase(vendorName)) {

	            drp.selectByVisibleText(option.getText());

	            found = true;

	            break;
	        }
	    }

	    if (!found) {

	        System.out.println("Vendor '" + vendorName
	                + "' not found. Selecting first available option.");

	        drp.selectByIndex(0);
	    }
	}
		
	public void setFirstName(String fname) {

	    shDriver.findElement(

	            By.id("FirstName"),
	            By.name("FirstName"),
	            By.xpath("//input[@id='FirstName']"),
	            By.cssSelector("#FirstName")

	    ).sendKeys(fname);
	}

	public void setLastName(String lname) {

	    shDriver.findElement(

	            By.id("LastName"),
	            By.name("LastName"),
	            By.xpath("//input[@id='LastName']"),
	            By.cssSelector("#LastName")

	    ).sendKeys(lname);
	}

		public void setDob (String dob){
			ldriver.findElement(txtDob).sendKeys(dob);
			}

		public void setCompanyName(String comname) {

		    shDriver.findElement(

		            By.id("Company"),
		            By.name("Company"),
		            By.xpath("//input[@id='Company']"),
		            By.cssSelector("#Company")

		    ).sendKeys(comname);
		}

		public void setAdminContent(String content) {

		    shDriver.findElement(

		            By.id("AdminComment"),
		            By.name("AdminComment"),
		            By.xpath("//textarea[@id='AdminComment']")

		    ).sendKeys(content);
		}

		public void clickOnSave() {

		    WebDriverWait wait =
		            new WebDriverWait(ldriver, Duration.ofSeconds(20));

		    wait.until(ExpectedConditions.elementToBeClickable(btnSave));

		    shDriver.findElement(

		            By.name("save"),
		            By.xpath("//button[@name='save']"),
		            By.cssSelector("button[name='save']")

		    ).click();
		}
	
}
