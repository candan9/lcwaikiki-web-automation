package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ElementHelper;

import java.util.List;

public class HomePage {

    By main_logo= By.className("main-header-logo");
    By section_login = By.className("dropdown-label");
    By btn_login = By.className("cart-action__btn");
    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Actions action;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.action = new Actions(driver);
    }
    public void assertTitle(String title) {
        elementHelper.checkElementWithText(section_login,title);
    }
    public void focusLogin(String title) {
        elementHelper.focusElementWithText(section_login,title);
    }
    public void clickGoToLogin(String title) {
        elementHelper.checkElementVisible(btn_login);
        elementHelper.focusElementWithText(btn_login,title);
    }
    public void checkHomePage() {
        elementHelper.checkElementVisible(main_logo);
    }
}
