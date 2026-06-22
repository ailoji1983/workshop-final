package com.exemple.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    private final By title = By.cssSelector(".title");
    private final By firstAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartLink = By.cssSelector(".shopping_cart_link");
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logoutLink = By.id("logout_sidebar_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String obtenerTitulo() {
        return obtenerTexto(title);
    }

    public void añadirPrimerProducto() {
        clic(firstAddToCartButton);
    }

    public void abrirCarrito() {
        clic(cartLink);
    }

    public void abrirMenu() {
        clic(menuButton);
    }

    public void hacerLogout() {
        clic(logoutLink);
    }
}