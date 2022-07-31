package com.cydeo.step_definitions;

import com.cydeo.pages.VehiclesPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehicleTableView_StepDefinitions {
    VehiclesPage vehiclesPage = new VehiclesPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);

    @Then("All vehicles information table should be seen under Fleet-Vehicle page")
    public void all_vehicles_information_table_should_be_seen_under_fleet_vehicle_page() {
        wait.until(ExpectedConditions.visibilityOf(vehiclesPage.all_cars_table_on_vehicles_page));
        Assert.assertTrue("All Cars table is not visible", vehiclesPage.all_cars_table_on_vehicles_page.isDisplayed());
    }

    @Then("User should see total page number")
    public void userShouldSeeTotalPageNumber() {
        Driver.getDriver().navigate().refresh();
       wait.until(ExpectedConditions.visibilityOf(vehiclesPage.lastPageNum));
 //       System.out.println( vehiclesPage.lastPageNum.getText());
        Assert.assertTrue("Total page number is not visible", vehiclesPage.lastPageNum.isDisplayed());
//        try {
//            Assert.assertTrue("Total page number is not visible", vehiclesPage.lastPageNum.isDisplayed());
//        } catch (StaleElementReferenceException e) {
//            Assert.assertTrue("Total page number is not visible", vehiclesPage.lastPageNum.isDisplayed());
//        }
    }

    @Then("User should go to the next page clicking forward button")
    public void userShouldGoToTheNextPageClickingForwardButton() {
        Driver.getDriver().navigate().refresh();
        wait.until(ExpectedConditions.elementToBeClickable(vehiclesPage.forwardPageArrow));

        vehiclesPage.forwardPageArrow.click();
        Assert.assertTrue("User can not go to the next page",
                vehiclesPage.page_number_input_widget.getAttribute("value").equals("2"));

//Alternative way to avoid StaleElementReferenceException:
//        try {
//            vehiclesPage.forwardPageArrow.click();
//        }
//        catch(org.openqa.selenium.StaleElementReferenceException ex)
//        {
//            vehiclesPage.forwardPageArrow.click();
//        }

    }

    @Then("User should go to the previous page clicking back button")
    public void userShouldGoToThePreviousPageClickingBackButton() {
        vehiclesPage.backPageArrow.click();
        Assert.assertTrue("User can not go to the next page",
                vehiclesPage.page_number_input_widget.getAttribute("value").equals("1"));
    }

    @Then("user should see total recordings of vehicles")
    public void userShouldSeeTotalRecordingsOfVehicles() {
        Driver.getDriver().navigate().refresh();
        wait.until(ExpectedConditions.visibilityOf(vehiclesPage.totalRecordsText));
        Assert.assertTrue("Total recordings of vehicles is not visible.",
                vehiclesPage.totalRecordsText.isDisplayed());
    }

    @When("User clicks on export grid link")
    public void userClicksOnExportGridLink() {
        Driver.getDriver().navigate().refresh();
//        wait.until(ExpectedConditions.elementToBeClickable(vehiclesPage.export_grid_link));
        BrowserUtils.sleep(2);
        vehiclesPage.export_grid_link.click();
    }

    @And("User clicks on CSV link")
    public void userClicksOnCSVLink() {
        BrowserUtils.sleep(2);
        vehiclesPage.csv_download_link.click();
    }

    @Then("User can download table data")
    public void userCanDownloadTableData() {
        Assert.assertTrue("Download process is not confirmed",
                vehiclesPage.export_confirmation_message.isDisplayed());
    }

    @And("User clicks on XLS link")
    public void userClicksOnXLSLink() {
        BrowserUtils.sleep(2);
        vehiclesPage.xlsx_download_link.click();
    }
}
