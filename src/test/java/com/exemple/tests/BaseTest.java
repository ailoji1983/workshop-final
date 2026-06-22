package com.exemple.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected TestInfo testInfo;
    private boolean testFailed;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        this.testInfo = testInfo;
        this.testFailed = false;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterEach
    void tearDown() {
        if (testFailed) {
            capturarScreenshot();
        }
        if (driver != null) {
            driver.quit();
        }
    }

    protected void marcarFallo() {
        this.testFailed = true;
    }

    private void capturarScreenshot() {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path dir = Path.of("screenshots");
            Files.createDirectories(dir);
            String nombre = testInfo.getDisplayName().replace("()", "").replace(" ", "_") + ".png";
            Files.copy(src.toPath(), dir.resolve(nombre), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception ignored) {
        }
    }
}