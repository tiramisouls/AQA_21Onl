package services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.configuration.ReadProperties;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class WaitService {
    private WebDriverWait wait;
    private WebDriver driver;

    public WaitService(WebDriver driver, Duration timeout) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
    }

    public WaitService(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ReadProperties.timeout()));
    }

    //наличие эл-та в самой DOM модели - пробросит timeout exception если не найдет
    public WebElement waitForExists(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    //виден ли элемент работает не с локатором, а с элементом возвращает вэб эл-т
    public WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    //invisibilty:
    //найти эл-т и проинициализировать до вып-я действия после кот он исчезнет

    public WebElement waitForVisibilityLocatedBy(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // для эл-тов кот уже есть в DOM модели, те сначала нужно дождаться пока они все появяться в дом модели, а затем исп-ть этот метод
    public List<WebElement> waitForAllVisibleElementsLocatedBy(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public Boolean waitForElementInvisible(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public WebElement fluentWaitForElement(By locator) {
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(50))
                .ignoring(NoSuchElementException.class);

        return fluent.until(driverItem -> driverItem.findElement(locator));
    }
}