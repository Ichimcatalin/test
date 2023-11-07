import org.junit.Before;
import org.junit.Test;

public class LoginTest extends Hooks {

  public LoginPage loginPage;


  @Before
  public void setupPageObject() {
    loginPage = new LoginPage(driver);
    driver.manage().window().maximize();
  }

  @Test
  public void checkout() throws InterruptedException {

    //click on account
    loginPage.getAccountButton();
    //click login
    loginPage.getLoginButton();
    //type email address
    loginPage.setEmailAddressField();
    //type password
    loginPage.setPasswordField();
    //press login
    loginPage.clickOnLoginButtonOnLogin();
    //check if Dashboard is opened
    loginPage.assertTextWhenReady(loginPage.dashboardTitle, "MY DASHBOARD");
    //assertEquals("MY DASHBOARD", loginPage.dashboardTitle.getText());

  }

}