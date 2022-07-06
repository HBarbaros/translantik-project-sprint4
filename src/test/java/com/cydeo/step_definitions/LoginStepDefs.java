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
    public void landsOnThePage(String expectedPageTitle) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.pageHeading));

        String actualPageHeading = dashboardPage.pageHeading.getText();
        Assert.assertEquals(expectedPageTitle.toLowerCase(), actualPageHeading.toLowerCase());
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

    @Then("user remains at the login page")
    public void userRemainsAtTheLoginPage() {
         String expectedURL = "https://qa.translantik.com/user/login";
         BrowserUtils.sleep(2);
         String actualURL = Driver.getDriver().getCurrentUrl();

         Assert.assertEquals(expectedURL, actualURL);
    }

    @And("user copies page URL, logs out, enters copied URL")
    public void userCopiesPageURLLogsOutEntersCopiedURL() {
        String urlAfterLogin = Driver.getDriver().getCurrentUrl();

        dashboardPage.logout();
        Driver.getDriver().get(urlAfterLogin);
    }

    @And("copies the URL, opens a new TAB, closes the previous TAB and then pastes the URL")
    public void copiesTheURLOpensANewTABClosesThePreviousTABAndThenPastesTheURL() {
        String actualURL = Driver.getDriver().getCurrentUrl();
        System.out.println("actualURL = " + actualURL);

        //Open new tab
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.open();");

        //handling multiple tabs with an ArrayList
        ArrayList<String> windowHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windowHandles.get(0));
        Driver.getDriver().close();
        Driver.getDriver().switchTo().window(windowHandles.get(1));
        Driver.getDriver().get(actualURL);
    }


    @Then("user remains logged in on the dashboard page {string}")
    public void userRemainsLoggedInOnTheDashboardPage(String expectedPageTitle) {
    //    BrowserUtils.sleep(3);
        String actualPageTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }

    @And("user copies URL, closes browser, opens new browser and pastes the URL")
    public void userCopiesURLClosesBrowserOpensNewBrowserAndPastesTheURL() {
        String currentUrl = Driver.getDriver().getCurrentUrl();

        //We are using Driver.closeDriver() method to get the Driver value null!
        // Driver.getDriver().close() method didn't work!
        Driver.closeDriver();
        Driver.getDriver().get(currentUrl + Keys.ENTER);
    }

    @Then("user can't remain logged in on the {string}")
    public void userCanTRemainLoggedInOnThe(String expectedPage) {
        BrowserUtils.sleep(2); //XXX
        String actualPageTitle = Driver.getDriver().getTitle();
        Assert.assertNotEquals(expectedPage, actualPageTitle);
    }

    @Then("user should log in the {string}")
    public void userShouldLogInThe(String expectedPage) {
        BrowserUtils.sleep(2);
        String actualPageTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedPage, actualPageTitle);
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

        String messageUsername = loginPage.usernameBox.getAttribute("validationMessage");
        String messagePassword = loginPage.passwordBox.getAttribute("validationMessage");

        if (string.equals(messageUsername)){
            Assert.assertEquals(string, messageUsername);
        }else if (string.equals(messagePassword)){
            Assert.assertEquals(string, messagePassword);
        }
        else{
            String invalidMessage = loginPage.invalidUsernameOrPasswordError.getText();
            Assert.assertEquals(string, invalidMessage);
        }
    }

    @And("user enters password in the {string} input box")
    public void userEntersPasswordInTheInputBox(String password) {
        loginPage.passwordBox.sendKeys(password);
        System.out.println("loginPage.passwordBox.getText() = " + loginPage.passwordBox.getText());
    }

    @Then("{string} text is toggled to hide its visibility")
    public void textIsToggledToHideItsVisibility(String password) {

        //Assert.assertNotEquals(password, "password");
    }
}
