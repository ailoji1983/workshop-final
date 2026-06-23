package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class InventoryPage extends BasePage {

    private final By title = By.cssSelector(".title");
    private final By inventoryContainer = By.id("inventory_container");

    private final By cartLink = By.cssSelector(".shopping_cart_link");
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logoutLink = By.id("logout_sidebar_link");

private final By backpackLink = By.xpath("//div[text()='Sauce Labs Backpack']");
private final By backpackAddButton = By.xpath("//div[./div/a/div[text()='Sauce Labs Backpack']]//button");
private final By cartBadge = By.cssSelector(".shopping_cart_badge");



    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void esperarCargaInventario() {
        wait.until(ExpectedConditions.urlContains("inventory.html"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryContainer));
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        wait.until(ExpectedConditions.textToBe(title, "Products"));
    }

    public String obtenerTitulo() {
        esperarCargaInventario();
        return obtenerTexto(title);
    }
    
    
public void añadirPrimerProducto() {
    esperarCargaInventario();

    WebElement botonAdd = wait.until(
            ExpectedConditions.elementToBeClickable(backpackAddButton)
    );

    ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView({block: 'center'});", botonAdd);
    ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", botonAdd);

    wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
}


    public CartPage abrirCarrito() {
        esperarCargaInventario();

        WebElement carrito = wait.until(ExpectedConditions.elementToBeClickable(cartLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", carrito);

        return new CartPage(driver);
    }

    public void abrirMenu() {
        esperarCargaInventario();

        WebElement botonMenu = wait.until(ExpectedConditions.presenceOfElementLocated(menuButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", botonMenu);

        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
    }

    public void hacerLogout() {
        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logout);
    }
}