package stepDefination;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReadConfig;
import utilities.WaitHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import PageObject.AddcustomerPage;
import PageObject.CategoryPage;
import PageObject.CheckoutAttributePage;
import PageObject.CountryPage;
import PageObject.CurrencyPage;
import PageObject.DiscountPage;
import PageObject.EmailAccountPage;
import PageObject.GiftCardPage;
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
import PageObject.TaxCategoryPage;
import PageObject.VendorPage;
import PageObject.WarehousePage;
import io.cucumber.messages.types.Duration;
public class BaseClass {

    public static WebDriver driver;

    public LoginPage lp;
    public WaitHelper waitHelper;
    public AddcustomerPage addCust;
    public SearchCustomerPage searchCust;
    public ProductPage productPage;
    public CategoryPage categoryPage;

    public ReadConfig readConfig = new ReadConfig();
    public Logger logger = LogManager.getLogger(this.getClass());

    public static String productName;
    public static String categoryName;
    
    public ManufacturerPage manufacturerPage;
    public static String manufacturerName;
    public ProductReviewPage productReviewPage;
    public static String reviewTitle;
    public static String productAttributeName;
    ProductAttributePage productAttributePage;
    public SpecificationAttributePage specificationAttributePage;
    public CheckoutAttributePage checkoutAttributePage;
    public VendorPage vendorPage;
    public static String vendorName;
    public LanguagePage languagePage;
    public static String languageName;
    public CurrencyPage currencyPage;
    public static String currencyName;
    public MeasurePage measurePage;
    public static String measureName;
    public CountryPage countryPage;
    public TaxCategoryPage taxCategoryPage;
    public EmailAccountPage emailAccountPage;
    public WarehousePage warehousePage;
    public NewsItemPage newsItemPage;
    public MessageTemplatePage messageTemplatePage;
    public GiftCardPage giftCardPage;
    public DiscountPage discountPage;
    String checkoutAttributeName="AutomationCheckout";
    // created to generate random values
    public static String randomstring() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public static String randomNumber() {
        return RandomStringUtils.randomNumeric(4);
    }
}
