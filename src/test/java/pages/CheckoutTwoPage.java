package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutTwoPage extends BasePage {

    // Блок описания локаторов для элементов

    private final By headerTitleLocatorCheckoutTwoPage = By.xpath("//span[contains(@class, 'title') " +
            "and contains(text(), 'Checkout: Overview')]");

    private final By finishButtonLocator = By.id("finish");

    // Блок инициализации

    public CheckoutTwoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLocatorCheckoutTwoPage;
    }

    // Блок атомарных методов

    public WebElement getFinishButton() {
        return driver.findElement(finishButtonLocator);
    }
}