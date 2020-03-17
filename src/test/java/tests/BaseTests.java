package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.LoginPage;
import pages.CatalogoPage;
import java.util.concurrent.TimeUnit;

public class BaseTests {



    public WebDriver driver;
    public LoginPage loginPage;
    public HomePage homePage;
    public CatalogoPage catalogoPage;

    @BeforeClass
    public void setup()  {

        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--disable-notifications"); //Opción de Chrome sirve para desactivar las notificacion
        opts.addArguments("--start-maximized"); //Opción de Chrome sirve para que inicie maximizado

        System.setProperty("webdriver.chrome.driver", "./src/test/resources/webdrivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.microplay.cl/");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        catalogoPage = new CatalogoPage(driver);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}

