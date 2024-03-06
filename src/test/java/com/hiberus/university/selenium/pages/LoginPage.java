package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage  extends  BasePage{

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20); // Adjust the timeout as needed

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='submit' and @value='Login']")
    private WebElement submitLoginButton;


    @FindBy(xpath = "//input[@type='text' and @id='input-email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@type='password' and @id='input-password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible' and contains(text(),'Warning: No match for E-Mail Address and/or Password.')]")
    private WebElement errorMessage;


    public void submitLogin()
    {
         submitLoginButton.click();
    }

    public void completarFormularioLogin(String email,String password)
    {
       inputEmail.sendKeys(email);
       inputPassword.sendKeys(password);
    }
public boolean isErrorDisplayed() {
    try {
         return errorMessage.isDisplayed();
    } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
        // Si el elemento no se encuentra o no está visible, se retorna false
        return false;
    }
}}

