import org.junit.Before;
import org.junit.Test;

public class CheckoutTest extends Hooks {

  public CheckoutPage checkoutPage;


  @Before
  public void setupPageObject() {
    checkoutPage = new CheckoutPage(driver);
    driver.manage().window().maximize();
  }

  @Test
  public void checkout() throws InterruptedException {

    checkoutPage.getFoodMenu();
    checkoutPage.getAddToCart();
    checkoutPage.completeAndSubmit();
    checkoutPage.assertTextWhenReady(checkoutPage.checkoutRequiredFields, "* Required Fields");
    checkoutPage.completeRequiredFieldsInCheckoutPage();
    checkoutPage.pressContinueAtEndOfCheckout();
    checkoutPage.assertTextWhenReady(checkoutPage.pageTitle, "YOUR ORDER HAS BEEN RECEIVED.");

  }

  @Test
  public void checkMandatoryFieldsTestExceptFirstname() throws InterruptedException {

    checkoutPage.getFoodMenu();
    checkoutPage.getAddToCart();
    checkoutPage.completeAndSubmit();
    checkoutPage.completeRequiredFieldsInCheckoutPageExceptOne(checkoutPage.firstNameField);
    checkoutPage.clickWhenReady(checkoutPage.billingContinue);
    checkoutPage.assertTextWhenReady(checkoutPage.mandatoryFirstName, "This is a required field.");

  }
  @Test
  public void checkMandatoryFieldsTestExceptLastname() throws InterruptedException {

    checkoutPage.getFoodMenu();
    checkoutPage.getAddToCart();
    checkoutPage.completeAndSubmit();
    checkoutPage.completeRequiredFieldsInCheckoutPageExceptOne(checkoutPage.lastNameField);
    checkoutPage.clickWhenReady(checkoutPage.billingContinue);
    checkoutPage.assertTextWhenReady(checkoutPage.mandatoryLastName, "This is a required field.");

  }
  @Test
  public void checkMandatoryFieldsTestExceptCity() throws InterruptedException {

    checkoutPage.getFoodMenu();
    checkoutPage.getAddToCart();
    checkoutPage.completeAndSubmit();
    checkoutPage.completeRequiredFieldsInCheckoutPageExceptOne(checkoutPage.cityField);
    checkoutPage.clickWhenReady(checkoutPage.billingContinue);
    checkoutPage.assertTextWhenReady(checkoutPage.mandatoryCity, "This is a required field.");

  }
  @Test
  public void checkMandatoryFieldsTestExceptEmail() throws InterruptedException {

    checkoutPage.getFoodMenu();
    checkoutPage.getAddToCart();
    checkoutPage.completeAndSubmit();
    checkoutPage.completeRequiredFieldsInCheckoutPageExceptOne(checkoutPage.emailField);
    checkoutPage.clickWhenReady(checkoutPage.billingContinue);
    checkoutPage.assertTextWhenReady(checkoutPage.mandatoryEmail, "This is a required field.");

  }

}