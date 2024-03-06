package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class StoreSteps {

    @When("anadir al carrito de productos al azar")
    public void anadirAlCarritoDeProductosAlAzar() {
        int number =PagesFactory.getInstance().getStorePage().generateRandomNumber();
        if (number==43 || number==40)
        {
            PagesFactory.getInstance().getStorePage().addProductToCart(number);
        } else if (number==30) {
            PagesFactory.getInstance().getCannonPage().addProductTocard2(number);
        } else if (number==42) {
            PagesFactory.getInstance().getApplePage().addProduct3(42);

        }
    }

    @Then("se agrega el numero de productos del carrito")
    public void se_agrega_el_numero_de_productos_del_carrito() {
         String expectedText = "1 item"; // El texto esperado en el elemento del carrito
       String actualText = PagesFactory.getInstance().getStorePage().getCartItemCount();
         Assert.assertTrue("no se agrega",actualText.contains(expectedText));
        System.out.println("se ha agregado"+actualText);
    }

    @Given("que estoy en la pagina")
    public void queEstoyEnLaPagina() {
        PagesFactory.getInstance().getStorePage().navigateTo("http://opencart.abstracta.us/");
    }

    @And("estoy dirigido a la pagina de registracion")
    public void estoyDirigidoALaPaginaDeRegistracion() {

PagesFactory.getInstance().getStorePage().registrationPage();


    }


    @And("estoy dirigido a la pagina de Login")
    public void estoyDirigidoALaPaginaDeLogin() {

   PagesFactory.getInstance().getStorePage().LoginPage();
    }

    @And("Hago una compra")
    public void hagoUnaCompra() {
        PagesFactory.getInstance().getStorePage().addProductToCart(43);
    }

    @When("hago click al Checkout")
    public void hagoClickAlCheckout() {
        // Esperar un momento antes de finalizar la ejecución
        try {
            TimeUnit.SECONDS.sleep(5); // Esperar 5 segundos (ajustar según sea necesario)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

     PagesFactory.getInstance().getStorePage().checkoutClick();
    }

    @When("anadir un producto al carrito")
    public void anadirUnProductoAlCarrito() {
        PagesFactory.getInstance().getStorePage().addProductToCart(43);
        
    }

    @When("hago clic en el botón de eliminar junto al producto que deseo quitar")
    public void hagoClicEnElBotónDeEliminarJuntoAlProductoQueDeseoQuitar() {

        PagesFactory.getInstance().getStorePage().eliminarMac();
    }

    @Then("el producto es eliminado del carrito de compras")
    public void elProductoEsEliminadoDelCarritoDeCompras() {
        String actual=PagesFactory.getInstance().getStorePage().getCartItemCount();
        String expected="0 item(s)";
        boolean contain=actual.contains(expected);
         Assert.assertTrue("no se ha eliminado",contain);
         System.out.println("se ha eliminado");
    }

    @When("eligo la divida en {String}")
    public void eligoLaDivida(String arg0) {
        PagesFactory.getInstance().getStorePage().divida(arg0);

    }

    @Then("se muestran los productos con la divisa eligida")
    public void seMuestranLosProductosConLaDivisaEligida() {
        boolean expected=PagesFactory.getInstance().getStorePage().inEuro();
        Assert.assertTrue("no son in euro",expected);
        System.out.println("son en euro");
     }
}
