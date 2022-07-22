package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GeneralInformationPage extends BasePage{
    @FindBy(xpath = "//h5/span")
    public WebElement pageTitle;
    @FindBy(xpath = "//a[@title='Edit Car']")
    public WebElement editButton;
    @FindBy(xpath = "//a[@title='Delete Car']")
    public WebElement deleteButton;

    @FindBy(xpath = "//a[@title='Add an event to this record']")
    public WebElement addEventButton;

    @FindBy(css = ".btn.cancel")
    public WebElement cancelButton;
    @FindBy(css = ".btn.ok.btn-danger")
    public WebElement yesDeleteButton;
    @FindBy(css = ".message")
    public WebElement carDeletedMessage;
    @FindBy (xpath = "//div[@class='message-item message']")
    public List<WebElement> titlesOfEvents;

    public List<String> getAllInfo() {
        List<String> info = new ArrayList<>();
        for (int i = 1; i <20; i++) {
            info.add(Driver.getDriver().findElement(By.xpath("(//div[@class='responsive-cell responsive-cell-no-blocks']//div[@class='control-label'])["+i+"]")).getText());
        }
        return info;
    }
}
