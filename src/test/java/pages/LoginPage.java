package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

public class LoginPage {
    By input_email= By.name("email");
    By input_password= By.name("password");
    By btn_login= By.className("login-form__button");
    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Actions action;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.action = new Actions(driver);
    }
    public void typeEmail(String email) {
        elementHelper.checkElementVisible(input_email);
        elementHelper.sendKey(input_email,email);
    }
    public void typePassword(String password) {
        elementHelper.checkElementVisible(input_password);
        elementHelper.sendKey(input_password,password);
    }
    public void clickLogin() {
        elementHelper.checkElementVisible(btn_login);
        elementHelper.click(btn_login);
    }
}
