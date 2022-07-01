package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "prependedInput")
    public WebElement loginUser;

    @FindBy(id = "prependedInput2")
    public WebElement loginPass;

    @FindBy(id = "_submit")
    public WebElement loginBtn;

    @FindBy(id = "remember_me")
    public WebElement rememberMeBtn;




    public void login(String username, String password) {
        loginUser.sendKeys(username);
        loginPass.sendKeys(password);
        loginBtn.click();
    }


}
