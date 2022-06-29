package com.cydeo.step_definitions;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MercedesStepdefs {
    @Given("User is on mercedes.uk homepage")
    public void userIsOnMercedesUkHomepage() {
        Driver.getDriver().get("https://www.mercedes-benz.co.uk/passengercars.html?group=all&subgroup=all.BODYTYPE.hatchback&view=BODYTYPE");
    }

    @When("User clicks the agree to all button")
    public void userClicksTheAgreeToAllButton() {

        //We access to the JavaScript first
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();

        //We find element through ShadowDom >> ShadowRoot and then click the button
        WebElement agreeToAllBtn = (WebElement) jsExecutor.executeScript("return document.querySelector('cmm-cookie-banner')." +
                "shadowRoot.querySelector('cmm-buttons-wrapper > div > div > button ~ button')\n");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(agreeToAllBtn));

        agreeToAllBtn.click();



    }

    @Then("pop-up frame goes off")
    public void popUpFrameGoesOff() {
        System.out.println("Current Page Title = " + Driver.getDriver().getTitle());
    }
}
