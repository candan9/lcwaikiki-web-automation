package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import util.ElementHelper;

import java.util.List;

public class CartPage {

    By code_product = By.className("rd-cart-item-code");
    By size_product = By.className("rd-cart-item-size");
    By count_product = By.className("item-quantity-input");
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
    public void checkProductInformations(String productCode,String count ,String size ) {
        System.out.println("Elemeent value ="+elementHelper.getText(code_product)+"parameter value"+productCode);
        Assert.assertTrue(productCode.contains(elementHelper.getText(code_product)));
        elementHelper.checkElementWithText(count_product,count);
        elementHelper.checkElementWithText(size_product,size);
    }

    public void goToPayment() {
        elementHelper.findFirstElement(go_to_payment).click();
    }
}
