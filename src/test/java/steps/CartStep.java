package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CheckoutOnePage;

public class CartStep extends BaseStep {

    public CartStep (WebDriver driver) {
        super(driver);
    }

    public CheckoutOnePage checkout() {
        cartPage.getCheckoutButton().click();
        return checkoutOnePage;
    }
}