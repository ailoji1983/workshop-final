package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    private final By title = By.cssSelector(".title");
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By completeHeader = By.cssSelector(".complete-header");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String obtenerTituloInformacion() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }

    public void rellenarDatos(String nombre, String apellido, String codigoPostal) {
        escribir(firstNameInput, nombre);
        escribir(lastNameInput, apellido);
        escribir(postalCodeInput, codigoPostal);
    }

    public void continuar() {
        click(continueButton);
    }

    public String obtenerTituloResumen() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }

    public void finalizar() {
        click(finishButton);
    }

    public String obtenerMensajeFinal() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(completeHeader)).getText();
    }
}