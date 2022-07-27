package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GeneralInformationPage {

    public GeneralInformationPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//h5[@class='user-fieldset']/span")
    public WebElement generalInformationPageTitle;

    @FindBy (xpath = "//a[@title='Edit Car']")
    public WebElement editCarButton;

    @FindBy (xpath = "//a[@title='Delete Car']")
    public WebElement deleteCarButton;

    @FindBy (xpath = "//a[@class='btn icons-holder-text no-hash']")
    public WebElement addEventButton;

    public List<String> getAllInfoOfGeneralInformation(){
        List<String> info = new ArrayList<>();
        for (int i = 1; i < 20 ; i++) {
            info.add(Driver.getDriver().findElement(By.xpath("(//div[@class='responsive-cell responsive-cell-no-blocks']//div[@class='control-label'])["+i+"]")).getText());
        }
        return info;
    }


}
