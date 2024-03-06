package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.hiberus.university.selenium.support.Hooks.driver;

public class RegistrationSteps {



    @When("I fill in the registration form with valid information")
    public void iFillInTheRegistrationFormWithValidInformation() {
      //  PagesFactory.getInstance().getRegistrationPage().fillRegistrationForm("amal","amakran","moncef@gmail.com","0986543234","azertyui");

    }

    @And("I submit the registration form")
    public void iSubmitTheRegistrationForm() {
  PagesFactory.getInstance().getRegistrationPage().register();

    }

    @Then("I should see a confirmation message")
    public void iShouldSeeAConfirmationMessage() {
        // Verify redirection to the specified URL
        String expectedURL = "https://opencart.abstracta.us/index.php?route=account/success";
        String actualURL =  driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);
        System.out.println("se ha redirigido al succes page con exito");

// Verify the presence of the message in the <p> element
        WebElement successMessage = driver.findElement(By.xpath("//p[contains(text(), 'Congratulations! Your new account has been successfully created!')]"));
        Assert.assertTrue(successMessage.isDisplayed());
        System.out.println("se ha muestrado el mensaje de registarcion exitoso");

    }

    @When("I fill in the registration form with valid information with {string} and {string} and {string} and {string} and {string} and {string}")
    public void iFillInTheRegistrationFormWithValidInformationWithAndAndAndAnd(String arg0, String arg1, String arg2, String arg3, String arg4,String arg5) {

        PagesFactory.getInstance().getRegistrationPage().fillRegistrationForm(arg0,arg1,arg2,arg3,arg4,arg5);

    }

    @Then("I should see a error message about the number of caracters")
    public void iShouldSeeAErrorMessageAboutTheNumberOfCaracters() {
        String firstnameText = PagesFactory.getInstance().getRegistrationPage().getFirstNameInput().getText();
        String lastnameText = PagesFactory.getInstance().getRegistrationPage().getLastNameInput().getText();

        boolean firstNameErrorMessageDisplayed = PagesFactory.getInstance().getRegistrationPage().errorNumberOfCaracters();
        boolean lastNameErrorMessageDisplayed = PagesFactory.getInstance().getRegistrationPage().errorNumberOfCaractersLastName();

        if (firstnameText.isEmpty() || firstnameText.length() > 32) {
            Assert.assertTrue("The error message for the first name is not displayed", firstNameErrorMessageDisplayed);
            System.out.println("The error message for the first name is displayed");
        } else {
            System.out.println("The length of the first name is correct or the error message is not expected");
        }

        if (lastnameText.isEmpty() || lastnameText.length() > 32) {
            Assert.assertTrue("The error message for the last name is not displayed", lastNameErrorMessageDisplayed);
            System.out.println("The error message for the last name is displayed");
        } else {
            System.out.println("The length of the last name is correct or the error message is not expected");
        }

    }

    @Then("I should see a error message about the incorrect passwords")
    public void iShouldSeeAErrorMessageAboutTheUnmatchedPasswords() {
        String pass=PagesFactory.getInstance().getRegistrationPage().getPasswordInput().getText();
        String confiPass=PagesFactory.getInstance().getRegistrationPage().getConfirmPasswordInput().getText();

        int passLength=PagesFactory.getInstance().getRegistrationPage().getPasswordInput().getText().length();

        Boolean unmatched=PagesFactory.getInstance().getRegistrationPage().errorUnmatchedPass();
        Boolean errorlength= PagesFactory.getInstance().getRegistrationPage().errorPasswordLength();
        if(!(pass==confiPass)){
            Assert.assertTrue("No se ha muestrado el error de unmatched passwords",unmatched);
            System.out.println("se ha muestrado el error de unmatched passwords");
        }
        else {
            System.out.println("los passwords con compatibles");
        }
        if(passLength<4 || passLength>20){
            Assert.assertTrue("no se ha muestrado el error del length ",errorlength);
            System.out.println("se ha muestrado el mensaje de error de password length");
        }else {
            System.out.println("la longitud del password esta correcta");
        }
    }


}
