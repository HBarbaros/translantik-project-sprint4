package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehiclesTablePage extends BasePage{

    public VehiclesTablePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='page-size pull-right form-horizontal']/div/div/button")
    public WebElement viewPerPageDropdownMenu;

    @FindBy(xpath = "//div[@class='page-size pull-right form-horizontal']/div/div/button/..//ul")
    public WebElement viewPerPageDropdownList;



}
