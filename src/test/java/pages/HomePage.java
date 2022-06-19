package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    By btn_login = By.className("cart-action__btn--bg-blue");
    By section_welcome =  By.className("list-content__item--welcome");
    By section_category =  By.className("menu-header-item__title");
    By section_branch =  By.className("zone-item__anchor");
    By btn_cart= By.id("shopping-cart");
    By btn_accept_cookies= By.cssSelector("#cookieseal-banner > div > button:nth-child(3)");

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
        elementHelper.presenceElement(section_login);
    }

    public void clickGoToLogin(String title) {
        elementHelper.presenceElement(section_login);
        elementHelper.clickElementWithText(section_login,title);
    }
    public void checkHomePage() {
        elementHelper.checkElementVisible(main_logo);
    }

    public void checkUserLoggedIn(String myAccount) {
        elementHelper.checkElementWithText(section_login,myAccount);
    }
    public void focusCategory(String categoryName) {
        elementHelper.focusElementWithText(section_category,categoryName);
        /*JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementByClassName('menu-header-item__title).contains('KADIN').focus();");*/
    }
    public void clickBranch(String branchName) {
        elementHelper.checkElementWithText(section_branch,branchName);
        elementHelper.clickElementWithText(section_branch,branchName);
    }
    public void goToCart() {
        elementHelper.checkElementVisible(btn_cart);
        elementHelper.click(btn_cart);
    }
    public void acceptCookies(){
        elementHelper.presenceElements(btn_accept_cookies);
        elementHelper.click(btn_accept_cookies);
    }
}
