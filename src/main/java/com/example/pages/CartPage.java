package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;


public class CartPage extends BasePage {

    private final By title = By.cssSelector(".title");
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logoutLink = By.id("logout_sidebar_link");
    private final By cartItems = By.cssSelector(".cart_item");
    private final By checkoutButton = By.id("checkout");
    

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void esperarCargaCarrito() {
        wait.until(ExpectedConditions.urlContains("cart.html"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        wait.until(ExpectedConditions.textToBe(title, "Your Cart"));
    }

    public String obtenerTitulo() {
        esperarCargaCarrito();
        return obtenerTexto(title);
    }

    public CheckoutPage iniciarCheckout() {
        esperarCargaCarrito();

        var botonCheckout = wait.until(ExpectedConditions.presenceOfElementLocated(checkoutButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", botonCheckout);

        return new CheckoutPage(driver);
    }

    public void abrirMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(menuButton));
        clic(menuButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));
    }

    public void hacerLogout() {
        clic(logoutLink);
    }
    public boolean contieneAlgunItem() {
    return !wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItems)).isEmpty();
}
public CheckoutPage irAlCheckout() {
    WebElement botonCheckout = wait.until(
            ExpectedConditions.elementToBeClickable(checkoutButton)
    );

    ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block: 'center'});", botonCheckout
    );
    ((JavascriptExecutor) driver).executeScript(
            "arguments[0].click();", botonCheckout
    );

    wait.until(ExpectedConditions.urlContains("checkout-step-one"));
    return new CheckoutPage(driver);
}
    
    
    
    
}