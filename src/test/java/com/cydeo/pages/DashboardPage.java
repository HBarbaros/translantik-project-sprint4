package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage{
    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
