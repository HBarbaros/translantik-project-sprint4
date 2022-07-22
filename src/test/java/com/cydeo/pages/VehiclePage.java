package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehiclePage {
    public VehiclePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='pull-left btn-group icons-holder'][3]")
    public WebElement addEventButton;

    //("//button[contains(text(),'Add User')]")
    //pull-left btn-group icons-holder

    //<a href="javascript: void(0);" class="btn icons-holder-text no-hash" title="Add an event to this record" data-id="163" data-url="/calendar/event/create?entityClass=Extend_Entity_Carreservation&amp;entityId=163&amp;_action=activity" data-bound-component="oroui/js/app/components/widget-component"><i class="fa-clock-o hide-text">Add Event</i>Add Event</a>
}

