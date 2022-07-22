package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEventPage extends BasePage{
    public AddEventPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='ui-dialog-title']")
    public WebElement addEventPopup;

    @FindBy(xpath = "//*[contains(text(),'Text') ]")
    public WebElement title;



}
