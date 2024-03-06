package com.hiberus.university.selenium.pages;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class StorePage  extends BasePage{
 WebDriver driver;
    public StorePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20); // Adjust the timeout as needed

        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "//button[@type='button' and contains(@onclick, \"cart.add('43')\")]")
    private WebElement buttonProducto1;


    @FindBy(xpath = "//a[@href='https://opencart.abstracta.us:443/index.php?route=checkout/checkout' and @title='Checkout']")
    private WebElement CheckoutButton;

    @FindBy(xpath = "//button[@type='button' and contains(@onclick, \"cart.remove('269203');\")]")
    private WebElement eliminarMac;

    @FindBy(xpath = "//button[@type='button'  and @class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
    private WebElement CardButton;

    @FindBy(xpath = "//button[@class='btn btn-link dropdown-toggle'] ")
    private WebElement currencyDrop;

    @FindBy(xpath = "//p[@class='price'] ")
    private List<WebElement> price;




    public boolean inEuro()
  {
      boolean allPricesInUSD = true;
      for (WebElement priceElement : price ) {
          String priceText = priceElement.getText();
          if (!priceText.contains("€")) {
              allPricesInUSD = false;
              break; // Exit the loop early if any price is not in USD
          }
      }
      return allPricesInUSD;

  }


    public  int generateRandomNumber() {
        // Crear una instancia de la clase Random
        Random random = new Random();

        // Definir los números disponibles
        int[] availableNumbers = {40, 30, 42, 43};

        // Obtener un índice aleatorio dentro del rango de la matriz availableNumbers
        int randomIndex = random.nextInt(availableNumbers.length);

        // Obtener el número aleatorio correspondiente al índice generado
        int randomNumber = availableNumbers[randomIndex];

        // Devolver el número aleatorio generado
        return randomNumber;
    }

    // Método para añadir un producto al carrito
    public void addProductToCart(int number) {

            String productXPath = "//button[@type='button' and contains(@onclick, \"cart.add('" + number + "');\")]";
            WebElement addToCartButton = null;
            int maxTries = 3;
            int currentTry = 0;
            while (currentTry < maxTries) {
                try {
                    addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(productXPath)));
                    addToCartButton.click();
                    System.out.println("Add to cart button clicked for product ID: " + number);
                    break; // Break out of the loop if successful
                } catch (StaleElementReferenceException e) {
                    // Increment the try count and retry
                    currentTry++;
                }
            }
        waitForCartItemCountToUpdate();

    }

    public String waitForCartItemCountToUpdate() {
        String cartItemCountText = "";
        WebElement cartItemCountElement = null;

        // Retry logic to handle StaleElementReferenceException
        int maxTries = 3;
        int currentTry = 0;
        while (currentTry < maxTries) {
            try {
                // Locate the element using visibilityOfElementLocated condition
                cartItemCountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='cart-total']")));
                cartItemCountText = cartItemCountElement.getText();
                break; // Break out of the loop if successful
            } catch (StaleElementReferenceException e) {
                // Increment the try count and retry
                currentTry++;
            }
        }
        return cartItemCountText;
    }


    public String getCartItemCount() {
        String cartItemCountText = "";
        WebElement cartItemCountElement = null;

        // Retry logic to handle StaleElementReferenceException
        int maxTries = 3;
        int currentTry = 0;
        while (currentTry < maxTries) {
            try {
                // Locate the element using visibilityOfElementLocated condition
                cartItemCountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='cart-total']")));
                cartItemCountText = cartItemCountElement.getText();
                break; // Break out of the loop if successful
            } catch (StaleElementReferenceException e) {
                // Increment the try count and retry
                currentTry++;
            }
        }
        return cartItemCountText;
    }



    public void registrationPage(){

        WebElement dropdownMenu = driver.findElement(By.xpath("//a[@class='dropdown-toggle' and contains(@title,'My Account')]"));

        // Click on the dropdown menu to expand it
        dropdownMenu.click();

        // Find the "Register" anchor element within the dropdown menu and click on it
        WebElement registerLink = driver.findElement(By.xpath("//ul[contains(@class, 'dropdown-menu')]/li/a[contains(text(), 'Register')]"));
        registerLink.click();
    }

    public void LoginPage(){

        WebElement dropdownMenu = driver.findElement(By.xpath("//a[@class='dropdown-toggle' and contains(@title,'My Account')]"));

        // Click on the dropdown menu to expand it
        dropdownMenu.click();

        // Find the "Register" anchor element within the dropdown menu and click on it
        WebElement registerLink = driver.findElement(By.xpath("//ul[contains(@class, 'dropdown-menu')]/li/a[contains(text(), 'Login')]"));
        registerLink.click();
    }

    public void checkoutClick()
    {
        CheckoutButton.click();
    }

    public void eliminarMac() {
        wait.until(ExpectedConditions.elementToBeClickable(CardButton));
        CardButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button' and @class='btn btn-danger btn-xs']")));
        WebElement eliminarButton = driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-danger btn-xs']"));
        eliminarButton.click();
    }



public  void divida(String desiredCurrency)
{
    currencyDrop.click();

    // Locate the dropdown menu
    WebElement dropdownMenu = driver.findElement(By.xpath("//ul[@class='dropdown-menu']"));

    // Find all currency options (buttons) inside the dropdown menu
    List<WebElement> currencyOptions = dropdownMenu.findElements(By.tagName("button"));

    // Click on a specific currency option (button)
    // For example, clicking on the first currency option

    //String desiredCurrency = "€ Euro";
    for (WebElement option : currencyOptions) {
        if (option.getText().equals(desiredCurrency)) {
            option.click();
            break; // Exit the loop once the desired option is clicked
        }
    }
}







}
