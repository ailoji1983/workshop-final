# Workshop Final - Automatización web con Selenium

Proyecto de automatización funcional sobre la web [SauceDemo](https://www.saucedemo.com/) utilizando Java, Selenium WebDriver, JUnit 5, Maven y el patrón Page Object Model (POM). SauceDemo se usa habitualmente como aplicación de práctica para flujos de login, inventario, carrito y checkout en automatización UI. [cite:380][cite:427]

## Objetivo

El objetivo del proyecto es automatizar los flujos básicos más importantes de la aplicación web:

- inicio de sesión correcto;
- validación de login incorrecto;
- navegación por inventario;
- acceso al carrito;
- cierre de sesión.

La suite se ha centrado en pruebas estables de tipo smoke/regresión básica, priorizando escenarios fiables antes que flujos end-to-end más frágiles. [cite:380]

## Tecnologías utilizadas

- Java
- Selenium WebDriver
- JUnit 5
- Maven
- ChromeDriver
- Page Object Model (POM)

El uso de Page Object Model permite separar la lógica de interacción con la interfaz de la lógica de los tests, lo que mejora el mantenimiento y la reutilización del código. [cite:421][cite:423]

## Estructura del proyecto

```text
workshop-final/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/example/pages/
│   │           ├── BasePage.java
│   │           ├── LoginPage.java
│   │           ├── InventoryPage.java
│   │           ├── CartPage.java
│   │           └── CheckoutPage.java
│   └── test/
│       └── java/
│           └── com/exemple/tests/
│               ├── BaseTest.java
│               ├── LoginTest.java
│               ├── LoginInvalidTest.java
│               ├── NavigationTest.java
│               ├── CartTest.java
│               ├── LogoutTest.java
│               └── CheckoutTest.java
```

La organización por páginas y tests sigue el enfoque habitual en proyectos Selenium con POM, donde cada pantalla encapsula sus locators y métodos de interacción. [cite:421]

## Casos de prueba

Los principales casos de prueba implementados en el proyecto son:

- **LoginTest**: verifica que un usuario válido puede iniciar sesión correctamente.
- **LoginInvalidTest**: comprueba que se muestra un error al introducir credenciales incorrectas.
- **NavigationTest**: valida la navegación principal dentro de la aplicación.
- **CartTest**: añade un producto al carrito y comprueba que el carrito contiene al menos un ítem.
- **LogoutTest**: verifica que el usuario puede cerrar sesión correctamente.

`CheckoutTest` se ha dejado como caso de ampliación o mejora futura, ya que el foco de la entrega actual está en una suite funcional básica y estable. La práctica habitual en automatización UI recomienda priorizar primero pruebas robustas y de bajo mantenimiento. [cite:425][cite:423]

## Requisitos previos

Antes de ejecutar el proyecto, es necesario tener instalado:

- Java 17 o superior
- Maven 3 o superior
- Google Chrome
- ChromeDriver compatible con la versión de Chrome instalada

También es necesario disponer de conexión a Internet para acceder a la web de SauceDemo. [cite:380]

## Ejecución del proyecto

Para ejecutar todos los tests:

```bash
mvn clean test
```

Para ejecutar un test concreto:

```bash
mvn -Dtest=LoginTest test
mvn -Dtest=NavigationTest test
mvn -Dtest=CartTest test
mvn -Dtest=LogoutTest test
```

Maven con Surefire es una forma estándar de lanzar suites JUnit en proyectos Java de automatización. [cite:427]

## Credenciales utilizadas

Para las pruebas positivas se ha utilizado el usuario estándar de SauceDemo:

- **Usuario:** `standard_user`
- **Contraseña:** `secret_sauce`

SauceDemo proporciona usuarios de prueba para practicar automatización de login y flujos básicos de e-commerce. [cite:380]

## Diseño del framework

El proyecto sigue una estructura basada en:

- **BasePage**: métodos comunes reutilizables para todas las páginas.
- **Page Objects**: encapsulan locators y acciones específicas de cada pantalla.
- **BaseTest**: configuración inicial y cierre del navegador.
- **Tests JUnit**: contienen las validaciones funcionales.

Este diseño reduce duplicación, mejora legibilidad y facilita el mantenimiento de los tests. [cite:421][cite:423]

## Estado de la entrega

Actualmente el proyecto incluye una suite funcional básica centrada en:

- login;
- validaciones principales;
- navegación;
- carrito;
- logout.

