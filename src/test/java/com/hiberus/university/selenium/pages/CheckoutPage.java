package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CheckoutPage extends BasePage {

    WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20); // Adjust the timeout as needed

        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@type='radio' and @name='account' and @value='guest']")
    private WebElement guestCheckout;

    @FindBy(xpath = "//input[@type='radio' and @name='account' and @value='register']")
    private WebElement registerCheckout;
    @FindBy(xpath = "//input[@type='button' and @id='button-account']")
    private WebElement continuButton;


    @FindBy(id = "input-payment-firstname")
    private WebElement firstNameInput;

    @FindBy(id = "input-payment-lastname")
    private WebElement lastNameInput;

    @FindBy(id = "input-payment-email")
    private WebElement emailInput;

    @FindBy(id = "input-payment-telephone")
    private WebElement telephoneInput;

    @FindBy(id = "input-payment-company")
    private WebElement companyInput;

    @FindBy(id = "input-payment-address-1")
    private WebElement address1Input;

    @FindBy(id = "input-payment-address-2")
    private WebElement address2Input;

    @FindBy(id = "input-payment-city")
    private WebElement cityInput;

    @FindBy(id = "input-payment-postcode")
    private WebElement postcodeInput;

    @FindBy(id = "input-payment-country")
    private WebElement countrySelect;

    @FindBy(id = "input-payment-zone")
    private WebElement zoneSelect;

    @FindBy(xpath = "//input[@type='button' and @id='button-guest']")
    private WebElement guestContinu;


    @FindBy(xpath = "//input[@type='checkbox' and @name='agree']")
    private WebElement termsBilling;



    @FindBy(xpath = "//input[@type='button' and @id='button-confirm']")
    private WebElement ConfirmOrder;


    @FindBy(xpath = "//input[@type='button' and @id='button-payment-method']")
    private WebElement termsContinue;


    @FindBy(id = "input-payment-password")
    private WebElement password;

    @FindBy(id = "input-payment-confirm")
    private WebElement confirmp;

    @FindBy(xpath = "//input[@type='checkbox' and @id='newsletter']")
    private WebElement newsletterNoRegi;

    @FindBy(xpath = "//input[@type='button' and @id='button-register']")
    private WebElement continuRegister;

    @FindBy(xpath = "//input[@type='checkbox' and @name='agree' and  @value='1']")
    private WebElement termsBillingR;

    @FindBy(xpath = "//input[@type='button' and @id='button-payment-address']")
    private WebElement continuAdress;


    @FindBy(xpath = "//input[@type='text' and @id='input-email']")
    private WebElement emailCliente;

    @FindBy(xpath = "//input[@type='password' and @id='input-password']")
    private WebElement passwordCliente;


    @FindBy(xpath = "//input[@type='button' and @id='button-login']")
    private WebElement loginbuttonCliente;

    @FindBy(xpath = "//div[@class='buttons']//div[@class='pull-right']//input[@type='checkbox' and @name='agree' and @value='1']")
    private WebElement termsBilling2;

    public void loginCustomer(String email,String pass)
    {
        sendKeys(emailCliente,email);
        sendKeys(passwordCliente,pass);

    }
    public void logedCustomer(){
        wait.until(ExpectedConditions.elementToBeClickable(loginbuttonCliente)).click();
        wait.until(ExpectedConditions.elementToBeClickable(continuAdress)).click();
        wait.until(ExpectedConditions.elementToBeClickable(termsBilling)).click();
        wait.until(ExpectedConditions.elementToBeClickable(termsContinue)).click();

       // loginbuttonCliente.click();
        // termsBilling.click();
       // termsContinue.click();
    }
    public void guestClick(){
        guestCheckout.click();
        continuButton.click();
    }

    public void registerClick()
    {
        registerCheckout.click();
        continuButton.click();
    }

    public void fillNewCheckoutForm(String firstName, String lastName, String email, String telephone,String pass,String confPass, String company, String address1, String address2, String city, String postcode, String country, String zone){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        telephoneInput.sendKeys(telephone);
        sendKeys(password,pass);
        sendKeys(confirmp,confPass);
        companyInput.sendKeys(company);
        address1Input.sendKeys(address1);
        address2Input.sendKeys(address2);

        cityInput.sendKeys(city);
        postcodeInput.sendKeys(postcode);

        Select countryDropdown = new Select(countrySelect);
        countryDropdown.selectByVisibleText(country);

        Select zoneDropdown = new Select(zoneSelect);
        zoneDropdown.selectByVisibleText(zone);
        wait.until(ExpectedConditions.elementToBeClickable(newsletterNoRegi)).click();
        wait.until(ExpectedConditions.elementToBeClickable(termsBilling)).click();
        wait.until(ExpectedConditions.elementToBeClickable(continuRegister)).click();


       // newsletterNoRegi.click();
        //termsBilling.click();
        //continuRegister.click();
        //salina m parte d formulaire db payment method
//termsBillingR.click();
//termsContinue.click();

       // continuAdress.click();

    }

    public void fillCheckoutForm(String firstName, String lastName, String email, String telephone, String company, String address1, String address2, String city, String postcode, String country, String zone) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        telephoneInput.sendKeys(telephone);
        companyInput.sendKeys(company);
        address1Input.sendKeys(address1);
        address2Input.sendKeys(address2);
        cityInput.sendKeys(city);
        postcodeInput.sendKeys(postcode);

        Select countryDropdown = new Select(countrySelect);
        countryDropdown.selectByVisibleText(country);

        Select zoneDropdown = new Select(zoneSelect);
        zoneDropdown.selectByVisibleText(zone);
        guestContinu.click();
    }

    public void BillingDetails()

    {
        try {
            TimeUnit.SECONDS.sleep(5); // Esperar 5 segundos (ajustar según sea necesario)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(termsBilling)).click();
        wait.until(ExpectedConditions.elementToBeClickable(termsContinue)).click();

        //termsBilling.click();
       // termsContinue.click();
    }

    public void BillingDetails2()

    {

        try {
            TimeUnit.SECONDS.sleep(5); // Esperar 5 segundos (ajustar según sea necesario)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.elementToBeClickable(termsBilling2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(termsContinue)).click();

        //termsBilling.click();
        // termsContinue.click();
    }


    public void ConfirmOrder()
    {
        ConfirmOrder.click();
        // Esperar un momento antes de finalizar la ejecución
        try {
            TimeUnit.SECONDS.sleep(5); // Esperar 5 segundos (ajustar según sea necesario)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
