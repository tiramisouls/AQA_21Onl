package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CheckoutTwoPage;
import pages.CheckoutOnePage;

public class CheckoutOneStep extends BaseStep {

    public CheckoutOneStep(WebDriver driver) {
        super(driver);
    }

    public CheckoutOnePage fillingInWithValidData() {
        checkoutOnePage.fillInYourInfoData();
        return checkoutOnePage;
    }

    public CheckoutTwoPage continueCheckout(){
        checkoutOnePage.getContinueButton().click();
        return checkoutTwoPage;
    }
}