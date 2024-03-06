package com.hiberus.university.selenium.pages;

import com.hiberus.university.selenium.utils.MyFluentWait;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;


public class ApplePage  extends BasePage{

    WebDriver driver;
    public ApplePage(WebDriver driver) {
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


    public void addProduct37(int productId) {
        // Click on the product with the specified ID and navigate to the form page
        String productXPath = "//button[@type='button' and contains(@onclick, \"cart.add('" + productId + "');\")]";
        WebElement productButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(productXPath)));
        productButton.click();

        // Select size by clicking the radio button
        WebElement sizeRadioButton = driver.findElement(By.xpath("//input[@name='option[218]']"));
        sizeRadioButton.click();

        WebElement sizeCheckbox = driver.findElement(By.xpath("//input[@type='checkbox' and @name='option[223][]']"));
        sizeCheckbox.click(); // Assuming size is represented as a checkbox

        WebElement commentField = driver.findElement(By.xpath("//input[@id='input-option208']"));
        commentField.sendKeys("new purchase");

        // Fill in the form
        WebElement colorDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='input-option217']")));
        Select colorSelect = new Select(colorDropdown);
        colorSelect.selectByVisibleText("Red (+$4.80)");


        // Locate the textarea element
        WebElement textArea = driver.findElement(By.xpath("//textarea[@id='input-option209']"));
        textArea.clear();
        textArea.sendKeys("This is the text you want to input into the textarea");


        WebElement fileInput = driver.findElement(By.xpath("//input[@id='input-option222']"));
        fileInput.sendKeys("C:\\Users\\Asus\\Pictures\\Screenshots\\cl.png");

        WebElement dateTimeInput = driver.findElement(By.xpath("//input[@id='input-option219']"));
       // dateTimeInput.sendKeys("dateTime");

        WebElement quantityInput = driver.findElement(By.xpath("//input[@id='input-quantity']"));
        quantityInput.clear();
        quantityInput.sendKeys("3");

        // Click on the "Add to Cart" button
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='button-cart']"))); // Wait for button to be clickable
        addToCartButton.click();


        try {
            Thread.sleep(2000); // Wait for 2 seconds (adjust as needed)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Wait for the cart item count to update
        waitForCartItemCountToUpdate();
    }

    public void uploadFile(String filePath) {
        // Click on the button to trigger the file selection dialog
        WebElement uploadButton = driver.findElement(By.xpath("//button[@id='button-upload222']"));
        uploadButton.click();

        // Wait for the file selection dialog to appear (adjust the delay as needed)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Use Robot class to handle file selection dialog
        try {
            Robot robot = new Robot();

            // Set clipboard with file path
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            // Paste the file path into the file selection dialog
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Press Enter to confirm file selection
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

public void addProduct3(int productId) {
    // Predefined data
    //int productId = 123; // Example product ID
    String comment = "New purchase";
    String dateTime = "2024-03-03 12:00 PM"; // Example datetime
    String filePath = "C:\\Users\\Asus\\Pictures\\Screenshots\\cl.png"; // Example file path
    int quantity = 2;

    // Click on the product with the specified ID and navigate to the form page
    String productXPath = "//button[@type='button' and contains(@onclick, \"cart.add('" + productId + "');\")]";

    WebElement productButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(productXPath)));
    productButton.click();

    // Select size by clicking the radio button
    WebElement sizeRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='radio' and @name='option[218]']")));
    sizeRadioButton.click();

    // Assuming size is represented as a checkbox
    WebElement sizeCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox' and @name='option[223][]']")));
    sizeCheckbox.click();

    // Fill in the comment field
    WebElement commentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-option208']")));
    commentField.sendKeys(comment);

    // Fill in the color dropdown
    WebElement colorDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='input-option217']")));
    Select colorSelect = new Select(colorDropdown);
    colorSelect.selectByVisibleText("Red (+$4.80)");

    // Fill in the textarea
    WebElement textArea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='input-option209']")));
    textArea.clear();
    textArea.sendKeys("This is the text you want to input into the textarea");

    // Upload file
    // Trigger file upload
    uploadFile(filePath);
    // Handle the alert
    try {
        WebDriverWait alertWait = new WebDriverWait(driver, 10);
        alertWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept(); // Click OK on the alert
    } catch (NoAlertPresentException e) {
        // No alert found, continue with the test
        System.out.println("No alert found after uploading file.");
    }


    // Fill in the dateTime input
       // WebElement dateTimeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-option219']")));
       // dateTimeInput.sendKeys(dateTime);

        try {
            TimeUnit.SECONDS.sleep(3); // Esperar 5 segundos (ajustar según sea necesario)
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        // Fill in the quantity input
        WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-quantity']")));
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));

        // Click on the "Add to Cart" button
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='button-cart']")));
        addToCartButton.click();



    // Add a short wait to allow time for the cart item count to update
    try {
        Thread.sleep(20000); // Wait for 2 seconds (adjust as needed)
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    // Wait for the cart item count to update
    waitForCartItemCountToUpdate();
}
}

