package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void abrir() {
        driver.get("https://www.saucedemo.com/");
    }

    public void escribirUsuario(String usuario) {
        escribir(usernameInput, usuario);
    }

    public void escribirPassword(String password) {
        escribir(passwordInput, password);
    }

    public void hacerLogin() {
        clic(loginButton);
    }

    public void loginComo(String usuario, String password) {
        escribirUsuario(usuario);
        escribirPassword(password);
        hacerLogin();
    }

    public String obtenerError() {
        return obtenerTexto(errorMessage);
    }
}