import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitService;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void dynamicControlsTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WaitService waitService = new WaitService(driver);

        WebElement checkbox = waitService.waitForExists(By.id("checkbox"));
        checkbox.isDisplayed();

        WebElement buttonRemove = waitService.waitForExists
                (By.xpath("//*[@id=\"checkbox-example\"]/button"));
        buttonRemove.click();
        Assert.assertTrue(waitService.waitForElementInvisible(checkbox));

        WebElement input = waitService.waitForExists(By.xpath("//*[@id=\"input-example\"]/input"));
        input.isDisplayed();
        Assert.assertTrue(Boolean.parseBoolean(input.getAttribute("disabled")));
        WebElement buttonEnable = waitService.waitForExists(By.xpath("//*[@id=\"input-example\"]/button"));
        buttonEnable.click();

        WebElement text = waitService.waitForExists(By.xpath("//*[@id=\"message\"]"));
        text.isDisplayed();
    }
}