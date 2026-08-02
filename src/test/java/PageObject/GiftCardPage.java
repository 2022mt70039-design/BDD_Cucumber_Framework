package PageObject;

import org.openqa.selenium.WebDriver;
import utilities.ElementUtil;

public class GiftCardPage {

    WebDriver driver;
    ElementUtil elementUtil;

    public GiftCardPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    //Menus

    private String salesMenu =
            "//p[contains(text(),'Sales')]";

    private String giftCardsMenu =
            "//p[contains(text(),'Gift cards')]";

    //Buttons

    private String btnAddNew =
            "//a[contains(@href,'/Admin/GiftCard/Create')]";

    private String btnGenerateCode =
            "//button[@id='generateCouponCode']";

    private String btnSave =
            "//button[@name='save']";

    //Fields

    private String txtCouponCode =
            "//input[@id='GiftCardCouponCode']";

    private String txtAmount =
            "//input[@id='Amount']";

    private String chkActivate =
            "//input[@id='IsGiftCardActivated']";

    private String txtRecipientName =
            "//input[@id='RecipientName']";

    private String txtRecipientEmail =
            "//input[@id='RecipientEmail']";

    private String txtSenderName =
            "//input[@id='SenderName']";

    private String txtSenderEmail =
            "//input[@id='SenderEmail']";

    private String txtMessage =
            "//textarea[@id='Message']";
  //================ Edit/Delete =================//

    private String firstEditButton =
            "//*[@id='giftcards-grid']//tbody//tr[1]//a[contains(@href,'Edit')]";

    private String btnDelete =
            "//*[@id='giftcard-delete']";

    private String btnConfirmDelete =
            "//button[@type='submit' and contains(text(),'Delete')]";

    private String deleteMessage =
            "//span[contains(text(),'deleted successfully')]";

    //Actions

    public void clickSalesMenu() {
        elementUtil.click(salesMenu);
    }

    public void clickGiftCardsMenu() {
        elementUtil.click(giftCardsMenu);
    }

    public void clickAddNew() {
        elementUtil.click(btnAddNew);
    }

    public void setAmount(String amount) {
        elementUtil.clear(txtAmount);
        elementUtil.type(txtAmount, amount);
    }

    public void generateCouponCode() {
        elementUtil.click(btnGenerateCode);
    }

    public void setRecipientName(String name) {
        elementUtil.type(txtRecipientName, name);
    }

    public void setRecipientEmail(String email) {
        elementUtil.type(txtRecipientEmail, email);
    }

    public void setSenderName(String name) {
        elementUtil.type(txtSenderName, name);
    }

    public void setSenderEmail(String email) {
        elementUtil.type(txtSenderEmail, email);
    }

    public void setMessage(String message) {
        elementUtil.type(txtMessage, message);
    }

    public void activateGiftCard() {

        if (!elementUtil.isSelected(chkActivate)) {
            elementUtil.click(chkActivate);
        }

    }

    public void clickSave() {
        elementUtil.click(btnSave);
    }
    
  //================ Edit/Delete =================//

    public void clickFirstEditButton() {

        elementUtil.click(firstEditButton);
    }

    public void clickDelete() {

        elementUtil.click(btnDelete);
    }

    public void clickConfirmDelete() {

        elementUtil.click(btnConfirmDelete);
    }

    public String getDeleteMessage() {

        return elementUtil.getText(deleteMessage);
    }

}