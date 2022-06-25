package pages;

import enitities.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

public class ProductPage {

    By section_color_filter = By.className("collapsible-filter-container__content-area--color-filter");
    By section_size_filter = By.className("collapsible-filter-container__content-area--size-filter");
    By btn_color_option = By.className("color-filter-option__text");
    By btn_size_option= By.className("filter-option__text");
    By img_product = By.className("product-image__image");
    By code_product  = By.cssSelector(".col-xs-7 div");
    By size_product = By.cssSelector(".option-size a");
    By discount_price = By.className("basket-discount");
    By price_product = By.className("price");
    By tooltip = By.className("evam-first-screen-objControl");
    By add_to_basket = By.id("pd_add_to_cart");
    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Actions action;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.action = new Actions(driver);
    }

    public void scrollToElementColor() {
        elementHelper.scrollToElement(elementHelper.findElement(section_color_filter));
    }

    public void scrollToElementSize() {
        elementHelper.checkElementVisible(section_size_filter);
        elementHelper.scrollToElement(elementHelper.findElement(section_size_filter));
    }

    public void selectColor(String colorName) {
        if(elementHelper.findElementEnable(btn_color_option).isDisplayed()){
            elementHelper.checkElementWithText(btn_color_option,colorName);
            elementHelper.clickElementWithText(btn_color_option,colorName);
        }
    }

    public void selectSize(String sizeName) {
        elementHelper.focusElementWithText(btn_size_option,sizeName);
        elementHelper.findElementInElement(btn_size_option,sizeName,By.xpath("./../div")).click();
    }

    public void productsListed() {
        elementHelper.checkElementVisible(img_product);
    }

    public void clickProduct() {
        elementHelper.checkElementVisible(img_product);
        elementHelper.findFirstElement(img_product).click();
    }

    public Product getProductInformation(Product product) {
        elementHelper.checkElementVisible(code_product);
        product.setProductCode(elementHelper.findFirstElement(code_product).getText());
        if(elementHelper.exist(discount_price)){
            product.setProductPrice(elementHelper.findElementEnable(discount_price).getText());
        }
        else{
            elementHelper.checkElementVisible(price_product);
            product.setProductPrice(elementHelper.findElementEnable(price_product).getText());
        }
        return product;
    }

    public void selectProductSize(String size) {
        if(elementHelper.exist(tooltip)){
            elementHelper.findElementEnable(tooltip).click();
        }
        elementHelper.checkElementWithText(size_product,size);
        elementHelper.clickElementWithText(size_product,size);
    }

    public void clickAddToBasket() {
        elementHelper.checkElementVisible(add_to_basket);
        elementHelper.click(add_to_basket);
    }
}