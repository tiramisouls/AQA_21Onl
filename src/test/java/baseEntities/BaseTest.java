package baseEntities;

import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.*;
import utils.configuration.ReadProperties;

public class BaseTest {
    protected WebDriver driver;
    protected LoginStep loginStep;
    protected InventoryStep inventoryStep;
    protected CartStep cartStep;
    protected CheckoutOneStep checkoutOneStep;
    protected CheckoutTwoStep checkoutTwoStep;
    protected CheckoutCompleteStep checkoutCompleteStep;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
        loginStep = new LoginStep(driver);
        inventoryStep = new InventoryStep(driver);
        cartStep = new CartStep(driver);
        checkoutOneStep = new CheckoutOneStep(driver);
        checkoutTwoStep = new CheckoutTwoStep(driver);
        checkoutCompleteStep = new CheckoutCompleteStep(driver);
        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}