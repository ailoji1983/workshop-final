package com.exemple.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By checkoutButton = By.id("checkout");
    private final By title = By.cssSelector(".title");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String obtenerTitulo() {
        return obtenerTexto(title);
    }

    public CheckoutPage iniciarCheckout() {
        clic(checkoutButton);
        return new CheckoutPage(driver);
    }
}