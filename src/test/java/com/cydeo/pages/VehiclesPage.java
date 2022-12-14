package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;

public class VehiclesPage extends BasePage{

    public VehiclesPage() {
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

    @FindBy(xpath = "//span[.='Model Year']")
    public WebElement modelYearColumnName;

    @FindBy(xpath = "//tbody//tr//td[7]")
    public WebElement allModelYears;

    @FindBy(xpath = "//tbody//tr[1]//td[2]")
    public WebElement firstRowLicensePlate;

    @FindBy(xpath = "//*[@id=\"grid-custom-entity-grid-246958702\"]/div[2]/div[1]/div/div[3]/div[1]/div/a[3]/i")
    public WebElement resetButton;

//=========================================================================================//

    @FindBy(className = "no-data")
    public WebElement noDataInformer;

    @FindBy(xpath = "//thead[@class='grid-header']//span[@class='grid-header-cell__label'][normalize-space()='Chassis Number']")
    public WebElement chassisNumTableHead;

    @FindBy(xpath = "//label[@class='dib'][2]")
    public WebElement lastPageNum;

    //@FindBy(xpath = "//i[@class='fa-chevron-right hide-text']")
    @FindBy(css = "i[class='fa-chevron-right hide-text']")
    public WebElement forwardPageArrow;

    @FindBy(xpath = "//input[@value='ChassisNumber']")
    public WebElement chassisNumberBox;

    @FindBy(xpath = "//div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value']")
    public WebElement chassisNumberAllButton;

    @FindBy(xpath = "//button[@class='btn dropdown-toggle']")
    public WebElement chassisDropdownMenu;

    @FindBy(xpath = "(//ul[@class='dropdown-menu'])[5]")
    public List<WebElement> chassisDDMenuOptions;

    @FindBy(css = "a.dropdown-item.choice-value")
    public List<WebElement> chassisDDMenuOpts;

    @FindBys({@FindBy(xpath = "//a[@class='dropdown-item choice-value']")})
    public List<WebElement> chassisDropdownMenuElements;

    @FindBy (css = "a[data-value='2']")
    public WebElement moreThanButton;

    @FindBy(css = "a[data-value='6']")
    public WebElement lessThanButton;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement inputBox;

    //    @FindBy(css = "button[class='btn btn-primary filter-update']")
    @FindBy(xpath = "//button[normalize-space()='Update']")
    public WebElement updateButton;

    @FindBy (css = "[data-column-label='Chassis Number']")
    public List<WebElement> chassisNumResults;

    @FindBy(xpath = "//button[@class='btn dropdown-toggle ']")
    public WebElement viewPerPageButton;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu__action-cell launchers-dropdown-menu detach dropdown-menu__floating']" +
            "//li[@class='launcher-item'][3]")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[@class='modal oro-modal-danger in']")
    public WebElement deleteConfirmation;

    @FindBy(css = ".btn.cancel")
    public WebElement cancelButton;

    @FindBy(css = ".btn.ok.btn-danger")
    public WebElement yesDeleteButton;

    @FindBy(xpath = "//div[@class='alert alert-success fade in top-messages ']/div[@class='message']")
    public WebElement itemDeletedMessage;

    @FindBy(xpath = "//label[@class='dib'][3]")
    public WebElement totalRecordsText;

    @FindBy (xpath = "//b")
    public WebElement filterCriteriaSelector; //her filtre se??ildi??inde ????kan yan??nda All yazan filtre (Sel??uk)


    //View Per Page Filter (Ramazan)
    @FindBy(xpath = "//a[@class='dropdown-item']")
    public List<WebElement> viewfilter;


    //Vehicle table rows (Ramazan)
    @FindBy(xpath = "//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr")
    public List <WebElement> vehicleTableRows;



    //Ramazan
    @FindBy (xpath = "//div/button[@class= 'btn dropdown-toggle ']")
    public WebElement button_locator;

    //Ramazan Reset Button
    @FindBy(xpath = "//a[@class='action btn reset-action mode-text-only']")
    public WebElement resetButton_Locator;

    //Ramazan
    @FindBy(xpath = "//a[@class='grid-header-cell__link']//span[@class='caret']")
    public  List<WebElement> spanCaret_Locator;

    //filtrede ????kan metod isimleri (Sel??uk)
    @FindBy(css = ".dropdown-item.choice-value")
    public List<WebElement> methods;

    //her filtrede default olarak ????kan metod(Sel??uk)
    public WebElement defaultMethodOfTheFilter(String name){
        return Driver.getDriver().findElement(By.xpath("//button[contains(text(),'"+name+"')]"));
    }

