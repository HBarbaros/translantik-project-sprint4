package com.cydeo.step_definitions;

import com.cydeo.pages.GeneralInformationPage;
import com.cydeo.pages.VehiclesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class VehicleGeneralInformationStepDef {

    VehiclesPage vehiclesPage = new VehiclesPage();
    GeneralInformationPage generalInformationPage = new GeneralInformationPage();

    @When("user on All Cars page and user clicks {string} .row on the All Cars page")
    public void userOnAllCarsPageAndUserClicksRowOnTheAllCarsPage(String row) throws InterruptedException {
        Thread.sleep(3000);
        vehiclesPage.selectAnyRowOfAllCarsTable(Integer.parseInt(row));
    }

    @Then("user should lands on General Information page")
    public void userShouldLandsOnGeneralInformationPage() {
        String actualTitle = generalInformationPage.generalInformationPageTitle.getText();
        String expectedTitle = "General Information";
        Assert.assertEquals("General Information Page Title", actualTitle, expectedTitle);
    }

    @When("user on All Cars page and user clicks any three dot at the end of the row and clicks Eye {string} icon")
    public void userOnAllCarsPageAndUserClicksAnyThreeDotAtTheEndOfTheRowAndClicksEyeIcon(String iconName) {
        vehiclesPage.goThreeDot();
        vehiclesPage.getThreeDotIcon(iconName).click();
    }

    @When("user clicks {string} .row")
    public void userClicksRow(String row) throws InterruptedException {
        Thread.sleep(3000);
        vehiclesPage.selectAnyRowOfAllCarsTable(Integer.parseInt(row));
    }

    @Then("Edit, Delete, and Add Event button should be displayed")
    public void editDeleteAndAddEventButtonShouldBeDisplayed() {
        Assert.assertTrue(generalInformationPage.editCarButton.isDisplayed());
        Assert.assertTrue(generalInformationPage.deleteCarButton.isDisplayed());
        Assert.assertTrue(generalInformationPage.addEventButton.isDisplayed());
    }

    List<String> allInfoOfVehiclePage;

    @Then("check and store all information of {string} .row")
    public void checkAndStoreAllInformationOfRow(String row) {
        allInfoOfVehiclePage = vehiclesPage.getAllInfoOfRow(row);
    }

    @Then("verify the all information are all same for both pages")
    public void verifyTheAllInformationAreAllSameForBothPages() {
        List<String> allInfoOfGeneralInformationPage = generalInformationPage.getAllInfoOfGeneralInformation();
        System.out.println("allInfoOdVehiclePage = " + allInfoOfVehiclePage);
        System.out.println("allInfoOfGeneralInformationPage = " + allInfoOfGeneralInformationPage);
        Assert.assertEquals(allInfoOfVehiclePage,allInfoOfGeneralInformationPage);
    }
}
