package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.configuration.ReadProperties;

public class EndToEndTest extends BaseTest {

    @Test
    public void E2ETest() {
        Assert.assertTrue(loginStep.successLogin(ReadProperties.username(), ReadProperties.password()).isPageOpened());
        Assert.assertTrue(inventoryStep.addToCart().isPageOpened());
        Assert.assertTrue(inventoryStep.openCart().isPageOpened());
        Assert.assertTrue(cartStep.checkout().isPageOpened());
        Assert.assertTrue(checkoutOneStep.fillingInWithValidData().isPageOpened());
        Assert.assertTrue(checkoutOneStep.continueCheckout().isPageOpened());
        Assert.assertTrue(checkoutTwoStep.finishCheckout().isPageOpened());
        Assert.assertTrue(checkoutCompleteStep.completeHeaderIsDisplayed().isPageOpened());
    }
}