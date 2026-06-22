package com.exemple.tests;

import com.exemple.pages.CartPage;
import com.exemple.pages.CheckoutPage;
import com.exemple.pages.InventoryPage;
import com.exemple.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FlowTest extends BaseTest {

    @Test
    void fluxCompletCompraILogout() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.abrir();
            loginPage.loginComo("standard_user", "secret_sauce");

            InventoryPage inventoryPage = new InventoryPage(driver);
            Assertions.assertEquals("Products", inventoryPage.obtenerTitulo());

            inventoryPage.añadirPrimerProducto();
            inventoryPage.abrirCarrito();

            CartPage cartPage = new CartPage(driver);
            Assertions.assertEquals("Your Cart", cartPage.obtenerTitulo());

            CheckoutPage checkoutPage = cartPage.iniciarCheckout();
            checkoutPage.rellenarFormulario("Aitor", "Lopez", "08201");
            checkoutPage.continuar();

            Assertions.assertEquals("Checkout: Overview", checkoutPage.obtenerTitulo());

            driver.navigate().back();
            driver.navigate().back();

            inventoryPage.abrirMenu();
            inventoryPage.hacerLogout();

            Assertions.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"));
        } catch (Throwable e) {
            marcarFallo();
            throw e;
        }
    }
}