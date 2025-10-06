package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementsTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");

        driver.manage().window().maximize();
        // driver.manage().window().setSize(new Dimension(900,400));
        //  driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    @Test
    public void findElementByTagName() {
        //by tag - h1
        WebElement title = driver.findElement(By.tagName("h1"));
        System.out.println(title.getText());
        //by tag - h2
        WebElement title2 = driver.findElement(By.tagName("h2"));
        System.out.println(title2.getText());
        //by tag - a
        WebElement link = driver.findElement(By.tagName("a"));
        System.out.println(link.getText());
        //by tag - label
        WebElement label = driver.findElement(By.tagName("label"));
        System.out.println(label.getText());

        //find list of elements
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        List<WebElement> labels = driver.findElements(By.tagName("label"));
        System.out.println(labels.size());
    }

    @Test
    public void findElementById() {
        WebElement city = driver.findElement(By.id("city"));
        System.out.println(city.getDomAttribute("id"));
        WebElement dates = driver.findElement(By.id("dates"));
        System.out.println(dates.getDomAttribute("id"));
    }

    @Test
    public void findElementByClassName() {
        WebElement telephone = driver.findElement(By.className("telephone"));
        System.out.println(telephone.getText());

        WebElement navi = driver.findElement(By.className("navigation-link"));
        System.out.println(navi.getText());
        System.out.println(navi.getDomAttribute("class"));
    }

    @Test
    public void findElementByLinkText() {
        WebElement linkText = driver.findElement(By.linkText("Let the car work"));
        System.out.println(linkText.getText());
    }

    @Test
    public void findElementByPartialLinkText() {
        WebElement partialLinkText = driver.findElement(By.partialLinkText("work"));
        System.out.println(partialLinkText.getText());
    }

    @Test
    public void findElementByCssSelector() {
        //driver.findElement(By.tagName("h1"));
        // tag name "h1" -> "h1"
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("h2"));
        //driver.findElement(By.id("city"));
        //id="city" -> #city
        driver.findElement(By.cssSelector("#city"));
        driver.findElement(By.cssSelector("#dates"));

        //driver.findElement(By.className("telephone"));
        //class="telephone" -> .telephone
        driver.findElement(By.cssSelector(".telephone"));
        driver.findElement(By.cssSelector(".navigation-link"));

        //contains -> *
        driver.findElement(By.cssSelector("[class*='pristine']"));

        //start -> ^
        driver.findElement(By.cssSelector("[class^='ng']"));

        //end to -> $
        driver.findElement(By.cssSelector("[class$='invalid']"));

        //[key='value'] // ключ значение
        driver.findElement(By.cssSelector("[ng-reflect-name='city']"));
        driver.findElement(By.cssSelector("[for='dates']"));
        driver.findElement(By.cssSelector("[href='/search']"));


        //composite cssSelector
        driver.findElement(By.cssSelector("a.navigation-link[href='/search']")); // tag + class + pare
        // тег потом (. -точка) Потом составная пара в квадратных скобках
        driver.findElement(By.cssSelector(".fas.fa-bars")); // два класса через точку class + class

        driver.findElement(By.cssSelector(".logo>img")); // one step below один шаг вниз
        WebElement element = driver.findElement(By.cssSelector(".feedback-body .feedback-date"));
        // space one more steps below, через пробел вниз вгрубь до элемента
        System.out.println(element.getText());


        WebElement feedbackText = driver.findElement(By.cssSelector(".feedback:nth-child(1) .feedback-text"));
        // <tag> or <class> or <id> or <pare> :nth-child(n)
        System.out.println(feedbackText.getText());
    }

    @Test

    public void FindElementByXpath() {
        //     //some_tag[@attribute='value']
        //    //some_tag[1]
        //    //some_tag[text()='Los Angeles'

        // driver.findElement(By.cssSelector("h1"));
        WebElement element = driver.findElement(By.xpath("//h1"));
        System.out.println(element.getText());

        // driver.findElement(By.cssSelector("#city"));
        driver.findElement(By.xpath("//*[@id='city']")); // * - ищи везде

        //driver.findElement(By.cssSelector(".telephone"));
        driver.findElement(By.xpath("//*[@class='telephone']"));

        //driver.findElement(By.cssSelector("[ng-reflect-name='city']"));
        driver.findElement(By.xpath("//*[@ng-reflect-name='city']"));

        //driver.findElement(By.cssSelector("[class^='ng']"));
        driver.findElement(By.xpath("//*[starts-with(@class,'ng')]"));

        // contains.text
        //WebElement text = driver.findElement(By.xpath("//span[contains(text(),'best services')]"));
        WebElement text = driver.findElement(By.xpath("//span[contains(.,'best services')]"));  //один из самых действенных способов найти по содержанию
        System.out.println("*****************");
        System.out.println(text.getText());

        //equals text абсолютное соответствие по тексту
        //WebElement textFind = driver.findElement(By.xpath("//*[text()='Find your car now!']"));
        WebElement textFind = driver.findElement(By.xpath("//*[.='Find your car now!']"));
        System.out.println("********************!!!");
        System.out.println(textFind.getText());

        //driver.findElement(By.cssSelector("a.navigation-link[href='/search']"));
        driver.findElement(By.xpath("//a[@class='navigation-link'][@href='/search']"));

        // driver.findElement(By.cssSelector(".fas.fa-bars"));
        driver.findElement(By.xpath("//*[@class='fas fa-bars']"));

        //driver.findElement(By.cssSelector(".logo>img")); идем вниз
        driver.findElement(By.xpath("//*[@class='logo']/img"));

        //driver.findElement(By.cssSelector(".feedback-body .feedback-date"));
        driver.findElement(By.xpath("//*[@class='feedback-body']//* [@class='feedback-date']"));

        //parent
        driver.findElement(By.xpath("//h1/parent::*"));  //one step up
        driver.findElement(By.xpath("//h1/parent::div"));  //one step up одинаково
        driver.findElement(By.xpath("//h1/.."));  //one step up одинаково

        //ancestor предок

        driver.findElement(By.xpath("//h1/ancestor::*")); // all это предок html прям самый главный
        driver.findElement(By.xpath("//h1/ancestor::div")); // two steps
        driver.findElement(By.xpath("//h1/ancestor::div[2]")); // one step

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}

// cssSelector ->  div>a   xpath ->   //div/a

//cssSelector->    div a   xpath ->   //div//a (дочерний элемент любого уровня)