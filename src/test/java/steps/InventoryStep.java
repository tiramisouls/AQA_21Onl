package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.InventoryPage;

public class InventoryStep extends BaseStep {

    public InventoryStep(WebDriver driver) {
        super(driver);
    }

    public InventoryPage addToCart() {
        inventoryPage.getAddToCartButton().click();
        return inventoryPage;
    }

    public CartPage openCart() {
        inventoryPage.getOpenCartButton().click();
        return cartPage;
    }
}
