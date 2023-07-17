import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.configuration.ReadProperties;

public class CssSelectorsTestHW {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void cssSelectorsTest() {
        driver.get(ReadProperties.getUrl());

        // Поиск по id
        Assert.assertTrue(driver.findElement(By.cssSelector("#bmiVar1")).isDisplayed());
        //   аналог
        Assert.assertTrue(driver.findElement(By.id("bmiVar1")).isDisplayed());

        // Поиск по class name
        Assert.assertTrue(driver.findElement(By.cssSelector(".btn-calculate")).isDisplayed());
        //   аналог
        Assert.assertTrue(driver.findElement(By.className("btn-calculate")).isDisplayed());

        // Поиск по нескольким значения в аттрибуте class
        Assert.assertTrue(driver.findElement(By.cssSelector(".calc-btn.btn-calculate")).isDisplayed());

        // Поиск по tag name
        Assert.assertTrue(driver.findElement(By.cssSelector("sup")).isDisplayed());
        //   аналог
        Assert.assertTrue(driver.findElement(By.tagName("sup")).isDisplayed());

        // Поиск по tag и значению из аттрибута class
        Assert.assertTrue(driver.findElement(By.cssSelector("a.calc-btn")).isDisplayed());

        // Поиск по id и значению из аттрибута class
        Assert.assertEquals(2, driver.findElements(By.cssSelector("#t3-content .active")).size());

        // Поиск всех элементов с тэгом ol или i
        Assert.assertEquals(8, driver.findElements(By.cssSelector("ol, i")).size());

        // Поиск всех элементов с тэгом li у которых непосредственный родитель с тэгом ol
        Assert.assertEquals(6, driver.findElements(By.cssSelector("ol > li")).size());

        // Поиск всех элементов с тэгом br которые идут сразу за элементом с тэго i
        Assert.assertEquals(1, driver.findElements(By.cssSelector("br + i")).size());

        // Поиск всех элементов с тэгом div которые являются братьями элементу с тэгом p
        Assert.assertEquals(2, driver.findElements(By.cssSelector("p ~ div")).size());

        // Поиск всех элементов у которых присутствует аттрибут style
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[style]")).size());

        // Поиск всех элементов у которых присутствует аттрибут style с конкретным значением
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[style='max-width:360px;']")).size());

        // Поиск всех элементов у которых присутствует аттрибут id со значением заканчивающимся на какое-то value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id$='Var1']")).size());

        // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то value
        Assert.assertEquals(2, driver.findElements(By.cssSelector("[id^=bmi]")).size());

        // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то слово
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id|=fraction]")).size());

        // Поиск всех элементов у которых присутствует аттрибут type со значением содержащим слово целиком
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[type~=text]")).size());

        // Поиск всех элементов у которых присутствует аттрибут type со значением содержащим какой текст
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[type*=tex]")).size());

        // Поиск всех disabled элементов
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":disabled")).size());

        // Поиск всех enabled элементов
        Assert.assertEquals(8, driver.findElements(By.cssSelector(":enabled")).size());

        // Поиск всех выборанных элементов
        Assert.assertEquals(2, driver.findElements(By.cssSelector(":checked")).size());

        // Поиск всех элементов c пустым телом
        Assert.assertEquals(16, driver.findElements(By.cssSelector(":empty")).size());

        // Поиск элемента с тэгом i и которым является первым дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("i:first-child")).size());

        // Поиск элемента с тэгом i и которым является последним дочерним элементом
        Assert.assertEquals(2, driver.findElements(By.cssSelector("i:last-child")).size());

        // Поиск элемента с тэгом li и которым является n-ым дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("li:nth-child(3)")).size());
    }
}