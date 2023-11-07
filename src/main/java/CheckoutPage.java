import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


public class CheckoutPage extends BasePage {
    private WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 30);

    }

    @FindBy(id = "advice-required-entry-billing:firstname")
    public WebElement mandatoryFirstName;

    @FindBy(xpath = "//*[@id=\"advice-required-entry-billing:lastname\"]")
    public WebElement mandatoryLastName;

    @FindBy(xpath = "//*[@id=\"advice-required-entry-billing:city\"]")
    public WebElement mandatoryCity;
    @FindBy(xpath = "//*[@id=\"advice-required-entry-billing:email\"]")
    public WebElement mandatoryEmail;

    @FindBy(xpath = "//a[text()='Food']") // (css = ".nav-16 > .level0")
    private WebElement foodMenu;

    @FindBy(xpath = "//a[text()='Books']")
    private WebElement booksMenu;

    @FindBy(css = ".product-info button")
    // .btn-cart:nth-child(1) > span > span"
    public WebElement addToCart;

    public String test = "Salut!";
    @FindBy(id = "city")
    private WebElement cityCart;

    @FindBy(css = ".method-checkout-cart-methods-onepage-bottom button")
    private WebElement checkoutButton;

    @FindBy(id = "onepage-guest-register-button")
    private WebElement registerButton;

    @FindBy(id = "billing:firstname")
    public WebElement firstNameField;

    @FindBy(id = "billing:middlename")
    public WebElement middleNameField;

    @FindBy(id = "billing:lastname")
    public WebElement lastNameField;

    @FindBy(id = "billing:company")
    public WebElement companyField;

    @FindBy(id = "billing:telephone")
    public WebElement billingTelephone;

    @FindBy(id = "billing:email")
    public WebElement emailField;

    @FindBy(id = "billing:street1")
    private WebElement street1Field;

    @FindBy(id = "billing:street2")
    private WebElement street2Field;

    @FindBy(id = "billing:postcode")
    public WebElement billingPostcode;

    @FindBy(id = "billing:city")
    public WebElement cityField;

    @FindBy(id = "billing:region_id")
    private WebElement regionDropdown;

    @FindBy(id = "region_id")
    private WebElement cartRegionDropdown;

    @FindBy(id = "postcode")
    private WebElement postcodeField;

    @FindBy(css = "#billing-buttons-container button")
    public WebElement billingContinue;

    @FindBy(css = "#shipping-method-buttons-container button")
    public WebElement shippingContinue;

    @FindBy(css = "#payment-buttons-container button")
    public WebElement lastContinue;

    @FindBy(css = ".btn-checkout")
    public WebElement order;

    @FindBy(xpath =  "//div[@class='page-title']")
    public WebElement pageTitle;

    @FindBy(xpath =  "//*[@id=\"co-billing-form\"]/div/p")
    public WebElement checkoutRequiredFields;

    public void getFoodMenu() {
        foodMenu.click();
    }

    public void getAddToCart() {
        addToCart.click();
    }

    public void getCityCart() {
        cityCart.sendKeys("alabama city");
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void clickFirstNameField() {
        firstNameField.click();
    }

    public void setPostcode(String postcode) {
        postcodeField.sendKeys(postcode);
    }

    public void selectRegion(String regionName) {
        Select regionSelect = new Select(regionDropdown);
        regionSelect.selectByVisibleText(regionName);
    }

    public void selectCartRegion(String cartRegionName) {
        Select cartRegionSelect = new Select(cartRegionDropdown);
        cartRegionSelect.selectByVisibleText(cartRegionName);
    }


    public void setFirstName(String name) {
        firstNameField.sendKeys(name);
    }

    public void setMiddleName(String name) {
        middleNameField.sendKeys(name);
    }

    public void setLastName(String name) {
        lastNameField.sendKeys(name);
    }

    public void setCompany(String company) {
        companyField.sendKeys(company);
    }

    public void setEmail(String email) {
        emailField.sendKeys(email);
    }

    public void setBillingTelephone(String number) {
        billingTelephone.sendKeys(number);
    }

    public void setBillingPostcode(String postcode) {
        billingPostcode.sendKeys(postcode);
    }

    public void setStreet1(String address) {
        street1Field.sendKeys(address);
    }

    public void setStreet2(String address) {
        street2Field.sendKeys(address);
    }

    public void setCity(String city) {
        cityField.sendKeys(city);
    }

    public void clickRegionDropdown() {
        regionDropdown.click();
    }

    public void clickCartRegionDropdown() {
        cartRegionDropdown.click();
    }

    public void clickWhenReady(WebElement locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void assertTextWhenReady(WebElement locator, String expectedText) {
        wait.until(ExpectedConditions.visibilityOf(locator));
        wait.until(ExpectedConditions.textToBePresentInElement(locator, expectedText));
        assertEquals(expectedText, locator.getText());
    }

    public void completeAndSubmit() {
        getCityCart();
        setPostcode("12345");
        clickCartRegionDropdown();
        selectCartRegion("Alabama");
        clickCheckoutButton();
        clickRegisterButton();
    }
    public void completeRequiredFieldsInCheckoutPage()
    {
        setFirstName("Test");
        setMiddleName("Test2");
        setLastName("Test3");
        setCompany("Test5");
        setEmail("asdf@example.com");
        setStreet1("adresa mea");
        setStreet2("adresa mea 2");
        setCity("Alabama City");
        selectRegion("Alabama");
        setBillingPostcode("12345");
        setBillingTelephone("0777777777");
    }
    public void pressContinueAtEndOfCheckout() {
        clickWhenReady(billingContinue);
        clickWhenReady(shippingContinue);
        clickWhenReady(lastContinue);
        clickWhenReady(order);
    }

    public void completeRequiredFieldsInCheckoutPageExceptOne(WebElement locator){
        completeRequiredFieldsInCheckoutPage();
        locator.clear();
    }

    }




