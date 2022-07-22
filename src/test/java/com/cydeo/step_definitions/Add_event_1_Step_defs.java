package com.cydeo.step_definitions;

import com.cydeo.pages.AddEventPopUpPage;
import com.cydeo.pages.GeneralInformationPage;
import com.cydeo.pages.VehiclesPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Add_event_1_Step_defs {

    @When("Store manager click on any vehicle")
    public void store_manager_click_on_any_vehicle() {
        VehiclesPage vehiclesPage = new VehiclesPage();
        BrowserUtils.waitFor(3);
        vehiclesPage.selectAnyRowOfAllCarsTable(2);

    }
    @When("Store manager will see {string} page")
    public void store_manager_will_see_page(String expectedPage) {
        BrowserUtils.waitFor(2);
        GeneralInformationPage generalinform1 = new GeneralInformationPage();
        String actualPage = generalinform1.pageTitle.getText();
        Assert.assertEquals("Verified that :", expectedPage, actualPage);
    }

    @Then("Store manager can see addEvent button")
    public void store_manager_can_see_addEvent_button() {
        BrowserUtils.waitFor(2);
        AddEventPopUpPage addEventPopUpPage = new AddEventPopUpPage();
        Assert.assertTrue(addEventPopUpPage.addEventButton.getSize().getWidth()!=0);
        System.out.println("true = " + true);

    }

    @Then("Store manager can click on addEvent button")
    public void store_manager_can_click_on_addEvent_button() {
        BrowserUtils.waitFor(4);
        AddEventPopUpPage addEventPopUpPage = new AddEventPopUpPage();
        addEventPopUpPage.addEventButton.click();
        BrowserUtils.waitForPageToLoad(4);
    }

    @Then("{string} Page opens")
    public void pageOpens(String expectedTitle) throws InterruptedException {

        BrowserUtils.waitFor(4);
        AddEventPopUpPage addEventPopUpPage = new AddEventPopUpPage();
        String actualTitle = Driver.getDriver().findElement(By.xpath("//span[text()='Add Event']")).getText();
        System.out.println("actualTitle = " + actualTitle);
        Assert.assertEquals("Verify that :", expectedTitle, actualTitle);
        Thread.sleep(10);
        addEventPopUpPage.closePopUp();
    }


    @Then("Compulsory Fields must be shown")
    public void compulsory_Fields_must_be_shown(List<String> expectedField) {
        BrowserUtils.waitFor(10);
        List<WebElement> actualElements = Driver.getDriver().findElements(By.xpath("//em[text()='*']/.."));
        List<String> elementsText = BrowserUtils.getElementsText(actualElements);
        System.out.println("elementsText = " + elementsText);
        List<String> afterManipulation=new ArrayList<>();
        for (String str : elementsText) {
            String text=str.substring(0,str.indexOf("*"));
            afterManipulation.add(text);
        }
        System.out.println("expectedText = " + expectedField);
        System.out.println("afterManipulation = " + afterManipulation);
        Assert.assertEquals(expectedField,afterManipulation);
        AddEventPopUpPage addEventPopUpPage = new AddEventPopUpPage();
        addEventPopUpPage.closePopUp();
    }
}

