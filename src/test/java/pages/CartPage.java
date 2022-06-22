package pages;

import enitities.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ElementHelper;

public class CartPage {

    By code_product = By.className("rd-cart-item-code");
    By size_product = By.className("rd-cart-item-size");
    By count_product = By.className("item-quantity-input");
    By color_product = By.className("rd-cart-item-color");
    By price_product = By.cssSelector(".price-info-area > div:nth-child(4) > div:nth-child(1) > span:nth-child(2)");
    By go_to_payment = By.className("main-button");
    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Actions action;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.action = new Actions(driver);
    }
    public void checkProductInformations(Product product) {
        Assert.assertTrue(product.getProductCode().contains(elementHelper.getText(code_product)));
        Assert.assertTrue(product.getProductPrice().contains(elementHelper.getText(price_product)));
        Assert.assertTrue(elementHelper.getText(color_product).contains(product.getProductColor()));
        Assert.assertTrue(elementHelper.getText(size_product).contains(product.getProductSize()));
        Assert.assertTrue(product.getProductCount().contains(elementHelper.getText(count_product)));
    }

    public void goToPayment() {
        elementHelper.findFirstElement(go_to_payment).click();
    }
}
