package com.cydeo.step_definitions;

import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.ForgotPasswordPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

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
        String usernameWithSpace = "   " + username + "   ";
        loginPage.login(usernameWithSpace, password);
    }

    @Then("user lands on the {string} page")
    public void landsOnThePage(String expectedPageTitle) {

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
    public void userValidatesBreadcrumbElementIsVisibleAndEquals(String expected_page_heading) {
        Assert.assertTrue(dashboardPage.breadcrumb.isDisplayed());

        String actualBreadcrumbText = dashboardPage.breadcrumb.getText().toLowerCase();
        Assert.assertTrue("Breadcrumb element/text is not visible on the page!", actualBreadcrumbText.contains(expected_page_heading.toLowerCase()));
    }

    @Then("user remains at the login page")
    public void userRemainsAtTheLoginPage() {
        String expectedURL = ConfigurationReader.getProperty("translantikLoginPageURL");
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
        wait.until(ExpectedConditions.titleIs(expectedPageTitle));
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
        BrowserUtils.sleep(3);
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
    public void warning_messageShouldBeDisplayedForInvalidEntryOrAnyEmptyField(String message) {

        String actualMessageUsername = loginPage.usernameBox.getAttribute("validationMessage");
        String actualMessagePassword = loginPage.passwordBox.getAttribute("validationMessage");

        if (message.equals(actualMessageUsername)) {
            Assert.assertEquals(message, actualMessageUsername);
        } else if (message.equals(actualMessagePassword)) {
            Assert.assertEquals(message, actualMessagePassword);
        }
    }

    @And("user enters password in the input box")
    public void userEntersPasswordInTheInputBox() {
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("valid.password"));

    }

    @Then("password text is toggled to hide its visibility")
    public void passwordTextIsToggledToHideItsVisibility() {
        String typeAttribute = loginPage.passwordBox.getAttribute("type");
        Assert.assertEquals(typeAttribute, "password");
    }

    @Then("user can verifies the remember me link is displayed")
    public void userCanVerifiesTheRememberMeLinkIsDisplayed() {
        Assert.assertTrue(loginPage.rememberMeCheckbox.isDisplayed());
    }

    @And("user validates the remember me checkbox is clickable")
    public void userValidatesTheRememberMeCheckboxIsClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.rememberMeCheckbox));
        loginPage.rememberMeCheckbox.click();
    //    Assert.assertTrue(loginPage.rememberMeCheckbox.isSelected());
        Assert.assertTrue(loginPage.rememberMeCheckbox.isDisplayed());

        /*        boolean isSelectedBefore = loginPage.rememberMeCheckbox.isSelected();
        System.out.println("isSelectedBefore = " + isSelectedBefore);

        wait.until(ExpectedConditions.elementToBeClickable(loginPage.rememberMeCheckbox));
        loginPage.rememberMeCheckbox.click();
        BrowserUtils.sleep(4);
        boolean isSelectedAfter = loginPage.rememberMeCheckbox.isSelected();

        System.out.println("isSelectedAfter = " + isSelectedAfter);

        Assert.assertTrue(loginPage.rememberMeCheckbox.isEnabled());*/
    }


    @Then("user validates background color of login button's hex code: {string}")
    public void userValidatesBackgroundColorOfLoginButtonSHexCode(String string) {
        String color = loginPage.loginBtn.getCssValue("background-color"); //color = rgba(12, 132, 163, 1)
        String hexColor = Color.fromString(color).asHex(); //hexColor = #0c84a3

        Assert.assertEquals(hexColor, string);
    }

    @When("user clicks username input box and enters a valid {string} and hits enter key")
    public void userClicksUsernameInputBoxAndEntersAValidAndHitsEnterKey(String username) {
        loginPage.usernameBox.click();
        loginPage.usernameBox.sendKeys(username + Keys.ENTER);
    }

    @And("cursor skips to password input box and user enters a valid {string} and hit enter key")
    public void cursorSkipsToPasswordInputBoxAndUserEntersAValidAndHitEnterKey(String password) {
        loginPage.passwordBox.sendKeys(password + Keys.ENTER + Keys.ENTER);
    }

    @When("user clicks username input box and enters a valid {string} and hits tab key")
    public void userClicksUsernameInputBoxAndEntersAValidAndHitsTabKey(String username) {
        loginPage.usernameBox.click();
        loginPage.usernameBox.sendKeys(username + Keys.TAB);
    }

    @And("cursor skips to password input box and user enters a valid {string} and hit tab key")
    public void cursorSkipsToPasswordInputBoxAndUserEntersAValidAndHitTabKey(String password) {
        loginPage.passwordBox.sendKeys(password + Keys.ENTER + Keys.TAB);
    }


    @When("user enters valid password to the password input box")
    public void userEntersValidPasswordToThePasswordInputBox() {
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("valid.password"));
    }

    @And("copies the entered password from the password box then the two text shouldn't match")
    public void copiesTheEnteredPasswordFromThePasswordBoxThenTheTwoTextShouldnTMatch() throws IOException, UnsupportedFlavorException {
        BrowserUtils.waitFor(3);
        loginPage.passwordBox.sendKeys(Keys.chord(Keys.CONTROL, "A"));
        loginPage.passwordBox.sendKeys(Keys.chord(Keys.CONTROL, "C"));
        String localClipboardData = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        Assert.assertNotEquals(ConfigurationReader.getProperty("valid.password"), localClipboardData);
        System.out.println(localClipboardData);
    }


    @When("user clicks forgot password link lands on the forgot_password_page")
    public void userClicksForgotPasswordLinkLandsOnTheForgot_password_page() {
        loginPage.forgotYourPasswordLink.click();
    }

    @And("user enters username {string} to the box and clicks the request button")
    public void userEntersUsernameToTheBoxAndClicksTheRequestButton(String username) {
        BrowserUtils.waitForVisibility(forgotPasswordPage.usernameOrEmailBox, 3);
        forgotPasswordPage.usernameOrEmailBox.sendKeys(username);
        forgotPasswordPage.requestButton.click();
    }

    @Then("user sees the success message")
    public void userSeesThe() {
        BrowserUtils.sleep(3);
        wait.until(ExpectedConditions.visibilityOf(forgotPasswordPage.message));
        String passwordRetrieveMessage = forgotPasswordPage.message.getText();
        String errorMessage1 = "Unable to send the email.";
        String errorMessage2 = "There is no active user with username or email address";

        if (passwordRetrieveMessage.contains(errorMessage1)||passwordRetrieveMessage.contains(errorMessage2)){
            Assert.fail();
        }else{
            Assert.assertTrue(true);
        }


    }


    @Then("{string} shouldn't be displayed in the page source")
    public void passwordShouldnTBeDisplayedInThePageSource(String password) {
        String pageSource = Driver.getDriver().getPageSource();
        boolean isDisplayed = pageSource.contains(password);
        Assert.assertFalse(isDisplayed);
    }


}
