package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.RegisterPage;
import util.DriverFactory;

public class registerStepDefs {
    RegisterPage registerPage = new RegisterPage(DriverFactory.getDriver());

    @And("type {string} in phone input")
    public void typeInPhoneInput(String phoneNumber) {
        registerPage.typePhone(phoneNumber);
    }

    @And("click Register button")
    public void clickRegisterButton() {
        registerPage.clickRegister();
    }

    @Then("see contract error {string}")
    public void seeContractError(String errorMessage) {
        registerPage.assertError(errorMessage);
    }

    @And("click Register button to navigate register page")
    public void clickRegisterButtonToNavigateRegisterPage() {
        registerPage.goToRegister();
    }

    @Then("see email error {string}")
    public void seeEmailError(String errorMessage) {
        registerPage.assertError(errorMessage);
    }

    @And("check contracts")
    public void checkContracts() {
        registerPage.checkContracts();
    }

    @Then("see password error {string}")
    public void seePasswordError(String errorMessage) {
        registerPage.assertError(errorMessage);
    }

    @Then("see phone error {string}")
    public void seePhoneError(String errorMessage) {
        registerPage.assertError(errorMessage);
    }
}
