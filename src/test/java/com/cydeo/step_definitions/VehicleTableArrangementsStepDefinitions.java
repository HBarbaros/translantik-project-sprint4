package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.VehiclesPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class VehicleTableArrangementsStepDefinitions {

    BasePage basePage = new BasePage();
    VehiclesPage vehiclesPage = new VehiclesPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Then("user validates default view per page value is {int}")
    public void user_validates_default_view_per_page_value_is(Integer value) {
        BrowserUtils.sleep(3);
        int actualPerPage = Integer.parseInt(vehiclesPage.viewPerPageDropdownMenu.getText());
        assertThat("default should be 25", actualPerPage, is(value));
    }


    @Then("user validates view per page dropdown has {string}, {string}, {string}, {string} values")
    public void userValidatesViewPerPageDropdownHasValues(String arg0, String arg1, String arg2, String arg3) {
        BrowserUtils.sleep(3);
        vehiclesPage.viewPerPageDropdownMenu.click();

        //Added expected values of dropdown to a List<String>
        List<String> expectedValues = new ArrayList<>();
        expectedValues.addAll(Arrays.asList(arg0, arg1, arg2, arg3));

        //Got actual dropdown values and added to a List<String>
        List<String> values = new ArrayList<>();
        values.add(vehiclesPage.tenPerPage.getText());         //10
        values.add(vehiclesPage.twentyFivePerPage.getText());  //25
        values.add(vehiclesPage.fiftyPerPage.getText());       //50
        values.add(vehiclesPage.hundredPerPage.getText());     //100

        assertThat("values should be displayed", values, equalTo(expectedValues));

    }


    @When("user selects {int} from view per page button")
    public void userSelectsValueFromViewPerPageButton(Integer value) {
        BrowserUtils.sleep(5);

        //select the given value from the view per page dropdown
        vehiclesPage.viewPerPageDropdownMenu.click();
        if (value == 10) {
            vehiclesPage.tenPerPage.click();
        } else if (value == 25) {
            vehiclesPage.twentyFivePerPage.click();
        } else if (value == 50) {
            vehiclesPage.fiftyPerPage.click();
        } else {
            vehiclesPage.hundredPerPage.click();
        }
    }


    @Then("selected {int} of vehicles should be displayed")
    public void selectedNumberOfVehiclesShouldBeDisplayed(Integer value) {
        BrowserUtils.sleep(5);

        //collect all webElements inside a List to get the number of elements
        List<WebElement> rows = Driver.getDriver().findElements(By.xpath("//tr[@class='grid-row']"));

        //Assert number of vehicles is equal(or less) to selected value at the view per page dropdown
        assertThat("Row size should be at least selected value", rows.size(), lessThanOrEqualTo(value));

    }


    @When("user clicks column name once to sort column ascending order")
    public void userClicksColumnNameOnceToSortColumnAscendingOrder() {
        BrowserUtils.sleep(3);

        vehiclesPage.viewPerPageDropdownMenu.click();
        vehiclesPage.hundredPerPage.click();

        BrowserUtils.sleep(3);

        //get the default order of the column
        List<String> modelYearsDefaultOrder = BrowserUtils.getElementsText(Driver.getDriver().findElements(By.xpath("//tbody//tr//td[7]")));

        //sort model ascending years for assertion
        Collections.sort(modelYearsDefaultOrder);
        System.out.println("modelYearsSortedOrder = " + modelYearsDefaultOrder);

        //click column name to sort the table at UI part
        BrowserUtils.sleep(3);
        vehiclesPage.modelYearColumnName.click();

        BrowserUtils.sleep(3);
        Driver.getDriver().navigate().refresh();

        //get model years after clicking column name
        List<String> modelYearsAscending = BrowserUtils.getElementsText(Driver.getDriver().findElements(By.xpath("//tbody//tr//td[7]")));

        System.out.println("modelYearsAscending = " + modelYearsAscending);

        assertThat(modelYearsAscending, equalTo(modelYearsDefaultOrder));
    }

    @Then("user clicks column name again to sort descending order")
    public void userClicksColumnNameAgainToSortDescendingOrder() {
        BrowserUtils.sleep(3);

        //get the current order of the column
        List<String> modelYearsActualOrder = BrowserUtils.getElementsText(Driver.getDriver().findElements(By.xpath("//tbody//tr//td[7]")));

        //sort model years ascending for assertion
        Collections.sort(modelYearsActualOrder, Collections.reverseOrder());
        System.out.println("modelYearsActualOrder = " + modelYearsActualOrder);

        //click column name to sort the table at UI part
        BrowserUtils.sleep(3);
        vehiclesPage.modelYearColumnName.click();

        //get model years after clicking column name
        BrowserUtils.sleep(3);
        List<String> modelYearsDescending = BrowserUtils.getElementsText(Driver.getDriver().findElements(By.xpath("//tbody//tr//td[7]")));
        System.out.println("modelYearsDescending = " + modelYearsDescending);

        assertThat(modelYearsDescending, equalTo(modelYearsActualOrder));
    }
}
