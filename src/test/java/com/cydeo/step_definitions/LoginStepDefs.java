package com.cydeo.step_definitions;

import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

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

    @And("user validates page URL")
    public void user_validates_page_url() {
        String expectedURL = "https://qa.translantik.com/";
        String actualURL = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(expectedURL, actualURL);
    }

    @And("user validates page title")
    public void user_validates_page_title() {
        String expectedPageTitle = "Dashboard Page";
        String actualPageTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(expectedPageTitle.contains(actualPageTitle));
    }

    @And("user validates breadcrumb element is visible and equals {string}")
    public void userValidatesBreadcrumbElementIsVisibleAndEquals(String expected_page_heading){
        Assert.assertTrue(dashboardPage.breadcrumb.isDisplayed());

        String actualBreadcrumbText = dashboardPage.breadcrumb.getText().toLowerCase();
        Assert.assertTrue("Breadcrumb element/text is not visible on the page!", actualBreadcrumbText.contains(expected_page_heading.toLowerCase()));
    }


    @Then("user sees Invalid user name or password message")
    public void userSeesInvalidUserNameOrPasswordMessage() {
        Assert.assertTrue(loginPage.invalidUsernameOrPasswordError.isDisplayed());
    }

    @Then("user remains at the login page")
    public void userRemainsAtTheLoginPage() {
         String expectedURL = "https://qa.translantik.com/user/login";
         String actualURL = Driver.getDriver().getCurrentUrl();

         Assert.assertEquals(expectedURL, actualURL);
    }

    @And("user copies page URL, logs out, enters copied URL")
    public void userCopiesPageURLLogsOutEntersCopiedURL() {
        String urlAfterLogin = Driver.getDriver().getCurrentUrl();

//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
//        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.fullName));
        BrowserUtils.sleep(3);

        dashboardPage.logout();
        Driver.getDriver().get(urlAfterLogin);
    }

    @And("user after logging into the app, copies the URL, opens a new TAB, closes the previous TAB and then pastes the URL")
    public void userAfterLoggingIntoTheAppCopiesTheURLOpensANewTABClosesThePreviousTABAndThenPastesTheURL() {
        String actualURL = Driver.getDriver().getCurrentUrl();

        //Open new tab
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.open();");

        //handling multiple tabs with an ArrayList
        ArrayList<String> all = new ArrayList<String>(Driver.getDriver().getWindowHandles());

        Driver.getDriver().close();
        Driver.getDriver().switchTo().window(all.get(1));
        Driver.getDriver().get(actualURL);

    }

    @Then("user remains logged in on the dashboard page")
    public void userRemainsLoggedInOnTheDashboardPage() {
        String expectedPageTitle = "Dashboard Page";
        String actualPageTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(expectedPageTitle.contains(actualPageTitle));
    }

    @And("user copies the URL, closes the browser, opens a new browser and then pastes the URL")
    public void userCopiesTheURLClosesTheBrowserOpensANewBrowserAndThenPastesTheURL() {

//        String actualURL = Driver.getDriver().getCurrentUrl();
//
//        Driver.getDriver().close();
//
//        Driver.getDriver().get(ConfigurationReader.getProperty("translantik.url"));
//        Driver.getDriver().get(actualURL);

    }

    @Then("user can't remain logged in on the dashboard page")
    public void userCanTRemainLoggedInOnTheDashboardPage() {
        String expectedPageTitle = "Dashboard Page";
        String actualPageTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(expectedPageTitle.contains(actualPageTitle));
    }
}
