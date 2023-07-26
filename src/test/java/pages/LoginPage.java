package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    // Блок описания локаторов для элементов
    private final By userNameInputLocator = By.id("user-name");
    private final By pswInputLocator = By.id("password");
    private final By loginButtonLocator = By.id("login-button");

    // Блок инициализации
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return loginButtonLocator;
    }

    // Блок атомарных методов

    public WebElement getUserNameInput() {
        return driver.findElement(userNameInputLocator);
    }

    public WebElement getPswInput() {
        return driver.findElement(pswInputLocator);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButtonLocator);
    }

    // Блок комплексных методов
    public void login(String username, String psw) {
        getUserNameInput().sendKeys(username);
        getPswInput().sendKeys(psw);
        getLoginButton().click();
    }
}