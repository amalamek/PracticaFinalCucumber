package com.hiberus.university.selenium.stepdefs;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.junit.Assert;

import static com.hiberus.university.selenium.support.Hooks.driver;

public class LoginSteps {
    
    
    @When("completo el formulario de inicio de sesión")
        public void completo_el_formulario_de_inicio_de_sesión()
        {
             PagesFactory.getInstance().getLoginPage().completarFormularioLogin("sabah@gmail.com","sabahsabah");
        }

    @And("hago login")
    public void hagoLogin() {
        PagesFactory.getInstance().getLoginPage().submitLogin();
    }

    @Then("se dirigo a la pagina login")
    public void seDirigoALaPaginaLogin() {


        String expectedURL = "https://opencart.abstracta.us/index.php?route=account/account";
        String actualURL =  driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);
        System.out.println("se ha redirigido al cuenta con exito");
    }

    @When("completo el formulario de inicio de sesión con el correo electrónico {string} y la contraseña {string}")
    public void completoElFormularioDeInicioDeSesiónConElCorreoElectrónicoYLaContraseña(String arg0, String arg1) {
        PagesFactory.getInstance().getLoginPage().completarFormularioLogin(arg0,arg1);

    }

    @Then("se muestra un mensaje de error")
    public void seMuestraUnMensajeDeError() {

       boolean mensajeError= PagesFactory.getInstance().getLoginPage().isErrorDisplayed();
        Assert.assertTrue("no se muestra",mensajeError);
        System.out.println("se muestre el mensaje d error");
    }
}
