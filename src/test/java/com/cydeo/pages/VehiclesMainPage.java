package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehiclesMainPage extends BasePage{
    public VehiclesMainPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//tr[@class='grid-row row-click-action'][1]")
    public WebElement vehicleRow;

    //<td class="string-cell grid-cell grid-body-cell grid-body-cell-LicensePlate" data-column-label="License Plate">15THQR</td>

    public void clickFirstVehicle(){

        vehicleRow.click();
    }

}
