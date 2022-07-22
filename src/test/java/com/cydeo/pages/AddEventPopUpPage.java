package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import java.util.List;

public class AddEventPopUpPage extends BasePage{
    @FindBy(xpath = "//span[@title='Use calendar color']")
    public WebElement defaultEmptyColorBox;

    @FindBy (xpath = "//span[@role='button']")
    public List<WebElement> colorBoxes;

    @FindBy (xpath = "//span[@role='button' and @data-selected]")
    public WebElement afterClickColorBox;

    @FindBy (xpath = "(//input[@type='checkbox'])[2]")
    public WebElement allDayEventCheckBox;

    @FindBy(xpath = "(//input[@type='checkbox'])[3]")
    public WebElement repeatCheckBox;

    @FindBy (xpath = "//select[@class='recurrence-repeats__select']")
    public WebElement repeatDropDown;

    @FindBy (xpath = "//div[@class='controls recurrence-subview-control recurrence-subview-control__items']" +
            "//div[contains(@class,'recurrence-subview-control__item')]")
    public List<WebElement> endingOptions;

    @FindBy (xpath = "(//span[@class='recurrence-subview-control__text'])[6]")
    public WebElement neverButton;

    @FindBy (xpath = "(//span[@class='recurrence-subview-control__text'])[7]")
    public WebElement afterButton;

    @FindBy (xpath = "(//span[@class='recurrence-subview-control__text'])[9]")
    public WebElement byButton;

    @FindBy (xpath = "(//input[@type='radio'])[3]")
    public WebElement neverRadioButton;

    @FindBy (xpath = "(//input[@type='radio'])[4]")
    public WebElement afterRadioButton;

    @FindBy (xpath = "(//input[@type='radio'])[5]")
    public WebElement byRadioButton;

    @FindBy (name = "oro_calendar_event_form[title]")
    public WebElement titleBox;

    @FindBy (name = "oro_calendar_event_form[organizerDisplayName]")
    public WebElement organizerNameBox;

    @FindBy (name= "oro_calendar_event_form[organizerEmail]")
    public WebElement organizerEmailBox;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//a[@title='Add an event to this record']")
    public WebElement addEventButton;

    @FindBy(xpath = "(//div[@class='message'])[1]")
    public WebElement calendarEventSaved;


    public void closePopUp (){
        Driver.getDriver().findElement(By.xpath("//button[@title='close']")).click();
    }

    public boolean sendWithOnlyOneInput(String input){
        Driver.getDriver().findElement(By.xpath("//input[@required]")).sendKeys(input);
        saveButton.click();
        try {
            Thread.sleep(2000);
            Driver.getDriver().findElement(By.className("validation-failed"));
        } catch (NoSuchElementException | InterruptedException e){
            return false;
        }
        return true;
    }




}
