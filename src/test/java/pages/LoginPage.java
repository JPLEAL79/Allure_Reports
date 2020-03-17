package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//div[@class='login-user']")
    private WebElement ingresar;

    @FindBy(id = "UserEmail")
    private WebElement campoEmail;

    @FindBy(id = "UserPassword")
    private WebElement campoPassword;

    @FindBy(xpath = "//*[@class='btnTamano']")
    private WebElement loginButton;

    @FindBy (linkText = "Salir")
    private WebElement logueado;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(this.driver, this);
    }

    public void Login(String email, String password) {
        ingresar.click();
        campoEmail.sendKeys(email);
        campoPassword.sendKeys(password);
        loginButton.click();
    }


    public boolean at() {
        return logueado.isDisplayed();
    }

}
