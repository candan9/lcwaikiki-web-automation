package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;
import util.DriverFactory;

public class e2eMakeOrderStepDefs {
    String productCode="";
    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    HomePage homePage = new HomePage(DriverFactory.getDriver());
    ProductPage productPage = new ProductPage(DriverFactory.getDriver());
    CartPage cartPage= new CartPage(DriverFactory.getDriver());
    PaymentPage paymentPage= new PaymentPage(DriverFactory.getDriver());

    @Then("should see {string} title next")
    public void shouldSeeTitleNext(String title) {
        homePage.assertTitle(title);
    }
    @And("click login button")
    public void clickLoginButton() {
        //loginPage.clickLogin();
    }

    @And("type {string} in password input")
    public void typeInPasswordInput(String errorMessage) {
        loginPage.typePassword(errorMessage);
    }

    @And("type {string} in email input")
    public void typeInEmailInput(String email) {
        loginPage.typeEmail(email);
    }

    @Then("user see logged in that {string} on top of page")
    public void userSeeLoggedInThatOnTopOfPage(String myAccount) {
        homePage.checkUserLoggedIn(myAccount);
    }

    @When("focus {string} category")
    public void focusCategory(String categoryName) {
        homePage.focusCategory(categoryName);
    }

    @And("click {string} branch")
    public void clickBranch(String branchName) {
        homePage.clickBranch(branchName);
    }

    @Then("user see products")
    public void userSeeProducts() {
        productPage.productsListed();
    }

    @When("click a product")
    public void clickAProduct() {
        productPage.clickProduct();
        productCode = productPage.getProductCode();
        System.out.println("Feature value"+productCode);
    }

    @And("click add to basket")
    public void clickAddToBasket() {
        productPage.clickAddToBasket();
    }

    @And("select {string} size")
    public void selectSize(String size) {
        productPage.selectProductSize(size);
    }

    @And("filter {string} color")
    public void filterColor(String colorName) {
        productPage.scrollToElement();
        productPage.selectColor(colorName);
    }

    @And("go to cart")
    public void goToCart() {
        homePage.goToCart();
    }

    @When("go to payment phase")
    public void goToPaymentPhase() {
        cartPage.goToPayment();
    }
    @Then("user should see payment screen")
    public void userShouldSeePaymentScreen() {
        paymentPage.clickDeliveryAddress();
        paymentPage.clickPayWithCreditCard();
        paymentPage.creditCardModalAppear();
        paymentPage.nameInputAppear();
        paymentPage.cardNumberInputAppear();
        paymentPage.monthSelectAppear();
        paymentPage.yearSelectAppear();
        paymentPage.cvvInputAppear();
    }
    @When("click {string} button to navigate login page")
    public void clickButtonToNavigateLoginPage(String loginButton) {
        homePage.clickGoToLogin(loginButton);
    }

    @Then("user verifies that product information,product code,{string},{string} , is correct on cart")
    public void userVerifiesThatProductInformationProductCodeIsCorrectOnCart(String count, String size) {
        cartPage.checkProductInformations(productCode,count,size);
    }

    @Given("user is opened LcWaikiki Website")
    public void userIsOpenedLcWaikikiWebsite() {
        homePage.checkHomePage();
        homePage.acceptCookies();
    }
}
