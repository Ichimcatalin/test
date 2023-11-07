import org.junit.Before;
import org.junit.Test;

public class CartTest extends Hooks {

  public CartPage cartPage;


  @Before
  public void setupPageObject() {
    cartPage = new CartPage(driver);
    driver.manage().window().maximize();
  }

  @Test
  public void deleteItemFromCart() throws InterruptedException {

    //click on the food category from header
    cartPage.getFoodMenu();
    //add item to cart
    cartPage.getAddToCart();
    //verify that the item is added to cart
    cartPage.assertTextWhenReady(cartPage.shoppingCartTitle, "SHOPPING CART");


  }

}