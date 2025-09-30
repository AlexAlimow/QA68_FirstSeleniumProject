package com.ait.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver driver;

    //Перед каждым тестом есть какие-то условия preconditions
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com"); // запуск без истории without history - innocent
        // driver.navigate().to("https://www.google.com"); // запуск с историей
//         driver.navigate().back();
//         driver.navigate().forward();
        // driver.navigate().refresh();


    }

    //test
    @Test
    public void openGoogle() {
        System.out.println("Google was opened!");
    }

    //after test
    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit(); // Полностью закрывается браузер all tabs and close browser
        // driver.close();  // Only one tab ( if tab only one -> close browser)
    }

}
