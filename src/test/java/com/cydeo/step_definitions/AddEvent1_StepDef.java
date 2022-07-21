package com.cydeo.step_definitions;

import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.pages.VehiclesPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEvent1_StepDef {
LoginPage loginPage = new LoginPage();
DashboardPage dashboardPage = new DashboardPage();
VehiclesPage vehiclesPage = new VehiclesPage();


    @Given("user login successfully as store manager with valid credentials.")
    public void userLoginSuccessfullyAsStoreManagerWithValidCredentials() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.login(ConfigurationReader.getProperty("store_manager_username"), ConfigurationReader.getProperty("store_manager_password"));
        String actualPageTitle = dashboardPage.pageSubTitle.getText();
        String expectedPageTitle = "Dashboard";
        Assert.assertEquals(expectedPageTitle,actualPageTitle);
        BrowserUtils.waitForPageToLoad(10);

    }


    @When("user navigates to {string}, {string}")
    public void userNavigatesTo(String tab, String module) {
        dashboardPage.navigateToModule(tab, module);
        BrowserUtils.waitForPageToLoad(10);

    }

    @Then("title contains {string}")
    public void title_contains(String expectedTitle) {
        BrowserUtils.sleep(10);
        System.out.println("expectedTitle = " + expectedTitle);
        BrowserUtils.waitFor(2);
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }

    @Then("user clicks on any vehicle")
    public void userClicksOnAnyVehicle() {
    BrowserUtils.isClicked(vehiclesPage.vehicleRow);

    }


}
