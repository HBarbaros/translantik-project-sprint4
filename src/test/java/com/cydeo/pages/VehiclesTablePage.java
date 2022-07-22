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

    @FindBy(xpath = "//div[@class='page-size pull-right form-horizontal']/div/div/button/..//ul/li[1]")
    public WebElement tenPerPage;

    @FindBy(xpath = "//div[@class='page-size pull-right form-horizontal']/div/div/button/..//ul/li[2]")
    public WebElement twentyFivePerPage;

    @FindBy(xpath = "//div[@class='page-size pull-right form-horizontal']/div/div/button/..//ul/li[3]")
    public WebElement fiftyPerPage;

    @FindBy(xpath = "//div[@class='page-size pull-right form-horizontal']/div/div/button/..//ul/li[4]")
    public WebElement hundredPerPage;

    @FindBy(xpath = "//tr[@class='grid-row']")
    public WebElement tableRows;







}
