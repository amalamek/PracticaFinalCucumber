package com.hiberus.university.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CannonPage  extends  BasePage{

    WebDriver driver;
    public CannonPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20); // Adjust the timeout as needed

        PageFactory.initElements(driver, this);
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
        System.out.println(cartItemCountText );
        return cartItemCountText;
    }

    public void addProductTocard2(int productId) {
        // Click on the product with the specified ID and navigate to the form page
        String productXPath = "//button[@type='button' and contains(@onclick, \"cart.add('" + productId + "');\")]";
        WebElement productButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(productXPath)));
        productButton.click();

        // Fill in the form
        WebElement colorDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='input-option226']")));
        Select colorSelect = new Select(colorDropdown);
        colorSelect.selectByVisibleText("Blue");

        // Find and interact with the form elements to fill them
        WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-quantity']")));
        quantityInput.clear(); // Clear any existing value
        quantityInput.sendKeys("1"); // Enter the desired quantity

        // Click on the "Add to Cart" button
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='button-cart']"))); // Wait for button to be clickable
        addToCartButton.click();

        // Add a short wait to allow time for the cart item count to update
        try {
            Thread.sleep(2000); // Wait for 2 seconds (adjust as needed)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Wait for the cart item count to update
        waitForCartItemCountToUpdate();
    }




}
