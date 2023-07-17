import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.configuration.ReadProperties;

public class BasicLocatorsTestHW {
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
    public void basicLocatorsTest() {
        driver.get(ReadProperties.getUrl());

        // Find webElement by ID
        driver.findElement(By.id("bmiVar1")).sendKeys(ReadProperties.height());

        // Find webElement by Name
        driver.findElement(By.name("bmiVar2")).sendKeys(ReadProperties.weight());

        // Find webElement by ClassName
        driver.findElement(By.className("btn-calculate")).click();

        // Find webElement by Tag
        driver.findElement(By.tagName("sup"));

        // Find webElement by LinkText
        driver.findElement(By.linkText("Статьи"));

        // Find webElement by PartialLinkText
        driver.findElement(By.partialLinkText("обратной связи"));
    }
}