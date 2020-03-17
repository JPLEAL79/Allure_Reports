package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogoPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@id='sidebar_section']//*[@title]")
    private List<WebElement> listaDeNotebooks;

    @FindBy(xpath = "//*[@class='titulo-seccion']")
    private WebElement resultadoCatalogo;

    public CatalogoPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(this.driver, driver);

    }

    public void obtenerDatosDeListaDeCatalogo() {
        String nombreMarca = "";
        listaDeNotebooks = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[@id='sidebar_section']//*[@title]"), 1));
        for (WebElement marca : listaDeNotebooks) {
            nombreMarca = marca.getText();
            System.out.println(nombreMarca);

        }
    }

    public boolean at() {

        return resultadoCatalogo.isDisplayed();
    }
}
