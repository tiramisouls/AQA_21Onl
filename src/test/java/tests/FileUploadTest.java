package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitService;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUploadTest() {
        driver.get("http://the-internet.herokuapp.com/upload");

        WaitService waitService = new WaitService(driver);

        WebElement fileUploadElement = waitService.waitForExists(By.id("file-upload"));
        String pathToFile = ActionTests.class.getClassLoader().getResource("download.jpeg").getPath();
        fileUploadElement.sendKeys(pathToFile.substring(1,pathToFile.length()));

        waitService.waitForVisibilityLocatedBy(By.id("file-submit")).submit();
        Assert.assertEquals(waitService.waitForVisibilityLocatedBy
                (By.id("uploaded-files")).getText(), "download.jpeg");
    }
}