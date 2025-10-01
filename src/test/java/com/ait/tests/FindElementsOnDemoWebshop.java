package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementsOnDemoWebshop {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void findElementsOnPage() {
        WebElement header = driver.findElement(By.className("header")); // Нашли класс header
        System.out.println("search by header class: \n" + header.getText());

        List<WebElement> searchBox = driver.findElements(By.ByClassName.className("search-box")); // Нашли класс search-box
        System.out.println("search by search.box: " + searchBox.size());

        WebElement logo = driver.findElement(By.cssSelector("div.header-logo img"));
        System.out.println("Logo src: " + logo.getAttribute("src")); // Проверяем логотип

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links: " + links.size()); // Получаем количество ссылок

        driver.findElement(By.linkText("Books")).click(); // переходим на страницу books
        WebElement h1 = driver.findElement(By.tagName("h1")); // получаем h1 на странице books
        System.out.println(h1.getText());

    }

    @Test
    public void findElementsByCssSelector(){
        driver.findElement(By.cssSelector(".master-wrapper-page"));
        driver.findElement(By.cssSelector(".master-wrapper-content  .header"));
        driver.findElement(By.cssSelector("div.title strong"));
        driver.findElement(By.cssSelector("div.listbox .list :nth-child(3) *"));
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}