package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

public class PaymentPage {

    By card_delivery_type= By.className("deliveryTypeImg");
    By card_payment_type = By.className("creditCardImg");
    By modal_credit_card = By.className("creditCardModalView");
    By input_name = By.xpath("\\input[@tabindex='1']");
    By input_card_number = By.xpath("\\input[@tabindex='2']");
    By select_month = By.xpath("\\input[@tabindex='3']");
    By select_year = By.xpath("\\input[@tabindex='4']");
    By input_cvv = By.className("cvvmaskeddisc");
    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Actions action;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.action = new Actions(driver);
    }

    public void clickDeliveryAddress() {
        elementHelper.checkElementVisible(card_delivery_type);
        elementHelper.findFirstElement(card_delivery_type).click();
    }

    public void clickPayWithCreditCard() {
        elementHelper.checkElementVisible(card_payment_type);
        elementHelper.findFirstElement(card_payment_type).click();
    }

    public void creditCardModalAppear() {
        elementHelper.checkElementVisible(modal_credit_card);
        elementHelper.findFirstElement(modal_credit_card).click();
    }

    public void nameInputAppear() {
        elementHelper.checkElementVisible(input_name);
        elementHelper.findFirstElement(input_name).click();
    }

    public void cardNumberInputAppear() {
        elementHelper.checkElementVisible(input_card_number);
        elementHelper.findFirstElement(input_card_number).click();
    }

    public void monthSelectAppear() {
        elementHelper.checkElementVisible(select_month);
        elementHelper.findFirstElement(select_month).click();
    }

    public void yearSelectAppear() {
        elementHelper.checkElementVisible(select_year);
        elementHelper.findFirstElement(select_year).click();
    }

    public void cvvInputAppear() {
        elementHelper.checkElementVisible(input_cvv);
        elementHelper.findFirstElement(input_cvv).click();
    }
}
