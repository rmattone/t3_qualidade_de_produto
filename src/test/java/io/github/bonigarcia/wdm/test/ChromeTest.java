package io.github.bonigarcia.wdm.test;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Test with Chrome.
 *
 * @author Eric Carlotto (eric.carlottoitapiruba@gmail.com)
 * @author Miguel Zanela (miguelzanela89@gmail.com)
 * @since 1.0.0
 */
public class ChromeTest {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    // Test done by Eric Carlotto, for product quality class study purposes.
    public void test_eric_Financeone() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get("https://financeone.com.br/conversor-de-moedas/");

        By searchInput = By.id("currency-value");
        wait.until(presenceOfElementLocated(searchInput));

        driver.findElement(searchInput).sendKeys("2300");
        wait.until(textToBePresentInElementLocated(By.tagName("body"),
                "50.008,86 BRL"));
    }

    @Test
    // Test done by Miguel Zanela, for product quality class study purposes.
    public void test_Miguel_Amazon() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get("https://www.amazon.com.br/");

        By searchInput = By.id("twotabsearchtextbox");
        wait.until(presenceOfElementLocated(searchInput));        
        driver.findElement(searchInput).sendKeys("Samsung S22");

        By searchButton = By.id("nav-search-submit-button");
        wait.until(elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();

        wait.until(textToBePresentInElementLocated(By.tagName("body"),
                "S22"));
    }

}