package pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import util.ElementHelper;

public class HomePage {

    By main_logo= By.className("main-header-logo");
    By section_login = By.className("dropdown-label");
    By section_category =  By.className("menu-header-item__title");
    By section_branch =  By.className("zone-item__anchor");
    By btn_cart= By.id("shopping-cart");
    By btn_accept_cookies= By.cssSelector("#cookieseal-banner > div > button:nth-child(3)");

    WebDriver driver;
    ElementHelper elementHelper;
    Actions action;
    FluentWait wait ;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait(driver);
        this.elementHelper = new ElementHelper(driver);
        this.action = new Actions(driver);
    }

    public void assertTitle(String title) {
        elementHelper.presenceElement(section_login);
    }

    public void clickGoToLogin(String title) {
        elementHelper.presenceElement(section_login);
        elementHelper.click(section_login);
    }

    public void checkHomePage() {
        elementHelper.checkElementVisible(main_logo);
    }

    @SneakyThrows
    public void checkUserLoggedIn(String myAccount) {
        elementHelper.checkElementWithText(section_login,myAccount);
        Thread.sleep(2000);
    }
    public void focusCategory(String categoryName) {
        elementHelper.checkElementWithText(section_category,categoryName);
        elementHelper.focusElementWithText(section_category,categoryName);
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
