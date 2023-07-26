package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage extends BasePage {

    // Блок описания локаторов для элементов

    private final By headerTitleLocatorCheckoutCompletePage = By.xpath("//span[contains(@class, 'title') " +
            "and contains(text(), 'Checkout: Complete!')]");
    private final By completeHeaderLocator = By.xpath("//h2[contains(@class, 'complete-header') " +
            "and contains(text(), 'Thank you for your order!')]");

    // Блок инициализации

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLocatorCheckoutCompletePage;
    }

    // Блок атомарных методов

    public WebElement getCompleteHeader() {
        return driver.findElement(completeHeaderLocator);
    }

}