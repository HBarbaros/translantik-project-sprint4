package com.cydeo.step_definitions;

import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("user is on Translatik login page")
    public void user_is_on_translatik_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("translantik.url"));
    }

    @When("user enters {string} and {string}")
    public void userEntersAnd(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("user lands on the {string} page")
    public void landsOnThePage(String expectedPageHeading) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.pageHeading));

        String actualPageHeading = dashboardPage.pageHeading.getText();
        Assert.assertEquals(expectedPageHeading.toLowerCase(), actualPageHeading.toLowerCase());

    }

    @Then("user validates breadcrumb element is visible and equals {string}")
    public void userValidatesBreadcrumbElementIsVisibleAndEquals(String expected_page_heading){
        Assert.assertTrue(dashboardPage.breadcrumb.isDisplayed());

        String actualBreadcrumbText = dashboardPage.breadcrumb.getText().toLowerCase();
        Assert.assertTrue(actualBreadcrumbText.contains(expected_page_heading.toLowerCase()));
    }

    @Then("user validates page URL")
    public void user_validates_page_url() {
        String expectedURL = "https://qa.translantik.com/";
        String actualURL = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(expectedURL, actualURL);
    }

    @Then("user validates page title")
    public void user_validates_page_title() {
        String expectedPageTitle = "Dashboard Page";
        String actualPageTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(expectedPageTitle.contains(actualPageTitle));
    }



}
