# Projecte Final de Curs - Automatització web amb Selenium WebDriver

Aquest projecte consisteix en una suite de proves automatitzades web desenvolupada en **Java** sobre l’aplicació **SauceDemo**, utilitzant **Selenium WebDriver**, **JUnit 5**, **Maven** i el patró **Page Object Model (POM)**. La suite s’ha construït seguint els objectius del workshop i prioritzant proves clares, repetibles i estables. [cite:435]

## 1. Aplicació triada

L’aplicació seleccionada és [SauceDemo](https://www.saucedemo.com/), un entorn públic molt utilitzat per practicar automatització funcional sobre fluxos típics d’una aplicació web, com ara login, navegació, inventari i carret. Aquest tipus d’aplicació permet aplicar localització d’elements amb `id`, `cssSelector` i `xpath`, així com l’ús d’esperes explícites i estructuració amb Page Objects. [cite:435]

## 2. Objectiu del projecte

L’objectiu principal és integrar els coneixements treballats durant el curs en una suite de proves end-to-end mantenible. En concret, el projecte busca:

- configurar un projecte Maven per automatització web;
- aplicar Page Object Model;
- escriure proves amb JUnit 5;
- utilitzar esperes explícites amb `WebDriverWait`;
- evitar `Thread.sleep()`;
- executar la suite des de terminal amb Maven.

Les esperes explícites es consideren una pràctica recomanada davant de pauses fixes perquè milloren l’estabilitat i redueixen el comportament flaky dels tests. [cite:449]

## 3. Tecnologies utilitzades

- Java
- Maven
- Selenium WebDriver
- JUnit 5
- ChromeDriver / FirefoxDriver
- WebDriverManager

`WebDriverManager` permet gestionar automàticament els drivers dels navegadors en projectes Selenium per Java, evitant configuracions manuals i problemes habituals de versions. [cite:435][cite:455]

## 4. Estructura del projecte

```text
workshop-final/
├── pom.xml
├── README.md
└── src
    ├── main/java/com/exemple/pages/
    │   ├── BasePage.java
    │   ├── LoginPage.java
    │   ├── InventoryPage.java
    │   ├── CartPage.java
    │   └── CheckoutPage.java
    └── test/java/com/exemple/tests/
        ├── BaseTest.java
        ├── LoginTest.java
        ├── LoginInvalidTest.java
        ├── NavigationTest.java
        ├── CartTest.java
        ├── LogoutTest.java
        └── CheckoutTest.java
```

La separació entre classes de pàgina i classes de prova segueix el model recomanat en projectes Selenium basats en POM. [cite:460]

## 5. Patró Page Object Model

El projecte aplica **Page Object Model**, de manera que cada pantalla rellevant de l’aplicació es representa amb una classe pròpia. Cada Page Object encapsula:

- els selectors dels elements;
- els mètodes d’acció sobre la pàgina;
- la lògica comuna de navegació o interacció.

Això permet separar la lògica dels tests de la lògica d’interacció amb la interfície, fent el codi més net, reutilitzable i fàcil de mantenir.

## 6. Gestió d’esperes

La suite utilitza **esperes explícites** amb `WebDriverWait` i `ExpectedConditions` per sincronitzar la interacció amb els elements. Aquesta estratègia evita l’ús de `Thread.sleep()` i s’ajusta a les bones pràctiques d’automatització funcional. [cite:449]

## 7. Casos de prova

Actualment, el projecte s’ha centrat en els fluxos més estables de l’aplicació. Les proves principals implementades són:

- **LoginTest**: valida l’inici de sessió correcte amb un usuari vàlid.
- **NavigationTest**: comprova la navegació principal dins de l’aplicació.
- **CartTest**: afegeix un producte al carret i verifica que el carret conté almenys un ítem.
- **LoginInvalidTest**: prova de login incorrecte amb validació del missatge d’error.
- **LogoutTest**: valida el tancament correcte de la sessió.

També s’ha iniciat el treball sobre **CheckoutTest**, però en l’estat actual del projecte aquest flux es considera una línia de millora futura i no forma part de la part més estable de la suite.

## 8. Captura d’evidències

El projecte incorpora captura automàtica de pantalla quan una prova falla. Aquesta funcionalitat està centralitzada a la base comuna de proves per facilitar la reutilització i ajudar en la depuració d’errors.

## 9. Requisits previs

Per executar el projecte cal tenir instal·lat:

- Java JDK 11 o superior;
- Maven;
- Google Chrome i/o Mozilla Firefox;
- connexió a Internet per accedir a SauceDemo.

## 10. Execució de la suite

### Executar totes les proves

```bash
mvn clean test
```

### Executar una sola classe de prova

```bash
mvn -Dtest=LoginTest test
mvn -Dtest=LoginInvalidTest test
mvn -Dtest=NavigationTest test
mvn -Dtest=CartTest test
mvn -Dtest=LogoutTest test
```

El plugin Maven Surefire permet executar una classe de prova concreta utilitzant la propietat `-Dtest=NomClasseTest`. [cite:449]

## 11. Credencials de prova

Per als casos positius de login s’utilitzen les credencials estàndard de SauceDemo:

- **Usuari:** `standard_user`
- **Contrasenya:** `secret_sauce`

## 12. Decisions de disseny

Durant el desenvolupament s’han pres les decisions següents:

- utilitzar **POM** per separar proves i interaccions amb la UI;
- centralitzar funcionalitat comuna a `BasePage` i `BaseTest`;
- prioritzar selectors estables i reutilitzables;
- utilitzar esperes explícites en lloc d’esperes fixes;
- donar prioritat a proves robustes abans que a fluxos més fràgils.

## 13. Limitacions actuals i millores futures

En l’estat actual, la suite cobreix correctament els fluxos principals de login, navegació, carret i logout. Com a millores futures es plantegen:

- completar i estabilitzar el flux de **checkout**;
- afegir execució **cross-browser** més sistemàtica;
- integrar informes més complets;
- ampliar la cobertura amb més escenaris de regressió.

