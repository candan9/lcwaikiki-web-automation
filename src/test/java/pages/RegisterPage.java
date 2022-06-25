package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

public class RegisterPage {

    By btn_go_register = By.className("login-form__link");
    By btn_register = By.className("register__button");
    By check_contract = By.name("memberPrivacyApprove");
    By input_phone= By.name("phone");
    By error = By.className("error");
    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Actions action;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.action = new Actions(driver);
    }

    public void goToRegister() {
        elementHelper.presenceElement(btn_go_register);
        elementHelper.click(btn_go_register);
    }

    public void clickRegister() {
        elementHelper.presenceElement(btn_register);
        elementHelper.click(btn_register);
    }

    public void typePhone(String phone) {
        elementHelper.checkElementVisible(input_phone);
        elementHelper.sendKey(input_phone,phone);
    }

    public void checkContracts() {
        elementHelper.presenceElement(check_contract);
        elementHelper.click(check_contract);
    }

    public void assertError(String errorMessage) {
        elementHelper.checkElementWithText(error,errorMessage);
    }
}
