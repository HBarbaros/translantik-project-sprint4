package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehiclesPage extends BasePage{
    public VehiclesPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(className = "string-cell_grid-cell_grid-body-cell_grid-body-cell-LicensePlate")
    public WebElement vehicleRow;


}
