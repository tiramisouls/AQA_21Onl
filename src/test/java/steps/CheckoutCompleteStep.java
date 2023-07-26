package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CheckoutCompletePage;
import pages.InventoryPage;

public class CheckoutCompleteStep extends BaseStep {

    public CheckoutCompleteStep(WebDriver driver) {
        super(driver);
    }

    public CheckoutCompletePage completeHeaderIsDisplayed() {
        checkoutCompletePage.getCompleteHeader().isDisplayed();
        return checkoutCompletePage;
    }
}