import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static java.lang.Thread.sleep;

public class SmokeTestHW {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }

    @Test
    public void calcElectricHotFloorTest() throws InterruptedException {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        WebElement widthInput = driver.findElement(By.id("el_f_width"));
        WebElement lenghtInput = driver.findElement(By.id("el_f_lenght"));
        WebElement lossesInput = driver.findElement(By.id("el_f_losses"));
        WebElement calcButton = driver.findElement(By.name("button"));

        widthInput.sendKeys("3");
        sleep(2000);
        lenghtInput.sendKeys("4");
        sleep(2000);
        lossesInput.sendKeys("120");
        sleep(2000);

        WebElement selectWebElement1 = driver.findElement(By.id("room_type"));
        Select selectRoomType = new Select(selectWebElement1);
        WebElement selectWebElement2 = driver.findElement(By.id("heating_type"));
        Select selectHeatingType = new Select(selectWebElement2);

        selectRoomType.selectByVisibleText("Ванная");
        sleep(2000);
        selectHeatingType.selectByValue("3");
        sleep(2000);

        calcButton.click();
        sleep(2000);

        WebElement resultFloorCablePower = driver.findElement(By.id("floor_cable_power"));
        Assert.assertEquals(resultFloorCablePower.getAttribute("value"), "67");

        WebElement resultSpecFloorCablePower = driver.findElement(By.id("spec_floor_cable_power"));
        Assert.assertEquals(resultSpecFloorCablePower.getAttribute("value"),"6");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}