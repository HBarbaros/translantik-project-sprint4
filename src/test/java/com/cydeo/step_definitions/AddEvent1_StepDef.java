package com.cydeo.step_definitions;

import com.cydeo.pages.*;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.ElementClickInterceptedException;

public class AddEvent1_StepDef {
LoginPage loginPage = new LoginPage();
DashboardPage dashboardPage = new DashboardPage();
VehiclesMainPage vehiclesMainPage = new VehiclesMainPage();
VehiclePage vehiclePage = new VehiclePage();
AddEventPage addEventPage= new AddEventPage();


  /*  @Given("user login successfully as store manager with valid credentials.")
    public void userLoginSuccessfullyAsStoreManagerWithValidCredentials() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.login(ConfigurationReader.getProperty("store_manager_username"), ConfigurationReader.getProperty("store_manager_password"));
        BrowserUtils.waitForPageToLoad(10);

    }

   */


    @When("user navigates to {string} {string}")
    public void theUserNavigatesTo(String tab, String module) {
        dashboardPage.navigateToModule(tab, module);
        BrowserUtils.waitFor(10);

    }

    @Then("title contains {string}")
    public void title_contains(String expectedTitle) {
        BrowserUtils.sleep(10);
        System.out.println("expectedTitle = " + expectedTitle);
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }

    @Then("user should be able to click any vehicle")
    public void userShouldBeAbleToClickAnyVehicle() {
        BrowserUtils.isClicked(vehiclesMainPage.vehicleRow);
    }

    @Given("user clicks on any vehicle")
    public void userClicksOnAnyVehicle() throws ElementClickInterceptedException {
BrowserUtils.sleep(10);
vehiclesMainPage.clickFirstVehicle();

    }

    @Then("user clicks on Add Event button")
    public void userClicksOnAddEventButton() {
BrowserUtils.waitFor(10);
vehiclePage.addEventButton.click();
    }

    @Then("the Add Event page should pop up")
    public void theAddEventPageShouldPopUp() {
        BrowserUtils.sleep(10);
        BrowserUtils.verifyElementDisplayed(addEventPage.addEventPopup);
    }

    @Then("Compulsory fields should be as below")
    public void compulsoryFieldsShouldBeAsBelow() {
        System.out.println("addEventPage.title.getText() = " + addEventPage.title.getText());
    }
}


