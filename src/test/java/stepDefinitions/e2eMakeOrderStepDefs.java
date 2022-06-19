package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;
import util.DriverFactory;

public class e2eMakeOrderStepDefs {

    String productDescription;
    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    HomePage homePage = new HomePage(DriverFactory.getDriver());
    CategoryPage categoryPage = new CategoryPage(DriverFactory.getDriver());
    ProductPage productPage = new ProductPage(DriverFactory.getDriver());
    CartPage cartPage= new CartPage(DriverFactory.getDriver());
    PaymentPage paymentPage= new PaymentPage(DriverFactory.getDriver());
    @Given("user is opened LcWaikiki App")
    public void userIsOpenedLcWaikikiApp() {
        homePage.checkHomePage();
    }

    @When("click Skip button")
    public void clickSkipButton() {
        homePage.clickSkipButton();
    }

    @Then("should see {string} title next")
    public void shouldSeeTitleNext(String title) {
        homePage.assertTitle(title);
    }
    @And("click login button")
    public void clickLoginButton() {
        loginPage.clickLogin();
    }

    @Then("see email error {string}")
    public void seeEmailError(String errorMessage) {
        loginPage.assertEmailError(errorMessage);
    }

    @And("see password error {string}")
    public void seePasswordError(String errorMessage) {
        loginPage.assertPasswordError(errorMessage);
    }

    @And("type {string} in password input")
    public void typeInPasswordInput(String errorMessage) {
        loginPage.typePassword(errorMessage);
    }

    @And("type {string} in email input")
    public void typeInEmailInput(String email) {
        loginPage.typeEmail(email);
    }

    @When("click {string} button")
    public void clickButton(String tabName) {
        homePage.clickTab(tabName);
    }

    @And("left empty fields")
    public void leftEmptyFields() {
        loginPage.leftEmptyFields();
    }

    @When("left password field empty")
    public void leftPasswordFieldEmpty() {
        loginPage.leftPasswordEmpty();
    }

    @Then("user see logged in that {string} on top of page")
    public void userSeeLoggedInThatOnTopOfPage(String fullName) {
        String fullNameLabel = homePage.checkUserLoggedIn();
        Assert.assertTrue(fullNameLabel.contains(fullName));
    }

    @When("click {string} category")
    public void clickCategory(String categoryName) {
        categoryPage.clickCategory(categoryName);
    }

    @And("click {string} sub category")
    public void clickSubCategory(String subCategoryName) {
        categoryPage.clickSubCategory(subCategoryName);
    }

    @And("click {string} branch")
    public void clickBranch(String branchName) {
        categoryPage.scrollToElemenAndClick(1,branchName);
    }

    @Then("user see products")
    public void userSeeProducts() {
        productPage.productsListed();
    }

    @When("click {string} tab")
    public void clickTab(String tabName) {
        homePage.clickTab(tabName);
    }

    @When("click a product")
    public void clickAProduct() {
        productPage.clickProduct();
        productDescription = productPage.getProductDescription();
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
        productPage.scrollToElement(0,colorName);
        productPage.selectColor(colorName);
    }

    @And("click filter button")
    public void clickFilterButton() {
        productPage.showFilters();
    }

    @And("click {string} filter")
    public void clickFilter(String filterName) {
        productPage.clickColorFilter(filterName);
    }

    @And("click color filter")
    public void clickColorFilter() {
        productPage.applyColorFilter();
    }

    @And("click apply filter")
    public void clickApplyFilter() {
        productPage.applyFilter();
    }

    @And("close product detail")
    public void closeProductDetail() {
        productPage.closeProduct();
    }

    @And("go to cart")
    public void goToCart() {
        homePage.goToCart();
    }

    @Then("user verifies that product information is correct on cart")
    public void userVerifiesThatProductInformationIsCorrectOnCart() {
        cartPage.checkProductInformations(productDescription,"1","M");
    }

    @When("go to payment phase")
    public void goToPaymentPhase() {
        cartPage.goToPayment();
        paymentPage.clickDeliveryAddress();

    }
    @Then("user should see payment screen")
    public void userShouldSeePaymentScreen() {
        paymentPage.hidePaymentTypes();
        paymentPage.showPaymentTypes();
        paymentPage.clickPayWithCreditCard();
        paymentPage.checkNameInputAppear();
        paymentPage.checkCardNumberInputAppear();
        paymentPage.checkCardMonthInputAppear();
        paymentPage.checkCardYearInputAppear();
        paymentPage.checkCvvInputAppear();

    }
    @When("click {string} button to navigate login page")
    public void clickButtonToNavigateLoginPage(String loginButton) {
        homePage.focusLogin(loginButton);
        homePage.clickGoToLogin(loginButton);
    }
}
