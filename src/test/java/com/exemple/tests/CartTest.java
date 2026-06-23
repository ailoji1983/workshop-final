package com.exemple.tests;

import com.example.pages.CartPage;
import com.example.pages.InventoryPage;
import com.example.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CartTest extends BaseTest {

    @Test
    void afegirProducteAlCarretDeberiaMostrarItemAlCarret() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.abrir();
            loginPage.loginComo("standard_user", "secret_sauce");

            InventoryPage inventoryPage = new InventoryPage(driver);
            Assertions.assertEquals("Products", inventoryPage.obtenerTitulo());

            inventoryPage.añadirPrimerProducto();

            CartPage cartPage = inventoryPage.abrirCarrito();
            Assertions.assertEquals("Your Cart", cartPage.obtenerTitulo());
            Assertions.assertTrue(cartPage.contieneAlgunItem(), "El carret hauria de tenir almenys un producte");

        } catch (Throwable e) {
            marcarFallo();
            throw e;
        }
    }
}