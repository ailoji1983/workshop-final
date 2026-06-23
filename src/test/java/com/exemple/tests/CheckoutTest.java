package com.exemple.tests;

import com.example.pages.CartPage;
import com.example.pages.CheckoutPage;
import com.example.pages.InventoryPage;
import com.example.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckoutTest extends BaseTest {

    @Test
    void checkoutCompletDeberiaFinalizarCorrectamente() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.abrir();
            loginPage.loginComo("standard_user", "secret_sauce");

            InventoryPage inventoryPage = new InventoryPage(driver);
            Assertions.assertEquals("Products", inventoryPage.obtenerTitulo());

            inventoryPage.añadirPrimerProducto();

            CartPage cartPage = inventoryPage.abrirCarrito();
            Assertions.assertEquals("Your Cart", cartPage.obtenerTitulo());

            CheckoutPage checkoutPage = cartPage.irAlCheckout();
            Assertions.assertEquals("Checkout: Your Information", checkoutPage.obtenerTituloInformacion());

            checkoutPage.rellenarDatos("Ailo", "Ji", "08001");
            checkoutPage.continuar();

            Assertions.assertEquals("Checkout: Overview", checkoutPage.obtenerTituloResumen());

            checkoutPage.finalizar();

            Assertions.assertTrue(
                    checkoutPage.obtenerMensajeFinal().contains("Thank you for your order!"),
                    "S'hauria de mostrar el missatge final de compra completada"
            );

        } catch (Throwable e) {
            marcarFallo();
            throw e;
        }
    }
}