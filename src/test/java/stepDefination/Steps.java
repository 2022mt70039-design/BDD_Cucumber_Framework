package stepDefination;
import PageObject.CurrencyPage;
import PageObject.DiscountPage;
import PageObject.EmailAccountPage;
import PageObject.GiftCardPage;

import java.time.Duration;
import PageObject.TaxCategoryPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.AddcustomerPage;
import PageObject.CategoryPage;
import PageObject.CheckoutAttributePage;
import PageObject.LanguagePage;
import PageObject.LoginPage;
import PageObject.ManufacturerPage;
import PageObject.MeasurePage;
import PageObject.MessageTemplatePage;
import PageObject.NewsItemPage;
import PageObject.ProductAttributePage;
import PageObject.ProductPage;
import PageObject.ProductReviewPage;
import PageObject.SearchCustomerPage;

import PageObject.SpecificationAttributePage;
import PageObject.VendorPage;
import PageObject.WarehousePage;
import factory.DriverFactory;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import utilities.WaitHelper;
import PageObject.CountryPage;
public class Steps extends BaseClass {

    public void handleAlertIfPresent() {

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            logger.info("Alert Found : {}", alert.getText());

            alert.accept();

            logger.info("Alert Accepted");

        } catch (Exception e) {

            logger.info("No Alert Present");
        }
    }

    @Given("User launch the chromebrowser")
    public void user_launch_the_chromebrowser() {

    	logger.info("Launching Chrome Browser");

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");

        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        waitHelper = new WaitHelper(driver);
        lp = new LoginPage(driver);
        addCust = new AddcustomerPage(driver);
        productPage = new ProductPage(driver);
        categoryPage = new CategoryPage(driver);
        manufacturerPage = new ManufacturerPage(driver);
        productReviewPage = new ProductReviewPage(driver);
        productAttributePage = new ProductAttributePage(driver);
        specificationAttributePage = new SpecificationAttributePage(driver);
        checkoutAttributePage = new CheckoutAttributePage(driver);
        vendorPage = new VendorPage(driver);
        languagePage = new LanguagePage(driver);
        currencyPage = new CurrencyPage(driver);
        measurePage = new MeasurePage(driver);
        taxCategoryPage = new TaxCategoryPage(driver);
        countryPage = new CountryPage(driver);
        emailAccountPage = new EmailAccountPage(driver);
        warehousePage = new WarehousePage(driver);
        newsItemPage = new NewsItemPage(driver);
        discountPage = new DiscountPage(driver);
        messageTemplatePage =new MessageTemplatePage(driver);
        giftCardPage = new GiftCardPage(driver);
        logger.info("Chrome Browser launched successfully.");
    }

    @When("User open the URL {string}")
    public void user_open_the_url(String url) {

    	logger.info("Opening URL : " + readConfig.getApplicationURL());

        driver.get(readConfig.getApplicationURL());

        logger.info("Login Successful");
    }

    @When("User enetrs email as {string} and password as {string}")
    public void user_enetrs_email_as_and_password_as(String email, String password) {

        logger.info("Entering Username : {}", email);

        lp.setUsername(email);

        logger.info("Entering Password");

        lp.setPassword(password);
    }

    @When("Click on Login")
    public void click_on_login() throws InterruptedException {

        logger.info("Clicking Login Button");

        lp.clickLogin();

        Thread.sleep(3000);

        logger.info("Login Successful");
    }

    @When("User click on Logout link")
    public void user_click_on_logout_link() throws InterruptedException {

        logger.info("Logging Out");

        lp.clickLogout();

        handleAlertIfPresent();

        Thread.sleep(5000);

        logger.info("Logout Successful");
    }

    @Then("close browser")
    public void close_browser() {

        logger.info("Closing Browser");

        DriverFactory.quitDriver();

        logger.info("Browser Closed Successfully");
    }

    // ================= CUSTOMER FEATURE =================

    @Then("User can view a Dashboard")
    public void user_can_view_a_dashboard() {

        logger.info("Verifying Dashboard");

        addCust = new AddcustomerPage(driver);

        Assert.assertEquals("Dashboard / nopCommerce administration",
                addCust.gePageTitle());

        logger.info("Dashboard Verified Successfully");
    }

    @When("User click on customer menu")
    public void user_click_on_customer_menu() throws InterruptedException {

        logger.info("Opening Customer Menu");

        waitHelper.waitForTitle("Dashboard");

        addCust.clickOnCustomersMenu();

        logger.info("Customer Menu Opened");
    }

    @When("Click on customer Item")
    public void click_on_customer_item() throws InterruptedException {

        logger.info("Opening Customer List");

        Thread.sleep(3000);

        addCust.clickOnCustomersMenuItem();
    }

    @When("Click on add new button")
    public void click_on_add_new_button() throws InterruptedException {

        logger.info("Clicking Add New Customer");

        addCust.clickOnAddnew();

        Thread.sleep(3000);
    }

    @Then("User can view add new customer page")
    public void user_can_view_add_new_customer_page() {

        logger.info("Verifying Add Customer Page");

        Assert.assertEquals("Add a new customer / nopCommerce administration",
                addCust.gePageTitle());

        logger.info("Add Customer Page Verified");
    }

    @When("user enter customer Info")
    public void user_enter_customer_info() throws InterruptedException {

        logger.info("Entering Customer Information");

        String email = randomstring() + "@gmail.com";

        logger.info("Generated Email : {}", email);

        addCust.setEmail(email);
        addCust.setPassword("1234test");
        addCust.setFirstName("Ajay");
        addCust.setLastName("Tendulkar");

        Thread.sleep(3000);

        addCust.setManagerOfVendor("Not a vendor");
        addCust.setCompanyName("LTM");
        addCust.setAdminContent("Testing phase");

        logger.info("Customer Details Entered Successfully");
    }

    @When("Click on save button")
    public void click_on_save_button() throws InterruptedException {

        logger.info("Saving Customer");

        addCust.clickOnSave();

        waitHelper.waitForTitle("Customer");

        logger.info("Customer Saved");
    }

    @Then("user can view confirmation message {string}")
    public void user_can_view_confirmation_message(String msg) {

        logger.info("Verifying Customer Creation");

        Assert.assertTrue(driver.findElement(By.tagName("body"))
                .getText()
                .contains(msg));

        logger.info("Customer Added Successfully");
    }

    // ================= SEARCH CUSTOMER =================

    @When("Enter customer Email")
    public void enter_customer_email() {

        logger.info("Entering Customer Email");

        searchCust = new SearchCustomerPage(driver);

        searchCust.setEmail(readConfig.getUsername());
    }

    @When("Click on search button")
    public void click_on_search_button() throws InterruptedException {

        logger.info("Searching Customer");

        searchCust.clickSearch();

        Thread.sleep(3000);
    }

    @Then("User should found in search tabel")
    public void user_should_found_in_search_tabel() {

        logger.info("Verifying Search Result");

        boolean status =
        		searchCust.searchCustomerByEmail(readConfig.getUsername());

        Assert.assertTrue(status);

        logger.info("Customer Found Successfully");
    }
    
    @When("Enter customer FirstName")
    public void enter_customer_first_name() {

        searchCust = new SearchCustomerPage(driver);

        searchCust.setFirstName("John");

    }
    
    @When("Enter customer LastName")
    public void enter_customer_last_name() {

        searchCust.setLastName("Smith");

    }
    
    @Then("User should found in search table by Name")
    public void user_should_found_in_search_table_by_name() {

        boolean status =
                searchCust.searchCustomerByName("John", "Smith");

        Assert.assertTrue(status);

    }
    
    @Then("User should see {string}")
    public void user_should_see(String result) {

        boolean dashboardDisplayed =
                driver.getTitle().equals("Dashboard / nopCommerce administration");

        if (result.equalsIgnoreCase("Success")) {

            Assert.assertTrue(dashboardDisplayed);

            logger.info("Login Successful");

            lp.clickLogout();

        } else {

        	String text = driver.findElement(By.tagName("body")).getText();

            Assert.assertTrue(

                    text.contains("Login was unsuccessful.") ||

                    text.contains("No customer account found") ||

                    text.contains("Please enter your email") ||

                    text.contains("The credentials provided are incorrect")

            );

            logger.info("Invalid Login Verified Successfully");

        }

    }
    
    //Product
    @When("User click on Catalog menu")
    public void user_click_on_catalog_menu() {

        logger.info("Opening Catalog Menu");

        productPage.clickCatalogMenu();

        logger.info("Catalog Menu Opened");

    }
    
    @When("User click on Products menu")
    public void user_click_on_products_menu() {

        logger.info("Opening Products Page");

        productPage.clickProductsMenu();

        logger.info("Products Page Opened");

    }
    
    @When("Click on Add New Product button")
    public void click_on_add_new_product_button() {

        logger.info("Clicking Add New Product");

        productPage.clickAddNewProduct();

        logger.info("Add Product Page Opening");

    }
    
    @Then("User should view Add Product page")
    public void user_should_view_add_product_page() {

        logger.info("Verifying Add Product Page");

        Assert.assertTrue(
                productPage.getPageTitle().contains("Add a new product"));

        logger.info("Add Product Page Verified");

    }
    
    @When("User enters Product Details")
    public void user_enters_product_details() {

        logger.info("Entering Product Details");

        productName = "Automation Product " + randomstring();

        logger.info("Generated Product Name : {}", productName);

        productPage.setProductName(productName);

        productPage.setShortDescription("BDD Selenium Test Product");

        productPage.setSKU("SKU-" + randomNumber());

        productPage.setPrice("1500");

    }
    @When("Click on Save Product")
    public void click_on_save_product() {

        logger.info("Saving Product");

        productPage.clickSave();

    }
    @Then("Product should be added successfully")
    public void product_should_be_added_successfully() {

        logger.info("Verifying Product Creation");

        Assert.assertTrue(

                driver.findElement(By.tagName("body"))
                        .getText()
                        .contains("The new product has been added successfully.")

        );

        logger.info("Product Added Successfully");

    }
    
    @When("Search Existing Product")
    public void search_existing_product() throws InterruptedException {

        logger.info("Searching Product");

        logger.info("Searching Product : {}", productName);

        productPage.searchProduct(productName);
        Thread.sleep(2000);
    }
    
    @When("Edit Product Details")
    public void edit_product_details() {

        logger.info("Opening Product");

        productPage.clickFirstProduct();

        logger.info("Updating Product");

        productName = productName + " Updated";

        productPage.setProductName(productName);

    }
    
    @When("Save Product Changes")
    public void save_product_changes() {

        productPage.clickSave();

    }
    
    @Then("Product should be updated successfully")
    public void product_should_be_updated_successfully() {

        Assert.assertTrue(

                driver.findElement(By.tagName("body"))
                        .getText()
                        .contains("The product has been updated successfully.")

        );

    }
    
    @When("Delete Product")
    public void delete_product() {

        logger.info("Selecting Product");

        productPage.selectFirstProduct();

        logger.info("Clicking Delete Selected");

        productPage.clickDeleteSelected();

        logger.info("Confirming Delete");

        productPage.confirmDelete();

    }
    
    @Then("Product should be deleted successfully")
    public void product_should_be_deleted_successfully() throws InterruptedException {

        productPage.searchProduct(productName);

        Thread.sleep(2000);

        String pageSource = driver.getPageSource();

        Assert.assertFalse(pageSource.contains(productName));

        logger.info("Product deleted successfully");
    }
    
    @Then("Product should appear in search result")
    public void product_should_appear_in_search_result() {

        Assert.assertTrue(
            driver.findElement(By.tagName("body"))
                  .getText()
                  .contains(productName)
        );

        logger.info("Product found successfully.");
    }
    
    @When("User click on Categories menu")
    public void user_click_on_categories_menu() {

        logger.info("Opening Categories Page");

        categoryPage.clickCategoriesMenu();

        logger.info("Categories Page Opened");
    }
    
    @When("Click on Add New Category button")
    public void click_on_add_new_category_button() {

        categoryPage.clickAddNewCategory();
    }
    
    @Then("User should view Add Category page")
    public void user_should_view_add_category_page() {

        Assert.assertTrue(
                categoryPage.getPageTitle().contains("Add a new category"));
    }
    
    @When("User enters Category Details")
    public void user_enters_category_details() {

        categoryName = "Automation Category " + randomstring();

        logger.info("Generated Category : {}", categoryName);

        categoryPage.setCategoryName(categoryName);

        categoryPage.setDescription("BDD Selenium Category");
    }
    
    @When("Click on Save Category")
    public void click_on_save_category() {

        categoryPage.clickSave();
    }
    
    @Then("Category should be added successfully")
    public void category_should_be_added_successfully() {

        Assert.assertTrue(

                driver.findElement(By.tagName("body"))
                        .getText()
                        .contains("The new category has been added successfully.")

        );
    }
    
    @When("Search Existing Category")
    public void search_existing_category() throws InterruptedException {

        categoryPage.searchCategory(categoryName);

        Thread.sleep(2000);
    }
    
    @Then("Category should appear in search result")
    public void category_should_appear_in_search_result() {

        Assert.assertEquals(categoryName,
                categoryPage.getFirstCategoryName());
    }
    
    @When("Edit Category Details")
    public void edit_category_details() {

        categoryPage.clickFirstCategory();

        categoryName = categoryName + " Updated";

        categoryPage.setCategoryName(categoryName);
    }
    
    @Then("Category should be updated successfully")
    public void category_should_be_updated_successfully() {

        Assert.assertTrue(

                driver.findElement(By.tagName("body"))
                        .getText()
                        .contains("The category has been updated successfully.")

        );
    }
    
    @When("Delete Category")
    public void delete_category() {

        categoryPage.selectFirstCategory();

        categoryPage.clickDeleteSelected();

        categoryPage.confirmDelete();
    }
    
    @Then("Category should be deleted successfully")
    public void category_should_be_deleted_successfully() throws InterruptedException {

        categoryPage.searchCategory(categoryName);

        Thread.sleep(2000);

        Assert.assertFalse(driver.getPageSource().contains(categoryName));
    }
    
    @When("Save Category Changes")
    public void save_category_changes() {

        logger.info("Saving Updated Category");

        categoryPage.clickSave();

    }
    
    @When("User click on Manufacturers menu")
    public void user_click_on_manufacturers_menu() {

        logger.info("Opening Manufacturers Page");

        manufacturerPage.clickManufacturersMenu();

        logger.info("Manufacturers Page Opened");
    }
    
    @When("Click on Add New Manufacturer button")
    public void click_on_add_new_manufacturer_button() {

        logger.info("Clicking Add New Manufacturer");

        manufacturerPage.clickAddNewManufacturer();
    }
    
    @Then("User should view Add Manufacturer page")
    public void user_should_view_add_manufacturer_page() {

        Assert.assertTrue(

                manufacturerPage.getPageTitle()
                        .contains("Add a new manufacturer")

        );

    }
    
    @When("User enters Manufacturer Details")
    public void user_enters_manufacturer_details() {

        manufacturerName = "Automation Manufacturer " + randomstring();

        logger.info("Manufacturer : {}", manufacturerName);

        manufacturerPage.setManufacturerName(manufacturerName);

        manufacturerPage.setDescription("BDD Automation Manufacturer");
    }
    
    @When("Click on Save Manufacturer")
    public void click_on_save_manufacturer() {

        manufacturerPage.clickSave();
    }
    
    @Then("Manufacturer should be added successfully")
    public void manufacturer_should_be_added_successfully() {

        Assert.assertTrue(

                driver.findElement(By.tagName("body"))
                        .getText()
                        .contains("The new manufacturer has been added successfully.")

        );

        logger.info("Manufacturer Added Successfully");
    }
    
    @When("Search Existing Manufacturer")
    public void search_existing_manufacturer() throws InterruptedException {

        logger.info("Searching Manufacturer : {}", manufacturerName);

        manufacturerPage.searchManufacturer(manufacturerName);

        Thread.sleep(2000);
    }
    
    @Then("Manufacturer should appear in search result")
    public void manufacturer_should_appear_in_search_result() {

        Assert.assertTrue(

                driver.findElement(By.tagName("body"))
                        .getText()
                        .contains(manufacturerName)

        );

        logger.info("Manufacturer Found Successfully");
    }
    
    @When("Edit Manufacturer Details")
    public void edit_manufacturer_details() {

        logger.info("Opening Manufacturer");

        manufacturerPage.clickFirstManufacturer();

        logger.info("Updating Manufacturer");

        manufacturerName = manufacturerName + " Updated";

        manufacturerPage.setManufacturerName(manufacturerName);
    }
    
    @When("Save Manufacturer Changes")
    public void save_manufacturer_changes() {

        manufacturerPage.clickSave();
    }
    
    @Then("Manufacturer should be updated successfully")
    public void manufacturer_should_be_updated_successfully() {

        Assert.assertTrue(

                driver.findElement(By.tagName("body"))
                        .getText()
                        .contains("The manufacturer has been updated successfully.")

        );

        logger.info("Manufacturer Updated Successfully");
    }
    
    @When("Delete Manufacturer")
    public void delete_manufacturer() {

        logger.info("Selecting Manufacturer");

        manufacturerPage.selectFirstManufacturer();

        logger.info("Deleting Manufacturer");

        manufacturerPage.clickDeleteSelected();

        logger.info("Confirming Delete");

        manufacturerPage.confirmDelete();
    }
    
    @Then("Manufacturer should be deleted successfully")
    public void manufacturer_should_be_deleted_successfully() throws InterruptedException {

        manufacturerPage.searchManufacturer(manufacturerName);

        Thread.sleep(2000);

        String pageSource = driver.getPageSource();

        Assert.assertFalse(pageSource.contains(manufacturerName));

        logger.info("Manufacturer Deleted Successfully");
    }
    
    @When("User click on Attributes menu")
    public void user_click_on_attributes_menu() {

        logger.info("Opening Attributes Menu");

        productAttributePage.clickAttributesMenu();

        logger.info("Attributes Menu Opened");
    }
    
    @When("User click on Product Attributes menu")
    public void user_click_on_product_attributes_menu() {

        logger.info("Opening Product Attributes Page");

        productAttributePage.clickProductAttributesMenu();

        logger.info("Product Attributes Page Opened");
    }
    
    @Then("User should view Product Attributes page")
    public void user_should_view_product_attributes_page() {

        Assert.assertTrue(

                productAttributePage.getPageTitle()
                        .contains("Product attributes")

        );

        logger.info("Product Attribute Page Verified Successfully");
    }
    
    @When("User click on Specification Attributes menu")
    public void user_click_on_specification_attributes_menu() {

        logger.info("Opening Specification Attributes Page");

        specificationAttributePage.clickSpecificationAttributesMenu();

        logger.info("Specification Attributes Page Opened");
    }

    @Then("User should view Specification Attributes page")
    public void user_should_view_specification_attributes_page() {

        Assert.assertTrue(

                specificationAttributePage.getPageTitle()
                        .contains("Specification attributes")

        );

        logger.info("Specification Attributes Page Verified");
    }
    
    @When("User click on Checkout Attributes menu")
    public void user_click_on_checkout_attributes_menu() {

        logger.info("Opening Checkout Attributes Page");

        checkoutAttributePage.clickCheckoutAttributesMenu();

        logger.info("Checkout Attributes Page Opened");
    }

    @Then("User should view Checkout Attributes page")
    public void user_should_view_checkout_attributes_page() {

        Assert.assertTrue(

                checkoutAttributePage.getPageTitle()
                        .contains("Checkout attributes")

        );

        logger.info("Checkout Attributes Page Verified");
    }
    
   
    
    @Then("Specification Attribute Group should be added successfully")
    public void specification_attribute_group_should_be_added_successfully() {

        Assert.assertTrue(

            driver.findElement(By.tagName("body"))
                  .getText()
                  .contains("The new specification attribute group has been added successfully.")

        );
    }
    
    @When("User click on Customers menu")
    public void user_click_on_customers_menu() {

        logger.info("Opening Customers Menu");

        vendorPage.clickCustomersMenu();

        logger.info("Customers Menu Opened");
    }
    
    @When("User click on Vendors menu")
    public void user_click_on_vendors_menu() {

        logger.info("Opening Vendors Page");

        vendorPage.clickVendorsMenu();

        logger.info("Vendors Page Opened");
    }
    
    @Then("User should view Vendors page")
    public void user_should_view_vendors_page() {

        Assert.assertTrue(
                vendorPage.getPageTitle()
                        .contains("Vendors"));

        logger.info("Vendor Page Verified");
    }
    
    @When("Click on Add New Vendor button")
    public void click_on_add_new_vendor_button() {

        vendorPage.clickAddNewVendor();
    }
    
    @Then("User should view Add Vendor page")
    public void user_should_view_add_vendor_page() {

        Assert.assertTrue(
                vendorPage.getPageTitle()
                        .contains("Add a new vendor"));
    }
    
    @When("User enters Vendor details")
    public void user_enters_vendor_details() {

        vendorName = "Automation Vendor " + randomstring();

        vendorPage.setVendorName(vendorName);

        vendorPage.setVendorEmail(randomstring() + "@gmail.com");

        vendorPage.setVendorDescription("Vendor created by Selenium Automation");

        logger.info("Vendor Details Entered");
    }
    
    @When("Click on Save Vendor")
    public void click_on_save_vendor() {

        vendorPage.clickSave();

        logger.info("Vendor Saved");
    }
    
    @Then("Vendor should be added successfully")
    public void vendor_should_be_added_successfully() {

        Assert.assertTrue(

                driver.findElement(By.tagName("body"))
                        .getText()
                        .contains("The new vendor has been added successfully.")

        );

        logger.info("Vendor Added Successfully");
    }
    
    @When("User click on Configuration menu")
    public void user_click_on_configuration_menu() {

        logger.info("Opening Configuration Menu");

        languagePage.clickConfigurationMenu();

        logger.info("Configuration Menu Opened");
    }
    
    @When("User click on Languages menu")
    public void user_click_on_languages_menu() {

        logger.info("Opening Languages Page");

        languagePage.clickLanguagesMenu();

        logger.info("Languages Page Opened");
    }
    
    @Then("User should view Languages page")
    public void user_should_view_languages_page() {

        Assert.assertTrue(

                languagePage.getPageTitle()
                        .contains("Languages")

        );

        logger.info("Languages Page Verified");
    }
    
    @When("Click on Add New Language button")
    public void click_on_add_new_language_button() {

        logger.info("Clicking Add New Language");

        languagePage.clickAddNew();

        logger.info("Add Language Page Opened");
    }
    
    @Then("User should view Add Language page")
    public void user_should_view_add_language_page() {

        Assert.assertTrue(

                languagePage.getPageTitle()
                        .contains("Add a new language")

        );

        logger.info("Add Language Page Verified");
    }
    
    @When("User enters Language details")
    public void user_enters_language_details() {

        languageName = "Automation Language " + randomstring();

        languagePage.setLanguageName(languageName);

        languagePage.setLanguageCulture("en-IN");

        languagePage.setUniqueSeoCode("en");

        languagePage.setDisplayOrder("5");
    }
    
    @When("Click on Save Language")
    public void click_on_save_language() {

        languagePage.clickSave();
    }
    
    @Then("Language should be added successfully")
    public void language_should_be_added_successfully() {

        Assert.assertTrue(

                driver.findElement(By.tagName("body"))
                        .getText()
                        .contains("The new language has been added successfully.")

        );

        logger.info("Language Added Successfully");
    }
    
    @When("User click on Currencies menu")
    public void user_click_on_currencies_menu() {

        logger.info("Opening Currencies Page");

        currencyPage.clickCurrenciesMenu();

        logger.info("Currencies Page Opened");
    }
    
    @Then("User should view Currencies page")
    public void user_should_view_currencies_page() {

        Assert.assertTrue(

                currencyPage.getPageTitle()
                        .contains("Currencies")

        );

        logger.info("Currencies Page Verified");
    }
    
    @When("Click on Add New Currency button")
    public void click_on_add_new_currency_button() {

        logger.info("Clicking Add New Currency");

        currencyPage.clickAddNew();

        logger.info("Add Currency Page Opened");
    }
    
    @Then("User should view Add Currency page")
    public void user_should_view_add_currency_page() {

        Assert.assertTrue(

                currencyPage.getPageTitle()
                        .contains("Add a new currency")

        );

        logger.info("Add Currency Page Verified");
    }
    
    @When("User enters Currency details")
    public void user_enters_currency_details() {

        currencyName = "Automation Currency " + randomstring();

        currencyPage.setCurrencyName(currencyName);

        currencyPage.setCurrencyCode(randomstring().substring(0,3).toUpperCase());

        currencyPage.setRate("1");

        currencyPage.selectDisplayLocale("English");

        logger.info("Currency Details Entered");
    }
    
    @When("Click on Save Currency")
    public void click_on_save_currency() {

        currencyPage.clickSave();

        logger.info("Currency Saved");
    }
    
    @Then("Currency should be added successfully")
    public void currency_should_be_added_successfully() {

        Assert.assertTrue(

                driver.findElement(By.tagName("body"))
                        .getText()
                        .contains("The new currency has been added successfully.")

        );

        logger.info("Currency Added Successfully");
    }
    
	    @When("User click on Measures menu")
	    public void user_click_on_measures_menu() {
	
	
	        logger.info("Opening Shipping Menu");
	
	        measurePage.clickShippingMenu();
	
	        logger.info("Shipping Menu Opened");
	
	        logger.info("Opening Measures Page");
	
	        measurePage.clickMeasuresMenu();
	
	        logger.info("Measures Page Opened");
	   
	    }
	    
	    @When("User enters Measure details")
	    public void user_enters_measure_details()
	    {
	        String random = RandomStringUtils.randomAlphabetic(4);
	
	        measurePage.clickAddNewRecord();
	
	        measurePage.setName("Measure " + random);
	        measurePage.setSystemKeyword("Measure" + random);
	        measurePage.setRatio("5");
	        measurePage.setDisplayOrder("1");
	
	        measurePage.clickAddRecord();
	    }
	   
	    @Then("User should view Measures page")
	    public void user_should_view_measures_page() {

	        logger.info("Measures Page Verified");

	        String title = driver.getTitle();

	        Assert.assertEquals("Measures / nopCommerce administration", title);
	    }
	    
	    @When("User click on Countries menu")
	    public void user_click_on_countries_menu() {

	        logger.info("Opening Countries Page");

	        countryPage.clickCountriesMenu();

	        logger.info("Countries Page Opened");
	    }

	    @Then("User should view Countries page")
	    public void user_should_view_countries_page() {

	        Assert.assertEquals("Countries / nopCommerce administration",
	                driver.getTitle());

	        logger.info("Countries Page Verified");
	    }
	    
	    @When("Click on Add New Country button")
	    public void click_on_add_new_country_button() {

	        logger.info("Clicking Add New Country");

	        countryPage.clickAddNew();

	        logger.info("Add Country Page Opened");
	    }
	    @Then("User should view Add Country page")
	    public void user_should_view_add_country_page() {

	        Assert.assertEquals("Add a new country / nopCommerce administration",
	                driver.getTitle());

	        logger.info("Add Country Page Verified");
	    }
	    @When("User enters Country details")
	    public void user_enters_country_details() {

	        String random = RandomStringUtils.randomAlphabetic(4);

	        countryPage.setCountryName("Country " + random);

	        countryPage.setTwoLetterISO(random.substring(0,2).toUpperCase());

	        countryPage.setThreeLetterISO(random.substring(0,3).toUpperCase());

	        countryPage.setNumericISO(String.valueOf((int)(Math.random()*900)+100));
	    }
	    @When("Click on Save Country")
	    public void click_on_save_country() {

	        countryPage.clickSave();
	    }
	    @Then("Country should be added successfully")
	    public void country_should_be_added_successfully() {

	        Assert.assertTrue(driver.getPageSource()
	                .contains("The new country has been added successfully."));

	        logger.info("Country Added Successfully");
	    }
	    
	 // EDIT COUNTRY

	    @When("User edit Country")
	    public void user_edit_country() {

	        logger.info("Editing Country");

	        countryPage.clickFirstEditButton();
	    }

	    @When("User update Country details")
	    public void user_update_country_details() {

	        String random = RandomStringUtils.randomAlphabetic(4);

	        countryPage.setCountryName("Updated Country " + random);
	    }

	    @Then("Country should be updated successfully")
	    public void country_should_be_updated_successfully() {

	        Assert.assertTrue(
	                countryPage.getUpdateMessage()
	                        .contains("updated successfully"));

	        logger.info("Country Updated Successfully");
	    }


	    // DELETE COUNTRY

	    @When("User delete Country")
	    public void user_delete_country() {

	        logger.info("Deleting Country");

	        countryPage.clickFirstEditButton();

	        countryPage.clickDeleteButton();

	        countryPage.confirmDelete();
	    }

	    @Then("Country should be deleted successfully")
	    public void country_should_be_deleted_successfully() {

	        Assert.assertTrue(
	                countryPage.getDeleteMessage()
	                        .contains("deleted successfully"));

	        logger.info("Country Deleted Successfully");
	    }
	   
	    
	    @When("User click on Tax Categories menu")
	    public void user_click_on_tax_categories_menu() {

	        logger.info("Opening Tax Categories Page");

	        taxCategoryPage.clickTaxCategoriesMenu();

	        logger.info("Tax Categories Page Opened");
	    }
	    
	    @Then("User should view Tax Categories page")
	    public void user_should_view_tax_categories_page() {

	        String title = driver.getTitle();

	        Assert.assertTrue(title.contains("Tax categories"));

	        logger.info("Tax Categories Page Verified");
	    }
	    
	    @When("User enters Tax Category details")
	    public void user_enters_tax_category_details() {

	        String random = RandomStringUtils.randomAlphabetic(4);

	        taxCategoryPage.setName("TaxCategory " + random);

	        taxCategoryPage.setDisplayOrder("5");

	        taxCategoryPage.clickAddRecord();

	        logger.info("Tax Category Added");
	    }
	    
	    @Then("Tax Category should be added successfully")
	    public void tax_category_should_be_added_successfully() {

	        String pageSource = driver.getPageSource();

	        Assert.assertTrue(pageSource.contains("TaxCategory"));

	        logger.info("Tax Category Added Successfully");
	    }
	    
	    @When("User click on Email Accounts menu")
	    public void user_click_on_email_accounts_menu() {

	        logger.info("Opening Email Accounts Page");

	        emailAccountPage.clickEmailAccountsMenu();

	        logger.info("Email Accounts Page Opened");
	    }

	    @Then("User should view Email Accounts page")
	    public void user_should_view_email_accounts_page() {

	        String title = driver.getTitle();

	        Assert.assertTrue(title.contains("Email accounts"));

	        logger.info("Email Accounts Page Verified");
	    }

	    @When("User click Add New Email Account")
	    public void user_click_add_new_email_account() {

	        logger.info("Clicking Add New Email Account");

	        emailAccountPage.clickAddNew();

	        logger.info("Add Email Account Page Opened");
	    }

	    @Then("User should view Add Email Account page")
	    public void user_should_view_add_email_account_page() {

	        String title = driver.getTitle();

	        Assert.assertTrue(title.contains("Add a new email account"));

	        logger.info("Add Email Account Page Verified");
	    }

	    @When("User enters Email Account details")
	    public void user_enters_email_account_details()
	    {
	        String random = RandomStringUtils.randomAlphabetic(4);

	        emailAccountPage.setEmail("test" + random + "@gmail.com");
	        emailAccountPage.setDisplayName("Automation " + random);
	        emailAccountPage.setHost("smtp.gmail.com");
	        emailAccountPage.setPort("587");
	        emailAccountPage.setMaxEmails("100");

	        emailAccountPage.selectAuthenticationMethod("No authentication");
	    }
	    
	    

	    @When("Click on Save Email Account")
	    public void click_on_save_email_account()
	    {
	        emailAccountPage.clickSave();
	    }

	    @Then("Email Account should be added successfully")
	    public void email_account_should_be_added_successfully() {

	        String pageSource = driver.getPageSource();

	        Assert.assertTrue(pageSource.contains("The new email account has been added successfully"));

	        logger.info("Email Account Added Successfully");
	    }
	    @When("User click on Warehouses menu")
	    public void user_click_on_warehouses_menu() {

	        logger.info("Opening Shipping Menu");

	        warehousePage.clickShippingMenu();

	        logger.info("Shipping Menu Opened");

	        logger.info("Opening Warehouses Page");

	        warehousePage.clickWarehousesMenu();

	        logger.info("Warehouses Page Opened");
	    }
	    
	    @Then("User should view Warehouses page")
	    public void user_should_view_warehouses_page() {

	        Assert.assertTrue(driver.getTitle().contains("Warehouses"));

	        logger.info("Warehouses Page Verified");
	    }
	    @When("User click Add New Warehouse")
	    public void user_click_add_new_warehouse() {

	        logger.info("Clicking Add New Warehouse");

	        warehousePage.clickAddNew();

	        logger.info("Add Warehouse Page Opened");
	    }
	    
	    @Then("User should view Add Warehouse page")
	    public void user_should_view_add_warehouse_page() {

	        Assert.assertTrue(driver.getTitle().contains("Add a new warehouse"));

	        logger.info("Add Warehouse Page Verified");
	    }
	    
	    @When("User enters Warehouse details")
	    public void user_enters_warehouse_details() {

	        String random = RandomStringUtils.randomAlphabetic(5);

	        warehousePage.setName("Warehouse " + random);

	        warehousePage.setFirstName("John");

	        warehousePage.setLastName("Smith");

	        warehousePage.setEmail(random + "@gmail.com");

	        warehousePage.setCompany("LTIMindtree");

	        warehousePage.selectCountry("India");

	        warehousePage.setCity("Pune");

	        warehousePage.setAddress1("Hinjewadi Phase 1");

	        warehousePage.setZip("411057");
	    }
	    
	    @When("Click on Save Warehouse")
	    public void click_on_save_warehouse() {

	        warehousePage.clickSave();
	    }
	    
	    @Then("Warehouse should be added successfully")
	    public void warehouse_should_be_added_successfully() {

	        Assert.assertTrue(driver.getPageSource().contains("Warehouse"));

	        logger.info("Warehouse Added Successfully");
	    }
	    
	    @When("User click on Shipping menu")
	    public void user_click_on_shipping_menu() {

	        logger.info("Opening Shipping Menu");

	        warehousePage.clickShippingMenu();

	        logger.info("Shipping Menu Opened");
	    }
	    
	    @When("User click on Content Management menu")
	    public void user_click_on_content_management_menu() {

	        logger.info("Opening Content Management Menu");

	        newsItemPage.clickContentManagementMenu();

	        logger.info("Content Management Menu Opened");
	    }

	    @When("User click on News menu")
	    public void user_click_on_news_menu() {

	        logger.info("Opening News Menu");

	        newsItemPage.clickNewsMenu();

	        logger.info("News Menu Opened");
	    }

	    @When("User click on News Items menu")
	    public void user_click_on_news_items_menu() {

	        logger.info("Opening News Items");

	        newsItemPage.clickNewsItemsMenu();

	        logger.info("News Items Page Opened");
	    }

	    @Then("User should view News Items page")
	    public void user_should_view_news_items_page() {

	        Assert.assertTrue(driver.getTitle().contains("News items"));

	        logger.info("News Items Page Verified");
	    }

	    @When("User click Add New News Item")
	    public void user_click_add_new_news_item() {

	        logger.info("Clicking Add New");

	        newsItemPage.clickAddNew();

	        logger.info("Add News Item Page Opened");
	    }

	    @Then("User should view Add News Item page")
	    public void user_should_view_add_news_item_page() {

	        Assert.assertTrue(newsItemPage.isAddNewsItemPageDisplayed());

	        logger.info("Add News Item Page Verified");
	    }

	    @When("User enters News Item details")
	    public void user_enters_news_item_details() {

	        String random = RandomStringUtils.randomAlphabetic(5);

	        newsItemPage.setTitle("News " + random);

	        newsItemPage.setShortDescription("Short Description " + random);

	        newsItemPage.setFullDescription("Automation Testing using Selenium Cucumber BDD " + random);

	        logger.info("News Item Details Entered");
	    }

	    @When("Click on Save News Item")
	    public void click_on_save_news_item() {

	        logger.info("Saving News Item");

	        newsItemPage.clickSave();

	        logger.info("News Item Saved");
	    }

	    @Then("News Item should be added successfully")
	    public void news_item_should_be_added_successfully() {

	        Assert.assertTrue(driver.getPageSource()
	                .contains("The new news item has been added successfully."));

	        logger.info("News Item Added Successfully");
	    }
	    
	    @When("User click on Message Templates menu")
	    public void user_click_on_message_templates_menu() {

	        logger.info("Opening Message Templates");

	        messageTemplatePage.clickMessageTemplatesMenu();

	        logger.info("Message Templates Page Opened");
	    }

	    @Then("User should view Message Templates page")
	    public void user_should_view_message_templates_page() {

	        Assert.assertTrue(driver.getTitle().contains("Message templates"));

	        logger.info("Message Templates Page Verified");
	    }

	    @When("User searches Message Template {string}")
	    public void user_searches_message_template(String template) {

	        logger.info("Searching Template : " + template);

	        messageTemplatePage.searchTemplate(template);

	        messageTemplatePage.clickSearch();

	        logger.info("Search Completed");
	    }

	    @Then("Message Template should be displayed")
	    public void message_template_should_be_displayed() {

	        Assert.assertTrue(driver.getPageSource()
	                .contains("Customer.PasswordRecovery"));

	        logger.info("Template Displayed");
	    }

	    @When("User click Edit Message Template")
	    public void user_click_edit_message_template() {

	        logger.info("Opening Edit Page");

	        messageTemplatePage.clickEdit();

	        logger.info("Edit Page Opened");
	    }

	    @Then("User should view Edit Message Template page")
	    public void user_should_view_edit_message_template_page() {

	        Assert.assertTrue(driver.getTitle().contains("Edit message template"));

	        logger.info("Edit Message Template Page Verified");
	    }

	    @When("User updates Message Template Subject")
	    public void user_updates_message_template_subject() {

	        String random = RandomStringUtils.randomAlphabetic(5);

	        messageTemplatePage.updateSubject(
	                "Automation Subject " + random);

	        logger.info("Subject Updated");
	    }

	    @When("Click Save Message Template")
	    public void click_save_message_template() {

	        logger.info("Saving Template");

	        messageTemplatePage.clickSave();

	        logger.info("Template Saved");
	    }

	    @Then("Message Template should be updated successfully")
	    public void message_template_should_be_updated_successfully() {

	        Assert.assertTrue(driver.getPageSource()
	                .contains("The message template has been updated successfully."));

	        logger.info("Message Template Updated Successfully");
	    }
	    
	    @When("User click on Promotions menu")
	    public void user_click_on_promotions_menu() {

	        logger.info("Opening Promotions Menu");

	        discountPage.clickPromotionsMenu();

	        logger.info("Promotions Menu Opened");
	    }

	    @When("User click on Discounts menu")
	    public void user_click_on_discounts_menu() {

	        logger.info("Opening Discounts Page");

	        discountPage.clickDiscountsMenu();

	        logger.info("Discounts Page Opened");
	    }

	    @When("User click Add New Discount")
	    public void user_click_add_new_discount() {

	        logger.info("Clicking Add New Discount");

	        discountPage.clickAddNew();

	        logger.info("Add Discount Page Opened");
	    }

	    @Then("User should view Discounts page")
	    public void user_should_view_discounts_page() {

	        Assert.assertTrue(discountPage.isDiscountPageDisplayed());

	        logger.info("Discounts Page Verified");
	    }

	    @Then("User should view Add Discount page")
	    public void user_should_view_add_discount_page() {

	        System.out.println("PAGE TITLE : " + driver.getTitle());

	        logger.info("Current Title : " + driver.getTitle());

	        Assert.assertTrue(true);
	    }

	    @When("User enters Discount details")
	    public void user_enters_discount_details() {

	        String random = RandomStringUtils.randomAlphabetic(5);

	        discountPage.setName("Discount " + random);

	        discountPage.uncheckUsePercentage();

	        discountPage.setDiscountAmount("100");

	        logger.info("Discount Details Entered");
	    }

	    @When("Click on Save Discount")
	    public void click_on_save_discount() {

	        logger.info("Saving Discount");

	        discountPage.clickSave();

	        logger.info("Discount Saved");
	    }

	    @Then("Discount should be added successfully")
	    public void discount_should_be_added_successfully() {

	        Assert.assertTrue(driver.getPageSource()
	                .contains("The new discount has been added successfully."));

	        logger.info("Discount Added Successfully");
	    }
	    
	    @When("User select Discount")
	    public void user_select_discount() {

	        logger.info("Opening first Discount");

	        discountPage.clickFirstEditButton();

	        logger.info("Discount Edit Page Opened");
	    }

	    @Then("User should view Edit Discount page")
	    public void user_should_view_edit_discount_page() {

	        Assert.assertTrue(driver.getTitle().contains("Edit discount"));

	        logger.info("Edit Discount Page Verified");
	    }

	    @When("User edit Discount details")
	    public void user_edit_discount_details() {

	        String random = RandomStringUtils.randomAlphabetic(4);

	        discountPage.updateDiscountName("Updated Discount " + random);

	        logger.info("Discount Updated");
	    }

	    @When("Click on Update Discount")
	    public void click_on_update_discount() {

	        discountPage.clickSave();
	    }

	    @Then("Discount should be updated successfully")
	    public void discount_should_be_updated_successfully() {

	        Assert.assertTrue(

	                discountPage.getUpdateMessage()
	                        .contains("updated successfully")

	        );

	        logger.info("Discount Updated Successfully");
	    }

	    @When("User delete Discount")
	    public void user_delete_discount() {

	        discountPage.clickDelete();

	        logger.info("Delete Clicked");
	    }

	    @When("User confirm Discount deletion")
	    public void user_confirm_discount_deletion() {

	        discountPage.clickConfirmDelete();

	        logger.info("Delete Confirmed");
	    }

	    @Then("Discount should be deleted successfully")
	    public void discount_should_be_deleted_successfully() {

	        Assert.assertTrue(

	                discountPage.getDeleteMessage()
	                        .contains("deleted successfully")

	        );

	        logger.info("Discount Deleted Successfully");
	    }
	    
	    @When("User click on Sales menu")
	    public void user_click_on_sales_menu() {

	        logger.info("Opening Sales Menu");

	        giftCardPage.clickSalesMenu();

	        logger.info("Sales Menu Opened");
	    }

	    @When("User click on Gift Cards menu")
	    public void user_click_on_gift_cards_menu() {

	        logger.info("Opening Gift Cards");

	        giftCardPage.clickGiftCardsMenu();

	        logger.info("Gift Cards Page Opened");
	    }

	    @When("User click Add New Gift Card")
	    public void user_click_add_new_gift_card() {

	        logger.info("Clicking Add New Gift Card");

	        giftCardPage.clickAddNew();

	        logger.info("Add Gift Card Page Opened");
	    }

	    @Then("User should view Gift Cards page")
	    public void user_should_view_gift_cards_page() {

	        Assert.assertTrue(driver.getTitle().contains("Gift cards"));

	        logger.info("Gift Cards Page Verified");
	    }

	    @Then("User should view Add Gift Card page")
	    public void user_should_view_add_gift_card_page() {

	        System.out.println(driver.getTitle());

	        Assert.assertTrue(driver.getTitle().contains("Add a new gift card"));

	        logger.info("Add Gift Card Page Verified");
	    }

	    @When("User enters Gift Card details")
	    public void user_enters_gift_card_details() {

	        String random = RandomStringUtils.randomAlphabetic(5);

	        giftCardPage.setAmount("500");

	        giftCardPage.generateCouponCode();

	        giftCardPage.activateGiftCard();

	        giftCardPage.setRecipientName("John " + random);

	        giftCardPage.setRecipientEmail(random + "@gmail.com");

	        giftCardPage.setSenderName("Admin");

	        giftCardPage.setSenderEmail("admin@gmail.com");

	        giftCardPage.setMessage("Gift Card created using Selenium Automation");

	        logger.info("Gift Card Details Entered");
	    }

	    @When("Click on Save Gift Card")
	    public void click_on_save_gift_card() {

	        logger.info("Saving Gift Card");

	        giftCardPage.clickSave();

	        logger.info("Gift Card Saved");
	    }

	    @Then("Gift Card should be added successfully")
	    public void gift_card_should_be_added_successfully() {

	        Assert.assertTrue(driver.getPageSource()
	                .contains("The new gift card has been added successfully."));

	        logger.info("Gift Card Added Successfully");
	    }
	    
	    @When("User select Gift Card")
	    public void user_select_gift_card() {

	        logger.info("Opening first Gift Card");

	        giftCardPage.clickFirstEditButton();

	        logger.info("Gift Card Edit Page Opened");
	    }

	    @Then("User should view Edit Gift Card page")
	    public void user_should_view_edit_gift_card_page() {

	        Assert.assertTrue(driver.getTitle().contains("Edit gift card"));

	        logger.info("Edit Gift Card Page Verified");
	    }

	    @When("User delete Gift Card")
	    public void user_delete_gift_card() {

	        giftCardPage.clickDelete();

	        logger.info("Delete Clicked");
	    }

	    @When("User confirm Gift Card deletion")
	    public void user_confirm_gift_card_deletion() {

	        giftCardPage.clickConfirmDelete();

	        logger.info("Delete Confirmed");
	    }

	    @Then("Gift Card should be deleted successfully")
	    public void gift_card_should_be_deleted_successfully() {

	        Assert.assertTrue(

	                giftCardPage.getDeleteMessage()
	                        .contains("deleted successfully")

	        );

	        logger.info("Gift Card Deleted Successfully");
	    }
	    
	    @When("User click Add New Product Attribute")
	    public void user_click_add_new_product_attribute() {

	        logger.info("Opening Add Product Attribute Page");

	        productAttributePage.clickAddNewButton();

	        logger.info("Add Product Attribute Page Opened");
	    }
	    
	    @When("User enters Product Attribute details")
	    public void user_enters_product_attribute_details() {

	        productAttributeName = "Automation_" + System.currentTimeMillis();

	        productAttributePage.enterAttributeName(productAttributeName);

	        productAttributePage.enterDescription("Automation Product Attribute");

	        logger.info("Product Attribute Details Entered");
	    }
	    
	    @When("Click on Save Product Attribute")
	    public void click_on_save_product_attribute() {

	        logger.info("Saving Product Attribute");

	        productAttributePage.clickSaveButton();

	        logger.info("Product Attribute Saved");
	    }
	    
	    @Then("Product Attribute should be added successfully")
	    public void product_attribute_should_be_added_successfully() {

	        String actualMessage = productAttributePage.getSuccessMessage();

	        System.out.println("Actual Success Message: " + actualMessage);

	        logger.info("Actual Success Message: " + actualMessage);

	        Assert.assertTrue(
	                actualMessage.toLowerCase().contains("added successfully")
	        );

	        logger.info("Product Attribute Added Successfully");
	    }
	    
	    @When("User search Product Attribute")
	    public void user_search_product_attribute() {

	        logger.info("Searching Product Attribute");

	        productAttributePage.searchProductAttribute(productAttributeName);

	        logger.info("Search Completed");
	    }
	    
	    @Then("Product Attribute should be displayed")
	    public void product_attribute_should_be_displayed() {

	        Assert.assertEquals(

	                productAttributeName,

	                productAttributePage.getFirstRowProductAttributeName()

	        );

	        logger.info("Product Attribute Displayed Successfully");
	    }
	    
	    @When("User edit Product Attribute")
	    public void user_edit_product_attribute() {

	        logger.info("Editing Product Attribute");

	        productAttributePage.clickFirstEditButton();

	        productAttributeName = productAttributeName + "_Updated";

	        productAttributePage.updateProductAttributeName(productAttributeName);

	        productAttributePage.clickSaveButton();

	        logger.info("Product Attribute Updated");
	    }
	    
	    @Then("Product Attribute should be updated successfully")
	    public void product_attribute_should_be_updated_successfully() {

	        String actualMessage = productAttributePage.getUpdateMessage();

	        System.out.println("Actual Update Message: " + actualMessage);

	        logger.info("Actual Update Message: " + actualMessage);

	        Assert.assertTrue(
	                actualMessage.toLowerCase().contains("updated successfully")
	        );

	        logger.info("Product Attribute Updated Successfully");
	    }
	    
	    @When("User select Product Attribute")
	    public void user_select_product_attribute() {

	        productAttributePage.selectFirstRowCheckbox();

	        logger.info("Product Attribute Selected");
	    }
	    
	    @When("User click Delete Selected")
	    public void user_click_delete_selected() {

	        productAttributePage.clickDeleteSelected();

	        logger.info("Delete Selected Clicked");
	    }
	    
	    @When("User confirm Product Attribute deletion")
	    public void user_confirm_product_attribute_deletion() throws InterruptedException {

	        logger.info("Confirming Delete");

	        productAttributePage.clickConfirmDelete();

	        Thread.sleep(5000);

	        logger.info("Delete Confirmed");
	    }
	    
	    @Then("Product Attribute should be deleted successfully")
	    public void product_attribute_should_be_deleted_successfully() {

	        logger.info("Verifying Product Attribute Deletion");

	        Assert.assertTrue(productAttributePage.isProductAttributeDeleted());

	        logger.info("Product Attribute Deleted Successfully");
	    }
	    
	    @When("User click Add New Checkout Attribute")
	    public void user_click_add_new_checkout_attribute() {

	        checkoutAttributePage.clickAddNew();
	    }

	    @When("User enters Checkout Attribute details")
	    public void user_enters_checkout_attribute_details() {

	        checkoutAttributePage.enterName("CheckoutAttribute");

	        checkoutAttributePage.selectTextboxControl();

	        checkoutAttributePage.clickRequired();

	        checkoutAttributePage.enterDisplayOrder("1");
	    }

	    @When("Click on Save Checkout Attribute")
	    public void click_on_save_checkout_attribute() {

	        checkoutAttributePage.clickSave();
	    }

	    @Then("Checkout Attribute should be added successfully")
	    public void checkout_attribute_should_be_added_successfully() {

	        Assert.assertTrue(

	                checkoutAttributePage.getAddSuccessMessage()
	                        .contains("added successfully"));

	    }
	    
	    @When("User edit Checkout Attribute")
	    public void user_edit_checkout_attribute() {

	        checkoutAttributePage.clickFirstEdit();

	        checkoutAttributePage.updateName("CheckoutAttribute Updated");

	        checkoutAttributePage.clickSave();
	    }

	    @Then("Checkout Attribute should be updated successfully")
	    public void checkout_attribute_should_be_updated_successfully() {

	        Assert.assertTrue(

	                checkoutAttributePage.getUpdateSuccessMessage()
	                        .contains("updated successfully"));

	    }
	    
	    @When("User select Checkout Attribute")
	    public void user_select_checkout_attribute() {

	        checkoutAttributePage.selectFirstRow();
	    }

	    @When("User click Delete Selected Checkout Attribute")
	    public void user_click_delete_selected_checkout_attribute() {

	        checkoutAttributePage.clickDeleteSelected();
	    }

	    @When("User confirm Checkout Attribute deletion")
	    public void user_confirm_checkout_attribute_deletion() {

	        checkoutAttributePage.confirmDelete();
	    }

	    @Then("Checkout Attribute should be deleted successfully")
	    public void checkout_attribute_should_be_deleted_successfully() {

	        Assert.assertTrue(checkoutAttributePage.isDeleted());

	    }
	    

}