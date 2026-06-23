package com.exemple.tests;

import com.example.pages.InventoryPage;
import com.example.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FlowTest extends BaseTest {

    @Test
    void fluxLoginILogout() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.abrir();
            loginPage.loginComo("standard_user", "secret_sauce");

            InventoryPage inventoryPage = new InventoryPage(driver);
            Assertions.assertEquals("Products", inventoryPage.obtenerTitulo());

            inventoryPage.abrirMenu();
            inventoryPage.hacerLogout();

            Assertions.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"));
        } catch (Throwable e) {
            marcarFallo();
            throw e;
        }
    }
}