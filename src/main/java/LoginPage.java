import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


public class LoginPage extends BasePage {
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 30);

    }
    @FindBy(xpath = "//*[@id=\"header\"]/div/div[2]/div/a")
    private WebElement accountButton;
    public void getAccountButton() {
        accountButton.click();
    }

    @FindBy(xpath = "//*[@id=\"header-account\"]/div/ul/li[6]/a")
    private WebElement loginButton;
    public void getLoginButton() {
        loginButton.click();
    }

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement emailAddressField;
    public void setEmailAddressField() {
        emailAddressField.sendKeys("catalin1@test.com");
    }

    @FindBy(xpath = "//*[@id=\"pass\"]")
    private WebElement passwordField;
    public void setPasswordField() {
        passwordField.sendKeys("testtest");
    }

    @FindBy(xpath = "//*[@id=\"send2\"]")
    private WebElement loginButtonOnLogin;
    public void clickOnLoginButtonOnLogin() {
        loginButtonOnLogin.click();
    }

    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div[2]/div[2]/div/div[1]/h1")
    public WebElement dashboardTitle;

    public void assertTextWhenReady(WebElement locator, String expectedText) {
        wait.until(ExpectedConditions.visibilityOf(locator));
        wait.until(ExpectedConditions.textToBePresentInElement(locator,expectedText));
        assertEquals(expectedText, locator.getText());
    }

}




