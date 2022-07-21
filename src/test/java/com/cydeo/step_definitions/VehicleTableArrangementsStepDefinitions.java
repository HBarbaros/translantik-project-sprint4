package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.VehiclesTablePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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


    @Then("user validates view per page dropdown has {string}")
    public void userValidatesViewPerPageDropdownHas(String arg0) {
        BrowserUtils.sleep(3);
        vehiclesTablePage.viewPerPageDropdownMenu.click();
        System.out.println("vehiclesTablePage.viewPerPageDropdownMenu.getText() = " + vehiclesTablePage.viewPerPageDropdownMenu.getText());

    }
}
