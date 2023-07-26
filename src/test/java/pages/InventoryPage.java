package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage extends BasePage {

    // Блок описания локаторов для элементов
    private final By headerTitleLocatorInventoryPage = By.xpath("//span[contains(@class, 'title') " +
            "and contains(text(), 'Products')]");

    public CartPage cartPage;

    private final By addToCartButtonLocator = By.id("add-to-cart-sauce-labs-backpack");
    private final By openCartButtonLocator = By.id("shopping_cart_container");

    // Блок инициализации
    public InventoryPage(WebDriver driver) {
        super(driver);

        cartPage = new CartPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLocatorInventoryPage;
    }

    // Блок атомарных методов

    public WebElement getAddToCartButton() {
        return driver.findElement(addToCartButtonLocator);
    }

    public WebElement getOpenCartButton() {
        return driver.findElement(openCartButtonLocator);
    }
}
