import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\MadisonIsland\\src\\main\\resources\\chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/magento-test/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
