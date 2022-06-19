package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

public class ProductPage {
    By section_color_filter = By.className("collapsible-filter-container__content-area--color-filter");
    By btn_color_option = By.className("color-filter-option__text");
    By img_product = By.className("product-image__image");
    By code_product  = By.cssSelector(".col-xs-7 > div:nth-child(1)");
    By size_product = By.cssSelector(".option-size a");
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
    public void scrollToElement() {
        elementHelper.scrollToElement(elementHelper.findElement(section_color_filter));
    }
    public void selectColor(String colorName) {
        elementHelper.clickElementWithText(btn_color_option,colorName);
    }
    public void productsListed() {
        elementHelper.checkElementVisible(img_product);
    }
    public void clickProduct() {
        elementHelper.findFirstElement(img_product).click();
    }
    public String getProductCode() {
        elementHelper.checkElementVisible(code_product);
        System.out.println("in function value "+ elementHelper.getText(code_product));

       return elementHelper.findFirstElement(code_product).getText();
    }
    public void selectProductSize(String size) {
        elementHelper.clickElementWithText(size_product,size);
    }
    public void clickAddToBasket() {
        elementHelper.checkElementVisible(add_to_basket);
        elementHelper.click(add_to_basket);
    }
}
