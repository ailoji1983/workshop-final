package com.exemple.tests;

import com.example.pages.InventoryPage;
import com.example.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @Test
    void loginCorrecte() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.abrir();
            loginPage.loginComo("standard_user", "secret_sauce");

            InventoryPage inventoryPage = new InventoryPage(driver);
            Assertions.assertEquals("Products", inventoryPage.obtenerTitulo());
        } catch (Throwable e) {
            marcarFallo();
            throw e;
        }
    }

    @Test
    void loginIncorrecte() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.abrir();
            loginPage.loginComo("bad_user", "bad_pass");

            Assertions.assertTrue(loginPage.obtenerError().contains("Username and password do not match"));
        } catch (Throwable e) {
            marcarFallo();
            throw e;
        }
    }
}