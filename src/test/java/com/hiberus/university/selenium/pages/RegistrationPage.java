package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends  BasePage{

    WebDriver driver;
    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20); // Adjust the timeout as needed

        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;

    @FindBy(id = "input-lastname")
    private WebElement lastNameInput;

    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(id = "input-telephone")
    private WebElement telephoneInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(id = "input-confirm")
    private WebElement confirmPasswordInput;
    @FindBy(xpath = "//label[@class='radio-inline' and contains(text(), 'No')]/input[@type='radio']")
    private WebElement noRadio;

    @FindBy(xpath = "//input[@type='checkbox' and @name='agree']")
    private WebElement agreeCheckbox;

    @FindBy(xpath = "//input[@type='submit' and @value='Continue' and contains(@class, 'btn-primary')]")
    private WebElement ContinueButton;

    @FindBy(xpath = "//div[@class='text-danger' and text()='First Name must be between 1 and 32 characters!']")
    private WebElement errorNumberCaracters;

    @FindBy(xpath = "//div[@class='text-danger' and text()='Last Name must be between 1 and 32 characters!']")
    private WebElement errorNumberCaractersLastName;


    @FindBy(xpath = "//div[@class='text-danger' and text()='Password confirmation does not match password!']")
    private WebElement unmatchedPassError;

    @FindBy(xpath = "//div[@class='text-danger' and text()='Password must be between 4 and 20 characters!']")
    private WebElement errorPasswordLength;


    public WebElement getErrorPasswordLength()
    {
        return errorPasswordLength;
    }

    public WebElement getFirstNameInput(){
        return  firstNameInput;
    }

    public WebElement getLastNameInput()
    {
        return lastNameInput;
    }

    public WebElement getPasswordInput()
    {
        return passwordInput;
    }

    public WebElement getConfirmPasswordInput()
    {
        return confirmPasswordInput;
    }
    public WebElement getEmailInput()
    {
        return emailInput;
    }

    public boolean errorPasswordLength(){
        try {
            return errorPasswordLength.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            // Si el elemento no se encuentra o no está visible, se retorna false
            return false;
        }
    }
    public boolean errorNumberOfCaracters(){
        try {
            return errorNumberCaracters.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            // Si el elemento no se encuentra o no está visible, se retorna false
            return false;
        }
    }

    public boolean errorUnmatchedPass(){
        try {
            return unmatchedPassError.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            // Si el elemento no se encuentra o no está visible, se retorna false
            return false;
        }
    }

    public boolean errorNumberOfCaractersLastName(){
        try {
            return errorNumberCaractersLastName.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            // Si el elemento no se encuentra o no está visible, se retorna false
            return false;
        }
    }



    public void fillRegistrationForm(String firstName, String lastName, String email, String telephone, String password,String confp) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        telephoneInput.sendKeys(telephone);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(confp);
      //  noRadio.click();
        agreeCheckbox.click();
    }

    public void register()
    {
        ContinueButton.click();
    }

}
