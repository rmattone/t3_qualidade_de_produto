/*
 * (C) Copyright 2016 Boni Garcia (http://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Test with Firefox.
 *
 * @author Henrique Wilson Werkhausen Filho (git; henriquewwf)
 * @BasedOn: Boni Garcia (boni.gg@gmail.com)
 * @OriginalSource: https://github.com/bonigarcia/webdrivermanager
 * @since 1.0.0
 */
public class FirefoxTest {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new FirefoxDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {
        // Your test code here. For example:

        String user = "henriquew";

        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        By username= By.name("username");
        wait.until(presenceOfElementLocated(username));
        driver.findElement(username).sendKeys(user);

        By submit = By.xpath("//input[@type='submit']");
        wait.until(elementToBeClickable(submit));
        driver.findElement(submit).click();

        wait.until(textToBePresentInElementLocated(By.id("_valueusername"), user));
    }

}