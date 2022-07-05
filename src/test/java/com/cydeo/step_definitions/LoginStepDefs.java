package com.cydeo.step_definitions;

import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

    @When("user enters {string} and {string} with spaces")
    public void userEntersAndWithSpaces(String username, String password) {
        String usernameWithSpace = "   "+username+"   ";
        loginPage.login(usernameWithSpace, password);
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

    @When("user enters {string} and {string}user can't remain at the {string}")
    public void userEntersAndUserCanTRemainAtThe(String arg0, String arg1, String arg2) {
        String urlBeforeClose = Driver.getDriver().getCurrentUrl();
        String titleBeforeClose = Driver.getDriver().getTitle();

        //We are using Driver.closeDriver() method to get the Driver value null!
        // Driver.getDriver().close() method didn't work!
        Driver.closeDriver();

        Driver.getDriver().get(urlBeforeClose + Keys.ENTER);
        String titleAfterClose = Driver.getDriver().getTitle();
        Assert.assertNotEquals(titleBeforeClose, titleAfterClose);
    }

    @Then("user can't remain logged in on the dashboard page")
    public void userCanTRemainLoggedInOnTheDashboardPage() {
        String expectedPageTitle = "Dashboard Page";
        String actualPageTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(expectedPageTitle.contains(actualPageTitle));
    }

    @Then("user can see placeholder in username and password input boxes")
    public void userCanSeePlaceholderInUsernameAndPasswordInputBoxes() {
        String expectedPlaceholderForUsernameInputBox = "Username or Email";
        String actualPlaceholderForUsernameInputBox = dashboardPage.usernamePlaceHolder.getAttribute("placeholder");
        Assert.assertEquals(expectedPlaceholderForUsernameInputBox, actualPlaceholderForUsernameInputBox);
        Assert.assertTrue(dashboardPage.usernamePlaceHolder.isDisplayed());

        String expectedPlaceholderForPasswordInputBox = "Password";
        String actualPlaceholderForPasswordInputBox = dashboardPage.passwordPlaceHolder.getAttribute("placeholder");
        Assert.assertEquals(expectedPlaceholderForPasswordInputBox, actualPlaceholderForPasswordInputBox);
        Assert.assertTrue(dashboardPage.passwordPlaceHolder.isDisplayed());

    }


    @Then("{string} should be displayed for invalid entry or any empty field")
    public void warning_messageShouldBeDisplayedForInvalidEntryOrAnyEmptyField(String string) {
//        String message = loginPage.usernameBox.getAttribute("validationMessage");
//        System.out.println("message = " + message);

        Assert.assertTrue(loginPage.invalidUsernameOrPasswordError.isDisplayed());


    }



}
