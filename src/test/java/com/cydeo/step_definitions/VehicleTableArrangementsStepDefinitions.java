package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.VehiclesTablePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class VehicleTableArrangementsStepDefinitions {

    BasePage basePage = new BasePage();
    VehiclesTablePage vehiclesTablePage = new VehiclesTablePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Then("user validates default view per page value is {int}")
    public void user_validates_default_view_per_page_value_is(Integer int1) {

        BrowserUtils.sleep(3);
        int actualPerPage = Integer.parseInt(vehiclesTablePage.viewPerPageDropdownMenu.getText());
        assertThat(actualPerPage, is(int1));
    }



    @Then("user validates view per page dropdown has {string}, {string}, {string}, {string} values")
    public void userValidatesViewPerPageDropdownHasValues(String arg0, String arg1, String arg2, String arg3) {

        BrowserUtils.sleep(3);
        vehiclesTablePage.viewPerPageDropdownMenu.click();

        //Added expected values of dropdown to a list<String>
        List<String> expectedValues = new ArrayList<>();
        expectedValues.addAll(Arrays.asList(arg0, arg1, arg2, arg3));

        //Got actual dropdown values and added to a List<String>
        List<String> values = new ArrayList<>();
        values.add(vehiclesTablePage.tenPerPage.getText());
        values.add(vehiclesTablePage.twentyFivePerPage.getText());
        values.add(vehiclesTablePage.fiftyPerPage.getText());
        values.add(vehiclesTablePage.hundredPerPage.getText());

        assertThat(values, equalTo(expectedValues));

    }


}
