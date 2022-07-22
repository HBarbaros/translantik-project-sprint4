package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.VehiclesTablePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class VehicleTableArrangementsStepDefinitions {

    BasePage basePage = new BasePage();
    VehiclesTablePage vehiclesTablePage = new VehiclesTablePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Then("user validates default view per page value is {int}")
    public void user_validates_default_view_per_page_value_is(Integer value) {

        BrowserUtils.sleep(3);
        int actualPerPage = Integer.parseInt(vehiclesTablePage.viewPerPageDropdownMenu.getText());
        assertThat("default should be 25", actualPerPage, is(value));
    }


    @Then("user validates view per page dropdown has {string}, {string}, {string}, {string} values")
    public void userValidatesViewPerPageDropdownHasValues(String arg0, String arg1, String arg2, String arg3) {

        BrowserUtils.sleep(3);
        vehiclesTablePage.viewPerPageDropdownMenu.click();

        //Added expected values of dropdown to a List<String>
        List<String> expectedValues = new ArrayList<>();
        expectedValues.addAll(Arrays.asList(arg0, arg1, arg2, arg3));

        //Got actual dropdown values and added to a List<String>
        List<String> values = new ArrayList<>();
        values.add(vehiclesTablePage.tenPerPage.getText());         //10
        values.add(vehiclesTablePage.twentyFivePerPage.getText());  //25
        values.add(vehiclesTablePage.fiftyPerPage.getText());       //50
        values.add(vehiclesTablePage.hundredPerPage.getText());     //100

        assertThat("values should be displayed", values, equalTo(expectedValues));

    }


    @When("user selects {int} from view per page button")
    public void userSelectsValueFromViewPerPageButton(Integer value) {
        BrowserUtils.sleep(3);
        vehiclesTablePage.viewPerPageDropdownMenu.click();
        if (value == 10) {
            vehiclesTablePage.tenPerPage.click();
        } else if (value == 25) {
            vehiclesTablePage.twentyFivePerPage.click();
        } else if (value == 50){
            vehiclesTablePage.fiftyPerPage.click();
        } else {
            vehiclesTablePage.hundredPerPage.click();
        }
    }


    @Then("selected {int} of vehicles should be displayed")
    public void selectedNumberOfVehiclesShouldBeDisplayed(Integer value) {
        BrowserUtils.sleep(4);
        List<WebElement> rows = Driver.getDriver().findElements(By.xpath("//tr[@class='grid-row']"));
        System.out.println("Number of vehicles listed = " + rows.size());
        assertThat("Row size should be at least selected value", rows.size(), lessThanOrEqualTo(value));

    }
}
