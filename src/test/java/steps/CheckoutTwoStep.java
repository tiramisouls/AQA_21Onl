package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CheckoutCompletePage;

public class CheckoutTwoStep extends BaseStep {

    public CheckoutTwoStep(WebDriver driver) {
        super(driver);
    }

    public CheckoutCompletePage finishCheckout (){
        checkoutTwoPage.getFinishButton().click();
        return checkoutCompletePage;
    }
}