package com.exemple.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishTitle = By.cssSelector(".title");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void rellenarFormulario(String nombre, String apellido, String codigoPostal) {
        escribir(firstNameInput, nombre);
        escribir(lastNameInput, apellido);
        escribir(postalCodeInput, codigoPostal);
    }

    public void continuar() {
        clic(continueButton);
    }

    public String obtenerTitulo() {
        return obtenerTexto(finishTitle);
    }
}