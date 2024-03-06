package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.hiberus.university.selenium.support.Hooks.driver;

public class CheckoutSteps {



    
    
    


    @Then("se redirigo a la pagina de checkout exitoso")
    public void seRedirigoALaPaginaDeCheckoutExitoso() {


        String expectedURL = "https://opencart.abstracta.us/index.php?route=checkout/success";
        String actualURL =  driver.getCurrentUrl();
        Assert.assertEquals("no hice el checkout, la pagina no se redirigida",expectedURL, actualURL);
        System.out.println("se ha redirigido al succes page con exito");
    }

    @And("eligir guest")
    public void eligirGuest() {
        PagesFactory.getInstance().getCheckoutPage().guestClick();

    }

    @And("completo el formulario del checkout guest")
    public void completoElFormularioDelCheckoutGuest() {

        PagesFactory.getInstance().getCheckoutPage().fillCheckoutForm("laila","la","laila@gmail.com","0987543332","hiberus","fnideq56","kondissa","fndq","93102","Morocco","Chaouen");
        PagesFactory.getInstance().getCheckoutPage().BillingDetails();
        PagesFactory.getInstance().getCheckoutPage().ConfirmOrder();
    }

    @And("eligir register")
    public void eligirRegister() {
        PagesFactory.getInstance().getCheckoutPage().registerClick();
    }

    @And("completo el formulario del checkout no registrado con {string} y {string} y {string} y {string} y {string} y {string} y {string} y {string} y {string} y {string} y {string} y {string} y {string}")
    public void completoElFormularioDelCheckoutNoRegistrado(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12) {

        PagesFactory.getInstance().getCheckoutPage().fillNewCheckoutForm(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11,arg12);
        PagesFactory.getInstance().getCheckoutPage().BillingDetails2();

        PagesFactory.getInstance().getCheckoutPage().ConfirmOrder();
    }

    @And("eligir cliente y hacer login con {string} y {string}")
    public void eligirClienteYHacerLogin(String arg0,String arg1) {
        PagesFactory.getInstance().getCheckoutPage().loginCustomer(arg1,arg0);
    }

    @And("completo el formulario del checkout registrado")
    public void completoElFormularioDelCheckoutRegistrado() {
        PagesFactory.getInstance().getCheckoutPage().logedCustomer();
        PagesFactory.getInstance().getCheckoutPage().ConfirmOrder();
    }

    @And("completo el formulario del checkout guest con {string} y {string} y {string} y {string} y {string} y {string} y {string} y {string} y {string} y {string} y {string}")
    public void completoElFormularioDelCheckoutGuestConYYYYYYYYYY(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10) {
        PagesFactory.getInstance().getCheckoutPage().fillCheckoutForm(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
        PagesFactory.getInstance().getCheckoutPage().BillingDetails();

        PagesFactory.getInstance().getCheckoutPage().ConfirmOrder();

    }


}