    //contains filtresi input box (Sel??uk)
    @FindBy(xpath = "//input[@name='value']")
    public WebElement filterInputbox;

    //contains filtresi update (Sel??uk)
    @FindBy(xpath = "//button[contains(text(),'Update')]")
    public WebElement filterUpdateButton;

    //Driver column da yer alanlar (Sel??uk)
    @FindBy(xpath = "//td[@data-column-label='Driver']")
    public List<WebElement> columnText;

    //Location column da yer alanlar (Salih)
    public List<WebElement>filterColumnNames(String subMethodName){
        return Driver.getDriver().findElements(By.xpath("//td[@data-column-label='"+subMethodName+"']"));
    }

    //Driver column da yer alanlar (Salih)
    @FindBy(xpath = "//td[@data-column-label='Location']")
    public List<WebElement> columnText2;

    @FindBy (xpath = "//div[@class='other-scroll-container']")
    public WebElement all_cars_table_on_vehicles_page;

    @FindBy (xpath = "//input[@class='input-widget']")
    public WebElement page_number_input_widget;

    @FindBy (xpath = "//i[@class='fa-chevron-left hide-text']")
    public WebElement backPageArrow;

    @FindBy (xpath = "//div[@class='extra-actions-panel']/div/div/a")
    public WebElement export_grid_link;

    @FindBy (xpath = "//div[@class='btn-group open']/ul/li[1]")
    public WebElement csv_download_link;

    @FindBy (xpath = "//div[@class='btn-group open']/ul/li[2]")
    public WebElement xlsx_download_link;

    @FindBy (xpath = "//div[.='Export started successfully. You will receive email notification upon completion.']")
    public WebElement export_confirmation_message;

    //her filtrenin alt??nda ????kan metodlar
    public List<WebElement>columnText3(String subMethodName){
        return Driver.getDriver().findElements(By.xpath("//td[@data-column-label='"+subMethodName+"']"));
    }

    //her filtrenin alt??nda ????kan metodlar
    public WebElement subMethodsOfTheFilter(String subMethodName){
        return Driver.getDriver().findElement(By.xpath("//a[contains(text(),'"+subMethodName+"')]"));
    }

    public String getTotalRecords(){
        String[] arr = totalRecordsText.getText().split(" ");
        return arr[2];
    }




    public void selectAnyRowOfAllCarsTable(int rowNum1to25) {
        BrowserUtils.waitForClickablility(Driver.getDriver().findElement(By.xpath("//tr[@class='grid-row row-click-action']["+rowNum1to25+"]")),10);
        Driver.getDriver().findElement(By.xpath("//tr[@class='grid-row row-click-action']["+rowNum1to25+"]")).click();
    }

    public WebElement selectRowWithAny(String head, String value){
        String xpath = "//td[contains(@class,'-cell grid-cell grid-body-cell grid-body-cell-"+head+"')][.='"+value+"']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }


    public void goThreeDot(){
        //(//td[@class='action-cell grid-cell grid-body-cell']/div[1]/div[1]/a)[1] // three dot button
        String xpath = "(//td[@class='action-cell grid-cell grid-body-cell']/div[1]/div[1]/a)[1]";
        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));
        BrowserUtils.waitForClickablility(element,5);
        new Actions(Driver.getDriver()).moveToElement(element).pause(2000).doubleClick(element).build().perform();
    }

    public void selectPerPage(int dataSize){
        viewPerPageButton.click();
        Driver.getDriver().findElement(By.xpath("//a[@data-size='" + dataSize + "']")).click();
    }
    public WebElement getThreeDotIcon(String iconName){
        return Driver.getDriver().findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu__action-cell launchers-dropdown-menu detach dropdown-menu__floating']//a[@title='"+iconName+"']"));
        //ul[@class='dropdown-menu dropdown-menu__action-cell launchers-dropdown-menu']//a[@title='View']
    }

    public List<String> getAllInfoOfRow(String rowNumber) {
        List<WebElement> getAllInfo = new ArrayList<>();
        for (int i = 2; i < 21; i++) {
            getAllInfo.add(Driver.getDriver().findElement(By.xpath("//tr[@class='grid-row row-click-action']["+rowNumber+"]//td["+i+"]")));
        }
        List<String> elementsText = BrowserUtils.getElementsText(getAllInfo);
        String noComma4 = elementsText.get(4).replaceAll(",","");
        elementsText.set(4,noComma4);
        String noComma6 = elementsText.get(6).replaceAll(",","");
        elementsText.set(6,noComma6);

        return elementsText;
    }

    public boolean isClickable(WebElement webe)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
            wait.until(ExpectedConditions.elementToBeClickable(webe));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }





}
